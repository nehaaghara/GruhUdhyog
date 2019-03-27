/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblShipping;
import com.damani.model.TblUserTable;
import com.damani.service.PaymentService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ITMCS-PC
 */
@Controller
public class CheckOutController {

    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/checkoutpage", method = RequestMethod.GET)
    public String checkout(Model model) {
        model.addAttribute("tblShipping", new TblShipping());
        return "com.damani.checkouttiles";
    }

    @RequestMapping(value = "/saveshippinginfo", method = RequestMethod.POST)
    public String saveShippingInformation(HttpServletRequest request,@ModelAttribute("tblShipping") TblShipping addTblShipping) {
        TblUserTable tblUserTable = new TblUserTable();
        List<TblUserTable> lstuser = (List<TblUserTable>) request.getSession(false).getAttribute("lstuser");
        tblUserTable.setUserid(lstuser.get(0).getUserid());

        paymentService.saveShippingInformation(addTblShipping, tblUserTable);
        return "redirect:/orderoverviewpage";
    }
}
