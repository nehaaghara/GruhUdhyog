/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.UserTable;
import com.damani.service.AuthenticationService;
import java.math.BigInteger;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author ITMCS-PC
 */
@Controller
public class Authentication {
    @Autowired
    AuthenticationService authenticationService;
    
   
    
    @RequestMapping("/register")
    public String  registration(HttpServletRequest req)
    {
         UserTable usertable=new UserTable();
        String firstname=req.getParameter("fname");
        String lastname=req.getParameter("lname");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        BigInteger phonenumber=new BigInteger(req.getParameter("phone"));
        usertable.setFirst_name(firstname);
        usertable.setLast_name(lastname);
        usertable.setEmail_address(email);
        usertable.setPassword(password);
        usertable.setPhonenumber(phonenumber);
        authenticationService.registrationservice(usertable);
        return "redirect:/loginindex";
    }
    
    @RequestMapping("/loginauthentication")
    public String  loginauthentication(HttpServletRequest req)
    {
        UserTable usertable=new UserTable();
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        usertable.setEmail_address(email);
        usertable.setPassword(password);
        List<UserTable> lstuser= authenticationService.loginservice(usertable);
        System.out.println("lst"+lstuser.size());
        HttpSession session=req.getSession(true);
        session.setAttribute("lstuser", lstuser);
        if(lstuser.isEmpty())
        {
         return "redirect:/loginindex";    
        }
        else
        {
         return "redirect:/";
        }
    }
}
