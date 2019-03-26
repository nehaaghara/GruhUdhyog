/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblCategory;
import com.damani.model.TblProduct;
import com.damani.service.HeaderService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author ITMCS-PC
 */
@Controller
public class HeaderController {
    
    @Autowired
    HeaderService  headerService;     
   
    public  Map<TblCategory,List<TblProduct>>  fetchallcategory()
    {
        Map<TblCategory,List<TblProduct>>  categorywiseproductmap=headerService.categoryservice();
        return categorywiseproductmap;
    }
        
    
    
}
