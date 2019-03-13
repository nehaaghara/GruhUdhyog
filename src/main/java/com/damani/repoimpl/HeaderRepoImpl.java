/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblCategory;
import com.damani.model.TblProduct;
import com.damani.repo.HeaderRepo;
import java.util.ArrayList;
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
public class HeaderRepoImpl implements HeaderRepo{

    @Autowired
    CommonDAO commonDAO;
    
    @Override
    public  Map<TblCategory,List<TblProduct>> categoryrepo() 
    {
        Map<TblCategory,List<TblProduct>> mapofcategorywiseproduct=new HashMap<>();
        List<TblCategory> lstcategory= commonDAO.findEntity(TblCategory.class);
        for (int i = 0; i < lstcategory.size(); i++) {
            
            List<TblProduct> lstproduct=commonDAO.findEntity(TblProduct.class,"categoryFK.categoryPK",OperationTypeEnum.EQ,lstcategory.get(i).getCategoryPK());
            mapofcategorywiseproduct.put(lstcategory.get(i), lstproduct);
            
        }
       return mapofcategorywiseproduct;
    }
    
}
