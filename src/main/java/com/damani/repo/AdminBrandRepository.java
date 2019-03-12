/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

import com.damani.model.TblAdminBrand;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public interface AdminBrandRepository {
    
    public TblAdminBrand saveAdminBrand(TblAdminBrand tblAdminBrand);
    public List<TblAdminBrand> fetchAllAdminBrand();
    public List<TblAdminBrand> fetchAllBrandById(BigInteger userId);
    public TblAdminBrand fetchAdminBrandById(BigInteger brandPk);
    public String deleteBrandById(TblAdminBrand tblAdminBrand);
    public String updateBrandById(TblAdminBrand tblAdminBrand);
    
}
