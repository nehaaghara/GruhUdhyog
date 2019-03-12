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
 * @author ITMCS-PC
 */
@Entity
@Table(name = "tblsellerproduct")
public class TblSellerProduct implements Serializable{
    
    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger productid;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="brandFK")
    TblBrand tblBrand;
    
    @Column(name = "productName")
    String productname;
    
    @Column(name = "productPrice")
    double productprice;
    
    @Column(name = "discount")
    String discount;
    
    @Column(name = "productStock")
    int productstock;
    
    @Column(name = "productDiscription")
    String productdiscription;
    
    @Column(name = "createdDate")
    Date createdDate ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="createdBy")
    TblUserTable tblUserTable;
    
    public BigInteger getProductid() {
        return productid;
    }

    public void setProductid(BigInteger productid) {
        this.productid = productid;
    }

    public TblBrand getTblBrand() {
        return tblBrand;
    }

    public void setTblBrand(TblBrand tblBrand) {
        this.tblBrand = tblBrand;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getProductprice() {
        return productprice;
    }

    public void setProductprice(double productprice) {
        this.productprice = productprice;
    }

    

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getProductstock() {
        return productstock;
    }

    public void setProductstock(int productstock) {
        this.productstock = productstock;
    }

    public String getProductdiscription() {
        return productdiscription;
    }

    public void setProductdiscription(String productdiscription) {
        this.productdiscription = productdiscription;
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
