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

          <form class="navbar-form navbar-right">

            <c:choose>
              <c:when test="${empty sessionScope.get('user')}">
                  <div>
                    <a class="btn btn-success" href="<c:url value="/login" />" role="button">Войти</a>
                  </div>
              </c:when>
              <c:otherwise>
                <div>
                  <span class="userName">Ваш логин: <span class="boldText"> "${sessionScope.get('user').getLogin()}" </span></span>
                  <a class="btn btn-danger pull-right" href="<c:url value="/logout" />" role="button">Выйти</a>
                </div>
              </c:otherwise>
            </c:choose>

          </form>

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