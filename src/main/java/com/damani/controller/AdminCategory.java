/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblCategory;
import com.damani.model.TblUserTable;
import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import com.damani.service.CategoryService;

/**
 *
 * @author ITMCS
 */
@Controller
public class AdminCategory {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/addcategory", method = RequestMethod.GET)
    public String addCategory(Model model, HttpServletRequest request) {
        model.addAttribute("tblcategory", new TblCategory());
        return "com.damani.addCategory";
    }

    @RequestMapping(value = "/viewcategory", method = RequestMethod.GET)
    public String viewCategory(Model model, HttpServletRequest request) {
        Object response = categoryService.fetchAllCategory();
        model.addAttribute("lstCategory", response);
        return "com.damani.viewCategory";
    }

    @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String saveCategory(HttpServletRequest request, @ModelAttribute("tblcategory") TblCategory addCategory, RedirectAttributes redirectAttributes) {
        TblUserTable tblUserTable = new TblUserTable();
        List<TblUserTable> lstuser = (List<TblUserTable>) request.getSession(false).getAttribute("lstuser");
        tblUserTable.setUserid(lstuser.get(0).getUserid());

        String response = null;
        if (addCategory.getCategoryPK() == null) {
            response = categoryService.saveCategory(addCategory,tblUserTable);
            redirectAttributes.addFlashAttribute("SuccessMessage", response);
        } else {
            response = categoryService.updateCategoryById(addCategory,tblUserTable);
            redirectAttributes.addFlashAttribute("UpdateMessage", response);
        }
        if (request.getParameter("save") != null) {
            return "redirect:/viewcategory";
        } else if (request.getParameter("saveAndNew") != null) {
            return "redirect:/addcategory";
        }
        return "redirect:/viewcategory";
    }

    @RequestMapping(value = "/edit/{categoryPK}", method = RequestMethod.GET)
    public String editCategory(@PathVariable("categoryPK") BigInteger categoryPK, Model model) {
        Object response = categoryService.fetchCategoryById(categoryPK);
        model.addAttribute("tblcategory", response);
        return "com.damani.addCategory";
    }

    @RequestMapping(value = "/delete/{categoryPK}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable("categoryPK") BigInteger categoryPK, RedirectAttributes redirectAttributes) {
        String response = categoryService.deleteCategoryById(categoryPK);
        redirectAttributes.addFlashAttribute("DeleteMessage", response);
        return "redirect:/viewcategory";
    }

    @RequestMapping(value = "/update/{categoryPK}", method = RequestMethod.POST)
    public String updateCategory(@PathVariable("categoryPK") BigInteger categoryPK, @ModelAttribute TblCategory tblCategory,HttpServletRequest request) {
        TblUserTable tblUserTable = new TblUserTable();
        List<TblUserTable> lstuser = (List<TblUserTable>) request.getSession(false).getAttribute("lstuser");
        tblUserTable.setUserid(lstuser.get(0).getUserid());
        
        String response = categoryService.updateCategoryById(tblCategory,tblUserTable);
        return "redirect:/viewcategory";
    }
}
