<%@ page contentType="text/html" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">

    <title>Редактирование пользователя</title>

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
    <form name="registerForm" action="<c:url value='/admin/user-edit' />" method='POST'>
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

                    <td><input type="hidden" class="form-control" name="id"
                               value="${userForEditing.getId()}"></td>
                    <td><input type="text" class="form-control" name="username" placeholder="Логин" required autofocus
                               value="${userForEditing.getLogin()}"></td>
                    <td><input type="password" class="form-control" name="password" placeholder="Пароль" required
                               value="${userForEditing.getPassword()}"></td>
                    <td><input type="email" class="form-control" name="email" placeholder="E-mail" required
                               value="${userForEditing.getEmail()}"></td>

                    <td>

                        <select class="form-control" name="role">
                            <option disabled>Укажите роль</option>

                            <c:forEach items="${roles}" var="role">
                                <option <c:if test="${userRoleId.equals(role.getId())}"> selected </c:if>
                                        value=${role.getName()}>${role.getDescription()}</option>
                            </c:forEach>

                        </select>

                    </td>

                    <td><input type="text" class="form-control" name="firstName" placeholder="Имя" required
                               value="${userForEditing.getFirstName()}"></td>
                    <td><input type="text" class="form-control" name="lastName" placeholder="Фамилия" required
                               value="${userForEditing.getLastName()}"></td>
                    <td><input type="date" class="form-control" name="birthday" placeholder="Дата рождения" required
                               value=${userForEditing.getBirthday()}></td>

                    <td>
                        <div class="radio">
                            <label>
                                <input type="radio" name="sex" id="male" value="male"
                                       <c:if test="${userSexName.equals('MALE')}">checked</c:if>>
                                Мужской
                            </label>
                        </div>

                        <div class="radio">
                            <label>
                                <input type="radio" name="sex" id="female" value="female"
                                       <c:if test="${userSexName.equals('FEMALE')}">checked</c:if>>
                                Женский
                            </label>
                        </div>
                    </td>

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