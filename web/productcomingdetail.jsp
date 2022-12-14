<%-- 
    Document   : productdetail
    Created on : Dec 4, 2022, 10:33:56 PM
    Author     : long
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

    <head>
        <!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/fav.png">
        <!-- Author Meta -->
        <meta name="author" content="CodePixar">
        <!-- Meta Description -->
        <meta name="description" content="">
        <!-- Meta Keyword -->
        <meta name="keywords" content="">
        <!-- meta character set -->
        <meta charset="UTF-8">
        <!-- Site Title -->
        <title>Karma Shop</title>
        <!--
                        CSS
                        ============================================= -->
        <link rel="stylesheet" href="css/linearicons.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="css/nice-select.css">
        <link rel="stylesheet" href="css/nouislider.min.css">
        <link rel="stylesheet" href="css/ion.rangeSlider.css" />
        <link rel="stylesheet" href="css/ion.rangeSlider.skinFlat.css" />
        <link rel="stylesheet" href="css/main.css">
        
        
       
    </head>

    <body>

        <!-- Start Header Area -->
        <jsp:include page="header.jsp"/>
        <!-- End Header Area -->

      
        
        <!-- End Banner Area -->

        <!--================Single Product Area =================-->
        <div class="product_image_area" style="padding-top: 10px">
            <div class="container">
                <div class="row s_product_inner">
                    <div class="col-lg-6">
                        <c:forEach items="${listProduct}" var="pd">
                            <div class="s_Product_carousel">
                                <div class="single-prd-item">
                                    <img class="img-fluid" src=${pd.product_thumbnail} alt="">
                                </div>
                                <div class="single-prd-item">
                                    <img class="img-fluid" src=${pd.product_thumbnail} alt="">
                                </div>
                                <div class="single-prd-item">
                                    <img class="img-fluid" src=${pd.product_thumbnail} alt="">
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <c:forEach items="${listProduct}" var="pd">
                        <div class="col-lg-5 offset-lg-1">
                            <div class="s_product_text">
                                <h3>${pd.product_name}</h3>
                                <h2>$${pd.product_price}</h2>


                                <ul class="list">
                                    <li><a class="active" href="category?id=${pd.category_id}"><span>Category</span> :  ${pd.category_name}</a></li>

                                    <li><a style="color: red"><span>Availibility</span> : Coming</a></li> 

                                </ul>
                                <p>${pd.product_description}</p>
<!--                                <div class="product_count">
                                    <label for="qty">Quantity:</label>
                                    <input type="text" name="qty" id="sst" maxlength="12" value="${pd.product_quatity}" title="Quantity:" class="input-text qty">
                                    <button onclick="var result = document.getElementById('sst');
                                            var sst = result.value;
                                            if (!isNaN(sst))
                                                result.value++;
                                            return false;"
                                            class="increase items-count" type="button"><i class="lnr lnr-chevron-up"></i></button>
                                    <button onclick="var result = document.getElementById('sst'); var sst = result.value; if (!isNaN(sst) & amp; & amp; sst > 0) result.value--; return false;"
                                            class="reduced items-count" type="button"><i class="lnr lnr-chevron-down"></i></button>
                                </div>-->
                               
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!--================End Single Product Area =================-->

        <!--================Product Description Area =================-->
        
        <!--================End Product Description Area =================-->

        <!-- Start related-product Area -->
     
        <!-- End related-product Area -->

        <!-- start footer Area -->
        <jsp:include page="footer.jsp"/>
        <!-- End footer Area -->

       

        <script src="js/vendor/jquery-2.2.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
        crossorigin="anonymous"></script>
        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery.sticky.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <!--gmaps Js-->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
        <script src="js/gmaps.min.js"></script>
        <script src="js/main.js"></script>

    </body>

</html>
