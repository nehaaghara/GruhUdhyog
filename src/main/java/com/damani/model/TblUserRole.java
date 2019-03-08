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
import javax.persistence.Id;
import javax.persistence.Table;

/**

 *
 * @author ITMCS
 */


@Entity
@Table(name = "tbl_userrole")
public class TblUserRole implements Serializable{


    @Id
    @Column(name = "rolePK")
    BigInteger rolePK;

    @Column(name = "roleName")
    String roleName;

    @Column(name = "isActive")
    Integer isActive;

    public BigInteger getRolePK() {
        return rolePK;
    }

    public void setRolePK(BigInteger rolePK) {
        this.rolePK = rolePK;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

   

}
