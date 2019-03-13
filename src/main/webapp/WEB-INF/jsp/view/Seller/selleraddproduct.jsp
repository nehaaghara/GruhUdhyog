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
                <c:if test="${not empty adminProductBean.tblproduct.productPK}">
                    Update
                </c:if>
                <c:if test="${empty adminProductBean.tblproduct.productPK}">
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
                    <form:form role="form" id="form" action="${pageContext.servletContext.contextPath}/selleraddproduct" enctype="multipart/form-data"  method="post"  modelAttribute="addProduct">
                        <form:hidden path="tblproduct.productPK" name="tblproduct.productPK" id="tblproduct.productPK"/>
                        <div class="box-body">
                            <div id="divAltMsg"></div>
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="categoryFK">Select Category</label>
                                        <form:select path="tblproduct.categoryFK.categoryPK" title="Category" name="tblproduct.categoryFK.categoryPK" id="categoryFK" class="form-control select2" style="width: 100%;">
                                            <option value="-1" disabled="true" selected="true">Please Select</option>
                                            <c:forEach items='${lstCategory}' var='entry'>
                                                <option value="${entry.categoryPK}">${entry.categoryName}</option> 
                                            </c:forEach>  
                                        </form:select>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Name</label>
                                        <form:input path="tblproduct.productName" type="text" name="tblproduct.productName" class="form-control"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Price </label>
                                        <form:input path="tblproduct.productPrice" type="text" name="tblproduct.productPrice" class="form-control"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Image</label>
                                        <input type="file" path="lstadminproductimage" name="lstadminproductimage" multiple="multiple" class="form-control"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Discount </label>
                                        <form:input path="tblproduct.discount" type="text" name="tblproduct.discount" class="form-control"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Stock</label>
                                        <form:input path="tblproduct.productStock" type="text" name="tblproduct.productStock" class="form-control"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Discription </label>
                                        <form:textarea path="tblproduct.productDiscription" type="text" name="tblproduct.productDiscription" class="form-control" col="20" row="7"></form:textarea>
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
                </div>
            </form:form>
        </div>
</div>
</section>
</div>
<script src="${pageContext.servletContext.contextPath}/webresource/admin/dist/js/productJs.js"></script>
<script src="${pageContext.servletContext.contextPath}/webresource/admin/dist/js/commonJs.js"></script>
