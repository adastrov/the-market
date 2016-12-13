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

<form name="registerForm" action="<c:url value='/add-user' />" method='POST'>
<div class="container-fluid">

    <h2>Добавить пользователя:</h2>

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
        <th>Action</th>
    </tr>
    </thead>

    <td><input type="text" class="form-control" name="username" placeholder="Логин" required autofocus value=""></td>
    <td><input type="password" class="form-control" name="password" placeholder="Пароль" required value=""></td>
    <td><input type="email" class="form-control" name="email" placeholder="E-mail" required value=""></td>

    <td>

        <select size="1" name="role">
            <option disabled>Укажите роль</option>
            <option selected value="user">Пользователь</option>
            <option value="admin">Администратор</option>
            <option value="guest">Гость</option>
        </select>

    </td>

    <td><input type="text" class="form-control" name="firstName" placeholder="Имя" required value=""></td>
    <td><input type="text" class="form-control" name="lastName" placeholder="Фамилия" required value=""></td>
    <td><input type="date" class="form-control" name="birthday" placeholder="Дата рождения" required value=""></td>

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

    <td><button class="btn btn-lg btn-primary btn-block" type="submit" value="Add">Добавить</button></td>

</tbody>

</table>

</div>

</form>

<div class="container-fluid">

    <h2>Список пользователей:</h2>

    <table class="table table-hover">

<thead>
    <tr>
        <th>id</th>
        <th>Login</th>
        <th>Email</th>
        <th>Role</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Birthday</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
</thead>

<c:forEach items="${sessionScope.users}" var="user">

    <tbody>

    <th scope="row">${user.getId()}</th>
        <td>${user.getLogin()}</td>
        <td>${user.getEmail()}</td>
        <td>${user.getRole().getName()}</td>
        <td>${user.getFirstName()}</td>
        <td>${user.getLastName()}</td>
        <td>${user.getBirthday()}</td>
        <td><a href="/user-edit?id=${user.getId()}">Изменить</a></td>
        <td><a href="/user-delete?id=${user.getId()}">Удалить</a></td>
    </tbody>

</c:forEach>


</table>

</div>

<footer>
    <p>© Pavel Padalka 2016</p>
</footer>
</body>
</html>