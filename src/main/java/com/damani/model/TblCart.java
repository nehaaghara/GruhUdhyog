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
@Table(name = "tbl_cart")
public class TblCart implements Serializable {

    @Id
    @Column(name = "cartPK", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger cartPK;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productFK")
    TblProduct productFK;

    @Column(name = "quantity")
    int quantity;

    @Column(name = "isOrder")
    boolean isorder;

    @Column(name = "isActive")
    boolean isactive;

    @Column(name = "createdDate")
    Date createdon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "createdBy")
    TblUserTable createdby;

    @Column(name = "totalPrice")
    double totalprice;

    public BigInteger getCartPK() {
        return cartPK;
    }

    public void setCartPK(BigInteger cartPK) {
        this.cartPK = cartPK;
    }

    public TblProduct getProductFK() {
        return productFK;
    }

    public void setProductFK(TblProduct productFK) {
        this.productFK = productFK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isIsorder() {
        return isorder;
    }

    public void setIsorder(boolean isorder) {
        this.isorder = isorder;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public TblUserTable getCreatedby() {
        return createdby;
    }

    public void setCreatedby(TblUserTable createdby) {
        this.createdby = createdby;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

}
