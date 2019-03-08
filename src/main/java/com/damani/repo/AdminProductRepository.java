/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

import com.damani.model.TblProduct;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public interface AdminProductRepository {
    
    public TblProduct saveProduct(TblProduct tblProduct);
    
    public List<TblProduct> fetchAllProduct();
    
    public TblProduct fetchProductById(BigInteger productPK);
    
    public void deleteProductById(TblProduct tblProduct);
    
    public void updateProductById(TblProduct tblProduct);
}
