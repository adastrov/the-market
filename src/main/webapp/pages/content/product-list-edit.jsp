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

<header>
    <%@include file="/pages/templates/header-template.jsp" %>
</header>

<main>
    <form name="registerForm" action="<c:url value='/product-edit' />" method='POST'>
        <div class="container-fluid">

            <h2>Изменить товар:</h2>

            <table class="table table-hover">

                <td>

                    <thead>
                    <tr>
                        <th></th>
                        <th>Наименование</th>
                        <th>Категория</th>
                        <th>Описание</th>
                        <th>Цена</th>
                        <th>Количество</th>
                        <th></th>
                    </tr>
                    </thead>

                    <tbody>
                    <td><input type="hidden" class="form-control" name="id"
                               value="${sessionScope.productForEditing.getId()}"></td>
                    <td><input type="text" class="form-control" name="title" placeholder="Наименование" required
                               autofocus value="${sessionScope.productForEditing.getTitle()}"></td>

                    <td>

                        <select class="form-control" name="productGroup">
                            <option disabled>Укажите группы товара</option>

                            <c:forEach items="${sessionScope.productGroups}" var="productGroup">
                                <option <c:if
                                        test="${sessionScope.productGroupId.equals(productGroup.getId())}"> selected </c:if>
                                        value=${productGroup.getId()}>${productGroup.getTitle()}</option>
                            </c:forEach>

                        </select>

                    </td>

                    <td><input type="text" class="form-control" name="description" placeholder="Описание" required
                               autofocus value="${sessionScope.productForEditing.getTitle()}"></td>

                    <td><input type="number" class="form-control" name="price" placeholder="Цена" required autofocus
                               value="${sessionScope.productForEditing.getPrice()}"></td>
                    <td><input type="number" class="form-control" name="count" placeholder="Количество" required
                               autofocus value="${sessionScope.productForEditing.getCount()}"></td>

                    <td>
                        <button class="btn btn-lg btn-primary btn-block" type="submit" value="Add">Изменить</button>
                    </td>

                    </tbody>

            </table>

        </div>

    </form>
</main>

<footer>
    <%@include file="/pages/templates/footer-template.jsp" %>
</footer>

</body>
</html>