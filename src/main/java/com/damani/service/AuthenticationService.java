/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.service;


import com.damani.model.TblUserTable;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public interface AuthenticationService {
    
    public void registrationservice(TblUserTable usertable);
    public List<TblUserTable> loginservice(TblUserTable usertable);
    
}
