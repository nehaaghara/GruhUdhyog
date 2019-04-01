/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.model;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "tbl_orderproduct")
public class TblOrderProduct implements Serializable{
    
    @Id
    @Column(name = "orderproductPK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger orderproductPK;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="orderFK")
    TblOrder orderFK;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="productFK")
    TblProduct productFK;
    
    @Column(name="quantity")
    BigInteger quantity;

    public BigInteger getOrderproductPK() {
        return orderproductPK;
    }

    public void setOrderproductPK(BigInteger orderproductPK) {
        this.orderproductPK = orderproductPK;
    }

    public TblOrder getOrderFK() {
        return orderFK;
    }

    public void setOrderFK(TblOrder orderFK) {
        this.orderFK = orderFK; 
    }

    public TblProduct getProductFK() {
        return productFK;
    }

    public void setProductFK(TblProduct productFK) {
        this.productFK = productFK;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

 
 }
