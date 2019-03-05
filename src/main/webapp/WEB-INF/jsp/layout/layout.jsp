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
</head>  

<!-- START HEADER -->
   <tiles:insertAttribute name="header" />
        <!-- END HEADER -->
  
    
        <tiles:insertAttribute name="body" flush="true" />
	<!-- =-=-=-=-=-=-= HOME =-=-=-=-=-=-= -->

  
 
  
           <!-- start footer-->
	  <tiles:insertAttribute name="footer" />
          <!-- end footer-->
<script src="${pageContext.servletContext.contextPath}/webresource/js/jquery-1.12.3.min.js"></script> 
<script src="${pageContext.servletContext.contextPath}/webresource/js/bootstrap.min.js"></script>  
<script src="${pageContext.servletContext.contextPath}/webresource/js/jquery-ui.min.js"></script> 
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