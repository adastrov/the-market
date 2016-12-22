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
    <form name="registerForm" action="<c:url value='/content/product-add' />" method='POST'>
        <div class="container-fluid">

            <h2>Добавить товар:</h2>

            <table class="table table-hover">

                <td>

                    <thead>
                    <tr>
                        <th>Наименование</th>
                        <th>Категория</th>
                        <th>Описание</th>
                        <th>Цена</th>
                        <th>Количество</th>
                        <th></th>
                    </tr>
                    </thead>

                <td><input type="text" class="form-control" name="title" placeholder="Наименование" required autofocus
                           value=""></td>

                <td>

                    <select class="form-control" name="productGroup">
                        <option disabled>Укажите группы товара</option>

                        <c:forEach items="${productGroups}" var="productGroup">
                            <option value=${productGroup.getId()}>${productGroup.getTitle()}</option>
                        </c:forEach>
                    </select>

                </td>

                <td><input type="text" class="form-control" name="description" placeholder="Описание" required autofocus
                           value=""></td>

                <td><input type="number" class="form-control" name="price" placeholder="Цена" required autofocus
                           value=""></td>
                <td><input type="number" class="form-control" name="count" placeholder="Количество" required autofocus
                           value=""></td>

                <td>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" value="Add">Добавить</button>
                </td>

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
                <th>Категория</th>
                <th>Описание</th>
                <th>Цена</th>
                <th>Количество</th>
                <th></th>
                <th></th>
            </tr>
            </thead>

            <c:forEach items="${products}" var="product">

                <tbody>

                <th scope="row">${product.getId()}</th>
                <td>${product.getTitle()}</td>
                <td>${product.getProductGroup().getTitle()}</td>
                <td>${product.getDescription()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getCount()}</td>
                <td><a href="/content/product-edit?id=${product.getId()}">Изменить</a></td>
                <td><a href="/content/product-delete?id=${product.getId()}">Удалить</a></td>

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