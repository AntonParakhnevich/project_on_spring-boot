<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="language"
       value="${sessionScope.language}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="translations"/>
<html>
<body>
<div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
    <a href="${pageContext.request.contextPath}/registration?language=en_US">Login (English)</a>
    &nbsp;|&nbsp;
    <a href="${pageContext.request.contextPath}/registration?language=ru_RU">Login (Rus)</a>
    &nbsp;|&nbsp;
</div>
<h3><spring:message code="registration"/></h3>
<form method="post">
    <label><spring:message code="login"/></label><br>
    <input type="text" required placeholder="<spring:message code="login"/>" name="login"><br>

    <label><fmt:message key="password"/></label><br>
    <input type="text" required placeholder="<spring:message code="password"/>" name="password"><br>

    <input type="submit" value="<spring:message code="registration"/>"/>

    <a href="start" style="display: inline"><spring:message code="back"/></a>
</form>
</body>
</html>
