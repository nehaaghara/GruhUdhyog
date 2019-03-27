/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblProductImageMapping;
import com.damani.model.TblCategory;
import com.damani.model.TblProduct;
import com.damani.model.TblUserTable;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.damani.utility.CommonUtility;
import com.damani.webbean.ProductBean;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.damani.service.CategoryService;
import com.damani.service.ProductImageService;
import com.damani.service.ProductService;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author ITMCS
 */
@Controller
public class AdminProduct {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService adminProductService;

    @Autowired
    ProductImageService adminProductImageService;

    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public String addProduct(HttpServletRequest request, Model model) {
        model.addAttribute("adminProductBean", new ProductBean());

        Object lstCategory = categoryService.fetchAllCategory();
        model.addAttribute("lstCategory", lstCategory);
        return "com.damani.addProduct";
    }

    @RequestMapping(value = "/viewproduct", method = RequestMethod.GET)
    public String viewProduct(Model model, HttpServletRequest request) {
        Object lstProducts = adminProductService.fetchAllProduct();
        model.addAttribute("lstProducts", lstProducts);
        return "com.damani.viewProduct";
    }

    @RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
    public String saveProduct(HttpServletRequest request, @ModelAttribute("adminProductBean") ProductBean addadminProductBean, RedirectAttributes redirectAttributes) throws FileNotFoundException, IOException {

        TblUserTable tblUserTable = new TblUserTable();
        List<TblUserTable> lstuser = (List<TblUserTable>) request.getSession(false).getAttribute("lstuser");
        tblUserTable.setUserid(lstuser.get(0).getUserid());

        addadminProductBean.getTblproduct().setCreatedBy(tblUserTable);
        addadminProductBean.getTblproduct().setCreatedOn(new Date());

        String response = null;
        if (addadminProductBean.getTblproduct().getProductPK() == null) {
            response = adminProductService.saveProduct(addadminProductBean.getTblproduct(), tblUserTable);
            redirectAttributes.addFlashAttribute("SuccessMessage", response);
        } else {
            response = adminProductService.updateProductById(addadminProductBean.getTblproduct(), tblUserTable);
            redirectAttributes.addFlashAttribute("UpdateMessage", response);
        }
        TblCategory tblCategory = categoryService.fetchCategoryById(addadminProductBean.getTblproduct().getCategoryFK().getCategoryPK());
        List<TblProductImageMapping> lstImageMappings = new ArrayList<>();
        for (MultipartFile file : addadminProductBean.getLstadminproductimage()) {
            String fileName = UUID.randomUUID().toString() + "." + file.getOriginalFilename().split("\\.")[1];
            String filePath = CommonUtility.getProperty("imagePath") + File.separator + "ProductImages" + File.separator + tblCategory.getCategoryName() + File.separator + addadminProductBean.getTblproduct().getProductName() + File.separator;
            File path = new File(filePath);
            if (!path.exists()) {
                path.mkdirs();
            }
            String fullFileName = filePath + fileName;
            File destFile = new File(fullFileName);
            OutputStream os = new FileOutputStream(destFile);
            os.write(file.getBytes());
            os.close();
            TblProductImageMapping tblAdminProductImageMapping = new TblProductImageMapping();
            tblAdminProductImageMapping.setImagePath(fullFileName);
            tblAdminProductImageMapping.setAdminProductFk(addadminProductBean.getTblproduct());
            tblAdminProductImageMapping.setCreatedDate(new Date());
            tblAdminProductImageMapping.setCreatedBy(tblUserTable);
            lstImageMappings.add(tblAdminProductImageMapping);
        }
        adminProductImageService.saveAdminProductImages(lstImageMappings);
        if (request.getParameter("save") != null) {
            return "redirect:/viewproduct";
        } else if (request.getParameter("saveAndNew") != null) {
            return "redirect:/addproduct";
        }
        return "redirect:/viewproduct";
    }

    @RequestMapping(value = "/editproduct/{productPK}", method = RequestMethod.GET)
    public String editProduct(@PathVariable("productPK") BigInteger productPK, Model model) throws FileNotFoundException, IOException {
        TblProduct response = adminProductService.fetchProductById(productPK);
        ProductBean productBean = new ProductBean();
        productBean.setTblproduct(response);
        System.out.println("in controller");
        List<TblProductImageMapping> lstImageMappings = adminProductImageService.fetchAllImagesByProductId(productPK);
        System.out.println("size::" + lstImageMappings.size());
//        for (TblProductImageMapping tblProductImageMapping : lstImageMappings) {
//            System.out.println("in controller:::" + tblProductImageMapping.getImagePath());
//            File file = new File(tblProductImageMapping.getImagePath().toString());
//            FileInputStream input = new FileInputStream(file);
//            MultipartFile multipartFile = new MockMultipartFile("file",file.getName(), "text/plain", IOUtils.toByteArray(input));
//            productBean.setLstadminproductimage((List<MultipartFile>) multipartFile);
//        }
    
        productBean.setTblProductImageMapping(lstImageMappings);
        model.addAttribute("adminProductBean", productBean);
        Object lstCategory = categoryService.fetchAllCategory();
        model.addAttribute("lstCategory", lstCategory);
        return "com.damani.addProduct";
    }

    @RequestMapping(value = "/deleteproduct/{productPK}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("productPK") BigInteger productPK, RedirectAttributes redirectAttributes) {
        String response = adminProductService.deleteProductById(productPK);
        redirectAttributes.addFlashAttribute("DeleteMessage", response);
        return "redirect:/viewproduct";
    }

    @RequestMapping(value = "/updateproduct/{productPK}", method = RequestMethod.POST)
    public String updateProduct(@PathVariable("productPK") BigInteger productPK, @ModelAttribute ProductBean adminProductBean, HttpServletRequest request) {
        TblUserTable tblUserTable = new TblUserTable();
        List<TblUserTable> lstuser = (List<TblUserTable>) request.getSession(false).getAttribute("lstuser");
        tblUserTable.setUserid(lstuser.get(0).getUserid());

        String response = adminProductService.updateProductById(adminProductBean.getTblproduct(), tblUserTable);
        return "redirect:/viewproduct";
    }

}
