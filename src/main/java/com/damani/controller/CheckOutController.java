/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ITMCS-PC
 */
@Controller
public class CheckOutController {
    
    ModelAndView mv=new ModelAndView();
    
    @RequestMapping("/checkoutpage")
    public ModelAndView checkout()
    {
        mv.setViewName("com.damani.checkouttiles");
        return mv;
        
    }
}
