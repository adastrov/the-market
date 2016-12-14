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


<form name="registerForm" action="<c:url value='/user-edit' />" method='POST'>
    <div class="container-fluid">

        <h2>Изменить данные пользователя:</h2>

        <table class="table table-hover">

            <td>

                <thead>
                <tr>
                    <th></th>
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

            <tbody>

            <td><input type="hidden"   class="form-control" name="id" value="${sessionScope.userForEditing.getId()}"></td>
            <td><input type="text"     class="form-control" name="username" placeholder="Логин" required autofocus value="${sessionScope.userForEditing.getLogin()}"></td>
            <td><input type="password" class="form-control" name="password" placeholder="Пароль" required value="${sessionScope.userForEditing.getPassword()}"></td>
            <td><input type="email"    class="form-control" name="email" placeholder="E-mail" required value="${sessionScope.userForEditing.getEmail()}"></td>

            <td>

                <select class="form-control" name="role">
                    <option disabled>Укажите роль</option>

                    <c:forEach items="${sessionScope.roles}" var="role">
                        <option <c:if test="${sessionScope.userRoleId.equals(role.getId())}"> selected </c:if> value=${role.getName()}>${role.getDescription()}</option>
                    </c:forEach>

                </select>

            </td>

            <td><input type="text" class="form-control" name="firstName" placeholder="Имя" required value="${sessionScope.userForEditing.getFirstName()}"></td>
            <td><input type="text" class="form-control" name="lastName" placeholder="Фамилия" required value="${sessionScope.userForEditing.getLastName()}"></td>
            <td><input type="date" class="form-control" name="birthday" placeholder="Дата рождения" required value=${sessionScope.userForEditing.getBirthday()}></td>

            <td>
                <div class="radio">
                    <label>
                        <input type="radio" name="sex" id="male" value="male" <c:if test="${sessionScope.userSexName.equals('MALE')}">checked</c:if>>
                        Мужской
                    </label>
                </div>

                <div class="radio">
                    <label>
                        <input type="radio" name="sex" id="female" value="female" <c:if test="${sessionScope.userSexName.equals('FEMALE')}">checked</c:if>>
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