/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblAdminBrand;
import com.damani.repo.AdminBrandRepository;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public class AdminBrandRepositoryImpl implements AdminBrandRepository {

    @Autowired
    CommonDAO commonDAO;

    @Override
    public TblAdminBrand saveAdminBrand(TblAdminBrand tblAdminBrand) {
        commonDAO.saveOrUpdate(tblAdminBrand);
        return tblAdminBrand;
    }

    @Override
    public List<TblAdminBrand> fetchAllAdminBrand() {
        return commonDAO.findEntity(TblAdminBrand.class);
    }

    @Override
    public TblAdminBrand fetchAdminBrandById(BigInteger brandPk) {
        List<TblAdminBrand> lstTblBrand = commonDAO.findEntity(TblAdminBrand.class, "brandPk", OperationTypeEnum.EQ, brandPk);
        if (!lstTblBrand.isEmpty()) {
            return lstTblBrand.get(0);
        }
        return null;
    }

    @Override
    public String deleteBrandById(TblAdminBrand tblAdminBrand) {
        if(null !=tblAdminBrand.getBrandPk()){
        commonDAO.delete(tblAdminBrand);
        return "Deleted SuccessFully";
        }
        return null;
    }

    @Override
    public String updateBrandById(TblAdminBrand tblAdminBrand) {
        commonDAO.update(tblAdminBrand);
        return "Updated Successfully";
    }

    @Override
    public List<TblAdminBrand> fetchAllBrandById(BigInteger userId) {
        return commonDAO.findEntity(TblAdminBrand.class,"createdBy.userid",OperationTypeEnum.EQ,userId);
    }

}
