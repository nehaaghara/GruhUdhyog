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
import com.google.gson.Gson;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.damani.service.ProductCrudOperationonCartService;

/**
 *
 * @author ITMCS-PC
 */

@Controller
public class ProductCrudOperationonCartController {
    
    @Autowired
    ProductCrudOperationonCartService productAddOnCartService;
    
     
        
    
    @ResponseBody 
    @RequestMapping(value = "/addcart" , method=RequestMethod.POST)
    public String productadd(HttpServletRequest req)
    {
        TblProduct tblproduct=new TblProduct();
        TblUserTable tbluser=new TblUserTable();
        Date date=new Date();
        TblCart tblcart=new TblCart();
       List<TblUserTable> lstuser=(List<TblUserTable>)req.getSession(false).getAttribute("lstuser");
        if(!lstuser.isEmpty())
        {
     
        System.out.println("lstuser.get(0).getUserid()"+lstuser.get(0).getUserid());
        tbluser.setUserid(lstuser.get(0).getUserid());
        BigInteger productid= new BigInteger(req.getParameter("id"));
       
        tblproduct.setProductPK(productid);
        tblcart.setProductFK(tblproduct);
        tblcart.setQuantity(1);
        tblcart.setIsorder(false);
        tblcart.setIsactive(true);
        tblcart.setCreatedon(date);
        tblcart.setCreatedby(tbluser);
        
        productAddOnCartService.productaddservice(tblcart);
        return "success";
        }
        else
        {
            return "com.damani.login";
        }

     }
    
    @ResponseBody 
    @RequestMapping(value = "/viewcart" , method=RequestMethod.GET)
    public String viewcartproduct(HttpServletRequest req)
    {
       
        TblProduct tblproduct=new TblProduct();
        TblUserTable tbluser=new TblUserTable();
        Date date=new Date();
        TblCart tblcart=new TblCart();
          List<TblUserTable> lstuser=(List<TblUserTable>)req.getSession(false).getAttribute("lstuser");
          System.out.println("before setuser");
          tbluser.setUserid(lstuser.get(0).getUserid());
          System.out.println("after setuser"+lstuser.get(0).getUserid());
          tblcart.setCreatedby(tbluser);
         
        return new Gson().toJson(productAddOnCartService.viewcartproductservice(tblcart));
          
    }
    
    @ResponseBody
    @RequestMapping(value = "/removeitemfromcart" , method=RequestMethod.POST)
    public String deleteitem(HttpServletRequest req)
    {
        TblProduct tblproduct=new TblProduct();
        TblUserTable tbluser=new TblUserTable();
        Date date=new Date();
        TblCart tblcart=new TblCart();
       
        BigInteger productid=new BigInteger(req.getParameter("id"));
        
        List<TblUserTable> lstuser=( List<TblUserTable>)req.getSession(false).getAttribute("lstuser");
        BigInteger userid=lstuser.get(0).getUserid();
        productAddOnCartService.deleteitemservice(productid,userid);
        return "success";
    }
}
