/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.webbean;

import com.damani.model.TblProduct;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ITMCS
 */
public class AdminProductBean {
    TblProduct tblProduct;
    List<MultipartFile> lstAdminProductImage;

    public TblProduct getTblProduct() {
        return tblProduct;
    }

    public void setTblProduct(TblProduct tblProduct) {
        this.tblProduct = tblProduct;
    }

    
    public List<MultipartFile> getLstAdminProductImage() {
        return lstAdminProductImage;
    }

    public void setLstAdminProductImage(List<MultipartFile> lstAdminProductImage) {
        this.lstAdminProductImage = lstAdminProductImage;
    }
    
    
}
