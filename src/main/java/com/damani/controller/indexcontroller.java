/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author ITMCS-PC
 */
@Controller
public class indexcontroller {
    
        @RequestMapping(value="/")
        public String index(){
        return "com.damani.userindex";
}

    
    
    
}
