/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblCategory;
import com.damani.model.TblProduct;
import com.damani.repo.HeaderRepo;
import com.damani.service.HeaderService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public class HeaderServiceImpl implements HeaderService{

    @Autowired
    HeaderRepo headerRepo;
    
    @Override
    public  Map<TblCategory,List<TblProduct>>  categoryservice() {
        
        return headerRepo.categoryrepo();
    }
    
}
