/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

import com.damani.model.TblCategory;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public interface AdminCategoryRepository {
    
    public TblCategory saveCategory(TblCategory tblCategory);
    
    public List<TblCategory> fetchAllCategory();
    
    public TblCategory fetchCategoryById(BigInteger categoryPK);
    
    public String deleteCategory(TblCategory tblCategory);
    
    public String updateCategory(TblCategory tblCategory);
    
}
