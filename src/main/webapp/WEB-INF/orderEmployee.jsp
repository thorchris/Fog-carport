<%@ page import="FunctionLayer.GenerateLists" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="../include/header.inc" %>

<div class="container col-lg-12">
    <div class="row">
        <div class="col-lg-8">
            <h1 class="headerseller"> Kunde Ordre </h1>
            <table class="table table-striped table-dark table-bordered table.responsive">
                <thead>
                <tr>
                    <th scope="col">Order ID</th>
                    <th scope="col">Kunde ID</th>
                    <th scope="col">Spær</th>
                    <th scope="col">Beklædning</th>
                    <th scope="col">Stolper</th>
                    <th scope="col">Skuer</th>
                    <th scope="col">Stern</th>
                    <th scope="col">Beslag</th>
                    <th scope="col">Straps</th>
                    <th scope="col">Dørhåndtag</th>
                    <th scope="col">Hængsler</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <!-- https://www.codejava.net/java-ee/jsp/how-to-list-records-in-a-database-table-using-jsp-and-jstl -->
                <tr>
                    <td>${sessionScope.order.orderId}</td>
                    <td>${sessionScope.order.userId}</td>
                    <td>${sessionScope.order.rafters}</td>
                    <td>${sessionScope.order.cladding}</td>
                    <td>${sessionScope.order.posts}</td>
                    <td>${sessionScope.order.screws}</td>
                    <td>${sessionScope.order.fascia}</td>
                    <td>${sessionScope.order.brackets}</td>
                    <td>${sessionScope.order.straps}</td>
                    <td>${sessionScope.order.doorknobs}</td>
                    <td>${sessionScope.order.doorhinges}</td>
                </tr>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-lg-4">
        </div>
        <div class="col-lg-1"></div>
    </div> <!-- ROW -->
</div>

<%@include file="../include/footer.inc" %>