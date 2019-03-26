/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.interceptor;

import com.damani.model.TblCategory;
import com.damani.model.TblProduct;
import com.damani.model.TblProductImageMapping;
import com.damani.service.HeaderService;
import com.damani.service.LetestService;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ITMCS-PC
 */
public class CustomInterceptor implements HandlerInterceptor{
    @Autowired
    HeaderService  headerService;  
    
    @Autowired
    LetestService letestService;
    
    @Override
    public boolean preHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o) throws Exception {
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, ModelAndView mav) throws Exception {

        Map<TblCategory,List<TblProduct>> mapofcategorywiseproduct=headerService.categoryservice();
        Map<TblProduct, List<TblProductImageMapping>> mapofproductwithimage= letestService.letestService();
        Map<TblProduct, List<TblProductImageMapping>> mostofferproductwithimage=letestService.mostofferproductservice();
        hsr.setAttribute("mapofcategorywiseproduct", mapofcategorywiseproduct);
        hsr.setAttribute("mapofproductwithimage", mapofproductwithimage);
        hsr.setAttribute("mostofferproductwithimage", mostofferproductwithimage);
    }
    
    @Override
    public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn) throws Exception {
        
    }
}
