/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblBrand;
import com.damani.model.TblSellerProduct;
import com.damani.ripo.SellerProductRepo;
import com.damani.service.SellerProductService;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public class SellerProductServiceImpl implements  SellerProductService{

    @Autowired
    SellerProductRepo sellerProductRepo;
    
    
    @Override
    public List<TblBrand> sellerproductpageservice(BigInteger userid) {
       return sellerProductRepo.sellerproductpagerepo(userid);
    }

    @Override
    public void selleraddproductservice(TblSellerProduct tblSellerProduct) {
        sellerProductRepo.selleraddproductrepo(tblSellerProduct);
    }

    @Override
    public List<TblSellerProduct> showproductservice(BigInteger userid) {
      return  sellerProductRepo.showproductrepo(userid);
    }

    @Override
    public List<TblSellerProduct> editproductservice(BigInteger productid) {
       return sellerProductRepo.editproductrepo(productid);
    }

    @Override
    public void deleteproductservice(BigInteger productid) {
        sellerProductRepo.deleteproductrepo(productid);
    }
    
}
