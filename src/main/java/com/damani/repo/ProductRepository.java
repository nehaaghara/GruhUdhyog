/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

import com.damani.model.TblProduct;
import com.damani.model.TblUserTable;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public interface ProductRepository {
    
    public TblProduct saveProduct(TblProduct tblProduct);
    
    public List<TblProduct> fetchAllProduct();
    
    public List<TblProduct> fetchAllProductById(BigInteger createdBy);
    
    public TblProduct fetchProductById(BigInteger productPK);
    
    public void deleteProductById(TblProduct tblProduct);
    
    public void updateProductById(TblProduct tblProduct);
}
