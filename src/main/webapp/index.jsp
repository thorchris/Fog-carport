<%@ page import="FunctionLayer.GenerateLists" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

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

%>

<%@include file="include/header.inc" %>

<h1>Velkommen</h1>
<h2>Design din carport her</h2>
<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="calculatePrice"/>
    <div class="dropdown">
        <label for="exampleFormControlSelect1">length</label>
        <select class="form-control dropbtn btn-secondary btn-style btn-block" name="length"
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
        <label for="exampleFormControlSelect1">width</label>
        <select class="form-control dropbtn btn-secondary btn-style btn-block" name="width"
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
    <input type="radio" id="shedCheckbox" onclick="myFunction1()" name="shedYesOrNo" value="true"> Ja </input>
    <input type="radio" name="shedYesOrNo" onclick="myFunction1()" value="false"> Nej </input>
    <div class="form-group" id="shedDropdowns" style="display: none">
        <select class="form-control" style="margin-bottom: 30px; margin-top: 30px"
                id="emptyDropdown1" type="text" name="shedLength">
            <option value="" disabled selected> Skurets størrelse</option>
            <option name="isHalf" id="inlineRadio3" value="false">Halv bredde af carport</option>
            <option name="isHalf" id="inlineRadio4" value="true">Hel bredde af carport</option>
        </select>
    </div>

    </div>


    <h5>Hvilken tagtype ønsker du?</h5>
    <input type="radio" name="isHighRoof" value="false" onclick="myFunction2()"> Fladt tag </input>
    <input type="radio" id="roofCheckbox" onclick="myFunction2()" name="isHighRoof" value="true"> Rejsning på
    taget </input>

    <div class="form-group" id="roofDropdowns" style="display: none">
        <select class="form-control" style="margin-bottom: 30px; margin-top: 30px"
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
                <select class="form-control dropbtn btn-secondary btn-style mb-2 btn-block" name="roofMaterial"
                        id="topping">
                    <c:forEach var="roofMaterialName" items="${applicationScope.roofMaterials}">
                        <option value="${roofMaterialName.materialName}">${roofMaterialName.materialName} </option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>


    </div>

    <br>
    <button type="input" class="btn btn-primary btn-style mt-2 mr-4">Beregn anslået pris</button>
    <h5>Anslået pris: ${sessionScope.totalPrice}</h5>
</form>

<button type="input" class="btn btn-primary btn-style mt-2 mr-4">Send til sælger</button>

<script src="JS/javascript.js"></script>


<%@include file="include/footer.inc" %>