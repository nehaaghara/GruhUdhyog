/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblUserRole;
import com.damani.model.TblUserTable;
import com.damani.service.AdminSellerService;
import java.math.BigInteger;
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
public class AdminSellerController{
   
    @Autowired
    AdminSellerService adminSellerService;
    
    @RequestMapping("/addseller")
    public ModelAndView addseller(@ModelAttribute("usertablemodel") TblUserTable usertable , HttpServletRequest req)
    {
        ModelAndView mv=new ModelAndView();
        TblUserRole tblUserRole=new TblUserRole();
        tblUserRole.setRolePK(new BigInteger("2"));
        usertable.setTblUserRole(tblUserRole);
        adminSellerService.adminaddseller(usertable);
        mv.addObject("usertablemodel", new TblUserTable());
        mv.setViewName("com.damani.adminaddsellertiles");
        return mv;
    }
    
    @RequestMapping("/showallsellercontroller")
    public ModelAndView viewseller()
    {
        ModelAndView mv=new ModelAndView();
        List<TblUserTable> lstseller= adminSellerService.viewallseller();
        mv.addObject("lstseller", lstseller);
        mv.setViewName("com.damani.showallsellertiles");
        return mv;
    }
    
     @RequestMapping(value = "/editseller/{id}" , method = RequestMethod.GET)
     public ModelAndView editseller(@PathVariable("id") BigInteger id, Model model) {
        ModelAndView mv = new ModelAndView();
        try {
            List<TblUserTable> lstseller = adminSellerService.editsellerservice(id);
            mv.addObject("usertablemodel", lstseller.get(0));
            mv.setViewName("com.damani.adminaddsellertiles");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;
    }
     
        @RequestMapping(value = "/deleteseller/{id}" , method = RequestMethod.GET)
     public String deleteseller(@PathVariable("id") BigInteger id, Model model) {
      
        try {
            System.out.println("00000000000000000000000000000000000000000"+id);
            adminSellerService.deletesellerservice(id);
           
        } catch (Exception e) {
            e.printStackTrace();
        }

         return "redirect:/showallsellercontroller";
    }
}
