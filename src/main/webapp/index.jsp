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
    <select class="form-control dropbtn btn-secondary btn-style btn-block" name="length" id="exampleFormControlSelect1">
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
    <select class="form-control dropbtn btn-secondary btn-style btn-block" name="width" id="exampleFormControlSelect2">
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

<h5>Skal din carport have et skur?</h5>
<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="shedYesOrNo" id="inlineRadio1" value="true" >
    <label class="form-check-label" for="inlineRadio1" value="true">Ja</label>
</div>
<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="shedYesOrNo" id="inlineRadio2" value="false" >
    <label class="form-check-label" for="inlineRadio2" value="false">Nej</label>
</div>

<h5>Hvis din carport har skur, hvor stort skal det være?</h5>
<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="isHalf" id="inlineRadio3" value="false">
    <label class="form-check-label" for="inlineRadio1">Hele carportens width</label>
</div>
<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="isHalf" id="inlineRadio4" value="true">
    <label class="form-check-label" for="inlineRadio2">Halve af carportens width</label>
</div>
<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="isHalf" id="inlineRadio5" value="option2">
    <label class="form-check-label" for="inlineRadio2">Intet skur</label>
</div>


<h5>Hvilken tagtype ønsker du?</h5>
<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio6" value="option1">
    <label class="form-check-label" for="inlineRadio1">Flat tag</label>
</div>
<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio7" value="option2">
    <label class="form-check-label" for="inlineRadio2">Rejsning på tag</label>
</div>

<div class="dropdown">
    <label for="exampleFormControlSelect1">Hvis tag med rejsning ønskes, vælg venligst antal grader på taget:</label>
    <select class="form-control dropbtn btn-secondary btn-style btn-block" name="height" id="exampleFormControlSelect4">
        <option value="1">15</option>
        <option value="2">20</option>
        <option value="3">25</option>
        <option value="4">30</option>
        <option value="5">35</option>
        <option value="6">40</option>
        <option value="6">45</option>
    </select>
</div>

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



<button type="input" class="btn btn-primary btn-style mt-2 mr-4">Beregn anslået pris</button>
<h5>Anslået pris: ${sessionScope.totalPrice}</h5>
</form>

<button type="input" class="btn btn-primary btn-style mt-2 mr-4">Send til sælger</button>


<%@include file="include/footer.inc" %>