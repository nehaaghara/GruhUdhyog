/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblPayment;
import com.damani.model.TblPaymentMethod;
import com.damani.model.TblShipping;
import com.damani.model.TblUserTable;
import com.damani.repo.PaymentRepository;
import com.damani.service.PaymentService;
import java.math.BigInteger;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    PaymentRepository paymentRepository;
    
    @Override
    public void saveShippingInformation(TblShipping tblShipping,TblUserTable tblUserTable) {
           tblShipping.setCreatedOn(new Date());
           tblShipping.setCreatedBy(tblUserTable);
         paymentRepository.saveShippingInformation(tblShipping,tblUserTable);
    }

    @Override
    public void savePayment(TblPayment tblPayment, TblUserTable tblUserTable) {
        TblPaymentMethod tblPaymentMethod = new TblPaymentMethod();
        tblPaymentMethod.setPaymentmethodPk(new BigInteger("1"));
        tblPayment.setCreatedBy(tblUserTable);
        tblPayment.setCreatedOn(new Date());
        tblPayment.setPaymentmethodFk(tblPaymentMethod);
        paymentRepository.savePaymentDetail(tblPayment, tblUserTable);
    }
    
}
