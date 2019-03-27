/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblOrder;
import com.damani.repo.OrderCompleteRepo;
import com.damani.service.OrderCompleteService;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public class OrderCompleteServiceImpl implements  OrderCompleteService{

    @Autowired
    OrderCompleteRepo orderCompleteRepo;
    
    @Override
    public void countinuewithshoppingservice(TblOrder tblorder,List<BigInteger> usercartproductid) {
        
        orderCompleteRepo.countinuewithshoppingrepo(tblorder,usercartproductid);
    }
    
    
    
}
