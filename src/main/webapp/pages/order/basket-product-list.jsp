<%@ page contentType="text/html" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">

    <title>Список товаров в корзине</title>

    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/general.css" />" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

<header>
    <%@include file="/pages/templates/header-template.jsp" %>
</header>

<main>
    <div class="container-fluid">

        <h2>Товары в корзине:</h2>

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

                <td>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" value="Add">
                        <span class="glyphicon glyphicon-ok"></span>
                        Заказать
                    </button>
                </td>

                <td>
                    <button class="btn btn-lg btn-warning btn-block" type="submit" value="Remove">
                        <span class="glyphicon glyphicon-remove"></span>
                        Отменить
                    </button>
                </td>

                </tbody>

            </c:forEach>


        </table>

    </div>
</main>

<footer>
    <%@include file="/pages/templates/footer-template.jsp" %>
</footer>

</body>
</html>