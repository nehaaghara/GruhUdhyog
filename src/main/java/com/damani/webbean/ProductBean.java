/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.webbean;

import com.damani.model.TblProduct;
import com.damani.model.TblProductImageMapping;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ITMCS
 */
public class ProductBean{
    
     TblProduct tblproduct;
     List<MultipartFile> lstadminproductimage;
     List<TblProductImageMapping> tblProductImageMapping;
     List<String> filePath;

    public List<TblProductImageMapping> getTblProductImageMapping() {
        return tblProductImageMapping;
    }

    public void setTblProductImageMapping(List<TblProductImageMapping> tblProductImageMapping) {
        this.tblProductImageMapping = tblProductImageMapping;
    }

    public List<String> getFilePath() {
        return filePath;
    }

    public void setFilePath(List<String> filePath) {
        this.filePath = filePath;
    }
   
    public TblProduct getTblproduct() {
        return tblproduct;
    }

    public void setTblproduct(TblProduct tblproduct) {
        this.tblproduct = tblproduct;
    }

    public List<MultipartFile> getLstadminproductimage() {
        return lstadminproductimage;
    }

    public void setLstadminproductimage(List<MultipartFile> lstadminproductimage) {
        this.lstadminproductimage = lstadminproductimage;
    }

   
}
