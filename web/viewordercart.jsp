<%-- 
    Document   : shoping_cart
    Created on : Dec 4, 2022, 10:28:36 PM
    Author     : long
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/nice-select.css">
        <link rel="stylesheet" href="css/nouislider.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/main.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <script>
            discount = 0;
        </script>
    </head>

    <body>

        <!-- Start Header Area -->
        <jsp:include page="header.jsp"/>
        <!-- End Header Area -->

        <!-- Start Banner Area -->

        <!-- End Banner Area -->

        <!--================Cart Area =================-->
        <section class="cart_area">
            <div class="container">
                <div class="cart_inner">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Product</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Total</th>
                                    <th scope="col">Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${requestScope.cart}">
                                    <tr>
                                        <td>
                                            <div class="media">
                                                <div class="d-flex">
                                                    <img src="${item.getProduct().getProduct_thumbnail()}" alt="">
                                                </div>
                                                <div class="media-body">
                                                    <p>${item.getProduct().getProduct_name()}</p>
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <h5 id="gia${item.getProduct().getPid()}">${item.getProduct().getProduct_price()}</h5>
                                        </td>
                                        <td>
                                            <div class="product_count">
                                                <input type="text" name="qty" id="amount${item.getProduct().getPid()}" 
                                                       maxlength="12" value="${item.quantity}" 
                                                       title="Quantity:"
                                                       class="input-text qty">
                                                <button
                                                    id="minus${item.getProduct().getPid()}"
                                                    class="increase items-count" type="button"
                                                    onClick="process(${item.getProduct().getPid()}, true)"
                                                    >
                                                    <i class="lnr lnr-chevron-up"></i>
                                                </button>
                                                <button
                                                    id="add${item.getProduct().getPid()}"
                                                    class="reduced items-count" type="button"
                                                    onClick="process(${item.getProduct().getPid()}, false)"
                                                    >
                                                    <i class="lnr lnr-chevron-down"></i>
                                                </button>
                                            </div>
                                        </td>
                                        <td>
                                            <h5 id="tong${item.getProduct().getPid()}">${item.quantity * item.getProduct().getProduct_price()}</h5>
                                        </td>
                                        <td>
                                            <button onclick="removeItem(${item.getProduct().getPid()})" >X</button>
                                        </td>
                                    </tr>
                                </c:forEach> 
                                <tr class="bottom_button">

                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>
                                        <div class="cupon_text d-flex align-items-center">
                                            <input id="coupon_code" type="text" placeholder="Coupon Code">
                                            <!--<a class="primary-btn" id="checkCoupon" href="javascript:void(0)">Apply</a>-->
                                            <button class="primary-btn" id="checkCoupon">Apply</button>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>
                                        <h5>Total discount: </h5>
                                    </td>
                                    <td>
                                        <h5 id="giamgia">0</h5>
                                    </td>
                                    <td>
                                        <h5>Subtotal</h5>
                                    </td>
                                    <td>
                                        <h5 id="tong">${requestScope.total}</h5>
                                    </td>
                                    <td>
                                        <h5>Total paid</h5>
                                    </td>
                                    <td>
                                        <h5 id="phaitra">${requestScope.total}</h5>
                                    </td>
                                </tr>
                                <tr>                                
                                    <td>
                                        <form method="POST" action="./checkout">
                                            <div class="col-md-12 form-group">
                                                FullName <input name="name" type="text" required="" class="form-control" id="name"  name="name" placeholder="Username" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Username'">
                                            </div>
                                            <div class="col-md-12 form-group">
                                                Email <input type="email" name="email" required="" class="form-control" id="name"  name="email" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'">
                                            </div>
                                            <div class="col-md-12 form-group">
                                                Phone <input type="text" name="phone" required="" class="form-control" id="name"  name="phone" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'">
                                            </div>
                                            <div class="col-md-12 form-group">
                                                Address <input type="text" name="address" required="" class="form-control" id="name"  name="address" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'">
                                            </div>
                                            <div class="col-md-12 form-group">
                                                Note <input type="text" name="note" required="" class="form-control" id="name"  name="address" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'">
                                            </div>
                                            <input name="discount" type="hidden" id="discount" value="0"/>
                                            <input name="totalpaid" type="hidden" id="totalpaid" value="0"/>
                                            <div class="col-md-12 form-group">
                                                <button class="primary-btn" type="submit">Submit</button>
                                            </div>
                                        </form>
                                    </td>
                                </tr>
                                <tr class="out_button_area">
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Cart Area =================-->

        <!-- start footer Area -->
        <jsp:include page="footer.jsp"/>

        <!-- End footer Area -->
        <script>
            function removeItem(id) {
                $.ajax({
                    type: "get",
                    url: "./cart?remove=" + id,
                    data: {

                    },
                    success: function (result) {
                        window.location.reload();
                    }
                });
            }

            function process(x, sign) {
                value = parseInt(document.getElementById(('amount' + x)).value)
                tong = parseFloat(document.getElementById("tong").innerHTML);
                if (sign) {
                    value += 1;
                    $.ajax({
                        type: "get",
                        url: "./cart?update=" + x + "&quantity=" + value,
                        data: {

                        },
                        success: function (result) {

                        }
                    });
                } else {
                    if (value > 0) {
                        value -= 1;
                        if (value == 0) {
                            $.ajax({
                                type: "get",
                                url: "./cart?remove=" + x,
                                data: {

                                },
                                success: function (result) {
                                    window.location.reload();
                                }
                            });
                        } else if (value > 0) {
                            $.ajax({
                                type: "get",
                                url: "./cart?update=" + x + "&quantity=" + value,
                                data: {

                                },
                                success: function (result) {

                                }
                            });
                        }
                    }
                }
                document.getElementById('amount' + x).value = value;
                price = parseFloat(document.getElementById("gia" + x).innerHTML);
                document.getElementById("tong" + x).innerHTML = value * price;
                if (value >= 0 && tong > 0) {
                    before_discount = tong + (sign ? 1 : -1) * price;
                    document.getElementById("tong").innerHTML = before_discount;
                    if (discount == 0) {
                        document.getElementById("phaitra").innerHTML = before_discount;
                        document.getElementById("totalpaid").value = before_discount;

                    } else if (discount > 0) {
                        document.getElementById("phaitra").innerHTML = before_discount - (discount / 100 * before_discount);
                        document.getElementById("totalpaid").value = before_discount - (discount / 100 * before_discount);
                    }
                }
            }

            $("#checkCoupon").click(function () {
                coupon = document.getElementById("coupon_code").value;
                if (coupon != null && coupon != "") {
                    $.ajax({
                        type: "post",
                        url: "./cart?coupon=" + coupon,
                        data: {

                        },
                        success: function (result) {
                            discount = parseInt(result);
                            tong = parseFloat(document.getElementById("tong").innerHTML);
                            total_paid = tong - (discount / 100 * tong)
                            $("#giamgia").text(discount);
                            $("#discount").val(discount);
                            $("#phaitra").text(total_paid);
                            $("#totalpaid").val(total_paid);

                        }
                    });
                }
            })
        </script>

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
