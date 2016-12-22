<%@ page contentType="text/html" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">

    <title>Список товаров</title>

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

            <c:forEach items="${products}" var="product">

                <tbody>

                <th scope="row">${product.getId()}</th>
                <td>${product.getTitle()}</td>
                <td>${product.getProductGroup().getTitle()}</td>
                <td>${product.getDescription()}</td>
                <td>${product.getPrice()}</td>

                <c:if test="${not empty sessionScope.get('user')}">
                    <td>
                        <form style="margin-top: 5px;" action="<c:url value='/product-list' />" method='POST'>
                            <button class="btn btn-lg btn-primary btn-block" name="id" type="submit" value="${product.getId()}">В корзину</button>
                        </form>
                    </td>
                </c:if>

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