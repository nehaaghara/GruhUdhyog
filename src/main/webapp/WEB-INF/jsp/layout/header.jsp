
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<body class="homepage">


    <div class="se-pre-con"></div>
    <div id="newslater-popup" class="mfp-hide white-popup-block open align-center" style="display: none">
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

                                        <li class="account-icon"> <a href="#"><span></span></a>
                                            <div class="header-link-dropdown account-link-dropdown">
                                                <ul class="link-dropdown-list">
                                                    <li> <span class="dropdown-title">User</span>
                                                        <ul>
                                                            <li><a href="${pageContext.servletContext.contextPath}/loginindex">LogIn</a></li>
                                                            <li><a href="${pageContext.servletContext.contextPath}/registrationindex">Create an Account</a></li>
                                                            <li><a href="${pageContext.servletContext.contextPath}/logout">Logout</a></li>
                                                        </ul>
                                                    </li>
                                                    <li> <span class="dropdown-title">Language :</span>
                                                        <ul>
                                                            <li><a class="active" href="#">English</a></li>
                                                        </ul>
                                                    </li>
                                                    <li> <span class="dropdown-title">Currency :</span>
                                                        <ul>
                                                            <li><a class="active" href="#">India</a></li>

                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>
                                        <li class="cart-icon" id="product" onclick="submit()"> <a href="#"> <span> <small class="cart-notification">2</small> </span> </a>
                                            <div class="cart-dropdown header-link-dropdown">
                                                <div class="questionAnswerScroll">
                                                    <ul class="cart-list link-dropdown-list">

                                                        <li> 
                                                            <a class="close-cart"><i class="fa fa-times-circle"></i></a>
                                                            <input type="hidden" name="productid" value="">
                                                            <div class="media">
                                                                <a class="pull-left"> <img alt="Eshoper" src=""></a>
                                                                <div class="media-body">
                                                                    <p class="cart-price"></p>
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
                                                </div>
                                                <p class="cart-sub-totle"> 
                                                    <span class="pull-left">Cart Subtotal</span> 
                                                    <span class="pull-right">
                                                        <strong class="price-box1">$29.98</strong>
                                                    </span> 
                                                </p>
                                                <div class="clearfix"></div>
                                                <div class="mt-20"> <a href="${pageContext.servletContext.contextPath}/cartpage" class="btn-color btn">Cart</a> <a href="${pageContext.servletContext.contextPath}/checkoutpage" class="btn-color btn right-side">Checkout</a> </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                                    <i class="fa fa-bars"></i>
                                </button>
                                <div id="menu" class="navbar-collapse collapse left-side " >
                                    <ul class="nav navbar-nav">
                                        <li class="level"><a href="shop.html" class="page-scroll">Today's Deals</a></li>

                                        <li class="level dropdown "> <span class="opener plus"></span> <a href="shop.html" class="page-scroll">Categories</a>

                                            <div class="megamenu mobile-sub-menu">
                                                <div class="questionAnswerScroll">
                                                    <div class="megamenu-inner-top">
                                                        <ul class="sub-menu-level1">
                                                            <c:forEach var="categorywithitem" items="${mapofcategorywiseproduct}">
                                                                <li class="level2"> <a href="shop.html"><span>${categorywithitem.key.categoryName}</span></a>
                                                                    <div class="questionAnswerScroll">
                                                                        <ul class="sub-menu-level2">
                                                                            <c:forEach var="product" items="${categorywithitem.value}">
                                                                                <li class="level3"><a href="shop.html"><span>■</span>${product.productName}</a></li>

                                                                            </c:forEach>
                                                                        </ul>
                                                                    </div>
                                                                </li>
                                                            </c:forEach>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>

                                        <li class="level"><a href="shop.html" class="page-scroll">Juniors <div class="menu-label"><span class="hot-menu"> Hot </span></div> </a></li>

                                        <li class="level"><a href="shop.html" class="page-scroll">Baby <div class="menu-label"><span class="new-menu"> New </span></div></a></li>

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