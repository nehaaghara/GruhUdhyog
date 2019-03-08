/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.service;

import com.damani.model.TblBrand;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public interface SellerBrandService {
    
     void addbrandservice(TblBrand tblBrand);
     
    List<TblBrand> viewbrandservice(BigInteger userid);
    List<TblBrand> editbrandservice(BigInteger brandid);
    void deletebrandservice(BigInteger brandid);
    
}
