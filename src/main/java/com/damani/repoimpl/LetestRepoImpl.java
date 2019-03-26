/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.HibernateQueryDao;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblProduct;
import com.damani.model.TblProductImageMapping;
import com.damani.repo.LetestRepo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.awt.SunToolkit;

/**
 *
 * @author ITMCS-PC
 */
@Repository
public class LetestRepoImpl implements LetestRepo {

    @Autowired
    HibernateQueryDao hibernatequerydao;

    @Autowired
    CommonDAO commonDAO;

    @Override
    public Map<TblProduct, List<TblProductImageMapping>> letestRepo() {

        Map<TblProduct, List<TblProductImageMapping>> mapofproductwithimage = new HashMap<>();
        List<TblProduct> lstletestproduct = new ArrayList<>();
        TblProduct tblproduct = new TblProduct();
        String query = "Select p from TblProduct p order by p.productPK DESC";
        List lstobject = hibernatequerydao.createByCountNewQuery(query, null, 0, 10);
        System.out.println("lstobject" + lstobject.size());
        for (int i = 0; i < lstobject.size(); i++) {
            TblProduct tblProduct = (TblProduct) lstobject.get(i);
            lstletestproduct.add(tblProduct);
        }
        for (int i = 0; i < lstletestproduct.size(); i++) {
          List<TblProductImageMapping> lstproductimagebyproductid= commonDAO.findEntity(TblProductImageMapping.class,"adminProductFk.productPK",OperationTypeEnum.EQ,lstletestproduct.get(i).getProductPK());
       
            mapofproductwithimage.put(lstletestproduct.get(i), lstproductimagebyproductid);
        }

        return mapofproductwithimage;
    }

    @Override
    public Map<TblProduct, List<TblProductImageMapping>> mostofferproductrepo() {
          Map<TblProduct, List<TblProductImageMapping>> mostofferproductwithimage = new HashMap<>();
        List<TblProduct> lstletestproduct = new ArrayList<>();
        String query = "Select p from TblProduct p order by p.discount DESC";
        List lstobject = hibernatequerydao.createByCountNewQuery(query, null, 0, 10);
            for(int i=0;i<lstobject.size();i++)
            {
                TblProduct product=(TblProduct)lstobject.get(i);
                lstletestproduct.add(product);
            }
              for(int i=0;i<lstletestproduct.size();i++)
              {
              List<TblProductImageMapping> productwiseimage =  commonDAO.findEntity(TblProductImageMapping.class,"adminProductFk.productPK",OperationTypeEnum.EQ,lstletestproduct.get(i).getProductPK());
             mostofferproductwithimage.put(lstletestproduct.get(i), productwiseimage);
              }
        
        return mostofferproductwithimage;
    }
}
