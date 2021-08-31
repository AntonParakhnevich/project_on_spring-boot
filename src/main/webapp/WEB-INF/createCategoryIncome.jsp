<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
    <a href="${pageContext.request.contextPath}/createIncome?language=en_US">Login (English)</a>
    &nbsp;|&nbsp;
    <a href="${pageContext.request.contextPath}/createIncome?language=ru_RU">Login (Rus)</a>
    &nbsp;|&nbsp;
</div>
<h3><spring:message code="newCategoryIncome"/></h3>
<form method="post">
    <label><spring:message code="name"/></label><br>
    <input required placeholder="<spring:message code="name"/>" name="name" type="text"/><br>
    <label><spring:message code="amount"/></label><br>
    <input required placeholder="<spring:message code="amount"/>" name="amount" type="number" min="1"/><br>
    <input type="submit" value="<spring:message code="create"/>" style="display: inline"/>
</form>
</body>
</html>
