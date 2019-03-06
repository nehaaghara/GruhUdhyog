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
@Table(name = "tbl_signup")
public class TblUserTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", nullable = false)
    BigInteger userid;

    @Column(name = "first_name")
    String first_name;

    @Column(name = "last_name")
    String last_name;

    @Column(name = "email_address")
    String email_address;

    @Column(name = "password")
    String password;
    
    @Column(name="phonenumber")
    BigInteger phonenumber ;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleFk")
    TblUserRole tblUserRole;

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigInteger getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(BigInteger phonenumber) {
        this.phonenumber = phonenumber;
    }

    public TblUserRole getTblUserRole() {
        return tblUserRole;
    }

    public void setTblUserRole(TblUserRole tblUserRole) {
        this.tblUserRole = tblUserRole;
    }

}
