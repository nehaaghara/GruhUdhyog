/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

import com.damani.model.TblUserTable;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public interface AdminSellerRepository {
    
    public void addseller(TblUserTable usertable);
    public List<TblUserTable> viewseller();
    public List<TblUserTable> editsellerripo(BigInteger id);
    public void deletesellerripo(BigInteger id);
}
