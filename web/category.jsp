<%@page import="dao.CategoryDAO"%>
<%@page import="java.util.List"%>
<%@page import="dao.DAO"%>
<%@page import="model.Product"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/nice-select.css">
        <link rel="stylesheet" href="css/nouislider.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <%
        if (request.getParameter("id") == null) {
            response.sendRedirect("home.jsp");
        }
    %>
    <body id="category">
        <jsp:include page="header.jsp"/>
        <!-- Start Header Area -->
    
        <!-- End Header Area -->

        <!-- Start Banner Area -->
       
        <!-- End Banner Area -->
        <div class="container">
            <div class="row">
                <div class="col-xl-3 col-lg-4 col-md-5">
                    <div class="sidebar-categories">
                        <div class="head">Browse Categories</div>
                        <ul class="main-categories">
                            <c:forEach items="${listCategory}" var="category">
                                <li class="main-nav-list"><a  href="category?id=${category.id}"><span
                                            class="lnr lnr-arrow-right"></span>${category.category_name}<span class="number"></span></a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="col-xl-9 col-lg-8 col-md-7">
                    <section class="lattest-product-area pb-40 category-list">
                        <div class="row">
                            <c:forEach items="${listProductByCategory}" var="product">
                                <div class="col-lg-4 col-md-6">
                                    <div class="single-product">
                                        <img class="img-fluid" src=${product.product_thumbnail} alt="">
                                        <div class="product-details">
                                            <h6>${product.product_name}</h6>
                                            <div class="price">
                                                <h6>${product.product_price}</h6>
                                            </div>
                                            <div class="prd-bottom">
                                                <a href="" class="social-info">
                                                    <span class="ti-bag"></span>
                                                    <p class="hover-text">add to bag</p>
                                                </a>
                                                <a href="" class="social-info">
                                                    <span class="lnr lnr-move"></span>
                                                    <p class="hover-text">view more</p>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </section>
                    <!-- End Best Seller -->
                    <!-- Start Filter Bar -->
                    <div class="filter-bar d-flex flex-wrap align-items-center">
                        <div class="pagination">
                            <!--<a href="#" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>-->

                            <%
                                String id = request.getParameter("id");
                                CategoryDAO dao = new CategoryDAO();
                                List<Product> listAllProductByCategory = dao.getProductByCategory(Integer.parseInt(id));
                                double productSize = listAllProductByCategory.size();
                                double productPerPage = 9;
                                for (int i = 1; i <= Math.ceil(productSize / productPerPage); i++) {%>
                                <a class="" href = "category?id=<%=id%>&page=<%=i%>"> <%=i%> </a>
                            <% }%>

                            <!--<a href="#" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>-->

                        </div>
                    </div>
                    <!-- End Filter Bar -->
                </div>
            </div>
        </div>

        <!-- Start related-product Area -->
       
        <!-- End related-product Area -->

        <!-- start footer Area -->
      
        <!-- End footer Area -->

        <!-- Modal Quick Product View -->
        <jsp:include page="footer.jsp"/>



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