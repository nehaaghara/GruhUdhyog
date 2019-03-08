/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.service;

import com.damani.model.TblSellerProductImageMapping;
import java.util.List;

/**
 *
 * @author ITMCS
 */
public interface SellerProductImageService {
    public void saveSellerProductImageMappings(List<TblSellerProductImageMapping> lstTblSellerProductImageMapping);
}
