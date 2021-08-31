<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
    <a href="${pageContext.request.contextPath}/calculate?language=en_US">Login (English)</a>
    &nbsp;|&nbsp;
    <a href="${pageContext.request.contextPath}/calculate?language=ru_RU">Login (Rus)</a>
    &nbsp;|&nbsp;
</div>
<h3><spring:message code="calculationAccumulation"/></h3>
<form method="post">
    <label><spring:message code="totalYears"/> </label><br>
    <input type="number" required placeholder="<spring:message code="totalYears"/> " name="years" min="1"><br>

    <label><spring:message code="incomes"/> </label><br>
    <input type="number" required placeholder="<spring:message code="incomes"/> " name="income" min="1"><br>

    <label><spring:message code="costs"/> </label><br>
    <input type="number" required placeholder="<spring:message code="costs"/> " name="cost" min="1"><br>

    <input type="submit" value="<spring:message code="calculation"/> "/>

    <a href="index" style="display: inline"><spring:message code="back"/> </a>
</form>
</body>
</html>
