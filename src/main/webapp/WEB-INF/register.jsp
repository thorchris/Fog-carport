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
        <a class="navbar-brand" href="#"><img src="img/FogBrand.png"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
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


<!-- Registrer form -->
<div class="container-fluid padding">
    <div class="row">
        <div class="col-4"></div>
        <div class="col-4">
            <h1 class="text-center">Opret bruger</h1>
            <table class="table table-borderless table.responsive">
                <td>
                    <form name="register" action="FrontController" method="POST" class="was-validated">
                        <div class="form-group ml-2 mr-2">
                            <input type="hidden" name="taget" value="register">
                            Email:
                            <input type="text" name="email" class="form-control"  placeholder="Email" required="required" pattern="[ÆØÅæøåA-Za-z0-9._%+-]+@[ÆØÅæøåA-Za-z0-9.-]+\.[ÆØÅæøåA-Za-z]{2,}$">
                            <div class="valid-feedback">Godkendt.</div>
                            <div class="invalid-feedback">Indtast email.</div>
                        </div>
                        <div class="form-group ml-2 mr-2">
                            Kodeord:
                            <input type="password" class="form-control" name="password1" placeholder="Kodeord" required="required">
                            <div class="valid-feedback">Godkendt.</div>
                            <div class="invalid-feedback">Indtast password.</div>
                        </div>
                        <div class="form-group ml-2 mr-2">
                            Kodeord igen:
                            <input type="password" class="form-control" name="password2" placeholder="Kodeord" required="required">
                            <div class="valid-feedback">Godkendt.</div>
                            <div class="invalid-feedback">Indtast password igen.</div>
                        </div>
                        <div class="form-footer text-center">
                            <input type="submit" class="btn btn-primary btn-style " value="Register dig her">
                        </div>
                        <div class="alert alert-danger mt-4 <c:if test = "${empty requestScope.message}">d-none</c:if> "
                             role="alert">
                            ${requestScope.message}
                        </div>
                    </form>
                </td>
                </tr>
            </table>
        </div>
    </div>
</div>

<%@include file="../include/footer.inc" %>
