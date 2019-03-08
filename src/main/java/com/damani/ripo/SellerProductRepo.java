/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.ripo;

import com.damani.model.TblBrand;
import com.damani.model.TblSellerProduct;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public interface SellerProductRepo {
    List<TblBrand> sellerproductpagerepo(BigInteger userid);
    void  selleraddproductrepo(TblSellerProduct tblSellerProduct );
    List<TblSellerProduct> showproductrepo(BigInteger userid);
    List<TblSellerProduct> editproductrepo(BigInteger productid);
    void deleteproductrepo(BigInteger productid);
    
}
