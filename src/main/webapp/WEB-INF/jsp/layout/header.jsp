<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body class="homepage">
<div class="se-pre-con"></div>
<div id="newslater-popup" class="mfp-hide white-popup-block open align-center">
  <div class="nl-popup-main">
    <div class="nl-popup-inner">
      <div class="newsletter-inner">
        <span>Sign up & get 10% off</span>
        <h2 class="main_title">Subscribe Emails</h2>
        <form>
          <input type="email" placeholder="Email Here...">
          <button class="btn-black" title="Subscribe">Subscribe</button>
        </form>
        <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.</p>
      </div>
    </div>
  </div>
</div>
<div class="main">
 
 <!-- HEADER START -->
  <header class="navbar navbar-custom " id="header">
    <div class="header-top">
      <div class="container">
        <div class="header-top-inner">
          <div class="row">
            <div class="col-xs-12 align-center">
              <div class="navbar-header align-center"> 
                <a class="navbar-brand page-scroll" href="index-2.html"> 
                  <img alt="Eshoper" src="${pageContext.servletContext.contextPath}/webresource/images/logo.png"> 
                </a>  
              </div>            
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="header-middle">
      <div class="container">
        <div class="header-inner">
          <div class="row header-position">
            <div class="float-none-sm">
              <div class="right-side float-left-xs header-right-link">
                <ul>
                  <li class="search-box">
                    <a><span></span></a>
                  </li>
                  <li class="account-icon"> <a href="#"><span></span></a>
                    <div class="header-link-dropdown account-link-dropdown">
                      <ul class="link-dropdown-list">
                        <li> <span class="dropdown-title">Default welcome msg!</span>
                          <ul>
                            <li><a href="${pageContext.servletContext.contextPath}/loginindex">LogIn</a></li>
                            <li><a href="${pageContext.servletContext.contextPath}/registrationindex">Create an Account</a></li>
                          </ul>
                        </li>
                        <li> <span class="dropdown-title">Language :</span>
                          <ul>
                            <li><a class="active" href="#">English</a></li>
                            <li><a href="#">French</a></li>
                            <li><a href="#">German</a></li>
                          </ul>
                        </li>
                        <li> <span class="dropdown-title">Currency :</span>
                          <ul>
                            <li><a class="active" href="#">USD</a></li>
                            <li><a href="#">AUD</a></li>
                            <li><a href="#">EUR</a></li>
                          </ul>
                        </li>
                      </ul>
                    </div>
                  </li>
                  <li class="cart-icon"> <a href="#"> <span> <small class="cart-notification">2</small> </span> </a>
                    <div class="cart-dropdown header-link-dropdown">
                      <ul class="cart-list link-dropdown-list">
                        <li> <a class="close-cart"><i class="fa fa-times-circle"></i></a>
                          <div class="media"> <a class="pull-left"> <img alt="Eshoper" src="${pageContext.servletContext.contextPath}/webresource/images/1.jpg"></a>
                            <div class="media-body"> <span><a>Black African Print Skirt</a></span>
                              <p class="cart-price">$14.99</p>
                              <div class="product-qty">
                                <label>Qty:</label>
                                <div class="custom-qty">
                                  <input type="text" name="qty" maxlength="8" value="1" title="Qty" class="input-text qty">
                                </div>
                              </div>
                            </div>
                          </div>
                        </li>
                        <li> <a class="close-cart"><i class="fa fa-times-circle"></i></a>
                          <div class="media"> <a class="pull-left"> <img alt="Eshoper" src="${pageContext.servletContext.contextPath}/webresource/images/2.jpg"></a>
                            <div class="media-body"> <span><a>Black African Print Skirt</a></span>
                              <p class="cart-price">$14.99</p>
                              <div class="product-qty">
                                <label>Qty:</label>
                                <div class="custom-qty">
                                  <input type="text" name="qty" maxlength="8" value="1" title="Qty" class="input-text qty">
                                </div>
                              </div>
                            </div>
                          </div>
                        </li>
                      </ul>
                      <p class="cart-sub-totle"> 
                        <span class="pull-left">Cart Subtotal</span> 
                        <span class="pull-right">
                          <strong class="price-box">$29.98</strong>
                        </span> 
                      </p>
                      <div class="clearfix"></div>
                      <div class="mt-20"> <a href="cart.html" class="btn-color btn">Cart</a> <a href="checkout.html" class="btn-color btn right-side">Checkout</a> </div>
                    </div>
                  </li>
                </ul>
              </div>
              <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                <i class="fa fa-bars"></i>
              </button>
              <div id="menu" class="navbar-collapse collapse left-side" >
                <ul class="nav navbar-nav">
                  <li class="level"><a href="shop.html" class="page-scroll">Today's Deals</a></li>
                  <li class="level dropdown"> <span class="opener plus"></span> <a href="shop.html" class="page-scroll">Women</a>
                    <div class="megamenu mobile-sub-menu">
                      <div class="megamenu-inner-top">
                        <ul class="sub-menu-level1">
                          <li class="level2 "> <a href="shop.html"><span>Women Cloths</span></a>
                            <ul class="sub-menu-level2">
                              <li class="level3"><a href="shop.html"><span>■</span>Dresses</a></li>
                              <li class="level3"><a href="shop.html"><span>■</span>Sport Jeans</a></li>
                              <li class="level3"><a href="shop.html"><span>■</span>Skirts</a></li>
                              <li class="level3"><a href="shop.html"><span>■</span>Tops</a></li>
                            </ul>
                          </li>
                          <li class="level2"> <a href="shop.html"><span>Women Fashion</span></a>
                            <ul class="sub-menu-level2 ">
                              <li class="level3"><a href="shop.html"><span>■</span>Blazer & Coat</a></li>
                              <li class="level3"><a href="shop.html"><span>■</span>Sport Shoes</a></li>
                              <li class="level3"><a href="shop.html"><span>■</span>Phone Cases</a></li>
                              <li class="level3"><a href="shop.html"><span>■</span>Trousers</a></li>
                            </ul>
                          </li>
                          <li class="level2"> <a href="shop.html"><span>Juniors kid</span></a>
                            <ul class="sub-menu-level2 ">
                              <li class="level3"><a href="shop.html"><span>■</span>Sleepwear</a></li>
                              <li class="level3"><a href="shop.html"><span>■</span>Jeans</a></li>
                              <li class="level3"><a href="shop.html"><span>■</span>Purse</a></li>
                              <li class="level3"><a href="shop.html"><span>■</span>Wallets</a></li>
                            </ul>
                          </li>
                        </ul>
                      </div>
                        <div class="megamenu-inner-bottom mt-20 visible-lg visible-md">
                          <a href="shop.html">
                            <img src="${pageContext.servletContext.contextPath}/webresource/images/drop_banner.jpg" alt="Eshoper">
                          </a>
                      </div>
                    </div>
                  </li>
                  <li class="level dropdown"> 
                    <span class="opener plus"></span> <a href="shop.html" class="page-scroll">Men</a>
                    <div class="megamenu full mobile-sub-menu">
                      <div class="menu-container">
                        <div class="megamenu-inner">
                          <div class="megamenu-inner-top">
                            <div class="row m-0">
                              <div class="col-md-10 left-p p-0">
                                <div class="row">
                                  <div class="col-md-4 level2"> <a href="shop.html"><span>Men Fashion</span></a>
                                    <ul class="sub-menu-level2 ">
                                      <li class="level3"><a href="shop.html"><span>■</span>Blazer & Coat</a></li>
                                      <li class="level3"><a href="shop.html"><span>■</span>Sport Shoes</a></li>
                                      <li class="level3"><a href="shop.html"><span>■</span>Phone Cases</a></li>
                                      <li class="level3"><a href="shop.html"><span>■</span>Trousers</a></li>
                                      <li class="level3"><a href="shop.html"><span>■</span>Purse</a></li>
                                      <li class="level3"><a href="shop.html"><span>■</span>Wallets</a></li>
                                    </ul>
                                  </div>
                                  <div class="col-md-4 level2"> <a href="shop.html"><span>Juniors kid</span></a>
                                    <ul class="sub-menu-level2 ">
                                      <li class="level3"><a href="shop.html"><span>■</span>Blazer & Coat</a></li>
                                      <li class="level3"><a href="shop.html"><span>■</span>Sport Shoes</a></li>
                                      <li class="level3"><a href="shop.html"><span>■</span>Phone Cases</a></li>
                                      <li class="level3"><a href="shop.html"><span>■</span>Trousers</a></li>
                                      <li class="level3"><a href="shop.html"><span>■</span>Purse</a></li>
                                      <li class="level3"><a href="shop.html"><span>■</span>Wallets</a></li>
                                    </ul>
                                  </div>
                                  <div class="col-md-4 level2"> <a href="shop.html"><span>Men Clothings</span></a>
                                    <ul class="sub-menu-level2 ">
                                      <li class="level3"><a href="shop.html"><span>■</span>Blazer & Coat</a></li>
                                      <li class="level3"><a href="shop.html"><span>■</span>Chinos & Trousers</a></li>
                                      <li class="level3"><a href="shop.html"><span>■</span>Underwear</a></li>
                                      <li class="level3"><a href="shop.html"><span>■</span>Trousers</a></li>
                                      <li class="level3"><a href="shop.html"><span>■</span>Purse</a></li>
                                      <li class="level3"><a href="shop.html"><span>■</span>Wallets</a></li>
                                    </ul>
                                  </div>
                                </div>
                                <div class="row">
                                  <div class="col-md-6 visible-lg visible-md mt-30">
                                    <div class="sub-menu-img">
                                      <a href="shop.html"> 
                                        <img src="${pageContext.servletContext.contextPath}/webresource/images/drop_banner1.jpg" alt="Eshoper"> 
                                      </a>
                                    </div>
                                  </div>
                                  <div class="col-md-6 visible-lg visible-md mt-30">
                                    <div class="sub-menu-img">
                                      <a href="shop.html"> 
                                        <img src="${pageContext.servletContext.contextPath}/webresource/images/drop_banner2.jpg" alt="Eshoper"> 
                                      </a>
                                    </div>
                                  </div>
                                </div>
                              </div>
                              <div class="col-md-2 level2 visible-lg visible-md p-0"> 
                                <div class="sub-menu-slider">
                                  <div class="row">
                                    <div class="pro_cat">
                                      <div class="owl-carousel sub_menu_slider">
                                        <div class="product-item">
                                          <div class="product-image"> 
                                            <a href="product-page.html"> <img src="${pageContext.servletContext.contextPath}/webresource/images/1.jpg" alt=""> </a>
                                          </div>
                                          <div class="product-item-details">
                                            <div class="product-item-name"> <a href="product-page.html">Defyant Reversible Dot Shorts</a> </div>
                                            <div class="price-box"> <span class="price">$80.00</span> 
                                            </div>
                                            <div class="rating-summary-block right-side">
                                              <div title="53%" class="rating-result"> <span style="width:53%"></span> </div>
                                            </div>
                                          </div>
                                        </div>
                                        <div class="product-item">
                                          <div class="product-image"> 
                                            <a href="product-page.html"> <img src="${pageContext.servletContext.contextPath}/webresource/images/2.jpg" alt=""> </a>
                                          </div>
                                          <div class="product-item-details">
                                            <div class="product-item-name"> <a href="product-page.html">Defyant Reversible Dot Shorts</a> </div>
                                            <div class="price-box"> <span class="price">$80.00</span>               
                                            </div>
                                            <div class="rating-summary-block right-side">
                                              <div title="53%" class="rating-result"> <span style="width:53%"></span> </div>
                                            </div>
                                          </div>
                                        </div>
                                        <div class="product-item">
                                          <div class="product-image"> 
                                            <a href="product-page.html"> <img src="${pageContext.servletContext.contextPath}/webresource/images/3.jpg" alt=""> </a>
                                          </div>
                                          <div class="product-item-details">
                                            <div class="product-item-name"> <a href="product-page.html">Defyant Reversible Dot Shorts</a> </div>
                                            <div class="price-box"> <span class="price">$80.00</span>  
                                            </div>
                                            <div class="rating-summary-block right-side">
                                              <div title="53%" class="rating-result"> <span style="width:53%"></span> </div>
                                            </div>
                                          </div>
                                        </div>
                                        <div class="product-item">
                                          <div class="product-image"> 
                                            <a href="product-page.html"> <img src="${pageContext.servletContext.contextPath}/webresource/images/4.jpg" alt=""> </a>                  
                                          </div>
                                          <div class="product-item-details">
                                            <div class="product-item-name"> <a href="product-page.html">Defyant Reversible Dot Shorts</a> </div>
                                            <div class="price-box"> <span class="price">$80.00</span> 
                                            </div>
                                            <div class="rating-summary-block right-side">
                                              <div title="53%" class="rating-result"> <span style="width:53%"></span> </div>
                                            </div>
                                          </div>
                                        </div>
                                        <div class="product-item">
                                          <div class="product-image"> 
                                            <a href="product-page.html"> <img src="${pageContext.servletContext.contextPath}/webresource/images/5.jpg" alt=""> </a>
                                          </div>
                                          <div class="product-item-details">
                                            <div class="product-item-name"> <a href="product-page.html">Defyant Reversible Dot Shorts</a> </div>
                                            <div class="price-box"> <span class="price">$80.00</span>
                                            </div>
                                            <div class="rating-summary-block right-side">
                                              <div title="53%" class="rating-result"> <span style="width:53%"></span> </div>
                                            </div>
                                          </div>
                                        </div>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </li>
                  <li class="level"><a href="shop.html" class="page-scroll">Juniors <div class="menu-label"><span class="hot-menu"> Hot </span></div> </a></li>
                  <li class="level dropdown"> <span class="opener plus"></span> <a href="shop.html" class="page-scroll">Kids</a>
                    <div class="megamenu mobile-sub-menu">
                      <div class="megamenu-inner-top">
                        <ul class="sub-menu-level1">
                          <li class="level2"> <a href="shop.html"><span>Kids Fashion</span></a>
                            <ul class="sub-menu-level2 ">
                              <li class="level3"><a href="shop.html"><span>■</span>Blazer & Coat</a></li>
                              <li class="level3"><a href="shop.html"><span>■</span>Sport Shoes</a></li>
                              <li class="level3"><a href="shop.html"><span>■</span>Phone Cases</a></li>
                              <li class="level3"><a href="shop.html"><span>■</span>Trousers</a></li>
                              <li class="level3"><a href="shop.html"><span>■</span>Purse</a></li>
                              <li class="level3"><a href="shop.html"><span>■</span>Wallets</a></li>
                            </ul>
                          </li>
                        </ul>
                      </div>
                    </div>
                  </li>
                  <li class="level"><a href="shop.html" class="page-scroll">Baby <div class="menu-label"><span class="new-menu"> New </span></div></a></li>
                  <li class="level dropdown"> <span class="opener plus"></span> <a class="page-scroll">Pages</a>
                    <div class="megamenu mobile-sub-menu">
                      <div class="megamenu-inner-top">
                        <ul class="sub-menu-level1">
                          <li class="level2">
                            <ul class="sub-menu-level2 ">
                              <li class="level3"><a href="about.html"><span>■</span>About Us</a></li>
                              <li class="level3"><a href="account.html"><span>■</span>Account</a></li>
                              <li class="level3"><a href="checkout.html"><span>■</span>Checkout</a></li>
                              <li class="level3"><a href="compare.html"><span>■</span>Compare</a></li>
                              <li class="level3"><a href="wishlist.html"><span>■</span>Wishlist</a></li>
                              <li class="level3"><a href="contact.html"><span>■</span>Contact</a></li>
                              <li class="level3"><a href="404.html"><span>■</span>404 Error</a></li>
                              <li class="level3"><a href="blog.html"><span>■</span>Blog</a></li>
                              <li class="level3"><a href="single-blog.html"><span>■</span>Single Blog</a></li>
                            </ul>
                          </li>
                        </ul>
                      </div>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>

  <div class="sidebar-search-wrap">
    <div class="sidebar-table-container">
      <div class="sidebar-align-container">
        <div class="search-closer right-side"></div>
        <div class="search-container">
          <form method="get" id="search-form">
            <input type="text" id="s" class="search-input" name="s" placeholder="Start Searching">
          </form>
          <span>Search and Press Enter</span>
        </div>
      </div>
    </div>
  </div>
  <!-- HEADER END --> 