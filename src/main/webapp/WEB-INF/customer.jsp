<%@ page import="FunctionLayer.User" %>
<%@ page import="FunctionLayer.LogicFacade" %>
<%@ page import="FunctionLayer.CustomerOrder" %>
<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../include/header.inc" %>

<%
    List<CustomerOrder> customerOrderList = LogicFacade.getCustomerDesignOrder(((User)session.getAttribute("user")).getId());
    session.setAttribute("customerOrderList", customerOrderList);
%>

<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="openSvgDesign">
<div class="container col-lg-12">
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <h1 class="headerseller"> Kundeside </h1>
            <p class="text-center">
                ${requestScope.message}
            </p>
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
                        <td><button class="btn btn-primary btn-style openSvgDesign" name="openSvgDesign">Åben Design</button></td>

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
        <div class="col-lg-1"></div>
    </div> <!-- ROW -->
</div>
</form>







<%@include file="../include/footer.inc" %>
