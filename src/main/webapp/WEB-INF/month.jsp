<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<h1><spring:message code="incomes"/></h1>
<table>
    <tr>
        <th><spring:message code="category"/></th>
        <th><spring:message code="amount"/></th>
    </tr>
    <c:forEach items="${categoriesIncome}" var="category">
    <tr>
        <th>${category.name}</th>
        <th>${category.value}</th>
        <td>
            <form method="post"
                  action='<c:url value="/deleteIncome?idMonth=${idMonth}&year=${year}" />'
                  style="display:inline;">
                <input type="hidden" name="idIncome" value="${category.id}">
                <input type="submit" value="<spring:message code="delete"/>">
            </form>
        </td>
        </c:forEach>
    </tr>

    <a href="createIncome?idMonth=${idMonth}&year=${year}"><spring:message code="create"/></a>
</table>
<h1><spring:message code="costs"/></h1>
<table>
    <tr>
        <th><spring:message code="category"/></th>
        <th><spring:message code="amount"/></th>
        <th><spring:message code="binding"/></th>
    </tr>
    <c:forEach items="${categoriesCost}" var="category">
    <tr>
        <th>${category.name}</th>
        <th>${category.price}</th>
        <th>${category.binding}</th>
        <td>
            <form method="post"
                  action='<c:url value="/deleteCost?idMonth=${idMonth}&year=${year}" />'
                  style="display:inline;">
                <input type="hidden" name="idCost" value="${category.id}">
                <input type="submit" value="<spring:message code="delete"/>">
            </form>
        </td>
        </c:forEach>
    </tr>
    <a href="createCost?idMonth=${idMonth}&year=${year}"><spring:message code="create"/></a>

</table>
</body>
<form method="post" action='<c:url value="/backYear?year=${year}"/>' style="display:inline;">
    <input type="submit" value="<spring:message code="back"/>">
</form>
</html>
