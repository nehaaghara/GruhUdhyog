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
@Table(name = "tbl_brand")
public class TblBrand implements Serializable{
    
    @Id
    @Column(name = "brandid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger brandid;
    
    @Column(name = "brandname")
    String brandName;

    @Column(name = "createdDate")
    Date createdDate ;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="createdBy")
    TblUserTable tblUserTable;
    
     public BigInteger getBrandid() {
        return brandid;
    }

    public void setBrandid(BigInteger brandid) {
        this.brandid = brandid;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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
