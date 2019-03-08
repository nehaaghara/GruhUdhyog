/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblProduct;
import com.damani.model.TblUserTable;
import com.damani.repo.AdminProductRepository;
import com.damani.service.AdminProductService;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public class AdminProductServiceImpl implements AdminProductService{

    @Autowired
    AdminProductRepository adminProductRepository;
    
    @Override
    public String saveProduct(TblProduct tblProduct,TblUserTable tblUserTable) {
        
        tblProduct.setCategoryFK(tblProduct.getCategoryFK());
        System.out.println("category fk"+tblProduct.getCategoryFK().getCategoryPK());
        tblProduct.setProductName(tblProduct.getProductName());
        tblProduct.setIsActive(1);
        tblProduct.setCreatedBy(tblUserTable);
        tblProduct.setCreatedOn(new Date());
        adminProductRepository.saveProduct(tblProduct);
        return "Product Saved  Successfully";
    }

    @Override
    public List<TblProduct> fetchAllProduct() {
        return adminProductRepository.fetchAllProduct();
    }

    @Override
    public TblProduct fetchProductById(BigInteger productPK) {
         return adminProductRepository.fetchProductById(productPK);
    }

    @Override
    public String deleteProductById(BigInteger productPK) {
            TblProduct tblProduct = new TblProduct();
            tblProduct.setProductPK(productPK);
            if(tblProduct.getProductPK()!=null){
                adminProductRepository.deleteProductById(tblProduct);
                return "Category Deleted Successfully";
            }
            return null;
    }

    @Override
    public String updateProductById(TblProduct tblProduct, TblUserTable tblUserTable) {
           TblProduct tblnewProduct = adminProductRepository.fetchProductById(tblProduct.getProductPK());
           tblnewProduct.setCategoryFK(tblProduct.getCategoryFK());
           tblnewProduct.setProductName(tblProduct.getProductName());
           tblnewProduct.setIsActive(1);
           tblnewProduct.setCreatedBy(tblUserTable);
           tblnewProduct.setCreatedOn(new Date());
           adminProductRepository.updateProductById(tblnewProduct);
           return "Product Updated Successfully";
    }
    
}
