/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblCart;
import com.damani.model.TblOrder;
import com.damani.model.TblOrderProduct;
import com.damani.model.TblProduct;
import com.damani.model.TblShipping;
import com.damani.model.TblUserTable;
import com.damani.repo.OrderCompleteRepo;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS-PC
 */
@Repository
public class OrderCompleteRepoImpl implements OrderCompleteRepo {

    @Autowired
    CommonDAO commonDAO;

    @Override
    public void countinuewithshoppingrepo(TblOrder tblorder, List<BigInteger> usercartproductid) {
        TblOrder paymentorder=new TblOrder();
        TblProduct product=new TblProduct();
        TblOrderProduct tblOrderProduct=new TblOrderProduct();
        List<TblCart> usercartproduct=new ArrayList<>();
        TblUserTable tbluser = tblorder.getCreatedby();
        List<TblShipping> lstaddress = commonDAO.findEntity(TblShipping.class, "createdBy.userid", OperationTypeEnum.EQ, tbluser.getUserid());
        String useraddress = lstaddress.get(lstaddress.size() - 1).getAddress();
        String usercity = lstaddress.get(lstaddress.size() - 1).getCity();
        String usercountry = lstaddress.get(lstaddress.size() - 1).getCountry();
        String userstate = lstaddress.get(lstaddress.size() - 1).getState();
        String userpincode = lstaddress.get(lstaddress.size() - 1).getPostcode();
        String userfulladdress = usercountry +", "+ userstate +", "+ usercity +", " +useraddress +", "+ "PinCode" +", "+ userpincode;
        tblorder.setAddress(userfulladdress);
        if (usercartproductid.size() > 0) {
            for (int i = 0; i < usercartproductid.size(); i++) {
                List<TblCart> lstcart = commonDAO.findEntity(TblCart.class, "productFK.productPK", OperationTypeEnum.EQ, usercartproductid.get(i),"createdby.userid",OperationTypeEnum.EQ,tblorder.getCreatedby().getUserid());
                lstcart.get(0).setIsorder(true);
                commonDAO.update(lstcart.get(0));
                System.out.println("productid"+lstcart.get(0).getProductFK().getProductPK());
                usercartproduct.add(lstcart.get(0));
            }
            commonDAO.saveOrUpdate(tblorder);
            System.out.println("usercartproduct.size()"+usercartproduct.size());
          List<TblOrder> orderinfo= commonDAO.findEntity(TblOrder.class,"orderno",OperationTypeEnum.EQ,tblorder.getOrderno(),"ispaid",OperationTypeEnum.EQ,false);
            for(int i=0;i<usercartproduct.size();i++)
            {
                product.setProductPK(usercartproduct.get(i).getProductFK().getProductPK());
                paymentorder.setOrderid(orderinfo.get(0).getOrderid());
                tblOrderProduct.setOrderFK(paymentorder);
                tblOrderProduct.setProductFK(product);
                tblOrderProduct.setQuantity(usercartproduct.get(i).getCartPK());
                commonDAO.save(tblOrderProduct);
            }
            
        } else {
            commonDAO.saveOrUpdate(tblorder);
        }

    }

}
