/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblAdminBrand;
import com.damani.model.TblBrand;
import com.damani.model.TblSellerProduct;
import com.damani.model.TblUserTable;
import com.damani.service.AdminCategoryService;
import com.damani.service.AdminProductService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ITMCS-PC
 */
@Controller
public class indexcontroller {

    @Autowired
    AdminProductService adminProductService;

    @RequestMapping(value = "/")
    public String index() {
        return "com.damani.userindex";
    }

    @RequestMapping(value = "/loginindex")
    public String login() {
        return "com.damani.login";
    }

    @RequestMapping(value = "/registrationindex")
    public String registration() {
        return "com.damani.register";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/loginindex";
    }

    @RequestMapping(value = "/adminaddsellerindex", method = RequestMethod.GET)
    public ModelAndView addseller() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("usertablemodel", new TblUserTable());
        mv.setViewName("com.damani.adminaddsellertiles");
        return mv;
    }

    @RequestMapping(value = "/selleraddbrandindex", method = RequestMethod.GET)
    public ModelAndView selleraddbrand(Model model) {
        Object lstProducts = adminProductService.fetchAllProduct();
        model.addAttribute("lstProducts", lstProducts);

        ModelAndView mv = new ModelAndView();
        mv.addObject("addsellerBrand",  new TblAdminBrand());
        mv.setViewName("com.damani.selleraddbrandtiles");
        return mv;
    }
}
