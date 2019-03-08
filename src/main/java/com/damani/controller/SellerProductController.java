/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblBrand;
import com.damani.model.TblSellerProduct;
import com.damani.model.TblUserTable;
import com.damani.service.SellerBrandService;
import com.damani.service.SellerProductService;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ITMCS-PC
 */
@Controller
public class SellerProductController {
    
    @Autowired
    SellerProductService sellerProductService;
    
     ModelAndView mv=new ModelAndView();
   @RequestMapping(value="/sellerproductpage",method = RequestMethod.GET)
  public ModelAndView sellerproductpage(HttpServletRequest req)
  {
      List<TblUserTable> lstuser=(List<TblUserTable>)req.getSession(false).getAttribute("lstuser");
      
      
      List<TblBrand> lstbrandbyuserid=sellerProductService.sellerproductpageservice(lstuser.get(0).getUserid());
      
      mv.addObject("lstbrandbyuserid", lstbrandbyuserid);
      mv.addObject("addProduct", new TblSellerProduct());
      mv.setViewName("com.damani.selleraddproducttiles");
      return mv;
  }
    
  @RequestMapping("/selleraddproduct")
  public ModelAndView addproductseller(@ModelAttribute("addProduct") TblSellerProduct tblSellerProduct ,HttpServletRequest req)
  {
      Date date=new Date();
      List<TblUserTable> lstuser=(List<TblUserTable>)req.getSession(false).getAttribute("lstuser");
      TblUserTable tblUserTable=new TblUserTable();
      tblUserTable.setUserid(lstuser.get(0).getUserid());
    
      tblSellerProduct.setTblUserTable(tblUserTable);
      tblSellerProduct.setCreatedDate(date);
      sellerProductService.selleraddproductservice(tblSellerProduct);
      mv.setViewName("redirect:/sellerproductpage");
      return mv;
  }
  
  @RequestMapping("/showproductlist")
  public ModelAndView showproduct(HttpServletRequest req)
  {
     List<TblUserTable> lstuser=(List<TblUserTable>)req.getSession(false).getAttribute("lstuser");
     List<TblSellerProduct> lstproduct=sellerProductService.showproductservice(lstuser.get(0).getUserid());
     mv.addObject("lstproduct",lstproduct);
     mv.setViewName("com.damani.viewproducttiles");
     return mv; 
  }
  
  @RequestMapping("/editproduct/{id}")
  public ModelAndView editproduct(@PathVariable("id") BigInteger id ,Model model, HttpServletRequest req)
  {
    List<TblSellerProduct> lstproduct = sellerProductService.editproductservice(id);
    mv.addObject("addProduct", lstproduct.get(0));
    mv.setViewName("com.damani.selleraddproducttiles");
    return mv; 
  }
  
   @RequestMapping("/deleteproduct/{id}")
  public ModelAndView deleteproduct(@PathVariable("id") BigInteger id ,Model model, HttpServletRequest req)
  {
    sellerProductService.deleteproductservice(id);
    mv.setViewName("redirect:/showproductlist");
    return mv; 
  }
}
