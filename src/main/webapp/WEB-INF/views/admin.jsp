<%--
  Created by IntelliJ IDEA.
  User: ura
  Date: 10.12.2019
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contentPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="autor" content="">
    <title>admin</title>
    <link href="${contentPath}/resource/css/bootstrap.min.css" rel="stylesheet">
</head>

<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="post" action="${contentPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2> Admin page ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">logout</a> </h2>
    </c:if>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11/2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>


