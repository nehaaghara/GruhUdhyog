/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.service;

import com.damani.model.TblOrder;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public interface OrderCompleteService {
    
    public void countinuewithshoppingservice(TblOrder tblorder,List<BigInteger> usercartproductid);
    
}
