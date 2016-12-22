<%@ page contentType="text/html" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ru">
<head>

    <meta charset="UTF-8">

    <title>Market – продаём товар, дарим – настроение</title>

    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/general.css" />" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

<header>
    <%@include file="/pages/templates/header-template.jsp" %>
</header>
<div class="page-wrapper">
<main>
    <div class="container-fluid">

        <div class="jumbotron">

            <h2>Интернет-магазин</h2>
            <h1>The Market</h1> <br>

            <p class="lead">
                The Market – продаём товар, дарим – настроение
            </p>

            <img class="img-responsive" src="<c:url value="/pages/img/market-icon.png"/>" border="0"/>

        </div>

    </div>

</main>

    </div>
<footer>
    <%@include file="/pages/templates/footer-template.jsp" %>
</footer>

</body>
</html>