/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblProduct;
import com.damani.model.TblUserTable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damani.repo.ProductRepository;
import com.damani.service.ProductService;

/**
 *
 * @author ITMCS
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository adminProductRepository;

    @Override
    public String saveProduct(TblProduct tblProduct, TblUserTable tblUserTable) {
        tblProduct.setCategoryFK(tblProduct.getCategoryFK());
        tblProduct.setProductName(tblProduct.getProductName());
        tblProduct.setProductPrice(tblProduct.getProductPrice());
        tblProduct.setDiscount(tblProduct.getDiscount());
        tblProduct.setProductStock(tblProduct.getProductStock());
        tblProduct.setProductDiscription(tblProduct.getProductDiscription());
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
        if (tblProduct.getProductPK() != null) {
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
        tblnewProduct.setProductPrice(tblProduct.getProductPrice());
        tblnewProduct.setDiscount(tblProduct.getDiscount());
        tblnewProduct.setProductStock(tblProduct.getProductStock());
        tblnewProduct.setProductDiscription(tblProduct.getProductDiscription());
        tblnewProduct.setCreatedBy(tblUserTable);
        tblnewProduct.setCreatedOn(new Date());
        adminProductRepository.updateProductById(tblnewProduct);
        return "Product Updated Successfully";
    }

    @Override
    public List<TblProduct> fetchAllProductByUserId(BigInteger createdBy) {
        return adminProductRepository.fetchAllProductById(createdBy);
    }

}
