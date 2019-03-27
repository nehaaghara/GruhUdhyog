/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblCart;
import com.damani.model.TblShipping;
import com.damani.repo.OrderOverViewRepo;
import com.damani.service.OrderOverViewService;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public class OrderOverViewServiceImpl implements OrderOverViewService{

    @Autowired
    OrderOverViewRepo orderOverViewRepo;
    
    @Override
    public  List<TblShipping> orderoverviewservice(BigInteger userid) {
      
       return orderOverViewRepo.orderoverviewrepo(userid);
        
    }
    
    
    
}
