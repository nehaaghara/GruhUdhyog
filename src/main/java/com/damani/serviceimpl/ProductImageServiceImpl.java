/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblProductImageMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damani.repo.ProductImageRepository;
import com.damani.service.ProductImageService;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author ITMCS
 */
@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    ProductImageRepository adminProductImageRepository;

    @Override
    public void saveAdminProductImages(List<TblProductImageMapping> lstTblAdminProductImageMapping) {
        adminProductImageRepository.addAdminProductImage(lstTblAdminProductImageMapping);
    }

    @Override
    public List<TblProductImageMapping> fetchAllImagesByProductId(BigInteger productFK) {
        System.out.println("in service image::"+productFK);
        return adminProductImageRepository.fetchAdminProductImageByProductId(productFK);

    }

}
