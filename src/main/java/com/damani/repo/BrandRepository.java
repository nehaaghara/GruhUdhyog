/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

import com.damani.model.TblBrand;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public interface BrandRepository {
    
    public TblBrand saveAdminBrand(TblBrand tblAdminBrand);
    public List<TblBrand> fetchAllAdminBrand();
    public List<TblBrand> fetchAllBrandById(BigInteger userId);
    public TblBrand fetchAdminBrandById(BigInteger brandPk);
    public String deleteBrandById(TblBrand tblAdminBrand);
    public String updateBrandById(TblBrand tblAdminBrand);
    
}
