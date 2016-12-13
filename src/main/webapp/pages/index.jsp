<%@ page contentType="text/html" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ru">
<head>

<meta charset="UTF-8">

<title>Market – продаём товар, дарим – настроение</title>

<link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/pages/css/main.css" />" rel="stylesheet">

</head>

<body>

<div class="navbar">

<c:choose>
    <c:when test="${empty sessionScope.get('user')}">
        <a class="btn btn-primary regis" href="<c:url value="/register" />" role="button">Регистрация</a>
        <a class="btn btn-success" href="<c:url value="/login" />" role="button">Войти</a>
    </c:when>
    <c:otherwise>
        <div>
            <span class="userName">Ваш логин: <span class="boldText"> "${sessionScope.get('user').getLogin()}" </span></span>
            <a class="btn btn-danger pull-right" href="<c:url value="/logout" />" role="button">Выйти</a>
        </div>
    </c:otherwise>
</c:choose>

</div>

<div class="container-fluid">
    <div class="jumbotron" style="margin-top: 25px;">

        <h2>Интернет-магазин</h2>
        <h1>Market</h1> <br>

        <p class="lead">
            Market – продаём товар, дарим – настроение
        </p>

        <a class="btn btn-lg btn-primary regis" href="<c:url value="/product-list" />" role="button">Список товаров</a>

    </div>
</div>

<footer>
  <p>© Pavel Padalka 2016</p>
</footer>
</body>
</html>