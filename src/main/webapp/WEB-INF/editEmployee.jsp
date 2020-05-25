<%@ page import="FunctionLayer.GenerateLists" %>
<%@ page import="FunctionLayer.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%!
    @Override
    public void jspInit() {
        GenerateLists.initLists();
    }
%>
<%
    if (request.getServletContext().getAttribute("customerList") == null) {
        request.getServletContext().setAttribute("customerList", GenerateLists.getCustomerList());
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
                        if (user == null) {
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
                            } else if (user.getRole().equals("customer")) {
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
    <form action="FrontController" method="post">
        <input type="hidden" name="taget" value="manageCommand"/>
    <div class="row">
        <div class="col-1"></div>
        <!-- Table showing orders with options to search and edit them -->
        <div class="col-10">
            <h3 class="text-center"> Kunde design </h3>
            <hr>
            <table class="table table-striped table-dark table-bordered table.responsive">
                <thead>
                <tr>
                    <th scope="col">Design</th>
                    <th scope="col">Kunde Order ID</th>
                    <th scope="col">Order ID</th>
                    <th scope="col">Kunde ID</th>
                    <th scope="col">Carport Længde</th>
                    <th scope="col">Carport Bredde</th>
                    <th scope="col">Tag ID</th>
                    <th scope="col">Skur ID</th>
                    <th scope="col">Carport Mat ID</th>
                    <th scope="col">Beklædning sider</th>
                    <th scope="col">Tag hældning</th>
                    <th scope="col">Pris</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <!-- https://www.codejava.net/java-ee/jsp/how-to-list-records-in-a-database-table-using-jsp-and-jstl -->
                    <c:forEach var="customerDesign" items="${requestScope.customerOrder}">
                <tr>
                    <td><button class="btn btn-primary btn-style openSvgDesign" name="openSvgDrawing" value="${customerDesign.orderId}">Se Design</button></td>

                    <td><c:out value="${customerDesign.customerOrderId}"/></td>
                    <td><c:out value="${customerDesign.orderId}"/></td>
                    <td><c:out value="${customerDesign.userId}"/></td>
                    <td><c:out value="${customerDesign.cp_height}"/></td>
                    <td><c:out value="${customerDesign.cp_width}"/></td>
                    <td><c:out value="${customerDesign.roofMatId}"/></td>
                    <td><c:out value="${customerDesign.shedMatId}"/></td>
                    <td><c:out value="${customerDesign.cpMatId}"/></td>
                    <td><c:out value="${customerDesign.claddingSides}"/></td>
                    <td><c:out value="${customerDesign.roofAngle}"/></td>
                    <td><c:out value="${customerDesign.price}"/></td>
                </tr>
                </c:forEach>
                </tr>
                </tbody>
            </table>

            <div class="mt-4">
                <div class="form-row">
                        <div class="mt-2">
                            <input type="text" name="customerEmail" class="form-control" placeholder="Indtast Kunde Email" pattern="[ÆØÅæøåA-Za-z0-9._%+-]+@[ÆØÅæøåA-Za-z0-9.-]+\.[ÆØÅæøåA-Za-z]{2,}$">
                            <button type="submit" class="btn btn-primary btn-style mt-2" name="findCustomerOrder">Find kunde design</button>
                        </div>
                        <div class="mt-2 ml-2">
                            <input type="text" class="form-control"
                                   placeholder="Indtast ordre ID" name="orderId">
                            <button type="submit" class="btn btn-primary btn-style mt-2" name="getCustomerOrder">Se kunde ordre</button>
                        </div>
                        <div class="mt-2 ml-2">
                            <input type="text" class="form-control" placeholder="Indtast kunde ordre id" name="co_id">
                            <input type="text" class="form-control" placeholder="Ny pris" name="updatePrice">
                            <button type="submit" class="btn btn-primary btn-style mt-2" name="changePrice">Ændre pris</button>
                        </div>
                </div>
            </div>
        </div>
        <div class="col-1"></div>
    </div>
        <!-- List showing customers -->
        <div class="row">
            <div class="col-4"></div>
        <div class="col-4">
            <h3 class="text-center"> Kunde liste </h3>
            <hr>
            <table class="table table-striped table-dark table-bordered table.responsive">
                <thead>
                <tr>
                    <th scope="col">Kunde id</th>
                    <th scope="col">Email</th>
                    <th scope="col">Kodeord</th>
                    <th scope="col">Role</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <!-- https://www.codejava.net/java-ee/jsp/how-to-list-records-in-a-database-table-using-jsp-and-jstl -->
                    <c:forEach var="customer" items="${applicationScope.customerList}">
                <tr>
                    <td><c:out value="${customer.id}"/></td>
                    <td><c:out value="${customer.email}"/></td>
                    <td><c:out value="${customer.password}"/></td>
                    <td><c:out value="${customer.role}"/></td>
                </tr>
                </c:forEach>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-4"></div>
    </div>
    </form>
</div>

<!-- Footer -->
<%@include file="../include/footer.inc" %>
