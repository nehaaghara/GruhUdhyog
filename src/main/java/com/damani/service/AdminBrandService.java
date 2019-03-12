/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.service;

import com.damani.model.TblAdminBrand;
import com.damani.model.TblUserTable;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public interface AdminBrandService {
    
    public String saveAdminBrand(TblAdminBrand tblAdminBrand,TblUserTable tblUserTable);
    public List<TblAdminBrand> fetchAllBrands();
    public List<TblAdminBrand> fetchBrandsByID(BigInteger userId);
    public TblAdminBrand fetchAdminBrandById(BigInteger brandPk);
    public String deleteBrandById(BigInteger brandPk);
    public String updateBrandById(TblAdminBrand tblAdminBrand,TblUserTable tblUserTable);
}
