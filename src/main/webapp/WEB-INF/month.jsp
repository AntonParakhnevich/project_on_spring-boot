<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../style.css">
</head>
<body>
<div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
    <a class="btn2" href="${pageContext.request.contextPath}/month?idMonth=${idMonth}&year=${year}&language=en_US"><span>Eng</span></a>

    <a class="btn2" href="${pageContext.request.contextPath}/month?idMonth=${idMonth}&year=${year}&language=ru_RU"><span>Rus</span></a>

</div>
<h1 class="text-center"><spring:message code="incomes"/></h1>


<table class="resp-tab">
    <thead>
    <tr>
        <th><spring:message code="category"/></th>
        <th><spring:message code="amount"/></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categoriesIncome}" var="category">
    <tr>
        <td>${category.name}</td>
        <td>${category.value}</td>
        <td>
            <form method="post"
                  action='<c:url value="/deleteIncome?idMonth=${idMonth}&year=${year}" />'
                  style="display:inline;">
                <input type="hidden" name="idIncome" value="${category.id}">
                <input class="btn" type="submit" value="<spring:message code="delete"/>">
            </form>
        </td>
    </tr>
    </tbody>
    </c:forEach>
</table>

<h1></h1>
<div  style="text-align:center">
    <a class="btn3" href="createIncome?idMonth=${idMonth}&year=${year}"><spring:message code="create"/></a>
</div>


<h1 class="text-center"><spring:message code="costs"/></h1>


<table class="resp-tab">
    <thead>
    <tr>
        <th><spring:message code="category"/></th>
        <th><spring:message code="amount"/></th>
        <th><spring:message code="binding"/></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categoriesCost}" var="category">
    <tr>
        <td>${category.name}</td>
        <td>${category.price}</td>
        <td>${category.binding}</td>
        <td>
            <form method="post"
                  action='<c:url value="/deleteCost?idMonth=${idMonth}&year=${year}" />'
                  style="display:inline;">
                <input type="hidden" name="idCost" value="${category.id}">
                <input class="btn" type="submit" value="<spring:message code="delete"/>">
            </form>
        </td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<h1></h1>
<div  style="text-align:center">
    <a class="btn3" href="createCost?idMonth=${idMonth}&year=${year}"><spring:message code="create"/></a>
</div>

</body>


<form method="post" action='<c:url value="/backYear?year=${year}"/>' style="text-align: right" >
    <input type="submit" class="btn3" value="<fmt:message key="back"/>">
</form>
</html>
