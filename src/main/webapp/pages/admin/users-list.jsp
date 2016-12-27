<%@ page contentType="text/html" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">

    <title>Список пользователей</title>

    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/general.css" />" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script>

        $(document).on("click", "#add", function () {

            $.ajax({
                method: 'post',
                type: 'post',
                url: '/admin/user-add',
                data: {
                    'username': $("#username").val(),
                    'password': $("#password").val(),
                    'email': $("#email").val(),
                    'role': $("#role").val(),
                    'firstName': $("#firstName").val(),
                    'lastName': $("#lastName").val(),
                    'birthday': $("#birthday").val(),
                    'sex': $('input:radio[name=sex]:checked').val()
                },

                success: function (response) {
                    $("#userListForm").load("/admin/users-list #userListForm", function () {
                    });
                }
            });
        });

        function userRemoveAction(user_id) {

            $.ajax({
                method: 'get',
                type: 'get',
                url: "/admin/user-delete?id=" + user_id,

                success: function (response) {
                    $("#userListForm").load("/admin/users-list #userListForm", function () {
                    });
                }
            });
        };

    </script>

</head>

<body>


<header>
    <%@include file="/pages/templates/header-template.jsp" %>
</header>

<main>
    <form>
        <div id="userAdd" class="container-fluid">

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

                <td><input id="username" type="text" class="form-control" name="username" placeholder="Логин" required
                           autofocus
                           value=""></td>
                <td><input id="password" type="password" class="form-control" name="password" placeholder="Пароль"
                           required value="">
                </td>
                <td><input id="email" type="email" class="form-control" name="email" placeholder="E-mail" required
                           value=""></td>

                <td>

                    <select id="role" class="form-control" name="role">
                        <option disabled>Укажите роль</option>

                        <c:forEach items="${roles}" var="role">
                            <option value=${role.getName()}>${role.getDescription()}</option>
                        </c:forEach>
                    </select>

                </td>

                <td><input id="firstName" type="text" class="form-control" name="firstName" placeholder="Имя" required
                           value=""></td>
                <td><input id="lastName" type="text" class="form-control" name="lastName" placeholder="Фамилия" required
                           value="">
                </td>
                <td><input id="birthday" type="date" class="form-control" name="birthday" placeholder="Дата рождения"
                           required
                           value=""></td>

                <td>
                    <div class="radio">
                        <label>
                            <input type="radio" name="sex" id="male" value="male"
                                   <c:if test="${sex == null }">checked</c:if>
                                   <c:if test="${sex == 'male' }">checked</c:if>>
                            Мужской
                        </label>
                    </div>

                    <div class="radio">
                        <label>
                            <input type="radio" name="sex" id="female" value="female"
                                   <c:if test="${sex == 'female' }">checked</c:if>>
                            Женский
                        </label>
                    </div>
                </td>

                <td>
                    <button id="add" class="btn btn-lg btn-primary btn-block" type="button" value="Add">Добавить
                    </button>
                </td>

                </tbody>

            </table>

        </div>
    </form>

    <div id="userListForm" class="container-fluid">

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

            <c:forEach items="${users}" var="user">

                <tbody>
                <th scope="row">${user.getId()}</th>
                <td>${user.getLogin()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getRole().getName()}</td>
                <td>${user.getFirstName()}</td>
                <td>${user.getLastName()}</td>
                <td>${user.getBirthday()}</td>
                <td>${user.getSex().toString()}</td>
                <td><a href="/admin/user-edit?id=${user.getId()}">Изменить</a></td>
                <td><a href="#" onclick="userRemoveAction(${user.getId()});return false;">Удалить</a></td>
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