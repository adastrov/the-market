<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h1>HTTP Status 403 - Access is denied</h1>

<c:choose>
  <c:when test="${empty username}">
    <h2>У Вас нет прав просматривать эту страницу!</h2>
  </c:when>
  <c:otherwise>
    <h2>${username} <br/>У Вас нет прав просматривать эту страницу!</h2>
  </c:otherwise>
</c:choose>

</body>
</html>