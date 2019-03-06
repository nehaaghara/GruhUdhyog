<%-- 
    Document   : wishList
    Created on : Mar 5, 2019, 5:15:21 PM
    Author     : ITMCS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 

  <!-- Bread Crumb STRAT -->
  <div class="banner inner-banner1 ">
    <div class="container">
      <section class="banner-detail center-xs">
        <h1 class="banner-title">Wishlist</h1>
        <div class="bread-crumb right-side float-none-xs">
          <ul>
            <li><a href="index-2.html">Home</a>/</li>
            <li><span>Wishlist</span></li>
          </ul>
        </div>
      </section>
    </div>
  </div>
  <!-- Bread Crumb END -->
  
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
                    <th>Descriotion</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Stock Status</th>
                    <th>Action</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>
                      <a href="product-page.html">
                      <div class="product-image"><img alt="Eshoper" src="${pageContext.servletContext.contextPath}/webresource/images/1.jpg"></div>
                      </a>
                    </td>
                    <td>
                      <div class="product-title"> 
                        <a href="product-page.html">Cross Colours Camo Print Tank half mengo</a>
                        <div class="size-text">SIZE:large  <br> <span>PRODUCT ID:0088746</span></div> 
                      </div>
                    </td>
                    <td>
                      <ul>
                        <li>
                          <div class="base-price price-box"> <span class="price">$80.00</span> </div>
                        </li>
                      </ul>
                    </td>
                    <td>
                      <div class="input-box">
                        <select data-id="100" class="quantity_cart" name="quantity_cart">
                          <option selected="" value="1">1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                          <option value="4">4</option>
                        </select>
                      </div>
                    </td>
                    <td><div class="total-price price-box"> <span class="price">In Stock</span> </div></td>
                    <td><a href="cart.html"><i title="Shopping Cart" class="fa fa-shopping-cart" aria-hidden="true"></i></a> <i title="Remove Item From Cart" data-id="100" class="fa fa-trash cart-remove-item"></i></td>
                  </tr>
                  <tr>
                    <td>
                      <a href="product-page.html">
                      <div class="product-image"><img alt="Eshoper" src="${pageContext.servletContext.contextPath}/webresource/images/2.jpg"></div>
                      </a>
                    </td>
                    <td>
                     <div class="product-title"> 
                        <a href="product-page.html">Defyant Reversible Dot Shorts</a>
                        <div class="size-text">SIZE:large  <br> <span>PRODUCT ID:0088746</span></div> 
                      </div>
                    </td>
                    <td>
                      <ul>
                        <li>
                          <div class="base-price price-box"> <span class="price">$80.00</span> </div>
                        </li>
                      </ul>
                    </td>
                    <td>
                      <div class="input-box">
                        <select data-id="100" class="quantity_cart" name="quantity_cart">
                          <option selected="true" value="1">1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                          <option value="4">4</option>
                        </select>
                      </div>
                    </td>
                    <td><div class="total-price price-box"> <span class="price">In Stock</span> </div></td>
                    <td><a href="cart.html"><i title="Shopping Cart" class="fa fa-shopping-cart" aria-hidden="true"></i></a>  <i title="Remove Item From Cart" data-id="100" class="fa fa-trash cart-remove-item"></i></td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      <div class="mb-30">
        <div class="row">
          <div class="col-sm-6">
            <div class="mt-30"> <a href="shop.html" class="btn btn-color"><span><i class="fa fa-angle-left"></i></span>Continue Shopping</a> </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- CONTAINER END --> 
  
  