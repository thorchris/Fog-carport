<%@ page import="FunctionLayer.User" %>
<%@ page import="FunctionLayer.LogicFacade" %>
<%@ page import="FunctionLayer.CustomerOrder" %>
<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%
    List<CustomerOrder> customerOrderList = LogicFacade.getCustomerDesignOrder(((User)session.getAttribute("user")).getId());
    session.setAttribute("customerOrderList", customerOrderList);
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

<!-- Table showing customer orders -->
<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="manageCommand">
<div class="container-fluid padding">
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10">
            <h3 class="text-center">Velkommen til din side: ${sessionScope.user.email}.</h3>
            <h4 class="text-center">Her kan du se en liste over dine tidligere designs.</h4>
            <hr>
                <table class="table table-striped table-dark table-bordered table.responsive ">
                    <thead>
                    <tr>
                        <th scope="col">Se design</th>
                        <th scope="col">Bestillings ID</th>
                        <th scope="col">Bruger ID</th>
                        <th scope="col">Order ID</th>
                        <th scope="col">Carport længde</th>
                        <th scope="col">Carport bredde</th>
                        <th scope="col">Beklædning sider</th>
                        <th scope="col">Tag materiale</th>
                        <th scope="col">Skur materiale</th>
                        <th scope="col">Carport materiale</th>
                        <th scope="col">Tag vinkel</th>
                        <th scope="col">Pris</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <c:forEach var="customerOrder" items="${sessionScope.customerOrderList}">
                    <tr>

                        <td><button class="btn btn-primary btn-style openSvgDesign" name="openSvgDrawing" value="${customerOrder.orderId}">Se Design</button></td>
                        <td><c:out value="${customerOrder.customerOrderId}"/></td>
                        <td><c:out value="${customerOrder.userId}"/></td>
                        <td><c:out value="${customerOrder.orderId}"/></td>
                        <td><c:out value="${customerOrder.cp_height}"/></td>
                        <td><c:out value="${customerOrder.cp_width}"/></td>
                        <td><c:out value="${customerOrder.claddingSides}"/></td>
                        <td><c:out value="${customerOrder.roofMatId}"/></td>
                        <td><c:out value="${customerOrder.shedMatId}"/></td>
                        <td><c:out value="${customerOrder.cpMatId}"/></td>
                        <td><c:out value="${customerOrder.roofAngle}"/></td>
                        <td><c:out value="${customerOrder.price}"/></td>
                    </tr>
                    </c:forEach>
                    </tr>
                    </tbody>
                </table>
        </div>
        <div class="col-1"></div>
    </div>
</div>
</form>


<!-- Footer -->
<%@include file="../include/footer.inc" %>
