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
                                <li><a href="<c:url value="/content/product-list-edit"/>">Список товаров</a></li>
                                <li class="divider"></li>
                                <li><a href="<c:url value="/admin/users-list"/>">Список пользователей</a></li>
                            </ul>
                        </li>
                    </c:if>

                </ul>

                <ul class="nav navbar-nav navbar-right">

                    <c:if test="${empty doNotShowRegisterAndIncomeButtons}">
                        <c:choose>
                            <c:when test="${empty sessionScope.get('user')}">
                                <li>
                                    <a href="<c:url value="/register"/>">
                                        <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Регистрация
                                    </a>
                                </li>

                                <li>
                                    <a href="<c:url value="/login"/>">
                                        <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> Войти
                                    </a>
                                </li>
                            </c:when>

                            <c:otherwise>

                                <c:if test="${not empty sessionScope.get('user') and empty doNotShowShoppingCartIcon}">
                                    <li>
                                        <a href="<c:url value="/order/shopping-cart"/>">

                                            <span class="glyphicon glyphicon-shopping-cart"></span>
                                            <span class="badge">
                                                <c:choose>
                                                    <c:when test="${not empty sessionScope.get('amountOfProductsInShoppingCart')}">
                                                        ${sessionScope.get('amountOfProductsInShoppingCart')}
                                                    </c:when>
                                                    <c:otherwise>
                                                        0
                                                    </c:otherwise>
                                                </c:choose>
                                       </span>
                                        </a>
                                    </li>
                                </c:if>

                                <li>
                                    <a href="<c:url value="/order/shopping-cart"/>">
                                        <span class="glyphicon glyphicon-user"
                                              aria-hidden="true"></span> ${sessionScope.get('user').getLogin()}
                                    </a>
                                </li>

                                <li>
                                    <a href="<c:url value="/logout"/>">
                                        <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> Выйти
                                    </a>
                                </li>

                            </c:otherwise>
                        </c:choose>
                    </c:if>

                </ul>

            </div>

        </div>

    </nav>

</div>