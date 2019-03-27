<%-- 
    Document   : payment
    Created on : Mar 12, 2019, 11:35:09 AM
    Author     : ITMCS-PC
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- CONTAIN START -->
<section class="checkout-section ptb-95">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <div class="checkout-step mb-40">
                    <ul>
                        <li> <a href="${pageContext.servletContext.contextPath}/checkoutpage">
                                <div class="step">
                                    <div class="line"></div>
                                    <div class="circle">1</div>
                                </div>
                                <span>Shipping</span> </a> </li>
                        <li> <a href="${pageContext.servletContext.contextPath}/orderoverviewpage">
                                <div class="step">
                                    <div class="line"></div>
                                    <div class="circle">2</div>
                                </div>
                                <span>Order Overview</span> </a> </li>
                        <li class="active"> <a href="${pageContext.servletContext.contextPath}/paymentpage">
                                <div class="step">
                                    <div class="line"></div>
                                    <div class="circle">3</div>
                                </div>
                                <span>Payment</span> </a> </li>
                        <li> <a href="${pageContext.servletContext.contextPath}/ordercompletepage">
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
                                <h2 class="heading">Select a payment method</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 col-md-8 col-sm-8 col-lg-offset-3 col-sm-offset-2">
                            <form:form action="${pageContext.servletContext.contextPath}/savePayment" modelAttribute="tblPayment" method="post">
                                <div class="payment-option-box mb-30">
                                    <div class="payment-option-box-inner gray-bg">
                                        <div class="payment-top-box">
                                            <div class="radio-box left-side"> <span>
                                                    <input type="radio" id="cash" value="cash" name="payment_type" path="paymentMethod"/>
                                                </span>
                                                <label for="cash">Would you like to pay by Cash on Delivery?</label>
                                            </div>

                                        </div>
                                        <p>Vestibulum semper accumsan nisi, at blandit tortor maxi'mus in phasellus malesuada sodales odio, at dapibus libero malesuada quis.</p>
                                    </div>
                                </div>
                                <div class="right-side float-none-xs"> 
                                    <input type="submit" value="Place Order" class="btn btn-primary" />
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- CONTAINER END --> 
