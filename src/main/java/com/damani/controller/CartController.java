/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblCart;
import com.damani.model.TblProduct;
import com.damani.model.TblProductImageMapping;
import com.damani.model.TblUserTable;
import com.damani.service.ProductCrudOperationonCartService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ITMCS-PC
 */
@Controller
public class CartController {

    @Autowired
    ProductCrudOperationonCartService productCrudOperationonCartService;

    ModelAndView mv = new ModelAndView();

    @RequestMapping("/cartpage")
    public ModelAndView cart(HttpServletRequest req) {
        TblCart tblcart = new TblCart();
        TblUserTable tbluser = new TblUserTable();
        List<TblUserTable> lstuser = (List<TblUserTable>) req.getSession(false).getAttribute("lstuser");
        if (!lstuser.isEmpty()) {
            tbluser.setUserid(lstuser.get(0).getUserid());
            tblcart.setCreatedby(tbluser);
            Map<TblProduct, List<TblProductImageMapping>> usercartproduct = productCrudOperationonCartService.viewcartproductservice(tblcart);
            mv.addObject("usercartproduct", usercartproduct);
            mv.setViewName("com.damani.carttiles");
        } else {
            mv.setViewName("com.damani.login");
        }
        return mv;
    }
}
