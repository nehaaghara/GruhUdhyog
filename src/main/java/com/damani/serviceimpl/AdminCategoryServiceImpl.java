/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblCategory;
import com.damani.model.TblUserTable;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damani.repo.AdminCategoryRepository;
import com.damani.service.AdminCategoryService;
import java.util.Date;

/**
 *
 * @author ITMCS
 */
@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {

    @Autowired
    AdminCategoryRepository categoryRepository;

    @Override
    public String saveCategory(TblCategory tblCategory, TblUserTable tblUserTable) {
        tblCategory.setCategoryName(tblCategory.getCategoryName());
        tblCategory.setCreatedBy(tblUserTable);
        tblCategory.setCreatedOn(new Date());
        categoryRepository.saveCategory(tblCategory);
        return "Save Category Successfully";
    }

    @Override
    public List<TblCategory> fetchAllCategory() {
        List<TblCategory> lstCategory = categoryRepository.fetchAllCategory();
        if (!lstCategory.isEmpty()) {
            return lstCategory;
        }
        return null;
    }

    @Override
    public TblCategory fetchCategoryById(BigInteger categoryPK) {
        return categoryRepository.fetchCategoryById(categoryPK);
    }

    @Override
    public String deleteCategoryById(BigInteger categoryPK) {
        TblCategory tblCategory = new TblCategory();
        tblCategory.setCategoryPK(categoryPK);
        if (null != tblCategory.getCategoryPK()) {
            categoryRepository.deleteCategory(tblCategory);
            return "Delete Category Successfully";
        }
        return null;
    }

    @Override
    public String updateCategoryById(TblCategory tblCategory, TblUserTable tblUserTable) {
        TblCategory newTblCategory = categoryRepository.fetchCategoryById(tblCategory.getCategoryPK());
        newTblCategory.setCategoryName(tblCategory.getCategoryName());
        newTblCategory.setCreatedBy(tblUserTable);
        newTblCategory.setCreatedOn(new Date());
        categoryRepository.updateCategory(newTblCategory);
        return "Record Updated SuccessFully";
    }

}
