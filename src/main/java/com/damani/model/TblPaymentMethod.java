/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.model;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ITMCS
 */
@Entity
@Table(name = "tbl_paymentsMethod")
public class TblPaymentMethod {

    @Id
    @Column(name = "paymentmethodPk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger paymentmethodPk;

    @Column(name = "mathodName")
    String mathodName;

    public BigInteger getPaymentmethodPk() {
        return paymentmethodPk;
    }

    public void setPaymentmethodPk(BigInteger paymentmethodPk) {
        this.paymentmethodPk = paymentmethodPk;
    }

    public String getMathodName() {
        return mathodName;
    }

    public void setMathodName(String mathodName) {
        this.mathodName = mathodName;
    }

}
