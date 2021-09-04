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
<h3 class="text-center"><spring:message code="calculationAccumulation"/></h3>
<table class="resp-tab">
    <thead>
    <tr>
        <th><spring:message code="totalYears"/></th>
        <th><spring:message code="incomes"/></th>
        <th><spring:message code="costs"/></th>
        <th><spring:message code="accumulations"/></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${years}</td>
        <td>${income}</td>
        <td>${cost}</td>
        <td>${accumulation}</td>
    </tr>
    </tbody>
</table>
<p></p>
<div class="text-center">
    <a class="btn3" href="calculate"><spring:message code="back"/> </a>
</div>

</body>
</html>

