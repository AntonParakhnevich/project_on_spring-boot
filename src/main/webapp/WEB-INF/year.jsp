<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
    <a href="${pageContext.request.contextPath}/year?language=en_US&year=${year}">Login (English)</a>
    &nbsp;|&nbsp;
    <a href="${pageContext.request.contextPath}/year?language=ru_RU&year=${year}">Login (Rus)</a>
    &nbsp;|&nbsp;
</div>
<table>
    <tr>
        <th><spring:message code="month"/></th>
        <th><spring:message code="incomes"/></th>
        <th><spring:message code="costs"/></th>
        <th><spring:message code="accumulations"/></th>
    </tr>

    <c:forEach items="${months}" var="month">
    <tr>
        <th>
            <a href="${pageContext.request.contextPath}/month?idMonth=${month.id}&year=${year}"><spring:message code="${month.name}"/></a>
        </th>
        <th>${month.income.calculationTotalIncome()}</th>
        <th>${month.expenses.calculationTotalExpenses()}</th>
        <th>${month.calculationAccumulationInMonth()}</th>
        <td>
            <form method="post" action='<c:url value="/deleteMonth?idMonth=${month.id}&year=${year}" />'
                  style="display:inline;">
                <input type="hidden" name="id" value="${month.id}">
                <input type="submit" value="<spring:message code="delete"/>">
            </form>
        </td>
        </c:forEach>
    </tr>
</table>
<a href="createMonth?year=${year}"><spring:message code="create"/></a>

<form method="post" action='<c:url value="/backIndex"/>' style="display:inline;">
    <input type="submit" value="<spring:message code="back"/>">
</form>
</body>
</html>