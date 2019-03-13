/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblProductImageMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.damani.repo.ProductImageRepository;
import java.math.BigInteger;

/**
 *
 * @author ITMCS
 */
@Repository
public class ProductImageRepositoryImpl implements ProductImageRepository{
    @Autowired
    CommonDAO commonDAO;
    
    @Override
    public void addAdminProductImage(TblProductImageMapping tblAdminProductImageMapping) {
        commonDAO.saveOrUpdate(tblAdminProductImageMapping);
    }

    @Override
    public void addAdminProductImage(List<TblProductImageMapping> lsttblAdminProductImageMapping) {
       commonDAO.saveOrUpdateAll(lsttblAdminProductImageMapping);
    }

    @Override
    public List<TblProductImageMapping> fetchAdminProductImageByProductId(BigInteger productFK) {
        System.out.println("in image repo::"+productFK);
        List<TblProductImageMapping> lstProductImageMappings = commonDAO.findEntity(TblProductImageMapping.class,"adminProductFk.productPK",OperationTypeEnum.EQ,productFK);
        return lstProductImageMappings;
    }
    
    
}
