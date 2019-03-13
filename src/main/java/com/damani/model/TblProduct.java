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
@Table(name = "tbl_product")
public class TblProduct implements Serializable {

    @Id
    @Column(name = "productPK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger productPK;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="categoryFK")
    TblCategory categoryFK;
    
    @Column(name = "productName")
    String productName;
    
    @Column(name = "productPrice")
    double productPrice;
    
    @Column(name = "discount")
    String discount;
    
    @Column(name = "productStock")
    int productStock;
    
    @Column(name = "productDiscription")
    String productDiscription;
    
    @Column(name = "createdOn")
    Date createdOn ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="createdBy")
    TblUserTable createdBy;

    public BigInteger getProductPK() {
        return productPK;
    }

    public void setProductPK(BigInteger productPK) {
        this.productPK = productPK;
    }

    public TblCategory getCategoryFK() {
        return categoryFK;
    }

    public void setCategoryFK(TblCategory categoryFK) {
        this.categoryFK = categoryFK;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public String getProductDiscription() {
        return productDiscription;
    }

    public void setProductDiscription(String productDiscription) {
        this.productDiscription = productDiscription;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public TblUserTable getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(TblUserTable createdBy) {
        this.createdBy = createdBy;
    }

}
