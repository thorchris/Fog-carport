<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../include/header.inc" %>

<div class="container col-lg-12">
    <div class="row">
        <div class="col-4"></div>
        <div class="col-4">
            <h1 class="headerseller">Login</h1>
            <table class="table table-borderless table.responsive">
                <td>
                    <form name="login" action="FrontController" method="POST" class="was-validated">
                        <div class="form-group">
                            <input type="hidden" name="taget" value="login">
                            <input type="text" class="form-control" name="email" placeholder="Email" required="required">
                            <div class="valid-feedback">Godkendt.</div>
                            <div class="invalid-feedback">Indtast email.</div>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="password" placeholder="Kodeord" required="required">
                            <div class="valid-feedback">Godkendt.</div>
                            <div class="invalid-feedback">Indtast password.</div>
                        </div>
                        <div class="form-footer">
                            <input type="submit" class="btn btn-primary btn-style" value="Login">
                            <a href="FrontController?taget=redirect&modtagerside=register" class="btn btn-primary btn-style ml-1">Opret Bruger</a>
                        </div>

                    </form>
                </td>
                </tr>
            </table>
            <div class="col-4"></div>
        </div>
    </div>
</div>

<%@include file="../include/footer.inc" %>
