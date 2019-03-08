/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblUserRole;
import com.damani.model.TblUserTable;
import com.damani.service.AuthenticationService;
import java.math.BigInteger;
import java.util.Date;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


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
        TblUserRole tblUserRole = new TblUserRole();
        tblUserRole.setRolePK(new BigInteger("3"));
        Date date=new Date();
        TblUserTable usertable=new TblUserTable();
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
        usertable.setCreatedDate(date);
        usertable.setTblUserRole(tblUserRole);
        authenticationService.registrationservice(usertable);
        return "redirect:/loginindex";
    }
    
    @RequestMapping("/loginauthentication")
    public ModelAndView  loginauthentication(HttpServletRequest req)
    {
        ModelAndView mv=new ModelAndView();
        TblUserTable usertable=new TblUserTable();
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        usertable.setEmail_address(email);
        usertable.setPassword(password);
        List<TblUserTable> lstuser= authenticationService.loginservice(usertable);
        System.out.println("lst"+lstuser.size());
        HttpSession session=req.getSession(true);
        session.setAttribute("lstuser", lstuser);
        if(!lstuser.isEmpty())
        {
                if(lstuser.get(0).getTblUserRole().getRolePK().equals(new BigInteger("1")))
                {
                    mv.setViewName("com.damani.adminIndex");
                }
                if(lstuser.get(0).getTblUserRole().getRolePK().equals(new BigInteger("2")))
                {
                        mv.setViewName("com.damani.sellerIndex");    
                }
                if(lstuser.get(0).getTblUserRole().getRolePK().equals(new BigInteger("3")))
                {
                    mv.setViewName("com.damani.userindex");
                }
        }
        else
        {
            mv.setViewName("com.damani.login");
        }
        return mv;
    }
}
