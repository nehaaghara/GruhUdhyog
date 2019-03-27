/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.model;

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
@Table(name = "tblPayment")
public class TblPayment {

    @Id
    @Column(name = "paymentPk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger paymentPk;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paymentmethodFk")
    TblPaymentMethod paymentmethodFk;

    @Column(name = "createdOn")
    Date createdOn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "createdBy")
    TblUserTable createdBy;

    public BigInteger getPaymentPk() {
        return paymentPk;
    }

    public void setPaymentPk(BigInteger paymentPk) {
        this.paymentPk = paymentPk;
    }

    public TblPaymentMethod getPaymentmethodFk() {
        return paymentmethodFk;
    }

    public void setPaymentmethodFk(TblPaymentMethod paymentmethodFk) {
        this.paymentmethodFk = paymentmethodFk;
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
