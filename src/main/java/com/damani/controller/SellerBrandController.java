/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblBrand;
import com.damani.model.TblUserTable;
import java.math.BigInteger;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.damani.service.BrandService;
import com.damani.service.ProductService;

/**
 *
 * @author ITMCS-PC
 */
@Controller
public class SellerBrandController {

    @Autowired
    ProductService adminProductService;

    @Autowired
    BrandService adminBrandService;

    @RequestMapping(value = "/selleraddbrand", method = RequestMethod.POST)
    public String addseller(@ModelAttribute("addsellerBrand") TblBrand addtblsellerBrand, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        TblUserTable tblUserTable = new TblUserTable();
        List<TblUserTable> lstuser = (List<TblUserTable>) request.getSession(false).getAttribute("lstuser");
        tblUserTable.setUserid(lstuser.get(0).getUserid());

        String response = null;
        if (addtblsellerBrand.getBrandPk() == null) {
            response = adminBrandService.saveAdminBrand(addtblsellerBrand, tblUserTable);
            redirectAttributes.addFlashAttribute("SuccessMessage", response);
        } else {
            response = adminBrandService.updateBrandById(addtblsellerBrand, tblUserTable);
            redirectAttributes.addFlashAttribute("UpdateMessage", response);
        }

        if (request.getParameter("save") != null) {
            return "redirect:/showallbrand";
        } else if (request.getParameter("saveAndNew") != null) {
            return "redirect:/selleraddbrandindex";
        }
        return "redirect:/showallbrand";

    }

    @RequestMapping("/showallbrand")
    public String viewbrand(HttpServletRequest req, Model model) {
        List<TblUserTable> lstuser = (List<TblUserTable>) req.getSession(false).getAttribute("lstuser");
        Object lstBrands = adminBrandService.fetchBrandsByID(lstuser.get(0).getUserid());
        model.addAttribute("lstBrands", lstBrands);
        return "com.damani.viewbrandtiles";
    }

    @RequestMapping(value = "/editbrand/{brandPk}", method = RequestMethod.GET)
    public String editbrand(@PathVariable("brandPk") BigInteger brandPk, Model model) {
        try {

            Object response = adminBrandService.fetchAdminBrandById(brandPk);
            model.addAttribute("addsellerBrand", response);

            Object lstProducts = adminProductService.fetchAllProduct();
            model.addAttribute("lstProducts", lstProducts);

            return "com.damani.selleraddbrandtiles";
        } catch (Exception e) {
            e.printStackTrace();
            return "Ettor";
        }
    
    }

    @RequestMapping(value = "/deletebrand/{brandPk}", method = RequestMethod.GET)
    public String deleteseller(@PathVariable("brandPk") BigInteger brandPk, Model model,RedirectAttributes redirectAttributes) {
        String response = adminBrandService.deleteBrandById(brandPk);
        redirectAttributes.addFlashAttribute("DeleteMessage", response);
        return "redirect:/showallbrand";
    }
    
     @RequestMapping(value = "/updatesellerbrand/{brandPk}", method = RequestMethod.POST)
    public String updateSellerBrand(@PathVariable("brandPk") BigInteger brandPk, @ModelAttribute TblBrand addsellerBrand, HttpServletRequest request) {
        TblUserTable tblUserTable = new TblUserTable();
        List<TblUserTable> lstuser = (List<TblUserTable>) request.getSession(false).getAttribute("lstuser");
        tblUserTable.setUserid(lstuser.get(0).getUserid());

        String response = adminBrandService.updateBrandById(addsellerBrand, tblUserTable);
        return "redirect:/viewadminbrand";
    }
}
