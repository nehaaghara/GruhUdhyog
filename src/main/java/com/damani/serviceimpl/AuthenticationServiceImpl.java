/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;



import com.damani.model.UserTable;
import com.damani.ripo.AuthenticationRipo;
import com.damani.service.AuthenticationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService{
    @Autowired
    AuthenticationRipo  authenticationRipo; 
   
    @Override
    public void registrationservice(UserTable usertable) {
       authenticationRipo.registrationripo(usertable);
    }
    @Override
    public List<UserTable> loginservice(UserTable usertable) {
     
        return authenticationRipo.loginripo(usertable);
    }
}
