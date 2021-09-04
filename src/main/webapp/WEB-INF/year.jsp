<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="../style.css">

</head>
<body>
<div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
    <a class="btn2" href="${pageContext.request.contextPath}/year?language=en_US&year=${year}"><span>Eng</span></a>

    <a class="btn2" href="${pageContext.request.contextPath}/year?language=ru_RU&year=${year}"><span>Rus</span></a>

</div>

<table class="resp-tab">
    <thead>
    <tr>
        <th><spring:message code="month"/></th>
        <th><spring:message code="incomes"/></th>
        <th><spring:message code="costs"/></th>
        <th><spring:message code="accumulations"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${months}" var="month">
    <tr>
        <td>
            <a class="btn-year" href="${pageContext.request.contextPath}/month?idMonth=${month.id}&year=${year}"><spring:message
                    code="${month.name}"/></a>
        </td>
        <td>${month.income.calculationTotalIncome()}</td>
        <td>${month.expenses.calculationTotalExpenses()}</td>
        <td>${month.calculationAccumulationInMonth()}</td>
        </c:forEach>
    </tr>
    </tbody>
</table>
<p></p>
<div class="text-center">
    <a class="btn3" href="createMonth?year=${year}"><spring:message code="create"/></a>
</div>



<form method="post" action='<c:url value="/backIndex"/>' style="text-align: right">
    <input type="submit" class="btn3" value="<spring:message code="back"/>">
</form>
</body>
</html>