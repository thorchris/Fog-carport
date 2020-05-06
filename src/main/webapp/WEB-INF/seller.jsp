<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="FunctionLayer.GenerateLists" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    @Override
    public void jspInit() {
        GenerateLists.initOrderList();
    }
%>
<%
    if (request.getServletContext().getAttribute("orderList") == null) {
        request.getServletContext().setAttribute("orderList", GenerateLists.getOrderList());
    }
%>

<%@include file="../include/header.inc" %>

<div class="container col-lg-12">
    <div class="row">



        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <h1 class="headerseller"> Sælger side </h1>
            <h2 class="headerseller"> Kunders design</h2>
            <div class="table-wrap" >
                <table class="table table-borderless table.responsive">
                    <thead>
                    <tr>
                        <th scope="col">Ordre ID</th>
                        <th scope="col">Bruger ID</th>
                        <th scope="col">Spær</th>
                        <th scope="col">Beklædning</th>
                        <th scope="col">Stolper</th>
                        <th scope="col">Skruer</th>
                        <th scope="col">Stær</th>
                        <th scope="col">Beslag</th>
                        <th scope="col">Rem</th>
                        <th scope="col">Dørhåndtag</th>
                        <th scope="col">Dørhængsler</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <c:forEach var="order" items="${applicationScope.orderList}">
                    <tr>
                        <td><c:out value="${order.orderId}"/></td>
                        <td><c:out value="${order.userId}"/></td>
                        <td><c:out value="${order.rafters}"/></td>
                        <td><c:out value="${order.cladding}"/></td>
                        <td><c:out value="${order.posts}"/></td>
                        <td><c:out value="${order.screws}"/></td>
                        <td><c:out value="${order.fascia}"/></td>
                        <td><c:out value="${order.brackets}"/></td>
                        <td><c:out value="${order.straps}"/></td>
                        <td><c:out value="${order.doorknobs}"/></td>
                        <td><c:out value="${order.doorhinges}"/></td>

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
