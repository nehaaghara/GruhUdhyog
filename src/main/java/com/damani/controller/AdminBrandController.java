/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblAdminBrand;
import com.damani.model.TblUserTable;
import com.damani.service.AdminBrandService;
import com.damani.service.AdminCategoryService;
import com.damani.service.AdminProductService;
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

/**
 *
 * @author ITMCS
 */
@Controller
public class AdminBrandController {

    @Autowired
    AdminBrandService adminBrandService;

    @Autowired
    AdminProductService adminProductService;
    
    @RequestMapping(value = "/addadminbrand", method = RequestMethod.GET)
    public String addAdminBrand(HttpServletRequest request,Model model) {
        model.addAttribute("tblAdminBrand", new TblAdminBrand());

        Object lstProducts = adminProductService.fetchAllProduct();
        model.addAttribute("lstProducts", lstProducts);
        
        return "com.damani.addadminBrand";
    }

    @RequestMapping(value = "/viewadminbrand", method = RequestMethod.GET)
    public String viewAdminBrand(Model model) {
        Object lstBrands = adminBrandService.fetchAllBrands();
        model.addAttribute("lstBrands", lstBrands);
        return "com.damani.viewadminBrand";
    }

    @RequestMapping(value = "/saveadminbrand", method = RequestMethod.POST)
    public String saveAdminBrand(HttpServletRequest request, @ModelAttribute("tblAdminBrand") TblAdminBrand addtblAdminBrand, RedirectAttributes redirectAttributes) {
        TblUserTable tblUserTable = new TblUserTable();
        List<TblUserTable> lstuser = (List<TblUserTable>) request.getSession(false).getAttribute("lstuser");
        tblUserTable.setUserid(lstuser.get(0).getUserid());

        String response = null;
        if (addtblAdminBrand.getBrandPk() == null) {
            response = adminBrandService.saveAdminBrand(addtblAdminBrand, tblUserTable);
            redirectAttributes.addFlashAttribute("SuccessMessage", response);
        } else {
            response = adminBrandService.updateBrandById(addtblAdminBrand, tblUserTable);
            redirectAttributes.addFlashAttribute("UpdateMessage", response);
        }

        if (request.getParameter("save") != null) {
            return "redirect:/viewadminbrand";
        } else if (request.getParameter("saveAndNew") != null) {
            return "redirect:/addadminbrand";
        }
        return "redirect:/viewadminbrand";
    }

    @RequestMapping(value = "/editadminbrand/{brandPk}", method = RequestMethod.GET)
    public String editAdminBrand(@PathVariable("brandPk") BigInteger brandPk, Model model) {
        Object response = adminBrandService.fetchAdminBrandById(brandPk);
        model.addAttribute("tblAdminBrand", response);
        
        Object lstProducts = adminProductService.fetchAllProduct();
        model.addAttribute("lstProducts", lstProducts);
        
        return "com.damani.addadminBrand";
    }

    @RequestMapping(value = "/deleteadminbrand/{brandPk}", method = RequestMethod.GET)
    public String deleteAdminBrand(@PathVariable("brandPk") BigInteger brandPk, RedirectAttributes redirectAttributes) {
        String response = adminBrandService.deleteBrandById(brandPk);
        redirectAttributes.addFlashAttribute("DeleteMessage", response);
        return "redirect:/viewadminbrand";
    }

    @RequestMapping(value = "/updateadminbrand/{brandPk}", method = RequestMethod.POST)
    public String updateAdminBrand(@PathVariable("brandPk") BigInteger brandPk, @ModelAttribute TblAdminBrand tblAdminBrand, HttpServletRequest request) {
        TblUserTable tblUserTable = new TblUserTable();
        List<TblUserTable> lstuser = (List<TblUserTable>) request.getSession(false).getAttribute("lstuser");
        tblUserTable.setUserid(lstuser.get(0).getUserid());

        String response = adminBrandService.updateBrandById(tblAdminBrand, tblUserTable);
        return "redirect:/viewadminbrand";
    }
}
