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
    <section class="content-header">
        <h1>
            Brand
            <small>
                <c:if test="${not empty tblAdminBrand.brandPk}">
                    Update
                </c:if>
                <c:if test="${empty tblAdminBrand.brandPk}">
                    Add 
                </c:if>
            </small>
        </h1>
    </section>
    <section class="content">
        <div class="row">
            <!-- left column -->
            <div class="col-md-6">
                <!-- general form elements -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Add Brand</h3>
                    </div>
                    <form:form action="${pageContext.servletContext.contextPath}/saveadminbrand" modelAttribute="tblAdminBrand" method="post">
                        <form:hidden path="brandPk" name="brandPk" />
                        <div class="box-body">
                            <div class="form-group">
                                <label for="productFk">Select Product</label>
                                <form:select path="productFk.productPK" title="Product" name="productFk.productPK" id="productFk" class="form-control select2" style="width: 100%;">
                                    <option value="-1" disabled="true" selected="true">Please Select</option>
                                    <c:forEach items='${lstProducts}' var='entry'>
                                        <c:if test="${tblAdminBrand.productFk.productPK eq entry.productPK}">
                                            <option value="${entry.productPK}" selected="true">${entry.productName}</option> 
                                        </c:if>
                                        <c:if test="${tblAdminBrand.productFk.productPK ne entry.productPK}">
                                            <option value="${entry.productPK}">${entry.productName}</option> 
                                        </c:if>
                                    </c:forEach>  
                                </form:select>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputAdminBrand">Brand Name</label>
                                <form:input path="brandName" name="brandName" class="form-control" id="brandName" title="Brand Name"  placeholder="Enter Brand" autofocus="on"/>
                                <span for="brandName" class="help-block"><form:errors path="brandName"/></span>
                            </div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <input type="submit" name="save" value="Save & Exit" class="btn btn-primary"/>
                            <input type="submit" name="saveAndNew" value="Save & New" class="btn btn-primary"/>
                            <input type="button" name="action" value="Cancel" class="btn btn-primary" onclick="window.location.href = '${pageContext.servletContext.contextPath}/viewadminbrand'"/>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
</div>
</div>
<!-- /.content-wrapper -->


