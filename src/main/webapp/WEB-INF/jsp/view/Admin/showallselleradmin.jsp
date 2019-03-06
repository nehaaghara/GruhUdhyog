<%-- 
    Document   : viewtopicadminside
    Created on : Feb 20, 2019, 3:45:52 PM
    Author     : ITMCS-Java
--%>

<%@page import="com.damani.model.TblUserTable"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            Seller List
            <small>view</small>
        </h1>
        <br>
        <input type="button" class="btn btn-primary" name="addseller" value="Add Seller" onclick="window.location.href = '${pageContext.servletContext.contextPath}/add'">
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <!-- /.box-header -->
                    <div class="box-body">
                        <div id="divAltMsg"></div>
                        <c:if test="${not empty SuccessMessage}">
                            <div class="row" style="margin-left: 0px;" id="SuccessMessage">
                                <div class="col-md-6 alert alert-success">
                                    ${SuccessMessage}.
                                </div>
                            </div>

                        </c:if>
                        <c:if test="${not empty DeleteMessage}">
                            <div class="row" style="margin-left: 0px;" id="DeleteMessage">
                                <div class="col-md-6 alert alert-success">
                                    ${DeleteMessage}.
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${not empty UpdateMessage}">
                            <div class="row" style="margin-left: 0px;" id="DeleteMessage">
                                <div class="col-md-6 alert alert-success">
                                    ${UpdateMessage}.
                                </div>
                            </div>
                        </c:if>
                        <table id="example" class="display" style="width:100%">
                            <thead>
                                <tr>
                                    <th>userId</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Email</th>
                                    <th>Password</th>
                                    <th>Phone Number</th>
                                    <th>Role name</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="count" value="1"/>
                                <c:forEach items="${lstseller}" var="seller">
                                    <tr>
                                        <td>${seller.userid}</td>
                                        <td>${seller.first_name}</td>
                                        <td>${seller.last_name}</td>
                                        <td>${seller.email_address}</td>
                                        <td>${seller.password}</td>
                                        <td>${seller.phonenumber}</td>
                                        <td>${seller.tblUserRole.rolePK}</td>
                                        <td><a href="${pageContext.servletContext.contextPath}/editseller/${seller.userid}" style="font-size: 22px;"><i class="fa fa-edit"></i></a></td>
                                        <td><a href="${pageContext.servletContext.contextPath}/deleteseller/${seller.userid}" style="font-size: 22px;"><i class="fa fa-trash"></i></a></td>
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
