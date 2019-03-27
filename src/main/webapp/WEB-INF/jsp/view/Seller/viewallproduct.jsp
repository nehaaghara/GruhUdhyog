<%-- 
    Document   : viewallproduct
    Created on : Mar 7, 2019, 7:24:25 PM
    Author     : ITMCS-PC
--%>




<%@page import="java.util.List"%>   
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            Product List
            <small>view</small>
        </h1>
        <br>
        <input type="button" class="btn btn-primary" name="addbrand" value="Add Brand" onclick="window.location.href = '${pageContext.servletContext.contextPath}/sellerproductpage'">
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <!-- /.box-header -->
                    <div class="box-body">
                        <div id="divAltMsg"></div>
                          <table id="example" class="display" style="width:100%">
                            <thead>
                                <tr>
                                    <th>Product Id</th>
                                     <th>product Name</th>
                                    <th>product Price</th>
                                    <th>product Discount</th>
                                    <th>product Stock</th>
                                    <th>product Discription</th>
                                    <th>Created Date</th>
                                    <th>Created By</th>
                                    <th>Edit Brand</th>
                                    <th>Delete Brand</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="count" value="1"/>
                                <c:forEach items="${lstproduct}" var="product">
                                    <tr>
                                        <td>${product.productPK}</td>
                                         <td>${product.productName}</td>
                                        <td>${product.productPrice}</td>
                                        <td>${product.discount}</td>
                                        <td>${product.productStock}</td>
                                        <td>${product.productDiscription    }</td>
                                        <td>${product.createdOn}</td>
                                        <td>${product.createdBy.first_name}</td>
                                        <td><a href="${pageContext.servletContext.contextPath}/editsellerproduct/${product.productPK}" style="font-size: 22px;"><i class="fa fa-edit"></i></a></td>
                                        <td><a href="${pageContext.servletContext.contextPath}/deletesellerproduct/${product.productPK}" style="font-size: 22px;"><i class="fa fa-trash"></i></a></td>
                                    </tr>
                                    <c:set var="count" value="${count+1}"/>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->

        <!-- /.row -->
    </section>

</div>

<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });
</script>
