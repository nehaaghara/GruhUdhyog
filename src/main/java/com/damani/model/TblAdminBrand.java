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
@Table(name = "tbl_brand")
public class TblAdminBrand implements Serializable{

    @Id
    @Column(name = "brandPk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger brandPk;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productFk")
    TblProduct productFk;

    @Column(name = "brandName")
    String brandName;

    @Column(name = "createdOn")
    Date createdOn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "createdBy")
    TblUserTable createdBy;

    public BigInteger getBrandPk() {
        return brandPk;
    }

    public void setBrandPk(BigInteger brandPk) {
        this.brandPk = brandPk;
    }

    public TblProduct getProductFk() {
        return productFk;
    }

    public void setProductFk(TblProduct productFk) {
        this.productFk = productFk;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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
