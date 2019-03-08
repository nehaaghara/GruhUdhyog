<%-- 
    Document   : viewCustomer
    Created on : Nov 15, 2018, 6:28:43 PM
    Author     : ITMCS
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="content-wrapper">
    <section class="content-header">
        <h1>
            Category
            <small>view</small>
        </h1>
        <br>
        <input type="button" class="btn btn-primary" name="addcategory" value="Add Category" onclick="window.location.href = '${pageContext.servletContext.contextPath}/add'">
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
                                <div class="col-md-6  alert alert-success">
                                    ${SuccessMessage}.
                                </div>
                            </div>

                        </c:if>
                        <c:if test="${not empty DeleteMessage}">
                            <div class="row" style="margin-left: 0px;" id="DeleteMessage">
                                <div class="col-md-6  alert alert-success">
                                    ${DeleteMessage}.
                                </div>
                            </div>
                        </c:if>
                         <c:if test="${not empty UpdateMessage}">
                            <div class="row" style="margin-left: 0px;" id="DeleteMessage">
                                <div class="col-md-6  alert alert-success">
                                    ${UpdateMessage}.
                                </div>
                            </div>
                        </c:if>
                        <table id="example" class="display" style="width:100%">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Category PK</th>
                                    <th>Category Name</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="count" value="1"/>
                                <c:forEach items="${lstCategory}" var="entry">
                                    <tr>
                                        <td>${count}</td>
                                        <td>${entry.categoryPK}</td>
                                        <td>${entry.categoryName}</td>
                                        <td><a href="${pageContext.servletContext.contextPath}/edit/${entry.categoryPK}" style="font-size: 22px;"><i class="fa fa-edit"></i></a></td>
                                        <td><a href="${pageContext.servletContext.contextPath}/delete/${entry.categoryPK}" style="font-size: 22px;"><i class="fa fa-trash"></i></a></td>

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