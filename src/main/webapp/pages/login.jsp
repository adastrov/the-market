<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>

  <title>Авторизация пользователя</title>

  <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
  <link href="<c:url value="/pages/css/signin.css" />" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
  <![endif]-->
</head>

<body>

<div class="container" style="width: 300px;">

  <c:if test="${not empty error}">
    <div class="error">${error}</div>
  </c:if>
  <c:if test="${not empty msg}">
    <div class="msg">${msg}</div>
  </c:if>

  <form action="<c:url value='/login' />" method='POST'>
    <h2 class="form-signin-heading">Эл. адрес или телефон</h2>
    <input type="text" class="form-control" name="username" placeholder="Email address" required autofocus value="">
    <br>
    <h3 class="form-signin-heading">Пароль</h3>
    <input type="password" class="form-control" name="password" placeholder="Password" required value="">
    <br>
    <p> Новый пользователь? <a href="/pages/register">Рергистрация</a> </p>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>

    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />

  </form>

</div>

</body>
</html>