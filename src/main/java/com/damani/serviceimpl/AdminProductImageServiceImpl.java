/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblAdminProductImageMapping;
import com.damani.repo.AdminProductImageRepository;
import com.damani.service.AdminProductImageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public class AdminProductImageServiceImpl implements AdminProductImageService{
    @Autowired
    AdminProductImageRepository adminProductImageRepository;
    
    @Override
    public void saveAdminProductImages(List<TblAdminProductImageMapping> lstTblAdminProductImageMapping) {
      adminProductImageRepository.addAdminProductImage(lstTblAdminProductImageMapping);
    }
    
}
