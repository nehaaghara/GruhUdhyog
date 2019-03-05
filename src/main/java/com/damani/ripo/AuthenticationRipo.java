/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.ripo;

import com.damani.model.UserTable;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public interface AuthenticationRipo {
    public void registrationripo(UserTable usertable);
    public List<UserTable> loginripo(UserTable usertable);
}
