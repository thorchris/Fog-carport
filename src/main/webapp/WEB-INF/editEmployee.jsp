<%@ page import="FunctionLayer.GenerateLists" %>
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

<%@include file="../include/header.inc" %>

<div class="container col-lg-12">
    <div class="row">
        <form class="col-lg-7">
            <h1 class="headerseller"> Kunde design </h1>
            <table class="table table-striped table-dark table-bordered table.responsive">
                <thead>
                <tr>
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
                    <td><c:out value="${customerDesign.customerOrderId}"/></td>
                    <td><c:out value="${customerDesign.orderId}"/></td>
                    <td><c:out value="${customerDesign.userId}"/></td>
                    <td><c:out value="${customerDesign.cp_length}"/></td>
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
                <form action="FrontController" method="post">
                    <input type="hidden" name="taget" value="findCustomerOrder"/>
                        <div>
                            <input type="text" name="customerEmail" class="form-control"
                                   placeholder="Indtast Kunde Email">
                            <button type="submit" class="btn btn-primary btn-style mt-2" name="findCustomerOrder">
                                Find kunde design
                            </button>
                        </div>
                </form>

                <form action="FrontController" method="post">
                    <input type="hidden" name="taget" value="getCustomerOrder"/>
                        <div>
                            <input type="text" class="form-control ml-2 "
                                   placeholder="Indtast ordre ID" name="orderId">
                            <button type="submit"class="btn btn-primary btn-style mt-2 ml-2"  name="getCustomerOrder" >
                                Se kunde ordre
                            </button>
                        </div>
                    </div>
            </div>
                </form>
            </div>
            <div class="alert alert-success mt-2 <c:if test = "${empty requestScope.message}">d-none</c:if> "
                 role="alert">
                ${requestScope.message}
            </div>

        <div class="col-lg-4">
            <h1 class="headerseller"> Kunde liste </h1>
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
        <div class="col-lg-1"></div>
    </div> <!-- ROW -->

<%@include file="../include/footer.inc" %>
