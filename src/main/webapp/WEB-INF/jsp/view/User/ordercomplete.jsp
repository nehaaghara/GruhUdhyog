<%-- 
    Document   : ordercomplete
    Created on : Mar 12, 2019, 11:41:45 AM
    Author     : ITMCS-PC
--%>


<%@page import="com.damani.model.TblProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.math.BigInteger"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Random"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%
Random rand = new Random();
int orderno = rand.nextInt(900000) + 10000;

%>
<form action="${pageContext.servletContext.contextPath}/conformorderdatasave" method="get">
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
              <li> <a href="order-overview.html">
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
              <li class="active"> <a href="order-complete.html">
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
                <div class="cart-item-table complete-order-table commun-table mb-30">
                  <div class="table-responsive">
                    <table class="table">
                      <thead>
                        <tr>
                          <th>Product</th>
                          <th>Product Detail</th>
                          <th> Payable Amount </th>
                        </tr>
                      </thead>
                      <tbody>
                          <% List<Object> usercartproductid=new ArrayList();%>
                           <c:set var = "amount"  value = "0"/>
                         <c:forEach var="productwithimage" items="${usercartproduct}" >
                          <tr>
                              <c:set var="productid" value="${productwithimage.key.productPK}" />
                               <% 
                                 usercartproductid.add( pageContext.getAttribute("productid"));
                               %> 
                          <td><a href="product-page.html">
                            <div class="product-image"><c:forEach  begin="0" end="0" var="image" items="${productwithimage.value}">
                             <c:set var = "string1" value = "${image.imagePath}"/> 
                            <c:set var = "string2" value = "${fn:replace(string1, '\\\\', '/')}" />
                            <c:set var = "string3" value = "${fn:replace(string2, '/home/gruhudhyog/', '')}" /> <img alt="Eshoper" src="resources/${string3}"></c:forEach></div>
                            </a></td>
                          <td><div class="product-title"> <a href="product-page.html">Cross Colours Camo Print Tank half mengo</a>
                              <div class="product-info-stock-sku m-0">
                                <div>
                                    <c:set var = "originalvalue"  value = "${productwithimage.key.productPrice}"/>
                                    <c:set var = "discount"  value = "${productwithimage.key.discount}"/>
                                    <c:set var = "amountwithdiscount"  value = "${originalvalue-discount}"/>
                                    <c:set var = "amount"  value = "${amountwithdiscount+amount}"/>
                                  <label>Price: </label>
                                  <div class="price-box"> <span class="info-deta price">${productwithimage.key.productPrice}</span> <del class="price old-price">  ${productwithimage.key.discount} </del></div>
                                </div>
                              </div>
                              <div class="product-info-stock-sku m-0">
                                <div>
                                  <label>Quantity: </label>
                                  <span class="info-deta">1</span> </div>
                              </div>
                            </div></td>
                            <td>${amountwithdiscount}</td>
                        </tr>
                       </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
                         <input type="hidden" name="listofusercartproductid" value="<%= usercartproductid %>">        
                <div class="complete-order-detail commun-table mb-30">
                  <div class="table-responsive">
                    <table class="table">
                      <tbody>
                        <tr>
                          <td><b>Order Places :</b></td>
                         
                              <%
                                LocalDate today = LocalDate.now(); 
                                LocalDate newdate= today.plusDays(10);

                              %>
                        
                        
                       
                          <td> <%= newdate %> </td>
                      <input type="hidden" name="orderpalcedate" value="<%= newdate %>" />
                      <input type="hidden" name="totalpayableamount" value="${amount}" />
                      <input type="hidden" name="orderno" value="<%= orderno %>" />
                        </tr>
                        <tr>
                          <td><b>Total :</b></td>
                          <td><div class="price-box"> <span class="price"> ${amount} </span> </div></td>
                        </tr>
                        <tr>
                          <td><b>Payment :</b></td>
                          <td>COD</td>
                        </tr>
                        <tr>
                          <td><b>Order No. :</b></td>
                          <td><%= orderno %></td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
                <div class="mb-30">
                  <div class="heading-part">
                    <h3 class="sub-heading"> Order Confirmation </h3>
                  </div>
                  <hr>
                  <p class="mt-20">Quisque id fermentum tellus. Donec fringilla mauris nec ligula maximus sodales. Donec ac felis nunc. Fusce placerat volutpat risus, ac fermentum ex tempus eget.</p>
                </div>
                        <div class="right-side float-none-xs"> <button class = "btn btn-color" type="submit"><span><i class="fa fa-angle-left"></i></span>Continue Shopping</button> </div>
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
 </form>
  <!-- CONTAINER END --> 