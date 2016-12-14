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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>


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


<div class="container-fluid">

    <h2>Список товаров:</h2>

    <table class="table table-hover">

        <thead>
        <tr>
            <th>Артикул</th>
            <th>Наименование</th>
            <th>Категория</th>
            <th>Описание</th>
            <th>Цена</th>
            <c:if test="${not empty sessionScope.get('user')}">
            <th></th>
            </c:if>
        </tr>
        </thead>

        <c:forEach items="${sessionScope.products}" var="product">

            <tbody>

            <th scope="row">${product.getId()}</th>
            <td>${product.getTitle()}</td>
            <td>${product.getProductGroup().getTitle()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getPrice()}</td>

            <c:if test="${not empty sessionScope.get('user')}">
                <td><button class="btn btn-lg btn-primary btn-block" type="submit" value="Add">В корзину</button></td>
            </c:if>

            </tbody>

        </c:forEach>


    </table>

</div>

<footer>
    <p>© Pavel Padalka 2016</p>
</footer>
</body>
</html>