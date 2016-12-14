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



<form name="registerForm" action="<c:url value='/product-add' />" method='POST'>
    <div class="container-fluid">

        <h2>Добавить товар:</h2>

        <table class="table table-hover">

            <td>

                <thead>
                <tr>
                    <th>Наименование</th>
                    <th>Описание</th>
                    <th>Группы товара</th>
                    <th>Цена</th>
                    <th>Количество</th>
                    <th></th>
                </tr>
                </thead>

            <td><input type="text" class="form-control" name="title" placeholder="Наименование" required autofocus value=""></td>
            <td><input type="text" class="form-control" name="description" placeholder="Описание" required autofocus value=""></td>

            <td>

                <select size="3" name="productGroup">
                    <option disabled>Укажите группы товара</option>

                    <c:forEach items="${sessionScope.productGroups}" var="productGroup">
                        <option selected value=${productGroup.getId()}>${productGroup.getTitle()}</option>
                    </c:forEach>
                </select>

            </td>

            <td><input type="number" class="form-control" name="price" placeholder="Цена" required autofocus value=""></td>
            <td><input type="number" class="form-control" name="count" placeholder="Количество" required autofocus value=""></td>

            <td><button class="btn btn-lg btn-primary btn-block" type="submit" value="Add">Добавить</button></td>

            </tbody>

        </table>

    </div>

</form>


<div class="container-fluid">

    <h2>Список товаров:</h2>

    <table class="table table-hover">

        <thead>
        <tr>
            <th>Артикул</th>
            <th>Наименование</th>
            <th>Описание</th>
            <th>Цена</th>
            <th>Количество</th>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <c:forEach items="${sessionScope.products}" var="product">

            <tbody>

            <th scope="row">${product.getId()}</th>
            <td>${product.getTitle()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getCount()}</td>
            <td><a href="/product-edit?id=${product.getId()}">Изменить</a></td>
            <td><a href="/product-delete?id=${product.getId()}">Удалить</a></td>

            </tbody>

        </c:forEach>


    </table>

</div>

<footer>
    <p>© Pavel Padalka 2016</p>
</footer>
</body>
</html>