<%-- 
    Document   : checkout
    Created on : Mar 12, 2019, 11:01:46 AM
    Author     : ITMCS-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <!-- CONTAIN START -->
  <section class="checkout-section ptb-95">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <div class="checkout-step mb-40">
            <ul>
              <li class="active"> <a href="checkout.html">
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
          <div class="checkout-content" >
            <div class="row">
              <div class="col-xs-12">
                <div class="heading-part align-center">
                  <h2 class="heading">Please fill up your Shipping details</h2>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-lg-6 col-md-8 col-sm-8 col-lg-offset-3 col-sm-offset-2">
                <form action="http://aaryaweb.info/html/eshoper/esh003/order-overview.html" class="main-form full">
                  <div class="mb-20">
                    <div class="row">
                      <div class="col-xs-12 mb-20">
                        <div class="heading-part">
                          <h3 class="sub-heading">Shipping Address</h3>
                        </div>
                        <hr>
                      </div>
                      <div class="col-sm-6">
                        <div class="input-box">
                          <input type="text" required placeholder="Full Name">
                        </div>
                      </div>
                      <div class="col-sm-6">
                        <div class="input-box">
                          <input type="email" required placeholder="Email Address">
                        </div>
                      </div>
                      <div class="col-sm-6">
                        <div class="input-box">
                          <input type="text" required placeholder="Company">
                        </div>
                      </div>
                      <div class="col-sm-6">
                        <div class="input-box">
                          <input type="text" required placeholder="Contact Number">
                        </div>
                      </div>
                      <div class="col-sm-12">
                        <div class="input-box">
                          <input type="text" required placeholder="Shipping Address">
                          <span>Please provide the number and street.</span> </div>
                      </div>
                      <div class="col-sm-12">
                        <div class="input-box">
                          <input type="text" required placeholder="Shipping Landmark">
                          <span>Please include landmark (e.g : Opposite Bank) as the carrier service may find it easier to locate your address.</span> </div>
                      </div>
                      <div class="col-sm-6">
                        <div class="input-box">
                          <select name="shippingCountryId" id="shippingcountryid">
                            <option selected="" value="">Select Country</option>
                           
                            <option value="IN">India</option>
                            
                          </select>
                        </div>
                      </div>
                      <div class="col-sm-6">
                        <div class="input-box">
                          <select name="shippingstateId" id="shippingstateid">
                            <option value="">Select a State</option>
                            <option value="AP">Andhra Pradesh</option>
                            <option value="AR">Arunachal Pradesh</option>
                            <option value="AS">Assam</option>
                            <option value="BR">Bihar</option>
                            <option value="CT">Chhattisgarh</option>
                            <option value="GA">Goa</option>
                            <option value="GJ">Gujarat</option>
                            <option value="HR">Haryana</option>
                            <option value="HP">Himachal Pradesh</option>
                            <option value="JK">Jammu and Kashmir</option>
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
                          </select>
                        </div>
                      </div>
                      <div class="col-sm-6">
                        <div class="input-box">
                          <input type="text" required placeholder="Select City">
                        </div>
                      </div>
                      <div class="col-sm-6">
                        <div class="input-box">
                          <input type="text" required placeholder="Postcode/zip">
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-12"> <a href="${pageContext.servletContext.contextPath}/orderoverviewpage" class="btn btn-color right-side">Next</a> </div>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- CONTAINER END --> 