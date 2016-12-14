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

<form name="registerForm" action="<c:url value='/user-edit' />" method='POST'>
    <div class="container-fluid">

        <h2>Изменить данные пользователя:</h2>

        <table class="table table-hover">

            <td>

                <thead>
                <tr>
                    <th>Login</th>
                    <th>Pass</th>
                    <th>Email</th>
                    <th>Role</th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Birthday</th>
                    <th>Sex</th>
                    <th></th>
                </tr>
                </thead>

            <td><input type="hidden"   class="form-control" name="id" value="${sessionScope.userForEditing.getId()}"></td>
            <td><input type="text"     class="form-control" name="username" placeholder="Логин" required autofocus value="${sessionScope.userForEditing.getLogin()}"></td>
            <td><input type="password" class="form-control" name="password" placeholder="Пароль" required value="${sessionScope.userForEditing.getPassword()}"></td>
            <td><input type="email"    class="form-control" name="email" placeholder="E-mail" required value="${sessionScope.userForEditing.getEmail()}"></td>

            <td>

                <select size="1" name="role">
                    <option disabled>Укажите роль</option>

                    <c:forEach items="${sessionScope.roles}" var="role">
                        <option selected value=${role.getName()}>${role.getDescription()}</option>
                    </c:forEach>
                </select>

            </td>

            <td><input type="text" class="form-control" name="firstName" placeholder="Имя" required value="${sessionScope.userForEditing.getFirstName()}"></td>
            <td><input type="text" class="form-control" name="lastName" placeholder="Фамилия" required value="${sessionScope.userForEditing.getLastName()}"></td>
            <td><input type="date" class="form-control" name="birthday" placeholder="Дата рождения" required value=${sessionScope.userForEditing.getBirthday()}></td>

            <td>
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
            </td>

            <td><button class="btn btn-lg btn-primary btn-block" type="submit" value="Add">Изменить</button></td>

            </tbody>

        </table>

    </div>

</form>

<footer>
    <p>© Pavel Padalka 2016</p>
</footer>

</body>
</html>