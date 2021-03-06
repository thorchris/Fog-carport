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
    <link rel="stylesheet" type="text/css" href="styles/styles.css">

    <title>Fog carport</title>
</head>

<body>
<div class="container-fluid banner">
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-md">
                <div class="navbar-brand">FOG-CARPORT</div>
                <ul class="nav">
                    <li class="nav-item">
                        <a class="nav-link" href="FrontController?taget=redirect&modtagerside=index">HJEM</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="FrontController?taget=redirect&modtagerside=contact">KONTAKT OS</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="FrontController?taget=redirect&modtagerside=design">CARPORT DESIGN</a>
                    </li>
                    <li>
                    <%
                     User user = (User) session.getAttribute("user");
                      if(user == null){
                       out.println("<a class=\"nav-link\" href=\"FrontController?taget=redirect&modtagerside=login\">LOGIN/REGISTRER</a>");
                         } else {
                       out.println("<a class=\"nav-link\" href=\"FrontController?taget=logout\">LOGUD</a>");
                       }
                    %>
                    </li>

                    <li>
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
            </nav>
        </div>

