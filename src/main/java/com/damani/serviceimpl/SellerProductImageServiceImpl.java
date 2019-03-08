/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblSellerProductImageMapping;
import com.damani.repo.SellerProductImageRepository;
import com.damani.service.SellerProductImageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public class SellerProductImageServiceImpl implements SellerProductImageService{
    
    @Autowired
    SellerProductImageRepository sellerProductImageRepository;

    @Override
    public void saveSellerProductImageMappings(List<TblSellerProductImageMapping> lstTblSellerProductImageMapping) {
        sellerProductImageRepository.addSellerProductImage(lstTblSellerProductImageMapping);
    }
    
}
