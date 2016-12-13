<%@ page contentType="text/html" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>

  <meta charset="UTF-8">

  <title>Авторизация пользователя</title>

  <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
  <link href="<c:url value="/pages/css/sign-in.css" />" rel="stylesheet">

</head>

<body>

<div class="container" style="width: 300px;">

  <c:if test="${not empty error}">
    <div class="error">${error}</div>
  </c:if>
  <c:if test="${not empty msg}">
    <div class="msg">${msg}</div>
  </c:if>

  <form name="loginForm" action="<c:url value='/login' />" method='POST'>
    <h2 class="form-sign-in-heading">Эл. адрес или телефон</h2>
    <input type="text" class="form-control" name="username" placeholder="Email address" required autofocus value="">
    <br>
    <h3 class="form-sign-in-heading">Пароль</h3>
    <input type="password" class="form-control" name="password" placeholder="Password" required value="">
    <br>
    <p> Новый пользователь? <a href="/register">Рергистрация</a> </p>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>

  </form>

</div>

</body>
</html>