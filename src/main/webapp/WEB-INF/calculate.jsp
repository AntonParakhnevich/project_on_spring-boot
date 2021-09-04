<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Calculate</title>
    <link rel="stylesheet" type="text/css" href="../style.css">
</head>
<body>
<div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
    <a class="btn2" href="${pageContext.request.contextPath}/calculate?language=en_US"><span>Eng</span></a>

    <a class="btn2" href="${pageContext.request.contextPath}/calculate?language=ru_RU"><span>Rus</span></a>

</div>
<h3 class="text-center"><spring:message code="calculationAccumulation"/></h3>
<form class="text-center" method="post">
    <label><spring:message code="totalYears"/> </label><br>
    <input type="number" required placeholder="<spring:message code="totalYears"/> " name="years" min="1"><br>

    <label><spring:message code="incomes"/> </label><br>
    <input type="number" required placeholder="<spring:message code="incomes"/> " name="income" min="1"><br>

    <label><spring:message code="costs"/> </label><br>
    <input type="number" required placeholder="<spring:message code="costs"/> " name="cost" min="1"><br>

    <p></p>
    <input class="btn3" type="submit" value="<spring:message code="calculation"/> "/>

    <a class="btn3" href="index"><spring:message code="back"/> </a>
</form>
</body>
</html>
