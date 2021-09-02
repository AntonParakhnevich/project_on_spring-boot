<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Start</title>
    <link rel="stylesheet" type="text/css" href="../style.css">
</head>
<body>

<div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
    <a class="btn2" href="${pageContext.request.contextPath}/start?language=en_US"><span>Eng</span></a>
    <a class="btn2" href="${pageContext.request.contextPath}/start?language=ru_RU"><span>Rus</span></a>
</div>

<form action="${pageContext.request.contextPath}/checkUser" method="post" class="text-centre">

    <div class="container">
        <form method="post" action="">

        <label><b><fmt:message key="login"/></b></label>
        <input type="text" required placeholder="<spring:message code="login"/>" id="login" name="username"><br>

        <label><b><fmt:message key="password"/></b></label>
        <input type="password" required placeholder="<spring:message code="password"/>" name="password"><br>

        <input class="button" type="submit" value="<spring:message code="loginInSystem"/>">
        </form>
        <form method="get" action='<c:url value="registration"/>' style="display:inline;">
            <input class="button" type="submit" value="<fmt:message key="registration"/>">
        </form>
    </div>




</form>

</body>
</html>
