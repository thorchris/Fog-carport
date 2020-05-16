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
        <a class="navbar-brand" href="FrontController?taget=redirect&modtagerside=index"><img src="img/FogBrand.png" ></a>
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

<!--- Image Slider -->
<div id="slides"  class="carousel slide"  data-ride="carousel">
    <ul class="carousel-indicators">
        <li data-target="#slides" data-slide-to="0" class="active"></li>
        <li data-target="#slides" data-slide-to="0"></li>
        <li data-target="#slides" data-slide-to="0"></li>
    </ul>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img class="img-fluid" src="img/background1.png">
            <div class="carousel-caption">
                <h1 class="display-2">Fog Carporte</h1>
                <h3>Carporte efter dit design</h3>
                <a class="btn btn-primary btn-lg" href="FrontController?taget=redirect&modtagerside=design" role="button">Start design</a>
            </div>
        </div>
        <div class="carousel-item">
            <img class="img-fluid" src="img/background4.png">
            <div class="carousel-caption">
                <h1 class="display-2">Fog Carporte</h1>
                <h3>Carporte efter dit design</h3>
                <a class="btn btn-primary btn-lg" href="FrontController?taget=redirect&modtagerside=design" role="button">Start design</a>
            </div>
        </div>
        <div class="carousel-item ">
            <img class="img-fluid" src="img/background5.png">
            <div class="carousel-caption">
                <h1 class="display-2">Fog Carporte</h1>
                <h3>Carporte efter dit design</h3>
                <a class="btn btn-primary btn-lg" href="FrontController?taget=redirect&modtagerside=design" role="button">Start design</a>
            </div>
        </div>
    </div>
</div>


<!--- Welcome Section -->
<div class="container-fluid padding">
    <div class="row welcome text-center">
        <div class="col-12">
            <h1 class="display-4">Fog Trælast & Byggecenter</h1>
        </div>
        <hr>
        <div class="col-12">
            <p class="lead">Fog trælast og byggecenter er en trælast og et byggecenter,
                som giver dig muligheden for at designe en carport,
                der passer perfekt til dit hus.
                Vi har eksperter, som sidder klar, hvis du har brug for hjælp til at få designet carporten,
                der passer til netop dig.
            </p>
        </div>
    </div>
</div>

<!--- Connect -->
<div class="container-fluid padding">
    <div class="row text-center padding">
        <div class="col-12">
            <h2>Find os her</h2>
        </div>
        <div class="col 12 social padding">
            <a href="https://www.facebook.com/fogtraelastbyggecenter" target="_blank"><i class="fab fa-facebook"></i></a>
            <a href="https://www.instagram.com/fogtraelastbyggecenter/" target="_blank"><i class="fab fa-instagram"></i></a>
        </div>
    </div>
</div>


<%@include file="include/footer.inc" %>


