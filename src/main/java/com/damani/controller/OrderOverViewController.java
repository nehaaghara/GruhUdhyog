/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblCart;
import com.damani.model.TblProduct;
import com.damani.model.TblProductImageMapping;
import com.damani.model.TblShipping;
import com.damani.model.TblUserTable;
import com.damani.service.OrderOverViewService;
import com.damani.service.ProductCrudOperationonCartService;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ITMCS-PC
 */
@Controller
public class OrderOverViewController {
    
    ModelAndView mv=new ModelAndView();
    
    @Autowired
    OrderOverViewService orderOverViewService;
    
    @Autowired
    ProductCrudOperationonCartService productCrudOperationonCartService;
    
   
    
    @RequestMapping("/orderoverviewpage")
    public ModelAndView orderoverview(HttpServletRequest req)
    {
       TblCart tblcart=new TblCart();
       TblUserTable tbluser = new TblUserTable();
       List<TblUserTable> lstuser =(List<TblUserTable>)req.getSession(false).getAttribute("lstuser");
       tbluser.setUserid(lstuser.get(0).getUserid());
       tblcart.setCreatedby(tbluser);
       Map<TblProduct, List<TblProductImageMapping>> usercartproduct= productCrudOperationonCartService.viewcartproductservice(tblcart);
       List<TblShipping>  lstaddressofuser = orderOverViewService.orderoverviewservice(lstuser.get(0).getUserid());
       mv.addObject("usercartproduct" , usercartproduct );
       mv.addObject("lstaddressofuser" , lstaddressofuser);
       mv.setViewName("com.damani.orderoverviewtiles");
       return mv;
    }
    
    
    @RequestMapping("/deletefromorderoverviewpage/{productPK}")
    public ModelAndView deleteitemfromcart(@PathVariable("productPK") BigInteger productid,HttpServletRequest req)
    {
        List<TblUserTable> lstuser=(List<TblUserTable>)req.getSession(false).getAttribute("lstuser");
        productCrudOperationonCartService.deleteitemservice(productid,lstuser.get(0).getUserid());
        mv.setViewName("redirect:/orderoverviewpage");
        return mv;
    }
}
