/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.webbean;

import com.damani.model.TblSellerProduct;
import com.damani.model.TblSellerProductImageMapping;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ITMCS
 */
public class SellerProductBean {
    TblSellerProduct tblSellerProduct;
    List<MultipartFile> lstSellerProductImages;

    public TblSellerProduct getTblSellerProduct() {
        return tblSellerProduct;
    }

    public void setTblSellerProduct(TblSellerProduct tblSellerProduct) {
        this.tblSellerProduct = tblSellerProduct;
    }

    public List<MultipartFile> getLstSellerProductImages() {
        return lstSellerProductImages;
    }

    public void setLstSellerProductImages(List<MultipartFile> lstSellerProductImages) {
        this.lstSellerProductImages = lstSellerProductImages;
    }

    
    
    
}
