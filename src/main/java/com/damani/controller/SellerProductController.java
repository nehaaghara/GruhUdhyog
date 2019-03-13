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
import com.damani.utility.CommonUtility;
import com.damani.webbean.ProductBean;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.damani.service.CategoryService;
import com.damani.service.ProductImageService;
import com.damani.service.ProductService;

/**
 *
 * @author ITMCS-PC
 */
@Controller
public class SellerProductController {


    @Autowired
    ProductImageService adminProductImageService;

    @Autowired
    ProductService adminProductService;

    @Autowired
    CategoryService categoryService;

    ModelAndView mv = new ModelAndView();

    @RequestMapping(value = "/sellerproductpage", method = RequestMethod.GET)
    public ModelAndView sellerproductpage(Model model, HttpServletRequest req) {
        List<TblUserTable> lstuser = (List<TblUserTable>) req.getSession(false).getAttribute("lstuser");

        Object lstCategory = categoryService.fetchAllCategory();
        model.addAttribute("lstCategory", lstCategory);
        mv.addObject("addProduct", new ProductBean());
        mv.setViewName("com.damani.selleraddproducttiles");
        return mv;
    }

    @RequestMapping(value = "/selleraddproduct", method = RequestMethod.POST)
    public String addproductseller(@ModelAttribute("addProduct") ProductBean addProductBean, HttpServletRequest req, RedirectAttributes redirectAttributes) throws Exception {
        Date date = new Date();
        List<TblUserTable> lstuser = (List<TblUserTable>) req.getSession(false).getAttribute("lstuser");
        TblUserTable tblUserTable = new TblUserTable();
        tblUserTable.setUserid(lstuser.get(0).getUserid());

        addProductBean.getTblproduct() .setCreatedBy(tblUserTable);
        addProductBean.getTblproduct() .setCreatedOn(new Date());

        String response = null;
        if (addProductBean.getTblproduct() .getProductPK() == null) {
            response = adminProductService.saveProduct(addProductBean.getTblproduct() , tblUserTable);
            redirectAttributes.addFlashAttribute("SuccessMessage", response);
        } else {
            response = adminProductService.updateProductById(addProductBean.getTblproduct() , tblUserTable);
            redirectAttributes.addFlashAttribute("UpdateMessage", response);
        }

        TblCategory tblCategory = categoryService.fetchCategoryById(addProductBean.getTblproduct() .getCategoryFK().getCategoryPK());
        List<TblProductImageMapping> lstImageMappings = new ArrayList<>();
        for (MultipartFile file : addProductBean.getLstadminproductimage()) {
            String fileName = UUID.randomUUID().toString() + "." + file.getOriginalFilename().split("\\.")[1];
            String filePath = CommonUtility.getProperty("imagePath") + File.separator + "ProductImages" + File.separator + tblCategory.getCategoryName() + File.separator + addProductBean.getTblproduct() .getProductName() + File.separator;
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
            tblAdminProductImageMapping.setAdminProductFk(addProductBean.getTblproduct() );
            tblAdminProductImageMapping.setCreatedDate(new Date());
            tblAdminProductImageMapping.setCreatedBy(tblUserTable);
            lstImageMappings.add(tblAdminProductImageMapping);
        }
        adminProductImageService.saveAdminProductImages(lstImageMappings);
        if (req.getParameter("save") != null) {
            return "redirect:/showproductlist";
        } else if (req.getParameter("saveAndNew") != null) {
            return "redirect:/sellerproductpage";
        }
        return "redirect:/showproductlist";

    }

    @RequestMapping(value="/showproductlist",method=RequestMethod.GET)
    public ModelAndView showsellerproduct(HttpServletRequest req) {
        List<TblUserTable> lstuser = (List<TblUserTable>) req.getSession(false).getAttribute("lstuser");
        List<TblProduct> lstproduct = adminProductService.fetchAllProductByUserId(lstuser.get(0).getUserid());
        mv.addObject("lstproduct", lstproduct);
        mv.setViewName("com.damani.viewproducttiles");
        return mv;
    }

    @RequestMapping(value="/editsellerproduct/{productPK}",method = RequestMethod.GET)
    public ModelAndView editsellerproduct(@PathVariable("productPK") BigInteger productPK, Model model, HttpServletRequest req) {
        TblProduct response = adminProductService.fetchProductById(productPK);
        ProductBean productBean = new ProductBean();
        productBean.setTblproduct(response);
        mv.addObject("addProduct", productBean);
        mv.setViewName("com.damani.selleraddproducttiles");
        return mv;
    }

    @RequestMapping("/deletesellerproduct/{productPK}")
    public ModelAndView deleteproduct(@PathVariable("productPK") BigInteger productPK, Model model, HttpServletRequest req) {
        adminProductService.deleteProductById(productPK);
        mv.setViewName("redirect:/showproductlist");
        return mv;
    }
    
    @RequestMapping(value = "/updatesellerproduct/{productPK}", method = RequestMethod.POST)
    public String updatesellerproduct(@PathVariable("productPK") BigInteger productPK, @ModelAttribute ProductBean addProduct, HttpServletRequest request) {
        TblUserTable tblUserTable = new TblUserTable();
        List<TblUserTable> lstuser = (List<TblUserTable>) request.getSession(false).getAttribute("lstuser");
        tblUserTable.setUserid(lstuser.get(0).getUserid());

        String response = adminProductService.updateProductById(addProduct.getTblproduct() , tblUserTable);
        return "redirect:/viewproduct";
    }
}
