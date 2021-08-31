<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
<h3><spring:message code="newMonth"/></h3>
<form method="post">
    <label><spring:message code="month"/></label><br>
    <input name="month" required placeholder="<spring:message code="month"/>" type="month" max="${maxMonth}"/><br>
    <input type="submit" value="<spring:message code="create"/>" style="display: inline"/>
    <a href="year?year=${year}" style="display: inline"><spring:message code="back"/></a>
</form>
</body>
</html>
