/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblBrand;
import com.damani.service.SellerBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damani.repo.SellerBrandRepo;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author ITMCS-PC
 */
@Service
public class SellerBrandServiceImpl implements SellerBrandService{

    @Autowired
    SellerBrandRepo  sellerBrandRepo;
    
    public void addbrandservice(TblBrand tblBrand) {
       sellerBrandRepo.addbrandrepo(tblBrand);
    }

    @Override
    public List<TblBrand> viewbrandservice(BigInteger userid) {
       
       return sellerBrandRepo.viewbrandripo(userid);
    }

    @Override
    public List<TblBrand> editbrandservice(BigInteger brandid) {
         return sellerBrandRepo.editbrandripo(brandid);
    }

    @Override
    public void deletebrandservice(BigInteger brandid) {
        sellerBrandRepo.deletebrandripo(brandid);
    }
    
}
