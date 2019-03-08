/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Blob;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ITMCS
 */
@Entity
@Table(name = "tbl_category")
public class TblCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryPK", nullable = false)
    BigInteger categoryPK;

    @Column(name = "categoryName")
    String categoryName;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "createdBy")
    TblUserTable createdBy;

    @Column(name = "createdOn")
    Date createdOn;
    
    @Column(name = "image")
    String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public TblUserTable getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(TblUserTable createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }


    public BigInteger getCategoryPK() {
        return categoryPK;
    }

    public void setCategoryPK(BigInteger categoryPK) {
        this.categoryPK = categoryPK;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
