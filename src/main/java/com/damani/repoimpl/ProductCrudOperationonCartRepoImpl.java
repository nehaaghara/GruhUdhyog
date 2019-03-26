/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblCart;
import com.damani.model.TblProduct;
import com.damani.model.TblProductImageMapping;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.damani.repo.ProductCrudOperationonCartRepo;

/**
 *
 * @author ITMCS-PC
 */
@Repository
public class ProductCrudOperationonCartRepoImpl implements ProductCrudOperationonCartRepo{

    @Autowired
    CommonDAO commonDAO;
    
    @Override
    public void productaddrepo(TblCart tblcart) {
        
        List<TblProduct> tblproduct= commonDAO.findEntity(TblProduct.class,"productPK",OperationTypeEnum.EQ,tblcart.getProductFK().getProductPK());
        tblcart.setTotalprice(tblproduct.get(0).getProductPrice());
        System.out.println("ssssssssssssssssssssssssssss"+tblcart.getCreatedby().getUserid());
        commonDAO.saveOrUpdate(tblcart);
    
    }

    @Override
    public Map<TblProduct,List<TblProductImageMapping>> viewcartproductrepo(TblCart tblcart) {
        Map<TblProduct,List<TblProductImageMapping>> usercartproductwithimage=new HashMap<>();
    List<TblCart> usercartproduct=    commonDAO.findEntity(TblCart.class,"createdby",OperationTypeEnum.EQ,tblcart.getCreatedby(),"isorder",OperationTypeEnum.EQ,false);
        for(int i=0;i<usercartproduct.size();i++)
        {
         List<TblProduct> lstproduct = commonDAO.findEntity(TblProduct.class,"productPK",OperationTypeEnum.EQ,usercartproduct.get(i).getProductFK().getProductPK()); 
           for(int j=0;j<lstproduct.size();j++)
           {
              List<TblProductImageMapping> lstproductwithimage= commonDAO.findEntity(TblProductImageMapping.class,"adminProductFk.productPK",OperationTypeEnum.EQ,lstproduct.get(j).getProductPK());
              usercartproductwithimage.put(lstproduct.get(j),lstproductwithimage);
           }
        }
       return  usercartproductwithimage;
    }

    @Override
    public void deleteitemrepo(BigInteger productid,BigInteger userid) {
       
        List<TblCart> productofcart=commonDAO.findEntity(TblCart.class,"productFK.productPK",OperationTypeEnum.EQ,productid,"createdby.userid",OperationTypeEnum.EQ,userid);
        if(!productofcart.isEmpty())
        {
            commonDAO.delete(productofcart.get(0));
        }
        
    }
    
}
