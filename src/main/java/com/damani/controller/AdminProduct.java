/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblAdminProductImageMapping;
import com.damani.model.TblCategory;
import com.damani.model.TblProduct;
import com.damani.model.TblUserTable;
import com.damani.service.AdminBrandService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.damani.service.AdminCategoryService;
import com.damani.service.AdminProductImageService;
import com.damani.service.AdminProductService;
import com.damani.utility.CommonUtility;
import com.damani.webbean.AdminProductBean;
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

/**
 *
 * @author ITMCS
 */
@Controller
public class AdminProduct {

    @Autowired
    AdminCategoryService categoryService;

    @Autowired
    AdminProductService adminProductService;

    @Autowired
    AdminProductImageService adminProductImageService;

    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public String addProduct(HttpServletRequest request, Model model) {
        model.addAttribute("adminProductBean", new AdminProductBean());

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
    public String saveProduct(HttpServletRequest request, @ModelAttribute("adminProductBean") AdminProductBean addadminProductBean, RedirectAttributes redirectAttributes) throws FileNotFoundException, IOException {

        TblUserTable tblUserTable = new TblUserTable();
        List<TblUserTable> lstuser = (List<TblUserTable>) request.getSession(false).getAttribute("lstuser");
        tblUserTable.setUserid(lstuser.get(0).getUserid());

        addadminProductBean.getTblProduct().setCreatedBy(tblUserTable);
        addadminProductBean.getTblProduct().setCreatedOn(new Date());

        String response = null;
        if (addadminProductBean.getTblProduct().getProductPK() == null) {
            response = adminProductService.saveProduct(addadminProductBean.getTblProduct(), tblUserTable);
            redirectAttributes.addFlashAttribute("SuccessMessage", response);
        } else {
            response = adminProductService.updateProductById(addadminProductBean.getTblProduct(), tblUserTable);
            redirectAttributes.addFlashAttribute("UpdateMessage", response);
        }

        TblCategory tblCategory = categoryService.fetchCategoryById(addadminProductBean.getTblProduct().getCategoryFK().getCategoryPK());
        List<TblAdminProductImageMapping> lstImageMappings = new ArrayList<>();
        for (MultipartFile file : addadminProductBean.getLstAdminProductImage()) {
            String fileName = UUID.randomUUID().toString() + "." + file.getOriginalFilename().split("\\.")[1];
            String filePath = CommonUtility.getProperty("imagePath") + File.separator + "ProductImages" + File.separator + tblCategory.getCategoryName() + File.separator + addadminProductBean.getTblProduct().getProductName() + File.separator;
            File path = new File(filePath);
            if (!path.exists()) {
                path.mkdirs();
            }
            String fullFileName = filePath + fileName;
            File destFile = new File(fullFileName);
            OutputStream os = new FileOutputStream(destFile);
            os.write(file.getBytes());
            os.close();
            TblAdminProductImageMapping tblAdminProductImageMapping = new TblAdminProductImageMapping();
            tblAdminProductImageMapping.setImagePath(fullFileName);
            tblAdminProductImageMapping.setAdminProductFk(addadminProductBean.getTblProduct());
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
    public String editProduct(@PathVariable("productPK") BigInteger productPK, Model model) {
        Object response = adminProductService.fetchProductById(productPK);
        model.addAttribute("adminProductBean", response);
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

    @RequestMapping(value = "/updateproduct/{productPK}", method = RequestMethod.GET)
    public String updateProduct(@PathVariable("productPK") BigInteger productPK, @ModelAttribute AdminProductBean adminProductBean, HttpServletRequest request) {
        TblUserTable tblUserTable = new TblUserTable();
        List<TblUserTable> lstuser = (List<TblUserTable>) request.getSession(false).getAttribute("lstuser");
        tblUserTable.setUserid(lstuser.get(0).getUserid());

        String response = adminProductService.updateProductById(adminProductBean.getTblProduct(), tblUserTable);
        return "redirect:/viewproduct";
    }

}
