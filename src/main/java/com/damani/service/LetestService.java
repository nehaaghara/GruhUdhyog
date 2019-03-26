/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.service;

import com.damani.model.TblProduct;
import com.damani.model.TblProductImageMapping;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public interface LetestService {

    public Map<TblProduct, List<TblProductImageMapping>> letestService();
    public Map<TblProduct, List<TblProductImageMapping>> mostofferproductservice();
    
}
