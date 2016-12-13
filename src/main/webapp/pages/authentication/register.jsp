<%@ page contentType="text/html" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Регистрация нового пользователя</title>

  <!-- Bootstrap core CSS -->
  <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="<c:url value="/pages/css/sign-in.css" />" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
  <![endif]-->
</head>

<body>

<div class="navbar">

<c:choose>
  <c:when test="${empty sessionScope.get('user').getLogin()}">
    <a class="btn btn-success pull-right" href="<c:url value="/login" />" role="button">Войти</a>
  </c:when>
</c:choose>

</div>

<div class="container" style="width: 300px;">

  <c:if test="${not empty error}">
    <div class="error">${error}</div>
  </c:if>
  <c:if test="${not empty msg}">
    <div class="msg">${msg}</div>
  </c:if>

  <form name="registerForm" action="<c:url value='/register' />" method='POST'>
    <h2 class="form-sign-in-heading">Регистрация</h2>
    <input type="text" class="form-control" name="username" placeholder="Эл. адрес или номер моб. телефона" required autofocus value="${sessionScope.get("username")}">
    <br>
    <input type="password" class="form-control" name="password" placeholder="Введите пароль*" required value="${sessionScope.get("password")}">
    <br>
    <input type="password" class="form-control" name="passwordConfirm" placeholder="Введите пароль еще раз*" required value="${sessionScope.get("passwordConfirm")}">
    <br>
    <input type="text" class="form-control" name="firstName" placeholder="Ваше имя" required value="${sessionScope.get("firstName")}">
    <br>
    <input type="text" class="form-control" name="lastName" placeholder="Ваша фамилия" required value="${sessionScope.get("lastName")}">
    <br>
    <input type="date" class="form-control" name="birthday" placeholder="Дата рождения" required value="${sessionScope.get("birthday")}">
    <br>

    <div class="radio">
      <label>
        <input type="radio" name="sex" id="male" value="male" <c:if test="${sessionScope.get('sex') == null }">checked</c:if> <c:if test="${sessionScope.get('sex') == 'male' }">checked</c:if>>
          Мужской
          </label>
    </div>

    <div class="radio">
      <label>
        <input type="radio" name="sex" id="female" value="female" <c:if test="${sessionScope.get('sex') == 'female' }">checked</c:if>>
          Женский
          </label>
    </div>

    <br>
    <input type="email" class="form-control" name="email" placeholder="Адрес эл. почты" required value="${sessionScope.get("email")}">
    <br>

    <button class="btn btn-lg btn-primary btn-block" type="submit" value="Register">Регистрация</button>

  </form>

</div>

</body>
</html>