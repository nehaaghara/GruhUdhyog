/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblUserTable;
import com.damani.ripo.AdminSellerRipo;
import com.damani.service.AdminSellerService;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public class AdminSellerServiceImpl implements AdminSellerService{

    @Autowired
    AdminSellerRipo adminSellerRipo;
    
    @Override
    public void adminaddseller(TblUserTable usertable) {
       
        adminSellerRipo.addseller(usertable);
       
    }

    @Override
    public List<TblUserTable> viewallseller() {
        return adminSellerRipo.viewseller();
    }

    @Override
    public List<TblUserTable> editsellerservice(BigInteger id) {
       return adminSellerRipo.editsellerripo(id);
    }

    @Override
    public void deletesellerservice(BigInteger id) {
       adminSellerRipo.deletesellerripo(id);
    }

  

   
    
}
