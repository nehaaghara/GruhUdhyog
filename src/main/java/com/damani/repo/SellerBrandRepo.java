/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

import com.damani.model.TblBrand;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public interface SellerBrandRepo {
    void addbrandrepo(TblBrand tblBrand);
    List<TblBrand> viewbrandripo(BigInteger userid);
    List<TblBrand> editbrandripo(BigInteger brandid);
    void deletebrandripo(BigInteger brandid);
}
