/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author ITMCS-PC
 */
@Controller
public class indexcontroller {
    

  @RequestMapping(value="/")
  public String index()
  {
        return "com.damani.userindex";
  }


  @RequestMapping(value="/loginindex")  
  public String login()
  {
      return "com.damani.login";
  }
  
  @RequestMapping(value="/registrationindex")  
  public String registration()
  {
      return "com.damani.register";
  }  
    
}
