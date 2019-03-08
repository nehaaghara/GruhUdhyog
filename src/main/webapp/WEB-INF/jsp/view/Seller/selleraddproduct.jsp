<%-- 
    Document   : selleraddbrand
    Created on : Mar 7, 2019, 11:49:34 AM
    Author     : ITMCS-PC
--%>



<%@page import="java.util.List"%>
<%@page import="com.damani.model.TblBrand"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

  <div class="content-wrapper">

    <section class="content">
      <div class="row">
        <!-- left column -->
        <div class="col-md-6">
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">Add Product</h3>
            </div>
            <% List<TblBrand> lstbrandbyuserid=( List<TblBrand>)request.getAttribute("lstbrandbyuserid"); %>
            <form:form action="${pageContext.servletContext.contextPath}/selleraddproduct" modelAttribute="addProduct" method="get">
               <form:hidden path="productid" name="productid" />
               
                <div class="form-group">
                    
                  <label>Select Brand</label>
                  <form:select path="tblBrand.brandid" class="questions-category form-control" name="tblBrand.brandid">
                  <c:forEach items="${lstbrandbyuserid}" var="entry">
                  <form:option value="${entry.brandid}">${entry.brandName}</form:option>
                  </c:forEach>
                  </form:select>
                </div>
               
               <div class="box-body">
                <div class="form-group">
                  <label for="exampleInputEmail1">Product Name</label>
                  <form:input path="productname" type="text" name="productname" class="form-control"  />
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">Product Price </label>
                  <form:input path="productprice" type="text" name="productprice" class="form-control"  />
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">Product Image</label>
                  <form:input path="productimage" type="text" name="productimage" class="form-control"  />
                </div>
                 <div class="form-group">
                  <label for="exampleInputEmail1">Product Discount </label>
                  <form:input path="discount" type="text" name="discount" class="form-control"  />
                </div>
                 <div class="form-group">
                  <label for="exampleInputEmail1">Product Stock</label>
                  <form:input path="productstock" type="text" name="productstock" class="form-control"  />
                </div>
                 <div class="form-group">
                  <label for="exampleInputEmail1">Product Discription </label>
                  <form:textarea path="productdiscription" type="text" name="productdiscription" class="form-control" col="20" row="7"></form:textarea>
                </div>
                
                </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <form:button type="submit" class="btn btn-primary">Submit</form:button>
              </div>
            </form:form>
          </div>
         </div>
      </div>
  </div>
    </div>
  <!-- /.content-wrapper -->
  

