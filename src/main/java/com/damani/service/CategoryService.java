/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.service;

import com.damani.model.TblCategory;
import com.damani.model.TblUserTable;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public interface CategoryService {
    
    public String saveCategory(TblCategory tblCategory,TblUserTable tblUserTable);
    
    public List<TblCategory> fetchAllCategory();
    
    public TblCategory fetchCategoryById(BigInteger categoryPK);
    
    public String deleteCategoryById(BigInteger categoryPK);
    
    public String updateCategoryById(TblCategory tblCategory,TblUserTable tblUserTable);
}
