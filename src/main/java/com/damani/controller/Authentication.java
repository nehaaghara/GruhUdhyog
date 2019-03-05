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
    
    UserTable usertable=new UserTable();
    
    @RequestMapping("/register")
    public String  registration(HttpServletRequest req)
    {
        String firstname=req.getParameter("fname");
        String lastname=req.getParameter("lname");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        BigInteger phonenumber=new BigInteger(req.getParameter("phone"));
        usertable.setFirstname(firstname);
        usertable.setLastname(lastname);
        usertable.setEmail(email);
        usertable.setPassword(password);
        usertable.setPhonenumber(phonenumber);
        authenticationService.registrationservice(usertable);
        return "";
    }
    
    @RequestMapping("/login")
    public String  loginauthentication(HttpServletRequest req)
    {
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        usertable.setEmail(email);
        usertable.setPassword(password);
        List<UserTable> lstuser= authenticationService.loginservice(usertable);
        HttpSession session=req.getSession(true);
        session.setAttribute("lstuser", lstuser);
        if(lstuser.isEmpty())
        {
         return "";    
        }
        else
        {
         return "";
        }
    }
}
