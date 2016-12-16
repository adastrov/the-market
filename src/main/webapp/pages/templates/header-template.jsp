<c:if test="${not empty error}">
    <div class="alert alert-danger">
        <strong>${error}</strong>
    </div>
</c:if>
<c:if test="${not empty msg}">
    <div class="alert alert-info">
        <strong>${msg}</strong>
    </div>
</c:if>

<div class="navbar">

    <nav class="navbar navbar-default" role="navigation">

        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
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
                            <a href="<c:url value="/index"/>" class="dropdown-toggle" data-toggle="dropdown">Администрирование<b
                                    class="caret"></b></a>
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

                    <c:if test="${empty doNotShowRegisterAndIncomeButtons}">
                        <c:choose>
                            <c:when test="${empty sessionScope.get('user')}">
                                <a class="btn btn-primary regis" href="<c:url value="/register" />" role="button">Регистрация</a>
                                <a class="btn btn-success" href="<c:url value="/login" />" role="button">Войти</a>
                            </c:when>

                            <c:otherwise>
                                <div>
                                <span class="userName">Ваш логин: <span
                                        class="boldText"> "${sessionScope.get('user').getLogin()}" </span></span>
                                    <a class="btn btn-danger pull-right" href="<c:url value="/logout" />" role="button">Выйти</a>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:if>

                </form>

            </div>

        </div><!-- /.navbar-collapse -->

    </nav>

    <c:if test="${not empty sessionScope.get('user') and empty doNotShowBasketIcon}">
        <div class="container-fluid">
            <form style="margin-top: 5px;" action="<c:url value='/added-product-list' />" method='GET'>

                <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-shopping-cart"></span>
                    <span class="badge">
                        <c:choose>
                            <c:when test="${not empty sessionScope.get('countOfProductsInBasket')}">
                                ${sessionScope.get('countOfProductsInBasket')}
                            </c:when>
                            <c:otherwise>
                                0
                            </c:otherwise>
                        </c:choose>
                    </span></button>

            </form>
        </div>
    </c:if>

</div>