<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page import="dao.ProductDAO"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    </head>

    <body id="category">
       
        <!-- Start Header Area -->

        <jsp:include page="header.jsp"/>

        <!-- End Header Area -->

        <!-- Start Banner Area -->
        
        <!-- End Banner Area -->
        <div class="container">
            <div class="row">
                <div>
                    <!-- Start Filter Bar -->
                    <div class="filter-bar d-flex flex-wrap align-items-between">
                        <div class="sorting">
                             <div>
                            <input type="text" class="form-control" name="search_input" id="search_input" onchange="search()" placeholder="Search Here">
                        </div>
                        </div>
                        <div class="pagination">
                            <a href="#" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>
                            <a href="#" class="active">1</a>
                            <a href="#">2</a>
                            <a href="#">3</a>
                            <a href="#" class="dot-dot"><i class="fa fa-ellipsis-h" aria-hidden="true"></i></a>
                            <a href="#">6</a>
                            <a href="#" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>
                        </div>
                       
                    </div>
                    <!-- End Filter Bar -->
                    <!-- Start Best Seller -->
                    <section class="lattest-product-area pb-40 category-list">
                        <div class="row" id="list">
                            <c:forEach var="i" items="${listAllComingProduct}">
                                <div class="col-lg-4 col-md-6">
                                    <div class="single-product">
                                        <img class="img-fluid" src="img/product/p1.jpg" alt="">
                                        <div class="product-details">
                                            <h6>${i.product_name}</h6>
                                            <div class="price">
                                                <h6>$${i.product_price}</h6>
                                            </div>
                                            <div class="prd-bottom">
                                                <a href="viewcomingproductdetail?id=${i.pid}" class="social-info">
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
                            <!--                            <a href="#" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>
                                                        <a href="#" class="active">1</a>
                                                        <a href="#">2</a>
                                                        <a href="#">3</a>
                                                        <a href="#" class="dot-dot"><i class="fa fa-ellipsis-h" aria-hidden="true"></i></a>
                                                        <a href="#">6</a>
                                                        <a href="#" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>-->
                            <%
                                String id = request.getParameter("id");
                                ProductDAO dao = new ProductDAO();
                                List<Product> listAllComingProduct = dao.getListComingProduct();
                                double productSize = listAllComingProduct.size();
                                double productPerPage = 6;
                                for (int i = 1; i <= Math.ceil(productSize / productPerPage); i++) {%>
                            <a class="" href = "list?id=<%=id%>&page=<%=i%>"> <%=i%> </a>
                            <% }%>
                        </div>
                    </div>
                    <!-- End Filter Bar -->
                </div>
            </div>
        </div>

        <!-- Start related-product Area -->
       
        <!-- End related-product Area -->

        <!-- start footer Area -->
        <jsp:include page="footer.jsp"/>
        <!-- End footer Area -->

        <!-- Modal Quick Product View -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="container relative">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <div class="product-quick-view">
                        <div class="row align-items-center">
                            <div class="col-lg-6">
                                <div class="quick-view-carousel">
                                    <div class="item" style="background: url(img/organic-food/q1.jpg);">

                                    </div>
                                    <div class="item" style="background: url(img/organic-food/q1.jpg);">

                                    </div>
                                    <div class="item" style="background: url(img/organic-food/q1.jpg);">

                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="quick-view-content">
                                    <div class="top">
                                        <h3 class="head">Mill Oil 1000W Heater, White</h3>
                                        <div class="price d-flex align-items-center"><span class="lnr lnr-tag"></span> <span
                                                class="ml-10">$149.99</span></div>
                                        <div class="category">Category: <span>Household</span></div>
                                        <div class="available">Availibility: <span>In Stock</span></div>
                                    </div>
                                    <div class="middle">
                                        <p class="content">Mill Oil is an innovative oil filled radiator with the most
                                            modern technology. If you are
                                            looking for something that can make your interior look awesome, and at the same
                                            time give you the pleasant
                                            warm feeling during the winter.</p>
                                        <a href="#" class="view-full">View full Details <span
                                                class="lnr lnr-arrow-right"></span></a>
                                    </div>
                                    <div class="bottom">
                                        <div class="color-picker d-flex align-items-center">Color:
                                            <span class="single-pick"></span>
                                            <span class="single-pick"></span>
                                            <span class="single-pick"></span>
                                            <span class="single-pick"></span>
                                            <span class="single-pick"></span>
                                        </div>
                                        <div class="quantity-container d-flex align-items-center mt-15">
                                            Quantity:
                                            <input type="text" class="quantity-amount ml-15" value="1" />
                                            <div class="arrow-btn d-inline-flex flex-column">
                                                <button class="increase arrow" type="button" title="Increase Quantity"><span
                                                        class="lnr lnr-chevron-up"></span></button>
                                                <button class="decrease arrow" type="button" title="Decrease Quantity"><span
                                                        class="lnr lnr-chevron-down"></span></button>
                                            </div>

                                        </div>
                                        <div class="d-flex mt-20">
                                            <a href="#" class="view-btn color-2"><span>Add to Cart</span></a>
                                            <a href="#" class="like-btn"><span class="lnr lnr-layers"></span></a>
                                            <a href="#" class="like-btn"><span class="lnr lnr-heart"></span></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script>
            function addToCart(id) {
                $.ajax({
                    type: "post",
                    url: "./add-to-cart?id=" + id,
                    data: {

                    },
                    success: function (result) {
                        alert("Added");
                    }
                });
            }

            function search() {
                var name = document.querySelectorAll('input[name=search_input]')[0].value;
                console.log(name);
                $.ajax({
                    type: "post",
                    url: "./searchcomingproduct?search=" + name,
                    data: {

                    },
                    success: function (result) {
                        document.getElementById("list").innerHTML = result
                    }
                });
            }
        </script>

        <script src="js/vendor/jquery-2.2.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
                integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
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