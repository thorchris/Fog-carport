<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="../include/header.inc" %>

<div class="container col-lg-12">
    <div class="row">
        <div class="col-4"></div>
        <div class="col-4">
            <h1>Login</h1>
            <table class="table table-borderless table.responsive">
                <td>
                    <form name="login" action="FrontController" method="POST">
                        <div class="form-group ml-2 mr-2">
                            <input type="hidden" name="taget" value="login">
                            <input type="text" class="form-control" name="email" placeholder="Email" required="required">
                        </div>
                        <div class="form-group ml-2 mr-2">
                            <input type="password" class="form-control" name="password" placeholder="Kodeord" required="required">
                        </div>
                        <div class="form-footer text-center">
                            <input type="submit" class="btn btn-danger btn-style " value="Login">
                        </div>
                    </form>
                </td>
                </tr>
            </table>
        </div>
    </div>
</div>

<%@include file="../include/footer.inc" %>
