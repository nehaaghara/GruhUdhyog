/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblBrand;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.damani.repo.BrandRepository;

/**
 *
 * @author ITMCS
 */
@Repository
public class BrandRepositoryImpl implements BrandRepository {

    @Autowired
    CommonDAO commonDAO;

    @Override
    public TblBrand saveAdminBrand(TblBrand tblAdminBrand) {
        commonDAO.saveOrUpdate(tblAdminBrand);
        return tblAdminBrand;
    }

    @Override
    public List<TblBrand> fetchAllAdminBrand() {
        return commonDAO.findEntity(TblBrand.class);
    }

    @Override
    public TblBrand fetchAdminBrandById(BigInteger brandPk) {
        List<TblBrand> lstTblBrand = commonDAO.findEntity(TblBrand.class, "brandPk", OperationTypeEnum.EQ, brandPk);
        if (!lstTblBrand.isEmpty()) {
            return lstTblBrand.get(0);
        }
        return null;
    }

    @Override
    public String deleteBrandById(TblBrand tblAdminBrand) {
        if(null !=tblAdminBrand.getBrandPk()){
        commonDAO.delete(tblAdminBrand);
        return "Deleted SuccessFully";
        }
        return null;
    }

    @Override
    public String updateBrandById(TblBrand tblAdminBrand) {
        commonDAO.update(tblAdminBrand);
        return "Updated Successfully";
    }

    @Override
    public List<TblBrand> fetchAllBrandById(BigInteger userId) {
        return commonDAO.findEntity(TblBrand.class,"createdBy.userid",OperationTypeEnum.EQ,userId);
    }

}
