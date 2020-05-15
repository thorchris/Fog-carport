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
    <script src="../JS/javascript.js"></script>
    <link href="styles/styles.css" rel="stylesheet">
</head>
<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="FrontController?taget=redirect&modtagerside=index"><img src="img/FogBrand.png"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <!-- Show whos logged in -->
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link"> ${sessionScope.HeaderMessage} </a>
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

<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="manageCommand"/>
    <div class="container-fluid padding">
        <div class="row">
            <div class="col-1"></div>
            <div class="col-6">
                <h3 class="text-center">Plantegning:</h3>
                <hr>
                ${requestScope.svgCustomerDrawing}
            </div>
    </div>
    </div>
</form>
</div>

</body>

<!-- Footer -->
<script src="JS/javascript.js"></script>
<%@include file="../include/footer.inc" %>
