<%-- 
    Document   : CartController
    Created on : Mar 12, 2019, 11:53:01 AM
    Author     : ITMCS-PC
--%>

<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<script type="text/javascript">
    var path = '${pageContext.servletContext.contextPath}';

    $(function () {
        viewcart();
    });
    function addcart(productid) {
        $.ajax({
            url: path + '/addcart',
            type: "POST",
            data: {'id': productid},
            success: function (result) {

                viewcart();
            },
            error: function (error) {
                console.log(error.responseText);

            }
        });

    }

    function viewcart() {

        //  var productid=productwithimage.key.productPK;
        $.ajax({
            url: path + '/viewcart',
            type: "GET",

            success: function (usercartproductwithimage) {

                console.log(usercartproductwithimage);
                var json = JSON.parse(usercartproductwithimage);
                var count = 0;
                var subtotal = 0;
                $.each(json, function (obj) {
                    count = count + 1;
                });
                console.log(count);
                $('.cart-list').html('');
                $.each(json, function (index, obj) {

                    var li = $('<li></li>');
                    var productid = obj[0]['adminProductFk']['productPK'];

                    $('<a class="close-cart" onclick="deleteitemfromcart(' + productid + ')"><i class="fa fa-times-circle"></i></a>').appendTo(li);


                    var div = $('<div class="media"></div>');
                    var path = obj[0]['imagePath'].replace(/\\/g, '/').replace('/home/gruhudhyog/', '');
                    var price = obj[0]['adminProductFk']['productPrice'];
                    var discount = obj[0]['adminProductFk']['discount'];
                    var subtotalwithdiscount = price - discount;
                    subtotal = subtotal + subtotalwithdiscount;
                    path = "resources/" + path;
                    $('<a class="pull-left"> <img alt="Eshoper" src="' + path + '">' + obj[0]['adminProductFk']['productName'] + '</a>').appendTo(div);
                    var div1 = $('<div class="media-body"></div>');
                    $('<p class="cart-price">:' + price + 'Rs</p><del class="price old-price">' + discount + '</del><strong> OFF</strong>').appendTo(div1);
                    var div2 = $('<div class="product-qty"></div>');
                    $('<label>Qty:</label>').appendTo(div2);
                    $('<div class="custom-qty"><input type="text" name="qty" maxlength="8" value="1" title="Qty" class="input-text qty"></div>').appendTo(div2);
                    $(div2).appendTo(div1);
                    $(div1).appendTo(div);
                    $(div).appendTo(li);

                    $('.cart-list').append(li);
                });
                $('.cart-notification').html(count);
                $('.price-box1').html(subtotal);
            },
            error: function (error) {
                console.log(error.responseText);

            }
        });

    }

    function deleteitemfromcart(productid) {


        $.ajax({
            url: path + '/removeitemfromcart',
            type: "POST",
            data: {'id': productid},
            success: function (result) {
                console.log(result);
                viewcart();
            },
            error: function (error) {
                console.log(error.responseText);

            }
        });

    }

    // $(document).on("change", "select", function () {
    function submit(ctrl) {
        var selectedVal = $(ctrl).children("option:selected").val();
        var amount = $(ctrl).parent().parent().siblings().find('#temp').text();
        var final = selectedVal * amount;
        $(ctrl).parent().parent().siblings().find('#temp').html(final);
        var str = $('[id^=totalamount]').text();
        var replaced = str.match(/[^ ,]+/g).join(',')
        var arr = replaced.split(',');
        var temp = 0.0;
        for (i = 0; i < arr.length; i++) {
            temp += Number(arr[i]);
        }
         $('#finaltotal').html(temp);
    }

</script>
<!-- CONTAIN START -->
<section class="ptb-95">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 mb-xs-30">
                <div class="cart-item-table commun-table">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Product Name</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Sub Total</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var = "total" value = "0"/> 
                            <div id="abc" value="${fn:length(usercartproduct)}"></div> 
                            <c:forEach var="productwithimage"  items="${usercartproduct}" varStatus="loop"> 

                                <tr>

                                    <c:forEach var="image" items="${productwithimage.value}">
                                        <c:set var = "string1" value = "${image.imagePath}"/>
                                        <c:set var = "string2" value = "${fn:replace(string1, '\\\\', '/')}" />
                                        <c:set var = "string3" value = "${fn:replace(string2, '/home/gruhudhyog/', '')}" />
                                        <td><a href="product-page.html">
                                                <div class="banner"><img alt="Eshoper" src="resources/${string3}"></div>
                                            </a></td></c:forEach>
                                    <td><div class="product-title"> ${productwithimage.key.productName} </div></td>
                                    <td><ul>
                                            <li>
                                                <div class="base-price price-box"> <span class="price">${productwithimage.key.productPrice}  </span><del class="price old-price">${productwithimage.key.discount}</del> <strong style="color: black ">OFF</strong></div>
                                            </li>
                                        </ul></td>
                                    <td><div class="input-box">
                                            <select data-id="100" class="quantity_cart" id="itemtotal" value="2" name="quantity_cart" onchange="submit(this)">
                                                <option selected="" value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                            </select>
                                        </div></td>
                                        <c:set var = "originalvalue"  value = "${productwithimage.key.productPrice}"/>
                                        <c:set var = "discount"  value = "${productwithimage.key.discount}"/>
                                    <td><div class="total-price price-box" id="totalamount" value="${originalvalue - discount}"> <span class="price" id="temp">${originalvalue - discount}</span> </div></td>
                                    <td><a href="" onclick="deleteitemfromcart('${productwithimage.key.productPK}')"><i title="Remove Item From Cart" data-id="100" class="fa fa-trash cart-remove-item"></i></a> </td>
                                </tr>
                                <c:set var = "total" value = "${total + originalvalue - discount }"/> 
                            </c:forEach> 
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="mb-30">
            <div class="row">
                <div class="col-sm-6">
                    <div class="mt-30"> <a href="" class="btn btn-color"><span><i class="fa fa-angle-left"></i></span>Continue Shopping</a> </div>
                </div>

            </div>
        </div>
        <hr>
        <div class="mtb-30">
            <div class="row">
                <div class="col-sm-6">
                    <div class="cart-total-table commun-table">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th colspan="2">Cart Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Item(s) Subtotal</td>
                                        <td><div class="price-box"> <span class="price"></span> </div></td>
                                    </tr>
                                    <tr>
                                        <td><b>Amount Payable</b></td>
                                        <td><div class="price-box"> <span class="price" id="finaltotal"><b>${total}</b></span> </div></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <hr>
        <div class="mt-30">
            <div class="row">
                <div class="col-xs-12">
                    <div class="right-side float-none-xs"> <a href="${pageContext.servletContext.contextPath}/checkoutpage" class="btn btn-color">Proceed to checkout<span><i class="fa fa-angle-right"></i></span></a> </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- CONTAINER END --> 
