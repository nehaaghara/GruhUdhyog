/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.service;

import com.damani.model.TblPayment;
import com.damani.model.TblShipping;
import com.damani.model.TblUserTable;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public interface PaymentService {
    public void saveShippingInformation(TblShipping tblShipping,TblUserTable tblUserTable);
    public void savePayment(TblPayment tblPayment,TblUserTable tblUserTable);
    
}
