/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblBrand;
import com.damani.model.TblCategory;
import com.damani.model.TblUserTable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damani.repo.BrandRepository;
import com.damani.service.BrandService;

/**
 *
 * @author ITMCS
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository adminBrandRepository;

    @Override
    public String saveAdminBrand(TblBrand tblAdminBrand, TblUserTable tblUserTable) {
        tblAdminBrand.setProductFk(tblAdminBrand.getProductFk());
        tblAdminBrand.setBrandName(tblAdminBrand.getBrandName());
        tblAdminBrand.setCreatedOn(new Date());
        tblAdminBrand.setCreatedBy(tblUserTable);
        adminBrandRepository.saveAdminBrand(tblAdminBrand);
        return "Brand save Successfully";
    }

    @Override
    public List<TblBrand> fetchAllBrands() {
        List<TblBrand> lstBrand = adminBrandRepository.fetchAllAdminBrand();
        return lstBrand;
    }

    @Override
    public TblBrand fetchAdminBrandById(BigInteger brandPk) {
        return adminBrandRepository.fetchAdminBrandById(brandPk);
    }

    @Override
    public String deleteBrandById(BigInteger brandPk) {
        TblBrand tblAdminBrand = new TblBrand();
        tblAdminBrand.setBrandPk(brandPk);
        if (null != tblAdminBrand.getBrandPk()) {
            adminBrandRepository.deleteBrandById(tblAdminBrand);
            return "Brand Deleted Successfully";
        }
        return null;
    }

    @Override
    public String updateBrandById(TblBrand tblAdminBrand, TblUserTable tblUserTable) {
        TblBrand newtblAdminBrand = adminBrandRepository.fetchAdminBrandById(tblAdminBrand.getBrandPk());
        newtblAdminBrand.setProductFk(tblAdminBrand.getProductFk());
        newtblAdminBrand.setBrandName(tblAdminBrand.getBrandName());
        newtblAdminBrand.setCreatedOn(new Date());
        newtblAdminBrand.setCreatedBy(tblUserTable);
        adminBrandRepository.updateBrandById(newtblAdminBrand);
        return "Brand Updated Successfully";
    }

    @Override
    public List<TblBrand> fetchBrandsByID(BigInteger userId) {
        return adminBrandRepository.fetchAllBrandById(userId);
    }

}
