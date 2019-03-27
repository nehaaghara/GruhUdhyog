/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblCart;
import com.damani.model.TblShipping;
import com.damani.repo.OrderOverViewRepo;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS-PC
 */
@Repository
public class OrderOverViewRepoImpl implements OrderOverViewRepo
{
    @Autowired
    CommonDAO commonDAO ;
    
    @Override
    public   List<TblShipping> orderoverviewrepo(BigInteger userid) {
      
        List<TblShipping> lstuseraddress=commonDAO.findEntity(TblShipping.class,"createdBy.userid",OperationTypeEnum.EQ,userid);
        System.out.println("lstuseraddress"+lstuseraddress.size());
        return lstuseraddress;
    }
    
}
