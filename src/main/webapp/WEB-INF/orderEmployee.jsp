<%@ page import="FunctionLayer.GenerateLists" %>
<%@ page import="FunctionLayer.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!--Header imports -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Fog Trælast og byggecenter</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <script src="../js/javascript.js"></script>
    <link href="styles/styles.css" rel="stylesheet">
</head>
<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><img src="img/FogBrand.png"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <!-- Show whos logged in -->
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link"> ${sessionScope.message} </a>
                </li>
            </ul>
            <!-- Navbar items -->
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?taget=redirect&modtagerside=index">Hjem</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?taget=redirect&modtagerside=design">Carport Design</a>
                </li>
                <li class="nav-item">
                    <%
                        User user = (User) session.getAttribute("user");
                        if(user == null){
                            out.println("<a class=\"nav-link\" href=\"FrontController?taget=redirect&modtagerside=login\">Login/Registrer</a>");
                        } else {
                            out.println("<a class=\"nav-link\" href=\"FrontController?taget=logout\">Logud</a>");
                        }
                    %>
                </li>
                <li class="nav-item">
                    <%
                        user = (User) session.getAttribute("user");
                        if (user != null) {
                            if (user.getRole().equals("employee")) {
                                out.println("<a class=\"nav-link\" href=\"FrontController?taget=redirect&modtagerside=employee\">Medarbejder</a>");
                            }
                            else if (user.getRole().equals("customer")) {
                                out.println("<a class=\"nav-link\" href=\"FrontController?taget=redirect&modtagerside=customer\">Min side</a>");
                            }
                        }
                    %>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10">
            <h1 class="text-center"> Kunde Ordre </h1>
            <table class="table table-striped table-dark table-bordered table.responsive">
                <thead>
                <tr>
                    <th scope="col">Slet order</th>
                    <th scope="col">Order ID</th>
                    <th scope="col">Kunde ID</th>
                    <th scope="col">Spær</th>
                    <th scope="col">Beklædning</th>
                    <th scope="col">Stolper</th>
                    <th scope="col">Skuer</th>
                    <th scope="col">Stern</th>
                    <th scope="col">Beslag</th>
                    <th scope="col">Straps</th>
                    <th scope="col">Dørhåndtag</th>
                    <th scope="col">Hængsler</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <!-- https://www.codejava.net/java-ee/jsp/how-to-list-records-in-a-database-table-using-jsp-and-jstl -->
                <tr>

                    <td><button class="btn btn-primary btn-style deleteOrder" name="deleteOrder" value="${sessionScope.order.orderId}">Slet</button></td>
                    <td>${sessionScope.order.orderId}</td>
                    <td>${sessionScope.order.userId}</td>
                    <td>${sessionScope.order.rafters}</td>
                    <td>${sessionScope.order.cladding}</td>
                    <td>${sessionScope.order.posts}</td>
                    <td>${sessionScope.order.screws}</td>
                    <td>${sessionScope.order.fascia}</td>
                    <td>${sessionScope.order.brackets}</td>
                    <td>${sessionScope.order.straps}</td>
                    <td>${sessionScope.order.doorknobs}</td>
                    <td>${sessionScope.order.doorhinges}</td>
                </tr>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-1"></div>
    </div>
</div>

<!-- Footer -->
<%@include file="../include/footer.inc" %>