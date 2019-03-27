<%-- 
    Document   : orderoverview
    Created on : Mar 12, 2019, 11:18:13 AM
    Author     : ITMCS-PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
 <!-- CONTAIN START -->

  <section class="checkout-section ptb-95">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <div class="checkout-step mb-40">
            <ul>
              <li> <a href="checkout.html">
                <div class="step">
                  <div class="line"></div>
                  <div class="circle">1</div>
                </div>
                <span>Shipping</span> </a> </li>
              <li class="active"> <a href="order-overview.html">
                <div class="step">
                  <div class="line"></div>
                  <div class="circle">2</div>
                </div>
                <span>Order Overview</span> </a> </li>
              <li> <a href="payment.html">
                <div class="step">
                  <div class="line"></div>
                  <div class="circle">3</div>
                </div>
                <span>Payment</span> </a> </li>
              <li> <a href="order-complete.html">
                <div class="step">
                  <div class="line"></div>
                  <div class="circle">4</div>
                </div>
                <span>Order Complete</span> </a> </li>
              <li>
                <div class="step">
                  <div class="line"></div>
                </div>
              </li>
            </ul>
            <hr>
          </div>
          <div class="checkout-content">
            <div class="row">
              <div class="col-xs-12">
                <div class="heading-part align-center">
                  <h2 class="heading">Order Overview</h2>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-8 mb-sm-30">
                <div class="cart-item-table commun-table mb-30">
                  <div class="table-responsive">
                    <table class="table">
                      <thead>
                        <tr>
                          <th>Product</th>
                          <th>Product Detail</th>
                          <th>Sub Total</th>
                          <th>Action</th>
                        </tr>
                      </thead>
                          <c:set var = "amount"  value = "0"/>
                      <tbody>
                          <c:forEach var="userproductwithimage" items="${usercartproduct}">
                        <tr>
                          <td>
                              <div class="product-image"><div class="banner"><div class="main-banner"><c:forEach  begin="0" end="0" var="image" items="${userproductwithimage.value}">
                             <c:set var = "string1" value = "${image.imagePath}"/> 
                            <c:set var = "string2" value = "${fn:replace(string1, '\\\\', '/')}" />
                            <c:set var = "string3" value = "${fn:replace(string2, '/home/gruhudhyog/', '')}" />               
                            <img alt="Honour" src="resources/${string3}"></c:forEach></div></div></div>
                            </td>
                            
                          <td><div class="product-title">${userproductwithimage.key.productName}
                              <div class="product-info-stock-sku m-0">
                                <div>
                                  <label>Price: </label>
                                  <div class="price-box"> <span class="info-deta price">${userproductwithimage.key.productPrice}</span> <del class="price old-price">  ${userproductwithimage.key.discount} </del> </div>
                                </div>
                              </div>
                              <div class="product-info-stock-sku m-0">
                                <div>
                                  <label>Quantity: </label>
                                  <span class="info-deta">1</span></div>
                              </div>
                              </div></td> <c:set var = "originalvalue"  value = "${userproductwithimage.key.productPrice}"/>
                      <c:set var = "discount"  value = "${userproductwithimage.key.discount}"/>
                      <c:set var = "amountwithdiscount"  value = "${originalvalue-discount}"/>
                      <c:set var = "amount"  value = "${amountwithdiscount+amount}"/>
                  
                          <td><div data-id="100" class="total-price price-box"> <span class="price">${originalvalue-discount}</span> </div></td>
                          <td><input type="hidden" name="productid" value="${userproductwithimage.key.productPK}" /><a href="${pageContext.servletContext.contextPath}/deletefromorderoverviewpage/${userproductwithimage.key.productPK}"><i class="fa fa-trash cart-remove-item" data-id="100" title="Remove Item From Cart"></i></a></td>
                      
                        </tr>
                             </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
                <div class="cart-total-table commun-table mb-30">
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
                          <td><div class="price-box"> <span class="price">${amount}</span> </div></td>
                        </tr>
                        <tr>
                          <td>Shipping</td>
                          <td><div class="price-box"> <span class="price">0.00</span> </div></td>
                        </tr>
                        <tr>
                          <td><b>Amount Payable</b></td>
                          <td><div class="price-box"> <span class="price"><b>${amount}</b></span> </div></td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
                <div class="right-side float-none-xs"> <a href="${pageContext.servletContext.contextPath}/paymentpage" class="btn btn-color">Next</a> </div>
              </div>
              <div class="col-sm-4">
                <div class="cart-total-table address-box commun-table mb-30">
                  <div class="table-responsive">
                    <table class="table">
                      <thead>
                        <tr>
                          <th>Shipping Address</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td><ul>
                                  
                                  <c:forEach  varStatus="loop"  var="address" items="${lstaddressofuser}" ><c:if test="${loop.index eq fn:length(lstaddressofuser)-1}"><li class="inner-heading"> <b>${address.firstName} ${address.lastName}</b> </li>
                                      <li class="inner-heading"> <b>${address.email} , ${address.contactNumber}</b> </li>
                                      <li class="inner-heading"> <b>${address.address}</b> </li>
                                      <li class="inner-heading"> <b>${address.country}</b> </li>
                                      <li class="inner-heading"> <b>${address.state} , ${address.city} - ${address.postcode} </b> </li>
                                     
                                      </c:if></c:forEach>
                             </ul></td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
                
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- CONTAINER END --> 
  
