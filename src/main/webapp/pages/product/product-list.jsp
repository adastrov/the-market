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

<div class="container-fluid">

    <h2>Список товаров:</h2>

    <table class="table table-hover">

        <thead>
        <tr>
            <th>Артикул</th>
            <th>Наименование</th>
            <th>Описание</th>
            <th>Цена</th>
            <c:choose>
            <c:when test="${not empty sessionScope.get('user')}">
            <th></th>
            </c:when>
            </c:choose>
        </tr>
        </thead>

        <c:forEach items="${sessionScope.products}" var="product">

            <tbody>

            <th scope="row">${product.getId()}</th>
            <td>${product.getTitle()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getPrice()}</td>

            <c:choose>
            <c:when test="${not empty sessionScope.get('user')}">
                <td><button class="btn btn-lg btn-primary btn-block" type="submit" value="Add">В корзину</button></td>
            </c:when>
            </c:choose>

            </tbody>

        </c:forEach>


    </table>

</div>

<footer>
    <p>© Pavel Padalka 2016</p>
</footer>
</body>
</html>