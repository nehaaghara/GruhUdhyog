/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;



import com.damani.model.TblUserTable;
import com.damani.service.AuthenticationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damani.repo.AuthenticationRepository;

/**
 *
 * @author ITMCS-PC
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService{
    @Autowired
    AuthenticationRepository  authenticationRipo; 
   
    @Override
    public void registrationservice(TblUserTable usertable) {
       authenticationRipo.registrationripo(usertable);
    }
    @Override
    public List<TblUserTable> loginservice(TblUserTable usertable) {
     
        return authenticationRipo.loginripo(usertable);
    }
}
