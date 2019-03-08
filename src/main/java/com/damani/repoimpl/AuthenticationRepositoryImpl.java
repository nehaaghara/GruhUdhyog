/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;


import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblUserTable;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.damani.repo.AuthenticationRepository;

/**
 *
 * @author ITMCS-PC
 */
@Repository
public class AuthenticationRepositoryImpl implements  AuthenticationRepository{
    @Autowired
    CommonDAO commonDAO;
    
    @Override
    public void registrationripo(TblUserTable usertable) {
        System.out.println(usertable.getFirst_name()+usertable.getLast_name());
         commonDAO.saveOrUpdate(usertable);
     }
    @Override
    public List<TblUserTable> loginripo(TblUserTable usertable) {
        System.out.println("hy i am hingu");
        return commonDAO.findEntity(TblUserTable.class,"email_address", OperationTypeEnum.EQ , usertable.getEmail_address() ,"password",OperationTypeEnum.EQ , usertable.getPassword());
    }
    
}
