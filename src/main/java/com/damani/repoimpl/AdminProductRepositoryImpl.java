/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblProduct;
import com.damani.repo.AdminProductRepository;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public class AdminProductRepositoryImpl implements AdminProductRepository{

    @Autowired
    CommonDAO commonDAO;
    
    @Override
    public TblProduct saveProduct(TblProduct tblProduct) {
         commonDAO.saveOrUpdate(tblProduct);
         return tblProduct;
    }

    @Override
    public List<TblProduct> fetchAllProduct() {
      return commonDAO.findEntity(TblProduct.class);
    }

    @Override
    public TblProduct fetchProductById(BigInteger productPK) {
      List<TblProduct> lstTblProduct = commonDAO.findEntity(TblProduct.class,"productPK",OperationTypeEnum.EQ,productPK);
      if(!lstTblProduct.isEmpty()){
          System.out.println("in repo if");
          return lstTblProduct.get(0);
      }
      return null;
    }

    @Override
    public void deleteProductById(TblProduct tblProduct) {
         commonDAO.delete(tblProduct);
     }

    @Override
    public void updateProductById(TblProduct tblProduct) {
        commonDAO.update(tblProduct);
    }

    @Override
    public List<TblProduct> fetchAllProductById(BigInteger createdBy) {
        List<TblProduct> lstProduct = commonDAO.findEntity(TblProduct.class,"createdBy.userid",OperationTypeEnum.EQ,createdBy);
        return lstProduct;
    }
    
}
