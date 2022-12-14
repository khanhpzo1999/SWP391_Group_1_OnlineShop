<%-- 
    Document   : viewuserinformation
    Created on : Dec 9, 2022, 9:28:25 AM
    Author     : Nhat Anh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/nice-select.css">
        <link rel="stylesheet" href="css/nouislider.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/main.css">
    </head>

    <body>

        <!-- Start Header Area -->
        <jsp:include page="header.jsp"/>
        <!-- End Header Area -->

        <!-- Start Banner Area -->
      
        <!-- End Banner Area -->

        <!--================Login Box Area =================-->
        <section class="login_box_area section_gap" style="padding-top: 0px">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="login_box_img">
                            <img class="img-fluid" src="img/login.jpg" alt="">
                        </div>
                    </div>
                   
                    <div class="col-lg-6">
                            <div class="login_form_inner" style="padding-top:50px;">
                                <h3 >Profile Information</h3>
                                <form class="row login_form" action="contact_process.php" method="post" id="contactForm" novalidate="novalidate">
                                   
                                    <div class="col-md-12 form-group">
                                        <input type="text" class="form-control" id="user_fullname" value="${userinfor.user_fullname}" disabled name="name" placeholder="name" onfocus="this.placeholder = ''" >
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <input type="text" class="form-control" id="user_email"  value="${userinfor.user_email}" disabled name="email" placeholder="email" onfocus="this.placeholder = ''" >
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <input type="text" class="form-control" id="user_phone" value="${userinfor.user_phone}" disabled name="phone" placeholder="phone" onfocus="this.placeholder = ''">
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <input type="text" class="form-control" id="user_address" value="${userinfor.user_address}" disabled name="address" placeholder="address" onfocus="this.placeholder = ''" >
                                    </div>
                         
                                    <div class="col-md-12 form-group">
                                        <a href="updateuserinformation?id=${requestScope.id}" class="primary-btn" style="color: white">Change Information</a>
                                    </div>
                                    
                                </form>
                            </div>
                        </div>
                                    
                </div>
            </div>
        </section>
        <!--================End Login Box Area =================-->

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