/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.model.TblAdminProductImageMapping;
import com.damani.repo.AdminProductImageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public class AdminProductImageRepositoryImpl implements AdminProductImageRepository{
    @Autowired
    CommonDAO commonDAO;
    
    @Override
    public void addAdminProductImage(TblAdminProductImageMapping tblAdminProductImageMapping) {
        commonDAO.saveOrUpdate(tblAdminProductImageMapping);
    }

    @Override
    public void addAdminProductImage(List<TblAdminProductImageMapping> lsttblAdminProductImageMapping) {
       commonDAO.saveOrUpdateAll(lsttblAdminProductImageMapping);
    }
    
    
}
