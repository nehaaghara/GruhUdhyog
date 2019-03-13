/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblProduct;
import com.damani.service.LetestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ITMCS-PC
 */
@Controller
public class LetestController {
    
    @Autowired
    LetestService letestService;        
            
    ModelAndView mv=new ModelAndView();
    
    @RequestMapping("/letestpage")
    public ModelAndView letest()
    {
        System.out.println("these is controller");
        List<TblProduct> lstletestproduct=letestService.letestService();
       
        return mv;
    }
    
}
