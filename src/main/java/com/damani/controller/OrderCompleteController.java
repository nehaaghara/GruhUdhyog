/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblCart;
import com.damani.model.TblOrder;
import com.damani.model.TblPayment;
import com.damani.model.TblPaymentMethod;
import com.damani.model.TblProduct;
import com.damani.model.TblProductImageMapping;
import com.damani.model.TblShipping;
import com.damani.model.TblUserTable;
import com.damani.service.OrderCompleteService;
import com.damani.service.OrderOverViewService;
import com.damani.service.ProductCrudOperationonCartService;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
public class OrderCompleteController {
    
    @Autowired
    OrderOverViewService orderOverViewService;   

    @Autowired
    ProductCrudOperationonCartService productCrudOperationonCartService;
    
    @Autowired
    OrderCompleteService orderCompleteService;        
    
    ModelAndView mv=new ModelAndView();
    
    @RequestMapping("/ordercompletepage")
    public ModelAndView ordercomplete(HttpServletRequest req)
    {
        TblCart tblcart=new TblCart();
        TblUserTable tbluser = new TblUserTable();
        List<TblUserTable> lstuser = (List<TblUserTable>)req.getSession(false).getAttribute("lstuser");
        tbluser.setUserid(lstuser.get(0).getUserid());
        tblcart.setCreatedby(tbluser);
        List<TblShipping> lstaddressofuser = orderOverViewService.orderoverviewservice(lstuser.get(0).getUserid());
        Map<TblProduct, List<TblProductImageMapping>> usercartproduct = productCrudOperationonCartService.viewcartproductservice(tblcart);
        mv.addObject("lstaddressofuser",lstaddressofuser);
        mv.addObject("usercartproduct",usercartproduct);
        mv.setViewName("com.damani.ordercompletetiles");
        return mv;
    }
    
    @RequestMapping("/conformorderdatasave")
    public ModelAndView countinuewithshopping(HttpServletRequest req) throws ParseException
    {
        
         String   listofusercartproductid=req.getParameter("listofusercartproductid");
         String substring=listofusercartproductid.substring(1,listofusercartproductid.length()-1);
         String[] arrayofusercartproductid=substring.split(",");
         for(int i=0;i<arrayofusercartproductid.length;i++)
         {
           arrayofusercartproductid[i] = arrayofusercartproductid[i].trim();
         }
         List<BigInteger> usercartproductid=new ArrayList<>();
         for(int i=0 ; i<arrayofusercartproductid.length;i++)
         {
             usercartproductid.add(new BigInteger(arrayofusercartproductid[i]));
             System.out.println(arrayofusercartproductid[i]);
         }
         Date date=new Date();
         TblUserTable tbluser=new TblUserTable();
         TblPaymentMethod tblpayment=new TblPaymentMethod();
         TblOrder tblorder=new TblOrder();
         SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
         String stringdate=  req.getParameter("orderpalcedate");
         LocalDate orderpalcedate = LocalDate.parse(stringdate);
         Date orderdeliverydate = java.sql.Date.valueOf(orderpalcedate);
         double totalpayableamount = Double.parseDouble(req.getParameter("totalpayableamount"));
         int orderno=Integer.parseInt(req.getParameter("orderno"));
         List<TblUserTable> latuser=(List<TblUserTable>)req.getSession(false).getAttribute("lstuser");
         tblpayment.setPaymentmethodPk(new BigInteger("1"));
         tbluser.setUserid(latuser.get(0).getUserid());
         tblorder.setOrderno(orderno);
         tblorder.setOrderdeliverydate(orderdeliverydate);
         tblorder.setOrdertotal(totalpayableamount);
         tblorder.setPaymentFK(tblpayment);
         tblorder.setIspaid(false);
         tblorder.setCreatedby(tbluser);
         tblorder.setCreatedon(date);
         orderCompleteService.countinuewithshoppingservice(tblorder,usercartproductid);
         mv.setViewName("redirect:/userindex");
         return mv;
    }
   
}
