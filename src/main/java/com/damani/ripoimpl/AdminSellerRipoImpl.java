/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.ripoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblUserTable;
import com.damani.ripo.AdminSellerRipo;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS-PC
 */
@Repository
public class AdminSellerRipoImpl implements AdminSellerRipo{

    @Autowired
    CommonDAO commonDAO;
    
    @Override
    public void addseller(TblUserTable usertable) {
        
        commonDAO.saveOrUpdate(usertable);
    }

    @Override
    public List<TblUserTable> viewseller() {
     return  commonDAO.findEntity(TblUserTable.class,"tblUserRole.rolePK",OperationTypeEnum.EQ,new BigInteger("2"));
    }

    @Override
    public List<TblUserTable> editsellerripo(BigInteger id) {
        List<TblUserTable> lstseller=commonDAO.findEntity(TblUserTable.class,"userid",OperationTypeEnum.EQ,id);
        return  lstseller;
    }

    @Override
    public void deletesellerripo(BigInteger id) {
        List<TblUserTable> lstseller=commonDAO.findEntity(TblUserTable.class,"userid",OperationTypeEnum.EQ,id);
        commonDAO.delete(lstseller.get(0));
    }

   
    
}
