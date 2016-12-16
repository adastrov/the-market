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
    <form name="registerForm" action="<c:url value='/admin/user-add' />" method='POST'>
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
                        <th></th>
                    </tr>
                    </thead>

                <td><input type="text" class="form-control" name="username" placeholder="Логин" required autofocus
                           value=""></td>
                <td><input type="password" class="form-control" name="password" placeholder="Пароль" required value="">
                </td>
                <td><input type="email" class="form-control" name="email" placeholder="E-mail" required value=""></td>

                <td>

                    <select class="form-control" name="role">
                        <option disabled>Укажите роль</option>

                        <c:forEach items="${sessionScope.roles}" var="role">
                            <option value=${role.getName()}>${role.getDescription()}</option>
                        </c:forEach>
                    </select>

                </td>

                <td><input type="text" class="form-control" name="firstName" placeholder="Имя" required value=""></td>
                <td><input type="text" class="form-control" name="lastName" placeholder="Фамилия" required value="">
                </td>
                <td><input type="date" class="form-control" name="birthday" placeholder="Дата рождения" required
                           value=""></td>

                <td>
                    <div class="radio">
                        <label>
                            <input type="radio" name="sex" id="male" value="male"
                                   <c:if test="${sessionScope.get('sex') == null }">checked</c:if>
                                   <c:if test="${sessionScope.get('sex') == 'male' }">checked</c:if>>
                            Мужской
                        </label>
                    </div>

                    <div class="radio">
                        <label>
                            <input type="radio" name="sex" id="female" value="female"
                                   <c:if test="${sessionScope.get('sex') == 'female' }">checked</c:if>>
                            Женский
                        </label>
                    </div>
                </td>

                <td>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" value="Add">Добавить</button>
                </td>

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
                <th>Sex</th>
                <th></th>
                <th></th>
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
                <td>${user.getSex().toString()}</td>
                <td><a href="/user-edit?id=${user.getId()}">Изменить</a></td>
                <td><a href="/user-delete?id=${user.getId()}">Удалить</a></td>
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