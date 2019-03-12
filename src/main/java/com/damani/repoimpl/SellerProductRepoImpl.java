/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblBrand;
import com.damani.model.TblSellerProduct;
import com.damani.model.TblUserTable;
import com.damani.repo.SellerProductRepo;

import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS-PC
 */
@Repository
public class SellerProductRepoImpl implements SellerProductRepo{

    @Autowired
    CommonDAO commonDAO;
    
    @Override
    public List<TblBrand> sellerproductpagerepo(BigInteger userid) {
       return commonDAO.findEntity(TblBrand.class,"tblUserTable.userid",OperationTypeEnum.EQ,userid);
    }

    @Override
    public void selleraddproductrepo(TblSellerProduct tblSellerProduct) {
        commonDAO.saveOrUpdate(tblSellerProduct);
    }

    @Override
    public List<TblSellerProduct> showproductrepo(BigInteger userid) {
       return  commonDAO.findEntity(TblSellerProduct.class,"tblUserTable.userid",OperationTypeEnum.EQ,userid);
    }

    @Override
    public List<TblSellerProduct> editproductrepo(BigInteger productid) {
        return  commonDAO.findEntity(TblSellerProduct.class,"productid",OperationTypeEnum.EQ,productid);
    }

    @Override
    public void deleteproductrepo(BigInteger productid) {
      List<TblSellerProduct> lstproductbyid=  commonDAO.findEntity(TblSellerProduct.class,"productid",OperationTypeEnum.EQ,productid);
        commonDAO.delete(lstproductbyid.get(0));
    }
    
}
