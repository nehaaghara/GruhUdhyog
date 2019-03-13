/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.service;

import com.damani.model.TblBrand;
import com.damani.model.TblUserTable;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public interface BrandService {
    
    public String saveAdminBrand(TblBrand tblAdminBrand,TblUserTable tblUserTable);
    public List<TblBrand> fetchAllBrands();
    public List<TblBrand> fetchBrandsByID(BigInteger userId);
    public TblBrand fetchAdminBrandById(BigInteger brandPk);
    public String deleteBrandById(BigInteger brandPk);
    public String updateBrandById(TblBrand tblAdminBrand,TblUserTable tblUserTable);
}
