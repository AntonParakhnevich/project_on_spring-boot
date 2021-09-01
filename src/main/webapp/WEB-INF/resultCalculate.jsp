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
    <a class="btn2" href="${pageContext.request.contextPath}/resultCalculate?language=en_US"><span>Eng</span></a>

    <a class="btn2" href="${pageContext.request.contextPath}/resultCalculate?language=ru_RU"><span>Rus</span></a>

</div>
<h3><spring:message code="calculationAccumulation"/></h3>
<table>
    <tr>
        <th><spring:message code="totalYears"/></th>
        <th><spring:message code="incomes"/></th>
        <th><spring:message code="costs"/></th>
        <th><spring:message code="accumulations"/></th>
    </tr>
    <tr>
        <th>${years}</th>
        <th>${income}</th>
        <th>${cost}</th>
        <th>${accumulation}</th>
    </tr>
</table>

<a href="calculate" style="display: inline"><spring:message code="back"/> </a>
</body>
</html>

