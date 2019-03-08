/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblProduct;
import com.damani.model.TblUserTable;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.damani.service.AdminCategoryService;
import com.damani.service.AdminProductService;
import java.math.BigInteger;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public String addProduct(HttpServletRequest request, Model model) {
        model.addAttribute("tblProduct", new TblProduct());

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
    public String saveProduct(HttpServletRequest request, @ModelAttribute("tblProduct") TblProduct addtblProduct, RedirectAttributes redirectAttributes) {
        TblUserTable tblUserTable = new TblUserTable();
        List<TblUserTable> lstuser = (List<TblUserTable>) request.getSession(false).getAttribute("lstuser");
        tblUserTable.setUserid(lstuser.get(0).getUserid());

        String response = null;
        if (addtblProduct.getProductPK() == null) {
            response = adminProductService.saveProduct(addtblProduct, tblUserTable);
            redirectAttributes.addFlashAttribute("SuccessMessage", response);
        } else {
            response = adminProductService.updateProductById(addtblProduct, tblUserTable);
            redirectAttributes.addFlashAttribute("UpdateMessage", response);
        }

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

        Object lstCategory = categoryService.fetchAllCategory();
        model.addAttribute("tblProduct", response);
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
    public String updateProduct(@PathVariable("productPK") BigInteger productPK, @ModelAttribute TblProduct tblProduct, HttpServletRequest request) {
        TblUserTable tblUserTable = new TblUserTable();
        List<TblUserTable> lstuser = (List<TblUserTable>) request.getSession(false).getAttribute("lstuser");
        tblUserTable.setUserid(lstuser.get(0).getUserid());

        String response = adminProductService.updateProductById(tblProduct, tblUserTable);
        return "redirect:/viewproduct";
    }

}
