/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblBrand;
import com.damani.model.TblSellerProduct;
import com.damani.model.TblSellerProductImageMapping;
import com.damani.model.TblUserTable;
import com.damani.service.SellerBrandService;
import com.damani.service.SellerProductImageService;
import com.damani.service.SellerProductService;
import com.damani.utility.CommonUtility;
import com.damani.webbean.SellerProductBean;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ITMCS-PC
 */
@Controller
public class SellerProductController {
    
    @Autowired
    SellerProductService sellerProductService;
    
    @Autowired
    SellerBrandService sellerBrandService;
    
    @Autowired
    SellerProductImageService sellerProductImageService;
    
     ModelAndView mv=new ModelAndView();
   @RequestMapping(value="/sellerproductpage",method = RequestMethod.GET)
  public ModelAndView sellerproductpage(HttpServletRequest req)
  {
      List<TblUserTable> lstuser=(List<TblUserTable>)req.getSession(false).getAttribute("lstuser");
      
      
      List<TblBrand> lstbrandbyuserid=sellerProductService.sellerproductpageservice(lstuser.get(0).getUserid());
      
      mv.addObject("lstbrandbyuserid", lstbrandbyuserid);
      mv.addObject("addProduct", new SellerProductBean());
      mv.setViewName("com.damani.selleraddproducttiles");
      return mv;
  }
    
  @RequestMapping(value="/selleraddproduct",method=RequestMethod.POST)
  public ModelAndView addproductseller(@ModelAttribute("addProduct") SellerProductBean sellerProductBean ,HttpServletRequest req)throws Exception
  {
      Date date=new Date();
      List<TblUserTable> lstuser=(List<TblUserTable>)req.getSession(false).getAttribute("lstuser");
      TblUserTable tblUserTable=new TblUserTable();
      tblUserTable.setUserid(lstuser.get(0).getUserid());
    
      sellerProductBean.getTblSellerProduct().setTblUserTable(tblUserTable);
      sellerProductBean.getTblSellerProduct().setCreatedDate(date);
      sellerProductService.selleraddproductservice(sellerProductBean.getTblSellerProduct());
      TblBrand tblBrand = sellerBrandService.editbrandservice(sellerProductBean.getTblSellerProduct().getTblBrand().getBrandid()).get(0);
      List<TblSellerProductImageMapping> lstImageMappings = new ArrayList<>();
      for(MultipartFile file : sellerProductBean.getLstSellerProductImages()){
            String fileName = UUID.randomUUID().toString() + "." +file.getOriginalFilename().split("\\.")[1];
            String filePath = CommonUtility.getProperty("imagePath") + File.separator + "SellerProductImages" + File.separator + tblBrand.getCategoryFk().getCategoryName() + File.separator + tblBrand.getBrandName() + File.separator + sellerProductBean.getTblSellerProduct().getProductname() + File.separator;
            File path = new File(filePath);
            if(!path.exists()){
                path.mkdirs();
            }
            String fullFileName = filePath + fileName;
            File destFile = new File(fullFileName);
            OutputStream os = new FileOutputStream(destFile);
            os.write(file.getBytes());
            os.close();
            TblSellerProductImageMapping tblSellerproductImageMapping = new TblSellerProductImageMapping();
            tblSellerproductImageMapping.setImagePath(fullFileName);
            tblSellerproductImageMapping.setSellerProductFk(sellerProductBean.getTblSellerProduct());
            tblSellerproductImageMapping.setCreatedDate(date);
            tblSellerproductImageMapping.setTblUserTable(tblUserTable);
            lstImageMappings.add(tblSellerproductImageMapping);
      }
      sellerProductImageService.saveSellerProductImageMappings(lstImageMappings);
      mv.setViewName("redirect:/sellerproductpage");
      return mv;
  }
  
  @RequestMapping("/showproductlist")
  public ModelAndView showproduct(HttpServletRequest req)
  {
     List<TblUserTable> lstuser=(List<TblUserTable>)req.getSession(false).getAttribute("lstuser");
     List<TblSellerProduct> lstproduct=sellerProductService.showproductservice(lstuser.get(0).getUserid());
     mv.addObject("lstproduct",lstproduct);
     mv.setViewName("com.damani.viewproducttiles");
     return mv; 
  }
  
  @RequestMapping("/editproduct/{id}")
  public ModelAndView editproduct(@PathVariable("id") BigInteger id ,Model model, HttpServletRequest req)
  {
    List<TblSellerProduct> lstproduct = sellerProductService.editproductservice(id);
    mv.addObject("addProduct", lstproduct.get(0));
    mv.setViewName("com.damani.selleraddproducttiles");
    return mv; 
  }
  
   @RequestMapping("/deleteproduct/{id}")
  public ModelAndView deleteproduct(@PathVariable("id") BigInteger id ,Model model, HttpServletRequest req)
  {
    sellerProductService.deleteproductservice(id);
    mv.setViewName("redirect:/showproductlist");
    return mv; 
  }
}
