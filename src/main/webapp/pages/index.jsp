<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>

<title>Shani – продаём не товар, продаём настроение.</title>

<link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/pages/css/main.css" />" rel="stylesheet">

</head>

<body>

<div class="navbar">

<c:choose>
    <c:when test="${empty username}">
        <a class="btn btn-primary regis" href="<c:url value="/register" />" role="button">Регистрация</a>
        <a class="btn btn-success" href="<c:url value="/login" />" role="button">Войти</a>
    </c:when>
    <c:otherwise>
        <div>
            <span class="userName">Ваш логин: <span class="boldText"><sec:authentication property="principal.username" /> </span></span>
            <a class="btn btn-danger pull-right" href="<c:url value="/logout" />" role="button">Выйти</a>
        </div>
    </c:otherwise>
</c:choose>

</div>

<div class="container">
    <div class="jumbotron" style="margin-top: 20px;">
        <h2>Интернет-магазин</h2>
        <h1>Shani</h1> <br>
        <p class="lead">
            Shani – продаём не товар, продаём настроение.
        </p>
    </div>
</div>

<footer>
  <p>© Padalka Pavel 2016</p>
</footer>
</body>
</html>