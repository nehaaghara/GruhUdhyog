/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblCart;
import com.damani.model.TblProduct;
import com.damani.model.TblProductImageMapping;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damani.service.ProductCrudOperationonCartService;
import com.damani.repo.ProductCrudOperationonCartRepo;

/**
 *
 * @author ITMCS-PC
 */
@Service
public class ProductCrudOperationonCartServiceImpl implements ProductCrudOperationonCartService{

    @Autowired
    ProductCrudOperationonCartRepo productAddOnCartRepo;
    
    @Override
    public void productaddservice(TblCart tblcart) {
        
        productAddOnCartRepo.productaddrepo(tblcart);
    }

    @Override
    public Map<TblProduct,List<TblProductImageMapping>> viewcartproductservice(TblCart tblcart) {
       
     return   productAddOnCartRepo.viewcartproductrepo(tblcart);
    }

    @Override
    public void deleteitemservice(BigInteger productid, BigInteger userid) {
       
        productAddOnCartRepo.deleteitemrepo(productid,userid);
    }

  
    
}
