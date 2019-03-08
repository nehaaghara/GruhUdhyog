/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.service;

import com.damani.model.TblProduct;
import com.damani.model.TblUserTable;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public interface AdminProductService {
    
    public String saveProduct(TblProduct tblProduct,TblUserTable tblUserTable);
    
    public List<TblProduct> fetchAllProduct();
    
    public TblProduct fetchProductById(BigInteger productPK);
    
    public String deleteProductById(BigInteger productPK);
    
    public String updateProductById(TblProduct tblProduct,TblUserTable tblUserTable);
    
}
