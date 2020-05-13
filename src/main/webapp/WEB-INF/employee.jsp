<%@ page import="FunctionLayer.GenerateLists" %>
<%@ page import="FunctionLayer.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%!
    @Override
    public void jspInit() {
        GenerateLists.initOrderList();
    }
%>
<%
    if (request.getServletContext().getAttribute("orderList") == null) {
        request.getServletContext().setAttribute("orderList", GenerateLists.getOrderList());
    }
%>


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
<!-- Welcome message -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-1"></div>
            <div class="col-10">
                <h3 class="text-center"> Velkommen tilbage:"Sælger navn"</h3>
                <h5 class="text-center">Hvor vil du hen?</h5>
                <a href="FrontController?taget=redirect&modtagerside=editEmployee" role="link"><h5 class="text-center">Rediger ordre</h5></a>
                <hr>
            </div>
        </div>
            <div class="col-1"></div>
        <!-- Employee table showing customer orders -->
            <div class="row">
                <div class="col-1"></div>
                <div class="col-10">
                <h2 class="text-center"> Kunders design</h2>
                <div class="table-wrap">
                    <table class="table table-striped table-dark table-bordered table.responsive">
                        <thead>
                        <tr>
                            <th scope="col">Ordre ID</th>
                            <th scope="col">Bruger ID</th>
                            <th scope="col">Spær</th>
                            <th scope="col">Beklædning</th>
                            <th scope="col">Stolper</th>
                            <th scope="col">Skruer</th>
                            <th scope="col">Stær</th>
                            <th scope="col">Beslag</th>
                            <th scope="col">Rem</th>
                            <th scope="col">Dørhåndtag</th>
                            <th scope="col">Dørhængsler</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <c:forEach var="order" items="${applicationScope.orderList}">
                        <tr>
                            <td><c:out value="${order.orderId}"/></td>
                            <td><c:out value="${order.userId}"/></td>
                            <td><c:out value="${order.rafters}"/></td>
                            <td><c:out value="${order.cladding}"/></td>
                            <td><c:out value="${order.posts}"/></td>
                            <td><c:out value="${order.screws}"/></td>
                            <td><c:out value="${order.fascia}"/></td>
                            <td><c:out value="${order.brackets}"/></td>
                            <td><c:out value="${order.straps}"/></td>
                            <td><c:out value="${order.doorknobs}"/></td>
                            <td><c:out value="${order.doorhinges}"/></td>

                        </tr>
                        </c:forEach>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-1"></div>
        </div>
    </div>
    <!-- Footer -->
    <%@include file="../include/footer.inc" %>
