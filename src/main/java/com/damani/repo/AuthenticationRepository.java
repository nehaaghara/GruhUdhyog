/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

import com.damani.model.TblUserTable;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public interface AuthenticationRepository {
    public void registrationripo(TblUserTable usertable);
    public List<TblUserTable> loginripo(TblUserTable usertable);
}
