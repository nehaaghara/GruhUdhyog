/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblPayment;
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
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @RequestMapping("/paymentpage")
    public String payment(Model model) {
        model.addAttribute("tblPayment", new TblPayment());
        return "com.damani.paymenttiles";
    }

    @RequestMapping(value = "/savePayment", method = RequestMethod.POST)
    public String savePaymentMethod(@ModelAttribute("tblPayment") TblPayment addTblPayment,HttpServletRequest request) {
        TblUserTable tblUserTable = new TblUserTable();
        List<TblUserTable> lstuser = (List<TblUserTable>) request.getSession(false).getAttribute("lstuser");
        tblUserTable.setUserid(lstuser.get(0).getUserid());

        paymentService.savePayment(addTblPayment, tblUserTable);
        return "redirect:/ordercompletepage";
    }
}
