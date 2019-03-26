<%@page import="com.damani.model.TblProduct"%>
<%@page import="java.util.List"%>
<%@page import="com.damani.model.TblCategory"%>
<%@page import="java.util.Map"%>
<%@page import="com.damani.controller.HeaderController"%>
<%@page import="com.damani.controller.HeaderController"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>


<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->

<!-- Mirrored from aaryaweb.info/html/eshoper/esh003/ by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 05 Mar 2019 06:18:21 GMT -->
<head>
  <!-- Global site tag (gtag.js) - Google Analytics -->
  <script async src="https://www.googletagmanager.com/gtag/js?id=UA-109718537-1"></script>
  <script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'UA-109718537-1');
  </script>
  
<script type="text/javascript">
    var path = '${pageContext.servletContext.contextPath}'; 
    
    $(function(){
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
               var subtotal=0;
                $.each(json,function(obj){
                    count=count+1;
                });
               console.log(count);
               $('.cart-list').html('');
               $.each(json,function(index,obj){
                   
                   var li = $('<li></li>');
                   var productid=obj[0]['adminProductFk']['productPK'];
                   
                   $('<a class="close-cart" onclick="deleteitemfromcart('+productid+')"><i class="fa fa-times-circle"></i></a>').appendTo(li);
                   
                     
                   var div = $('<div class="media"></div>');
                   var path = obj[0]['imagePath'].replace(/\\/g, '/').replace('/home/gruhudhyog/','');
                   var price=obj[0]['adminProductFk']['productPrice'];
                   var discount=obj[0]['adminProductFk']['discount'];
                   var subtotalwithdiscount=price-discount;
                   subtotal=subtotal + subtotalwithdiscount;
                   path = "resources/"+path;
                   $('<a class="pull-left"> <img alt="Eshoper" src="'+path+'">'+obj[0]['adminProductFk']['productName']+'</a>').appendTo(div);
                   var div1 = $('<div class="media-body"></div>');
                   $('<p class="cart-price">:'+price+'Rs</p><del class="price old-price">'+discount+'</del><strong> OFF</strong>').appendTo(div1);
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
     
</script>
  
<!-- Basic Page Needs
  ================================================== -->
<meta charset="utf-8">
<title>Eshoper</title>
<!-- SEO Meta
  ================================================== -->
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="distribution" content="global">
<meta name="revisit-after" content="2 Days">
<meta name="robots" content="ALL">
<meta name="rating" content="8 YEARS">
<meta name="Language" content="en-us">
<meta name="GOOGLEBOT" content="NOARCHIVE">
<!-- Mobile Specific Metas
  ================================================== -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- CSS
  ================================================== -->
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/webresource/css/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/webresource/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/webresource/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/webresource/css/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/webresource/css/fotorama.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/webresource/css/magnific-popup.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/webresource/css/custom.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/webresource/css/responsive.css">
<link rel="shortcut icon" href=" ${pageContext.servletContext.contextPath}/webresource/images/favicon.png">
<link rel="apple-touch-icon" href="${pageContext.servletContext.contextPath}/webresource/images/apple-touch-icon.html">
<link rel="apple-touch-icon" sizes="72x72" href="${pageContext.servletContext.contextPath}/webresource/images/apple-touch-icon-72x72.html">
<link rel="apple-touch-icon" sizes="114x114" href="${pageContext.servletContext.contextPath}/webresource/images/apple-touch-icon-114x114.html">
<script src="${pageContext.servletContext.contextPath}/webresource/js/jquery-1.12.3.min.js"></script> 
<script src="${pageContext.servletContext.contextPath}/webresource/js/bootstrap.min.js"></script>  
<script src="${pageContext.servletContext.contextPath}/webresource/js/jquery-ui.min.js"></script>

<style>
            
            ::-webkit-scrollbar {width: 5px;}
            ::-webkit-scrollbar-thumb {background: #888;border-radius: 20px;}
            div.questionAnswerScroll{padding: 5px;width: auto;height: 300px;overflow: scroll;background-color: white;border-radius: 12px;}
 </style>
</head>  



<!-- START HEADER -->
   <tiles:insertAttribute name="header" />
        <!-- END HEADER -->
  
    
        <tiles:insertAttribute name="body" flush="true" />
	<!-- =-=-=-=-=-=-= HOME =-=-=-=-=-=-= -->

  
 
  
           <!-- start footer-->
	  <tiles:insertAttribute name="footer" />
          <!-- end footer-->
 
<script src="${pageContext.servletContext.contextPath}/webresource/js/fotorama.js"></script>
<script src="${pageContext.servletContext.contextPath}/webresource/js/jquery.magnific-popup.js"></script> 
<script src="${pageContext.servletContext.contextPath}/webresource/js/owl.carousel.min.js"></script> 
<script src="${pageContext.servletContext.contextPath}/webresource/js/custom.js"></script>

<script>
  /* ------------ Newslater-popup JS Start ------------- */
  $(window).load(function() {
    $.magnificPopup.open({
      items: {src: '#newslater-popup'},type: 'inline'}, 0);
  });
    /* ------------ Newslater-popup JS End ------------- */
</script>

</body>

<!-- Mirrored from aaryaweb.info/html/eshoper/esh003/ by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 05 Mar 2019 06:20:30 GMT -->
</html>