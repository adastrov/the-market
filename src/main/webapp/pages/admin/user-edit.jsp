<%@ page contentType="text/html" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">

    <title>Список товаров</title>

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

<div class="container">
    <div class="jumbotron" style="margin-top: 20px;">

        <ul>
            <li>Список пользователей
        <ol>
            <c:forEach items="${sessionScope.users}" var="user">
                <li>
                        ${user.getLogin()} ; ${user.getEmail()}} (<a href="/edit-user?id=${user.getId()}">Изменить</a>)   (<a href="/delete-user?id=${user.getId()}">Удалить</a>)
                </li>


            </c:forEach>
        </ol>
            </li>
        </ul>
    </div>
</div>

<footer>
    <p>© Pavel Padalka 2016</p>
</footer>
</body>
</html>