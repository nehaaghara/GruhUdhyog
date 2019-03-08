<%-- 
    Document   : selleraddbrand
    Created on : Mar 7, 2019, 11:49:34 AM
    Author     : ITMCS-PC
--%>



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
                <h3 class="box-title">Add Seller</h3>
            </div>
            <form:form action="${pageContext.servletContext.contextPath}/selleraddbrand" modelAttribute="addBrand" method="get">
               <form:hidden path="brandid" name="brandid" />
                <div class="box-body">
                <div class="form-group">
                  <label for="exampleInputEmail1">Brand Name</label>
                  <form:input path="brandName" type="text" name="fname" class="form-control"  />
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
  

