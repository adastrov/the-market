<%@ page contentType="text/html" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">

    <title>Регистрация нового пользователя</title>

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

        <form name="registerForm" action="<c:url value='/register' />" method='POST'>
            <h2 class="form-sign-in-heading">Регистрация</h2>
            <input type="text" class="form-control" name="username" placeholder="Эл. адрес или номер моб. телефона"
                   required autofocus value="${sessionScope.get("username")}">
            <br>
            <input type="password" class="form-control" name="password" placeholder="Введите пароль*" required
                   value="${sessionScope.get("password")}">
            <br>
            <input type="password" class="form-control" name="passwordConfirm" placeholder="Введите пароль еще раз*"
                   required value="${sessionScope.get("passwordConfirm")}">
            <br>
            <input type="text" class="form-control" name="firstName" placeholder="Ваше имя" required
                   value="${sessionScope.get("firstName")}">
            <br>
            <input type="text" class="form-control" name="lastName" placeholder="Ваша фамилия" required
                   value="${sessionScope.get("lastName")}">
            <br>
            <input type="date" class="form-control" name="birthday" placeholder="Дата рождения" required
                   value="${sessionScope.get("birthday")}">
            <br>

            <div class="radio">
                <label>
                    <input type="radio" name="sex" id="male" value="male"
                           <c:if test="${sessionScope.get('sex') == null }">checked</c:if>
                           <c:if test="${sessionScope.get('sex') == 'male' }">checked</c:if>>
                    Мужской
                </label>
            </div>

            <div class="radio">
                <label>
                    <input type="radio" name="sex" id="female" value="female"
                           <c:if test="${sessionScope.get('sex') == 'female' }">checked</c:if>>
                    Женский
                </label>
            </div>

            <br>
            <input type="email" class="form-control" name="email" placeholder="Адрес эл. почты" required
                   value="${sessionScope.get("email")}">
            <br>

            <button class="btn btn-lg btn-primary btn-block" type="submit" value="Register">Регистрация</button>

        </form>

    </div>
</main>


<footer>
    <%@include file="/pages/templates/footer-template.jsp" %>
</footer>

</body>
</html>