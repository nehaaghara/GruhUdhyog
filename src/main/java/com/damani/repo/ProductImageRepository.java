/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

import com.damani.model.TblProductImageMapping;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public interface ProductImageRepository {
    
    public void addAdminProductImage(TblProductImageMapping tblAdminProductImageMapping);
    public void addAdminProductImage(List<TblProductImageMapping> lsttblAdminProductImageMapping);
    public List<TblProductImageMapping> fetchAdminProductImageByProductId(BigInteger productFK);
    
}
