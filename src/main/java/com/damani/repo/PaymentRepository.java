/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

import com.damani.model.TblPayment;
import com.damani.model.TblShipping;
import com.damani.model.TblUserTable;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public interface PaymentRepository {
    
    public TblShipping saveShippingInformation(TblShipping tblShipping,TblUserTable tblUserTable);
    public TblPayment savePaymentDetail(TblPayment tblPayment,TblUserTable tblUserTable);
}
