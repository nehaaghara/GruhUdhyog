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
@Table(name = "")
public class TblOrder implements Serializable{
    
    @Id
    @Column(name = "orderPK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger orderid;
    
    @Column(name = "orderDate")
    Date orderdate;
    
     
    @Column(name = "orderTotal")
    double ordertotal ;
    
     
    @Column(name = "status")
    boolean status;
    
     
    @Column(name = "paymentMethod")
    String paymentMethod;
   
    @Column(name = "isPaid")
    boolean ispaid;
     
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="createdBy")
    TblUserTable createdby;

    public BigInteger getOrderid() {
        return orderid;
    }

    public void setOrderid(BigInteger orderid) {
        this.orderid = orderid;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public double getOrdertotal() {
        return ordertotal;
    }

    public void setOrdertotal(double ordertotal) {
        this.ordertotal = ordertotal;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isIspaid() {
        return ispaid;
    }

    public void setIspaid(boolean ispaid) {
        this.ispaid = ispaid;
    }

    public TblUserTable getCreatedby() {
        return createdby;
    }

    public void setCreatedby(TblUserTable createdby) {
        this.createdby = createdby;
    }
    
    
    
 }
