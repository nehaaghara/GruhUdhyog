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
<style>

    .timeline-item {
        -webkit-box-shadow: 0 1px 1px rgba(0,0,0,0.1);
        box-shadow: 0 1px 1px rgba(0,0,0,0.1);
        border-radius: 3px;
        margin-top: 0;
        background: #fff;
        color: #444;
        margin: 7px;
        margin-right: 48px;
        padding: 0;
        position: relative;
        width: 350px;
        height: 100px;
        overflow-y: scroll;
    }
    .imgcontainer {
        position: relative;
        float:left;
        margin:5px;
        width: 150px;
        height: 100px;
    }

    .margin {
        margin: 10px;
    }
    img{
        vertical-align: middle;
        width: 130px;
        height: 100px;
    }

    .imgcontainer:hover img {
        opacity:0.5;
    }

    .imgcontainer:hover input {
        display: block;
    }

    .imgcontainer input {
        position:absolute;
        display:none;
    }

    .imgcontainer input.delete {
        top:0;
        left:65%;
    }

</style>

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
                    <form:form role="form" id="form" action="${pageContext.servletContext.contextPath}/saveproduct" enctype="multipart/form-data"  method="post"  modelAttribute="adminProductBean">
                        <form:hidden path="tblproduct.productPK" name="tblproduct.productPK" id="productPK"/>
                        <div class="box-body">
                            <div id="divAltMsg"></div>
                            <div class="row">
                                <div class="col-md-4" id="col">
                                    <div class="form-group">
                                        <label for="categoryFK">Select Category</label>
                                        <form:select path="tblproduct.categoryFK.categoryPK" title="Category" name="tblproduct.categoryFK.categoryPK" id="categoryFK" class="form-control select2" style="width: 100%;">
                                            <option value="-1" disabled="true" selected="true">Please Select</option>
                                            <c:forEach items='${lstCategory}' var='entry'>
                                                <c:if test="${tblproduct.categoryFK.categoryPK ne entry.categoryPK}">
                                                    <option value="${entry.categoryPK}">${entry.categoryName}</option> 
                                                </c:if>
                                                <c:if test="${tblproduct.categoryFK.categoryPK eq entry.categoryPK}">
                                                    <option value="${entry.categoryPK}" selected="true">${entry.categoryName}</option> 
                                                </c:if>
                                            </c:forEach>  
                                        </form:select>
                                    </div>

                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Name</label>
                                        <form:input path="tblproduct.productName" name="tblproduct.productName" class="form-control"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Price </label>
                                        <form:input path="tblproduct.productPrice" name="tblproduct.productPrice" class="form-control"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Image</label>
                                        <input type="file" path="lstadminproductimage" id="lstadminproductimage" name="lstadminproductimage" multiple="multiple" class="form-control"  />
                                    </div>
                                    <div class="form-group">
                                        <div class="timeline-item">
                                            <div class="timeline-body" style="padding: 5px;" id="dvProductImgs">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Discount </label>
                                        <form:input path="tblproduct.discount" name="tblproduct.discount" class="form-control"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Stock</label>
                                        <form:input path="tblproduct.productStock" name="tblproduct.productStock" class="form-control"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Product Discription </label>
                                        <form:textarea path="tblproduct.productDiscription" name="tblproduct.productDiscription" class="form-control" col="20" row="7"></form:textarea>
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
                    </form:form>
                </div>

                </section>

            </div>

            <script src="${pageContext.servletContext.contextPath}/webresource/admin/dist/js/productJs.js"></script>
            <script src="${pageContext.servletContext.contextPath}/webresource/admin/dist/js/commonJs.js"></script>
            <script>
                
                                    function readURL(input) {
                                        console.log(input.files.length);
                                        $('#dvProductImgs').html('');
                                        for (var i = 0; i < input.files.length; i++) {
                                            console.log('in loop');
                                            if (input.files && input.files[i]) {
                                                var name = input.files[i]['name'];
                                                var reader = new FileReader();
                                                
                                                reader.onload = function (e) {

                                                    var divImage = "<div class='imgcontainer' >";
                                                    divImage = divImage + '<img id="productImg' + i + '" src="' + e.target.result + '" alt="your image"/>';
                                                    divImage = divImage + '<input class="delete" type="button" value="Delete" onclick="remove(this)" name="' + name + '"/></div></div></div>';
                                                    $('#dvProductImgs').append(divImage);
                                                }
                                                reader.readAsDataURL(input.files[i]);
                                            }
                                        }
                                    }
                                    function remove(e) {
                                        //alert("in function");
                                        $(e).parent().remove();
//                                       var name = $(e).attr('name');
//                                        var input1 = $('input[type=file]');
//                                        console.log(name)
//
//                                        var files = $(input1).prop('files');
//                                        console.log(files);
//
//                                        var removeIndex = 0;
//
//                                        for (var i = 0; i < files.length; i++) {
//                                            if (name == files[i]['name']) {
//                                                removeIndex = i;
//                                            }
//                                        }
//                                       
//                                       
//                                        const dt = new DataTransfer()
//                                        $.each(files, function (index, obj) {
//                                            if (removeIndex != index) {
//                                               // copy[index] = obj;
//                                                dt.items.add(new File([], obj['name']))
//                                            }
//                                        });
//
//                                        
//                                        $(input1).prop('files', dt.files)

                                    }
                                    
                                    $("#lstadminproductimage").change(function () {
                                        readURL(this);
                                    });
            </script>