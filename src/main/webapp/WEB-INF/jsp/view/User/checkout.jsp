<%-- 
    Document   : checkout
    Created on : Mar 12, 2019, 11:01:46 AM
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
                <section class="content">
                    <div class="row">
                        <!-- left column -->
                        <div class="col-md-8">
                            <!-- general form elements -->
                            <div class="box box-primary" style="MARGIN: -15PX -86PX -6PX 190PX;">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Please Enter Your Information</h3>
                                </div>
                                <div style="height: 10px"></div>
                                <form:form action="${pageContext.servletContext.contextPath}/saveshippinginfo" modelAttribute="tblShipping" method="post">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="box-body">
                                                <div class="form-group">
                                                    <form:input path="firstName" type="text" name="firstName"  placeholder="First Name" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="box-body">
                                                <div class="form-group">
                                                    <form:input type="text" path="lastName"  name="lastName"  placeholder="Last Name" /> 
                                                </div>
                                                <!-- /.box-body -->
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="box-body">
                                                <div class="form-group">
                                                    <form:input type="email" path="email" name="email"  placeholder="Email Address" />   </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="box-body">
                                                <div class="form-group">
                                                    <form:input type="text" path="contactNumber" name="contactNumber"  placeholder="Contact Number" />  </div>
                                                <!-- /.box-body -->
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="box-body">
                                                <div class="form-group">
                                                    <form:textarea type="text" path="address" name="address"  placeholder="Shipping Address" cols="45" rows="4"/>
                                                </div>   </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="box-body">
                                                <div class="form-group">
                                                    <form:select name="country" path="country" id="shippingcountryid" style="width: 199px">
                                                        <option selected="" value="">Select Country</option>
                                                        <option value="IN">India</option>
                                                    </form:select>    </div>
                                                <!-- /.box-body -->
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="box-body">
                                                <div class="form-group">
                                                    <form:select name="state" path="state"  id="shippingstateid" style="width: 199px">
                                                        <option value="">Select State</option>
                                                        <option value="AS">Assam</option>
                                                        <option value="BR">Bihar</option>
                                                        <option value="CT">Chhattisgarh</option>
                                                        <option value="GA">Goa</option>
                                                        <option value="GJ">Gujarat</option>
                                                        <option value="HR">Haryana</option>
                                                        <option value="JH">Jharkhand</option>
                                                        <option value="KA">Karnataka</option>
                                                        <option value="KL">Kerala</option>
                                                        <option value="MP">Madhya Pradesh</option>
                                                        <option value="MH">Maharashtra</option>
                                                        <option value="MN">Manipur</option>
                                                        <option value="ML">Meghalaya</option>
                                                        <option value="MZ">Mizoram</option>
                                                        <option value="NL">Nagaland</option>
                                                        <option value="OR">Orissa</option>
                                                        <option value="PB">Punjab</option>
                                                        <option value="RJ">Rajasthan</option>
                                                        <option value="SK">Sikkim</option>
                                                        <option value="TN">Tamil Nadu</option>
                                                        <option value="TS">Telangana</option> 
                                                        <option value="TR">Tripura</option>
                                                        <option value="UK">Uttarakhand</option>
                                                        <option value="UP">Uttar Pradesh</option>
                                                        <option value="WB">West Bengal</option>
                                                        <option value="AN">Andaman and Nicobar Islands</option>
                                                        <option value="CH">Chandigarh</option>
                                                        <option value="DN">Dadar and Nagar Haveli</option>
                                                        <option value="DD">Daman and Diu</option>
                                                        <option value="DL">Delhi</option>
                                                        <option value="LD">Lakshadeep</option>
                                                        <option value="PY">Pondicherry (Puducherry)</option>
                                                    </form:select>   </div>
                                                <!-- /.box-body -->
                                            </div>
                                        </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="box-body">
                                                    <div class="form-group">
                                                        <form:input type="text" path="city" name="city"  placeholder="Select City" />
                                                    </div>
                                                </div>
                                            </div>
                                                <div class="col-md-4">
                                                    <div class="box-body">
                                                        <div class="form-group">
                                                            <form:input type="text" path="postcode" name="postcode"  placeholder="Postcode/zip" />
                                                            <!-- /.box-body -->
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="box-footer">
                                                 <input type="button" name="action" value="Back" class="btn btn-primary" onclick="window.location.href = '${pageContext.servletContext.contextPath}/cartpage'"/>
                                                <input type="submit" name="save" value="Next" class="btn btn-primary"/>
                                                <input type="button" name="action" value="Cancel" class="btn btn-primary" onclick="window.location.href = '${pageContext.servletContext.contextPath}/checkoutpage'"/>
                                            </div>
                                        </form:form>
                                   
                                </div>
                            </div>

                        </div>
                    </div>
            </div>
        </div>
</section>
<!-- CONTAINER END --> 