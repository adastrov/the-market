<%@ page contentType="text/html" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>

  <meta charset="UTF-8">

  <title>Авторизация пользователя</title>

  <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
  <link href="<c:url value="/pages/css/sign-in.css" />" rel="stylesheet">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <div class="navbar">

    <nav class="navbar navbar-default" role="navigation">

      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<c:url value="/index"/>">The-market</a>

        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li>
              <a href="<c:url value="/index"/>">
                <span class="glyphicon glyphicon-home" aria-hidden="true"></span> Домой
              </a>
            </li>
            <li>
              <a href="<c:url value="/product-list"/>">
                <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> Товары
              </a>
            </li>

            <c:if test="${sessionScope.currentUserAdmin}">
              <li class="dropdown">
                <a href="<c:url value="/index"/>" class="dropdown-toggle" data-toggle="dropdown">Администрирование<b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li class="divider"></li>
                  <li><a href="<c:url value="/product-list-edit"/>">Список товаров</a></li>
                  <li class="divider"></li>
                  <li><a href="<c:url value="/users-list"/>">Список пользователей</a></li>
                </ul>
              </li>
            </c:if>

          </ul>

        </div>

      </div><!-- /.navbar-collapse -->

    </nav>

    <div class="container-fluid">
      <form class="navbar-form navbar-right" style="margin-top: 5px;">

        <c:if test="${not empty sessionScope.get('user')}">
          <button type="button" class="btn btn-info">
            <span class="glyphicon glyphicon-shopping-cart"></span>
            <span class="badge">0</span></button>
        </c:if>

      </form>
    </div>

  </div>


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