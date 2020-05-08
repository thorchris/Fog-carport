<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.inc" %>



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
                        <td><c:out value="${sessionScope.customerOrder.customerOrderId}"/></td>
                        <td><c:out value="${sessionScope.customerOrder.userId}"/></td>
                        <td><c:out value="${sessionScope.customerOrder.orderId}"/></td>
                        <td><c:out value="${sessionScope.customerOrder.cp_length}"/></td>
                        <td><c:out value="${sessionScope.customerOrder.cp_width}"/></td>



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
