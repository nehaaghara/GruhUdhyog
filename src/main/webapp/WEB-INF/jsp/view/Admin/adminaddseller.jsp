<%-- 
    Document   : adminaddseller
    Created on : Mar 6, 2019, 12:57:37 PM
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
            <form:form action="${pageContext.servletContext.contextPath}/addseller" modelAttribute="usertablemodel" method="get">
               <form:hidden path="userid" name="userid" id="userid"/>
                <div class="box-body">
                <div class="form-group">
                  <label for="exampleInputEmail1">First Name</label>
                  <form:input path="first_name" type="text" name="fname" class="form-control"  />
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">Last Name</label>
                  <form:input path="last_name" type="text" name="lname" class="form-control"  />
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">Email</label>
                  <form:input path="email_address" type="email" name="email" class="form-control"  />
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">Password</label>
                  <form:input path="password" type="password" name="password" class="form-control"  />
                </div>
                  <div class="form-group">
                  <label for="exampleInputEmail1">Phone Number</label>
                  <form:input path="phonenumber" type="text" name="password" class="form-control"  />
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
  
