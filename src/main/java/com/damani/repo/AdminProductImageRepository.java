/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

import com.damani.model.TblAdminProductImageMapping;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public interface AdminProductImageRepository {
    
    public void addAdminProductImage(TblAdminProductImageMapping tblAdminProductImageMapping);
    public void addAdminProductImage(List<TblAdminProductImageMapping> lsttblAdminProductImageMapping);
    
}
