/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblBrand;
import com.damani.model.TblUserTable;
import com.damani.service.SellerBrandService;
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
public class SellerBrandController {
    
    @Autowired
    SellerBrandService sellerBrandService;
    
     @RequestMapping("/selleraddbrand")
    public ModelAndView addseller(@ModelAttribute("addBrand")  TblBrand tblBrand , HttpServletRequest req)
    {   
        TblUserTable tblUserTable=new TblUserTable();
        Date date=new Date();
        ModelAndView mv=new ModelAndView();
        List<TblUserTable> lstuser=(List<TblUserTable>)req.getSession(false).getAttribute("lstuser");
        tblUserTable.setUserid(lstuser.get(0).getUserid());
        tblBrand.setCreatedDate(date);
        tblBrand.setTblUserTable(tblUserTable);
        sellerBrandService.addbrandservice(tblBrand);
        mv.setViewName("redirect:/selleraddbrandindex");
        return mv;
    }
    
    @RequestMapping("/showallbrand")
    public ModelAndView viewbrand(HttpServletRequest req)
    {
        List<TblUserTable> lstuser=( List<TblUserTable> )req.getSession(false).getAttribute("lstuser");
        ModelAndView mv=new ModelAndView();
        List<TblBrand> lstbrand=sellerBrandService.viewbrandservice(lstuser.get(0).getUserid());
        mv.addObject("lstbrand", lstbrand);
        mv.setViewName("com.damani.viewbrandtiles");
        return mv;
    }
    
      
     @RequestMapping(value = "/editbrand/{id}" , method = RequestMethod.GET)
     public ModelAndView editbrand(@PathVariable("id") BigInteger id, Model model) {
        ModelAndView mv = new ModelAndView();
        try {
            List<TblBrand> brand=sellerBrandService.editbrandservice(id);
            mv.addObject("addBrand",brand.get(0));
            mv.setViewName("com.damani.selleraddbrandtiles");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;
    }
     
       
        @RequestMapping(value = "/deletebrand/{id}" , method = RequestMethod.GET)
     public String deleteseller(@PathVariable("id") BigInteger id, Model model) {
      
        try {
            
           sellerBrandService.deletebrandservice(id);
           
        } catch (Exception e) {
            e.printStackTrace();
        }

         return "redirect:/showallbrand";
    }
}
