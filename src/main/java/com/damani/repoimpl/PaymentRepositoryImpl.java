/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.model.TblPayment;
import com.damani.model.TblShipping;
import com.damani.model.TblUserTable;
import com.damani.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

    @Autowired
    CommonDAO commonDAO;

    @Override
    public TblShipping saveShippingInformation(TblShipping tblShipping, TblUserTable tblUserTable) {
        commonDAO.saveOrUpdate(tblShipping);
        return tblShipping;
    }

    @Override
    public TblPayment savePaymentDetail(TblPayment tblPayment, TblUserTable tblUserTable) {
        commonDAO.save(tblPayment);
        return tblPayment;
    }

}
