/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ITMCS
 */
@Entity
@Table(name = "tblsellerproductImageMapping")
public class TblSellerProductImageMapping implements Serializable {
    @Id
    @Column(name = "sellerProductImagePk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger sellerProductImagePk;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="sellerProductFk")
    TblSellerProduct sellerProductFk;
    
    @Column(name = "imagePath")
    String imagePath;
    
    @Column(name = "createdDate")
    Date createdDate ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="createdBy")
    TblUserTable tblUserTable;

    public BigInteger getSellerProductImagePk() {
        return sellerProductImagePk;
    }

    public void setSellerProductImagePk(BigInteger sellerProductImagePk) {
        this.sellerProductImagePk = sellerProductImagePk;
    }

    public TblSellerProduct getSellerProductFk() {
        return sellerProductFk;
    }

    public void setSellerProductFk(TblSellerProduct sellerProductFk) {
        this.sellerProductFk = sellerProductFk;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public TblUserTable getTblUserTable() {
        return tblUserTable;
    }

    public void setTblUserTable(TblUserTable tblUserTable) {
        this.tblUserTable = tblUserTable;
    }
    
    
    
}
