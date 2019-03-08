/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.ripoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.damani.ripo.SellerBrandRepo;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author ITMCS-PC
 */
@Repository
public class SellerBrandRepoImpl implements SellerBrandRepo{

    @Autowired
    CommonDAO  commonDAO; 
    
    @Override
    public void addbrandrepo(TblBrand tblBrand) {
        commonDAO.saveOrUpdate(tblBrand);
    }

    @Override
    public List<TblBrand> viewbrandripo(BigInteger userid) {
       List<TblBrand> lstbrand=commonDAO.findEntity(TblBrand.class,"tblUserTable.userid",OperationTypeEnum.EQ,userid);
       return lstbrand;
    }

    @Override
    public List<TblBrand> editbrandripo(BigInteger brandid) {
       
       return commonDAO.findEntity(TblBrand.class, "brandid",OperationTypeEnum.EQ,brandid);
    }

    @Override
    public void deletebrandripo(BigInteger brandid) {
        
       List<TblBrand> brand=commonDAO.findEntity(TblBrand.class, "brandid",OperationTypeEnum.EQ,brandid);
       commonDAO.delete(brand.get(0));
    }
    
}
