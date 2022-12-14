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
        <section class="features-area section_gap" style="padding: 0px">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="login_form_inner">
                            <h1>Feedback</h1>
                            <form class="row" action="AddFeedbackServlet" method="post" id="contactForm" novalidate="novalidate">
                                <div class="col-md-12 form-group">
                                    <input type="text" class="form-control" required="" id="fullname" name="fullname" placeholder="Fullname" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Fullname'">
                                </div>
                                <div class="col-md-12 form-group">
                                    <input type="email" class="form-control" required="" id="email" name="email" placeholder="Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email'">
                                </div>
                                <div class="col-md-12 form-group">
                                    <input type="text" class="form-control" required="" id="address" name="address" placeholder="Address" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Address'">
                                </div>
                                <div class="col-md-12 form-group">
                                    <input type="number" class="form-control" required="" id="phone" name="phone" placeholder="Phone" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Phone'">
                                </div>
                                <div class="col-md-12 form-group">
                                    <textarea rows="5" type="text" class="form-control" required="" id="feedback" name="feedback" placeholder="Feedback" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Feedback'"></textarea>
                                </div>

                                <div class="col-md-12 form-group">
                                    <button type="submit" value="submit" class="primary-btn">Send Feedback</button>
                                </div>
                                <div class="col-md-12 form-group">
                                    <h4>${successMessage}</h4>
                                    <h4>${errorMessage}</h4>
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