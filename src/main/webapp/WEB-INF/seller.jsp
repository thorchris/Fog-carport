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



<h1> Sælger side </h1>

<h2> Kunders design</h2>
<div class="col-lg-5">
    <div class="table-wrap">
        <table class="table table-borderless table.responsive">
            <thead>
            <tr>
                orderId, userId, rafters, cladding, posts,
                screws, fascia, brackets, straps, doorKnobs, doorHinges
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
                <!-- https://www.codejava.net/java-ee/jsp/how-to-list-records-in-a-database-table-using-jsp-and-jstl -->
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


<%@include file="../include/footer.inc" %>
