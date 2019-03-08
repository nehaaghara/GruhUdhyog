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
            Product
            <small>
                <c:if test="${not empty tblProduct.productPK}">
                    Update
                </c:if>
                <c:if test="${empty tblProduct.productPK}">
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
                        <h3 class="box-title">Product Details</h3>
                    </div>
                    <form:form role="form" id="form" action="${pageContext.servletContext.contextPath}/saveproduct" method="post" onsubmit="return submitProduct();" modelAttribute="tblProduct">
                        <form:hidden path="productPK" name="productPK" id="productPK"/>
                        <div class="box-body">
                            <div id="divAltMsg"></div>
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="categoryFK">Select Category</label>
                                        <form:select path="categoryFK.categoryPK" title="Category" name="categoryFK.categoryPK" id="categoryFK" class="form-control select2" style="width: 100%;">
                                            <option value="-1" disabled="true" selected="true">Please Select</option>
                                            <c:forEach items='${lstCategory}' var='entry'>
                                                <option value="${entry.categoryPK}">${entry.categoryName}</option> 
                                            </c:forEach>  
                                        </form:select>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="exampleInputProductId">Product Name</label>
                                        <form:input path="productName" name="productName" class="form-control" id="productName" title="Product Name"  placeholder="Enter Product" autofocus="on"/>
                                        <span for="productName" class="help-block"><form:errors path="productName"/></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <input type="submit" name="save" value="Save & Exit" class="btn btn-primary"/>
                            <input type="submit" name="saveAndNew" value="Save & New" class="btn btn-primary"/>
                            <input type="button" name="action" value="Cancel" class="btn btn-primary" onclick="window.location.href = '${pageContext.servletContext.contextPath}/viewproduct'"/>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </section>
</div>
<script src="${pageContext.servletContext.contextPath}/webresource/admin/dist/js/productJs.js"></script>
<script src="${pageContext.servletContext.contextPath}/webresource/admin/dist/js/commonJs.js"></script>
