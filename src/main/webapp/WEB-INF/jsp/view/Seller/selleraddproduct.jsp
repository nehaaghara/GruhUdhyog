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
                        <form:hidden path="tblProduct.productPK" name="tblProduct.productPK" id="tblProduct.productPK"/>
                        <div class="box-body">
                            <div id="divAltMsg"></div>
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="categoryFK">Select Category</label>
                                        <form:select path="tblProduct.categoryFK.categoryPK" title="Category" name="tblProduct.categoryFK.categoryPK" id="categoryFK" class="form-control select2" style="width: 100%;">
                                            <option value="-1" disabled="true" selected="true">Please Select</option>
                                            <c:forEach items='${lstCategory}' var='entry'>
                                                <option value="${entry.categoryPK}">${entry.categoryName}</option> 
                                            </c:forEach>  
                                        </form:select>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Name</label>
                                        <form:input path="tblProduct.productName" type="text" name="tblProduct.productName" class="form-control"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Price </label>
                                        <form:input path="tblProduct.productPrice" type="text" name="tblProduct.productPrice" class="form-control"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Image</label>
                                        <input type="file" path="lstAdminProductImage" name="lstAdminProductImage" multiple="multiple" class="form-control"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Discount </label>
                                        <form:input path="tblProduct.discount" type="text" name="tblProduct.discount" class="form-control"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Stock</label>
                                        <form:input path="tblProduct.productStock" type="text" name="tblProduct.productStock" class="form-control"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Discription </label>
                                        <form:textarea path="tblProduct.productDiscription" type="text" name="tblProduct.productDiscription" class="form-control" col="20" row="7"></form:textarea>
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
