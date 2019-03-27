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
@Table(name = "tbl_order")
public class TblOrder implements Serializable{
    
    @Id
    @Column(name = "orderPK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger orderid;
    
        @Column(name = "orderno")
    int orderno;
    
    @Column(name = "orderdeliverydate")
    Date orderdeliverydate;
    
    @Column(name = "address")
    String address; 
    
    @Column(name = "orderTotal")
    double ordertotal ;
     
     @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name = "paymentFK")
     TblPaymentMethod  paymentFK;
   
    @Column(name = "isPaid")
    boolean ispaid;
     
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="createdBy")
    TblUserTable createdby;
    
    @Column(name = "createdon")
    Date createdon;
    

    public BigInteger getOrderid() {
        return orderid;
    }

    public void setOrderid(BigInteger orderid) {
        this.orderid = orderid;
    }

    public Date getOrderdeliverydate() {
        return orderdeliverydate;
    }

    public void setOrderdeliverydate(Date orderdeliverydate) {
        this.orderdeliverydate = orderdeliverydate;
    }


    public double getOrdertotal() {
        return ordertotal;
    }

    public void setOrdertotal(double ordertotal) {
        this.ordertotal = ordertotal;
    }

   
    public TblPaymentMethod getPaymentFK() {
        return paymentFK;
    }

    public void setPaymentFK(TblPaymentMethod paymentFK) {
        this.paymentFK = paymentFK;
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

    public int getOrderno() {
        return orderno;
    }

    public void setOrderno(int orderno) {
        this.orderno = orderno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }
    
    
    
 }
