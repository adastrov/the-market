<%@ page contentType="text/html" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">

    <title>Авторизация пользователя</title>

    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/main.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/sign-in.css" />" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

<header>
    <%@include file="/pages/templates/header-template.jsp" %>
</header>

<main>
    <div class="container" style="width: 300px;">

        <form name="loginForm" action="<c:url value='/login' />" method='POST'>
            <h2 class="form-sign-in-heading">Эл. адрес или телефон</h2>
            <input type="text" class="form-control" name="username" placeholder="Email address" required autofocus
                   value="">
            <br>
            <h3 class="form-sign-in-heading">Пароль</h3>
            <input type="password" class="form-control" name="password" placeholder="Password" required value="">
            <br>
            <p> Новый пользователь? <a href="/register">Рергистрация</a></p>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
        </form>

    </div>
</main>

<footer>
    <%@include file="/pages/templates/footer-template.jsp" %>
</footer>

</body>
</html>