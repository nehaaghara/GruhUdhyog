<%-- 
    Document   : viewtopicadminside
    Created on : Feb 20, 2019, 3:45:52 PM
    Author     : ITMCS-Java
--%>

<%@page import="com.damani.model.TblBrand"%>
<%@page import="com.damani.model.TblUserTable"%>
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
            Brand List
            <small>view</small>
        </h1>
        <br>
        <input type="button" class="btn btn-primary" name="addbrand" value="Add Brand" onclick="window.location.href = '${pageContext.servletContext.contextPath}/selleraddbrandindex'">
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <!-- /.box-header -->
                    <div class="box-body">
                        <div id="divAltMsg"></div>
                        <% List<TblBrand> lstbrand=(List<TblBrand>) request.getAttribute("lstbrand"); %>
                        <table id="example" class="display" style="width:100%">
                            <thead>
                                <tr>
                                    <th>BrandId</th>
                                    <th>Brand Name</th>
                                    <th>Created Date</th>
                                    <th>Edit Brand</th>
                                    <th>Delete Brand</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="count" value="1"/>
                                <c:forEach items="${lstbrand}" var="lstbrand">
                                    <tr>
                                        <td>${lstbrand.brandid}</td>
                                        <td>${lstbrand.brandName}</td>
                                        <td>${lstbrand.createdDate}</td>
                                        <td><a href="${pageContext.servletContext.contextPath}/editbrand/${lstbrand.brandid}" style="font-size: 22px;"><i class="fa fa-edit"></i></a></td>
                                        <td><a href="${pageContext.servletContext.contextPath}/deletebrand/${lstbrand.brandid}" style="font-size: 22px;"><i class="fa fa-trash"></i></a></td>
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
