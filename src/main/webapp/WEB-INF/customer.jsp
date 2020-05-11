<%@ page import="PresentationLayer.GetCustomerOrder" %>
<%@ page import="FunctionLayer.CustomerOrder" %>
<%@ page import="java.util.List" %>
<%@ page import="FunctionLayer.GenerateLists" %>
<%@ page import="FunctionLayer.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.inc" %>

<%!
    @Override
    public void jspInit() {
        GenerateLists.initCustomerOrderList();
    }
%>
<%
    if (session.getAttribute("customerOrderList") == null) {
        session.setAttribute("customerOrderList", GenerateLists.getCustomerOrderList());
    }
%>


<div class="container col-lg-12">
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <h1 class="headerseller"> Kundeside </h1>
            <p class="text-center">
                ${requestScope.message}
            </p>

            <div class="table-wrap">
                <table class="table table-striped table-dark table-bordered table.responsive ">
                    <thead>
                    <tr>
                        <th scope="col">Bestillings ID</th>
                        <th scope="col">Bruger ID</th>
                        <th scope="col">Order ID</th>
                        <th scope="col">Carport længde</th>
                        <th scope="col">Carport bredde</th>
                        <th scope="col">Antal sider med beklædning</th>
                        <th scope="col">Tag materiale</th>
                        <th scope="col">Skur materiale</th>
                        <th scope="col">Carport-skelet materiale</th>
                        <th scope="col">Tag vinkel</th>
                        <th scope="col">Pris</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <c:forEach var="customerOrder" items="${sessionScope.customerOrderList}">
                    <tr>
                        <td><c:out value="${customerOrder.customerOrderId}"/></td>
                        <td><c:out value="${customerOrder.userId}"/></td>
                        <td><c:out value="${customerOrder.orderId}"/></td>
                        <td><c:out value="${customerOrder.cp_length}"/></td>
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
        </div>
        <div class="col-lg-1"></div>
    </div> <!-- ROW -->
</div>




<%@include file="../include/footer.inc" %>
