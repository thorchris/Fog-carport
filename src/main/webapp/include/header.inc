<%@ page import="FunctionLayer.User" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@800&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/styles/styles.css">

    <title>Fog carport</title>
</head>

<body>
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="FrontController?taget=redirect&modtagerside=index"><img src="/img/fog.png"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?taget=redirect&modtagerside=index">Hjem</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?taget=redirect&modtagerside=contact">Kontakt Os</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?taget=redirect&modtagerside=design">Carport Design</a>
                </li>
                <li class="nav-item">
                    <%
                     User user = (User) session.getAttribute("user");
                      if(user == null){
                       out.println("<a class=\"nav-link\" href=\"FrontController?taget=redirect&modtagerside=login\">LOGIN/REGISTRER</a>");
                         } else {
                       out.println("<a class=\"nav-link\" href=\"FrontController?taget=logout\">LOGUD</a>");
                       }
                    %>
                    </li>

                <li class="nav-item">
                        <%
                            user = (User) session.getAttribute("user");
                            if (user != null) {
                                if (user.getRole().equals("employee")) {
                                    out.println("<a class=\"nav-link\" href=\"FrontController?taget=redirect&modtagerside=employee\">MEDARBEJDER SIDE</a>");
                                }
                                else if (user.getRole().equals("customer")) {
                                    out.println("<a class=\"nav-link\" href=\"FrontController?taget=redirect&modtagerside=customer\">MIN SIDE</a>");
                                }
                            }
                        %>
                    </li>
                </ul>
        </div>
    </div>
</nav>

