<%-- 
    Document   : view-discount
    Created on : Dec 6, 2022, 9:50:20 AM
    Author     : hung tran
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.DAODiscount"%>
<%@page import="model.Discount"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="shortcut icon" href="img/fav.png">
        <meta name="author" content="CodePixar">
        <meta name="description" content="">
        <meta name="keywords" content="">
        <meta charset="UTF-8">
        <title>JSP Page</title>
        <!-- CSS -->
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
        
        <header class="header_area sticky-header">
            <div class="main_menu">
                <nav class="navbar navbar-expand-lg navbar-light main_box">
                    <div class="container">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <a class="navbar-brand logo_h" href="index.jsp"><img src="img/logo.png" alt=""></a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                            <ul class="nav navbar-nav menu_nav ml-auto">
                                
                                <li class="nav-item"><a class="nav-link" href="logout">Log out</a></li>
                            </ul>
                            
                        </div>
                    </div>
                </nav>
            </div>
            <div class="search_input" id="search_input_box">
                <div class="container">
                    <form class="d-flex justify-content-between">
                        <input type="text" class="form-control" id="search_input" placeholder="Search Here">
                        <button type="submit" class="btn"></button>
                        <span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
                    </form>
                </div>
            </div>
        </header>
        
        <section>
            <div class="table-responsive">
                <form action="" method="">
                    <table>
                        <thead>
                            <tr>
                                <th>Discount</th>
                                <th>Sale off</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <%
                            List<Discount> list = new DAODiscount().getAll();
                            for (Discount d : list) {
                        %>
                        <tr>
                            <td><%= d.getDiscount_name()%></td>
                            <td><%= d.getDiscount_number()%></td>
                            <td><a href="">Edit</a>&nbsp;<a href="">Delete</a></td>
                        </tr>
                        <%
                            }
                        %>
                        <tbody>
                            
                        </tbody>
                    </table>
                </form>
            </div>
        </section>
    </body>
</html>
