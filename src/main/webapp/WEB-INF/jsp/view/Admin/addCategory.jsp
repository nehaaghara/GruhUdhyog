<%-- 
    Document   : addInvoice
    Created on : 25 Oct, 2018, 4:30:59 PM
    Author     : Mohit Java
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
            <small>
                <c:if test="${not empty tblcategory.categoryPK}">
                    Update
                </c:if>
                <c:if test="${empty tblcategory.categoryPK}">
                    Add 
                </c:if>
            </small>
        </h1>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-md-12">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Category Details</h3>
                    </div>
                    <form:form role="form" id="form" action="${pageContext.servletContext.contextPath}/save" method="post"  modelAttribute="tblcategory">
                        <form:hidden path="categoryPK" name="categoryPK" id="categoryPK"/>
                        <div class="box-body">
                            <div id="divAltMsg"></div>
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="exampleInputCategoryId">Category Name</label>
                                        <form:input path="categoryName" name="categoryName" class="form-control" id="categoryName" title="Category Name"  placeholder="Enter Category" autofocus="on"/>
                                        <span for="categoryName" class="help-block"><form:errors path="categoryName"/></span>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <input type="submit" name="save" value="Save & Exit" class="btn btn-primary"/>
                            <input type="submit" name="saveAndNew" value="Save & New" class="btn btn-primary"/>
                            <input type="button" name="action" value="Cancel" class="btn btn-primary" onclick="window.location.href = '${pageContext.servletContext.contextPath}/view'"/>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </section>
</div>
<!-- datepicker -->
