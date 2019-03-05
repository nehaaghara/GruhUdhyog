/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.ripoimpl;

import  com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.UserTable;
import com.damani.ripo.AuthenticationRipo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS-PC
 */
@Repository
public class AuthenticationRipoImpl implements  AuthenticationRipo{
    @Autowired
    CommonDAO commonDAO;
    
    @Override
    public void registrationripo(UserTable usertable) {
         commonDAO.saveOrUpdate(usertable);
     }
    @Override
    public List<UserTable> loginripo(UserTable usertable) {
        return commonDAO.findEntity(UserTable.class, "email", OperationTypeEnum.EQ , usertable.getEmail() , "password",OperationTypeEnum.EQ , usertable.getPassword());
    }
    
}
