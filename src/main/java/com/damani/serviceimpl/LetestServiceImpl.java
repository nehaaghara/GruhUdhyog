/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblProduct;
import com.damani.model.TblProductImageMapping;
import com.damani.repo.LetestRepo;
import com.damani.service.LetestService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public class LetestServiceImpl implements LetestService{

    @Autowired
    LetestRepo letestRepo;
    
    @Override
    public Map<TblProduct, List<TblProductImageMapping>> letestService() {
       
      return  letestRepo.letestRepo();
    }

    @Override
    public Map<TblProduct, List<TblProductImageMapping>> mostofferproductservice() {
        
         return  letestRepo.mostofferproductrepo();
    }
    
}
