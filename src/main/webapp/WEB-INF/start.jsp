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
        <form method="post">

            <label><b><fmt:message key="login"/></b></label>
            <input type="text" required placeholder="<spring:message code="login"/>" id="login" name="username"><br>

            <label><b><fmt:message key="password"/></b></label>
            <input type="password" required placeholder="<spring:message code="password"/>" name="password"><br>

            <c:if test="${param.error != null}">
                <label><b><fmt:message key="loginErrorMessage"/></b></label><br>
            </c:if>
            <input class="btn4" type="submit" value="<spring:message code="loginInSystem"/>">
        </form>

        <a class="btn4" href="registration"><spring:message code="registration"/></a>
    </div>
</form>
</body>
</html>
