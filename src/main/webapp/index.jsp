<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="include/header.inc" %>

<h1>Velkommen</h1>
<h2>Design din carport her</h2>

<div class="dropdown">
    <label for="exampleFormControlSelect1">Længde</label>
    <select class="form-control dropbtn btn-secondary btn-style btn-block" name="height" id="exampleFormControlSelect1">
        <option value="1">240</option>
        <option value="2">270</option>
        <option value="3">300</option>
        <option value="4">330</option>
        <option value="5">360</option>
        <option value="6">390</option>
        <option value="7">420</option>
        <option value="8">450</option>
        <option value="9">480</option>
        <option value="10">510</option>
        <option value="10">540</option>
        <option value="10">570</option>
        <option value="10">600</option>
        <option value="10">630</option>
        <option value="10">660</option>
        <option value="10">690</option>
        <option value="10">720</option>
        <option value="10">750</option>
        <option value="10">780</option>
    </select>
</div>

<div class="dropdown">
    <label for="exampleFormControlSelect1">Bredde</label>
    <select class="form-control dropbtn btn-secondary btn-style btn-block" name="height" id="exampleFormControlSelect2">
        <option value="1">240</option>
        <option value="2">270</option>
        <option value="3">300</option>
        <option value="4">330</option>
        <option value="5">360</option>
        <option value="6">390</option>
        <option value="7">420</option>
        <option value="8">450</option>
        <option value="9">480</option>
        <option value="10">510</option>
        <option value="10">540</option>
        <option value="10">570</option>
        <option value="10">600</option>
        <option value="10">630</option>
        <option value="10">660</option>
        <option value="10">690</option>
        <option value="10">720</option>
        <option value="10">750</option>
    </select>
</div>

<h5>Skal din carport have et skur?</h5>
<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
    <label class="form-check-label" for="inlineRadio1">Ja</label>
</div>
<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
    <label class="form-check-label" for="inlineRadio2">Nej</label>
</div>

<h5>Hvis din carport har skur, hvor stort skal det være?</h5>
<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option1">
    <label class="form-check-label" for="inlineRadio1">Hele carportens bredde</label>
</div>
<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio4" value="option2">
    <label class="form-check-label" for="inlineRadio2">Halve af carportens bredde</label>
</div>
<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio5" value="option2">
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
    <select class="form-control dropbtn btn-secondary btn-style btn-block" name="height" id="exampleFormControlSelect3">
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
    <label for="exampleFormControlSelect1">Materialer til taget:</label>
    <select class="form-control dropbtn btn-secondary btn-style btn-block" name="height" id="exampleFormControlSelect4">
        <option value="1">option1</option>
        <option value="1">option2</option>
        <option value="1">option3</option>
        <option value="1">option4</option>
        <option value="1">option5</option>
    </select>
</div>

<div class="dropdown">
    <label for="exampleFormControlSelect1">Materialer til carporten:</label>
    <select class="form-control dropbtn btn-secondary btn-style btn-block" name="height" id="exampleFormControlSelect5">
        <option value="1">option1</option>
        <option value="1">option2</option>
        <option value="1">option3</option>
        <option value="1">option4</option>
        <option value="1">option5</option>
    </select>
</div>

<button type="input" class="btn btn-primary btn-style mt-2 mr-4">Beregn anslået pris</button>
<h5>Anslået pris: 19.995kr</h5>


<button type="input" class="btn btn-primary btn-style mt-2 mr-4">Send til sælger</button>

<%@include file="include/footer.inc" %>