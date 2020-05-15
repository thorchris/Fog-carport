<%@ page import="FunctionLayer.GenerateLists" %>
<%@ page import="FunctionLayer.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!-- Loading lists from DB -->
<%!
    @Override
    public void jspInit() {
        GenerateLists.initLists();
    }
%>
<%
    if (request.getServletContext().getAttribute("roofMaterials") == null) {
        request.getServletContext().setAttribute("roofMaterials", GenerateLists.getRoffMaterialList());
    }
    if (request.getServletContext().getAttribute("carportMaterials") == null) {
        request.getServletContext().setAttribute("carportMaterials", GenerateLists.getCarportMaterialsList());
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

<!-- Design form, used to design custom carport -->
<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="manageCommand"/>
    <div class="container-fluid padding">
        <div class="row">
            <div class="col-1"></div>
            <div class="col-6">
                <h3 class="text-center">Plantegning:</h3>
                <hr>
                ${requestScope.svgdrawing}
            </div>
            <div class="col-4">
                <h3 class="text-center">Specifikationer:</h3>
                <hr>
                <div class="dropdown">
                    <label for="exampleFormControlSelect1"><h5>Længde på carporten:</h5></label>
                    <select class="form-control dropbtn btn-primary btn-style btn-block" name="length"
                            id="exampleFormControlSelect1">
                        <option value="2.40">240</option>
                        <option value="2.70">270</option>
                        <option value="3.00">300</option>
                        <option value="3.30">330</option>
                        <option value="3.60">360</option>
                        <option value="3.90">390</option>
                        <option value="4.20">420</option>
                        <option value="4.50">450</option>
                        <option value="4.80">480</option>
                        <option value="5.10">510</option>
                        <option value="5.40">540</option>
                        <option value="5.70">570</option>
                        <option value="6.00">600</option>
                        <option value="6.30">630</option>
                        <option value="6.60">660</option>
                        <option value="6.90">690</option>
                        <option value="7.20">720</option>
                        <option value="7.50">750</option>
                        <option value="7.80">780</option>
                    </select>
                </div>

                <div class="dropdown">
                    <label for="exampleFormControlSelect1"><h5>Bredde på carporten:</h5></label>
                    <select class="form-control dropbtn btn-primary btn-style btn-block" name="width"
                            id="exampleFormControlSelect2">
                        <option value="2.40">240</option>
                        <option value="2.70">270</option>
                        <option value="3.00">300</option>
                        <option value="3.30">330</option>
                        <option value="3.60">360</option>
                        <option value="3.90">390</option>
                        <option value="4.20">420</option>
                        <option value="4.50">450</option>
                        <option value="4.80">480</option>
                        <option value="5.10">510</option>
                        <option value="5.40">540</option>
                        <option value="5.70">570</option>
                        <option value="6.00">600</option>
                        <option value="6.30">630</option>
                        <option value="6.60">660</option>
                        <option value="6.90">690</option>
                        <option value="7.20">720</option>
                        <option value="7.50">750</option>
                    </select>
                </div>

                <h5>Ønsker de et skur?</h5>
                <input type="radio" id="shedCheckbox" onclick="myFunction1()" name="shedYesOrNo" value="true">
                Ja </input>
                <input type="radio" name="shedYesOrNo" onclick="myFunction1()" value="false"> Nej </input>
                <div class="form-group" id="shedDropdowns" style="display: none">
                    <select class="form-control dropbtn btn-primary btn-style mb-2 btn-block"
                            id="emptyDropdown1" type="text" name="shedLength">
                        <label for="exampleFormControlSelect1">Størrelse på skuret:</label>
                        <option name="isHalf" id="inlineRadio3" value="true">Halv bredde af carport</option>
                        <option name="isHalf" id="inlineRadio4" value="false">Hel bredde af carport</option>
                    </select>
                </div>


                <h5>Ønsker de beklædning til carporten?</h5>
                <input type="radio" id="claddingCheckbox" onclick="myFunction3()" name="claddingYesOrNo" value="true">
                Ja </input>
                <input type="radio" name="claddingYesOrNo" value="false" onclick="myFunction3()"> Nej </input>

                <div class="dropdown" style="display:none" id="carportDropdowns">
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Beklædning til carporten:</label>
                        <select class="form-control dropbtn btn-primary btn-style mb-2 btn-block"
                                name="carportMaterial"
                                id="carportMat">
                            <c:forEach var="carportMaterialName" items="${applicationScope.carportMaterials}">
                                <option value="${carportMaterialName.materialName}">${carportMaterialName.materialName} </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-group" id="numberOfCladdingSides" style="display: none">
                    <select class="form-control dropbtn btn-primary btn-style mb-2 btn-block"
                            id="emptyDropdown3" type="text" name="claddingsides">
                        <option value="1">En langside</option>
                        <option value="2">To langsider</option>
                        <option value="3">En langside og bagsiden</option>
                        <option value="4">Begge langsider og bagsiden</option>
                    </select>
                </div>

                <div class="form-group" id="numberOfCladdingSides1" style="display: none">
                    <select class="form-control dropbtn btn-primary btn-style mb-2 btn-block"
                            id="emptyDropdown4" type="text" name="claddingsides1">
                        <option value="1">En langside</option>
                        <option value="2">To langsider</option>
                    </select>
                </div>

                <h5>Hvilken tagtype ønsker du?</h5>
                <input type="radio" name="isHighRoof" value="false" onclick="myFunction2()"> Fladt tag </input>
                <input type="radio" id="roofCheckbox" onclick="myFunction2()" name="isHighRoof" value="true"> Rejsning på taget </input>

                <div class="form-group" id="roofDropdowns" style="display: none">
                    <select class="form-control dropbtn btn-primary btn-style mb-2 btn-block"
                            id="emptyDropdown2" type="text" name="angle">
                        <option value="0" disabled selected> Tagets hældning</option>
                        <option value="15">15</option>
                        <option value="20">20</option>
                        <option value="25">25</option>
                        <option value="30">30</option>
                        <option value="35">35</option>
                        <option value="40">40</option>
                        <option value="45">45</option>
                        <option value="50">50</option>
                    </select>

                    <div class="dropdown">
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">Materialer til taget:</label>
                            <select class="form-control dropbtn btn-primary btn-style mb-2 btn-block"
                                    name="roofMaterial"
                                    id="topping">
                                <c:forEach var="roofMaterialName" items="${applicationScope.roofMaterials}">
                                    <option value="${roofMaterialName.materialName}">${roofMaterialName.materialName} </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <br>
                <button type="input" class="btn btn-primary btn-style mt-2 mb-2" name="calcPriceButton" >Beregn anslået pris
                </button>
                <h5>Anslået pris: ${sessionScope.totalPrice}</h5>

                <button type="input" class="btn btn-primary btn-style mt-2" name="createOrderButton" >Send til sælger
                </button>
                <button type="input" class="btn btn-primary btn-style mt-2" name="svgDrawing">Plantegning</button>
            </div>
            <div class="col-1"></div>
        </div>
    </div>
</form>
</div>


<!-- Footer -->
<script src="JS/javascript.js"></script>
<%@include file="../include/footer.inc" %>
