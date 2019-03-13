/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;


import com.damani.dal.CommonDAO;
import com.damani.dal.HibernateQueryDao;
import com.damani.model.TblCategory;
import com.damani.model.TblProduct;
import com.damani.model.TblSellerProductImageMapping;
import com.damani.model.TblUserTable;
import com.damani.repo.LetestRepo;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS-PC
 */
@Repository
public class LetestRepoImpl implements LetestRepo{

    @Autowired
    HibernateQueryDao hibernatequerydao;
    
    @Autowired
    CommonDAO commonDAO;
            
    @Override
    public List<TblProduct> letestRepo() {
        
        Map<TblProduct,TblSellerProductImageMapping> mapofproductwithimage=new HashMap<>();
        List<TblProduct> lstletestproduct=new ArrayList<>();
        
        String query="Select p from TblProduct p order by p.productPK DESC";
        List lstproduct= hibernatequerydao.createByCountNewQuery(query, null,0,10);
        for(int i=0;i<lstproduct.size();i++)
        {
           
        }
        
        return lstletestproduct;
}
}