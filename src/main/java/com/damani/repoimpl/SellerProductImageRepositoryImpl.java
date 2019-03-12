/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.model.TblSellerProductImageMapping;
import com.damani.repo.SellerProductImageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public class SellerProductImageRepositoryImpl implements SellerProductImageRepository{
    
    @Autowired
    CommonDAO  commonDAO; 

    @Override
    public void addSellerProductImage(TblSellerProductImageMapping tblSellerProductImage) {
        commonDAO.saveOrUpdate(tblSellerProductImage);
    }

    @Override
    public void addSellerProductImage(List<TblSellerProductImageMapping> tblSellerProductImage) {
        try{
        commonDAO.saveOrUpdateAll(tblSellerProductImage);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
