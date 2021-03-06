/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.service;

import com.damani.model.TblProductImageMapping;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public interface ProductImageService {
    public void saveAdminProductImages(List<TblProductImageMapping> lstTblAdminProductImageMapping);
    public List<TblProductImageMapping> fetchAllImagesByProductId(BigInteger productFK);
}
