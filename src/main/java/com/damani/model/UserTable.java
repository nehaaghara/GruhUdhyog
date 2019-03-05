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
 * @author ITMCS-PC
 */
@Entity
@Table(name = "Sign_Up")
public class UserTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    BigInteger userid;
    
    @Column(name="first_name")
    String firstname;
    
    @Column(name="last_name")
    String lastname;
    
    @Column(name="email_address")
    String email;
    
    @Column(name="password")
    String password;
    
    @Column(name="phonenumber")
    BigInteger phonenumber ;

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

   
    
    
}
