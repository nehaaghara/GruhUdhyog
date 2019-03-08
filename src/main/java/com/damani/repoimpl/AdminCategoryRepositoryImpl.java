/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblCategory;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.damani.repo.AdminCategoryRepository;

/**
 *
 * @author ITMCS
 */
@Repository
public class AdminCategoryRepositoryImpl implements AdminCategoryRepository {

    @Autowired
    CommonDAO commonDAO;

    @Override
    public TblCategory saveCategory(TblCategory tblCategory) {
        commonDAO.saveOrUpdate(tblCategory);
        return tblCategory;
    }

    @Override
    public List<TblCategory> fetchAllCategory() {
        return commonDAO.findEntity(TblCategory.class);
    }

    @Override
    public TblCategory fetchCategoryById(BigInteger categoryPK) {
        List<TblCategory> lsttblCategory = commonDAO.findEntity(TblCategory.class, "categoryPK", OperationTypeEnum.EQ, categoryPK);
        if (!lsttblCategory.isEmpty()) {
            return lsttblCategory.get(0);
        }
        return null;
    }

    @Override
    public String deleteCategory(TblCategory tblCategory) {
        if (null != tblCategory.getCategoryPK()) {
            commonDAO.delete(tblCategory);
            return "Delete Successfully";
        }
        return null;
    }

    @Override
    public String updateCategory(TblCategory tblCategory) {
        commonDAO.update(tblCategory);
        return "Record Deleted SuccessFully";
    }

}
