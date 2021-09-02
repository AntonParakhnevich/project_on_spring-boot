<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="../style.css">

</head>
<body>
<div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
    <a class="btn2" href="${pageContext.request.contextPath}/index?language=en_US"><span>Eng</span></a>

    <a class="btn2" href="${pageContext.request.contextPath}/index?language=ru_RU"><span>Rus</span></a>
    <a class="btn2" href="${pageContext.request.contextPath}/logout"><span><spring:message code="logout"/></span></a>

</div>

<p><spring:message code="login"/>: ${family.login}</p>
<p><spring:message code="accumulations"/>: ${totalAccumulation}</p>
<p><spring:message code="years"/>:</p>
<c:forEach items="${years}" var="year">
    <tr>
        <th>
            <a href="${pageContext.request.contextPath}/year?year=${year.id}">${year.year}</a>
        </th>
    </tr>
</c:forEach>

<c:if test="${roles.contains('admin')}">
    <a href="${pageContext.request.contextPath}/allFamily">All family</a>
</c:if>

<p>
    <a href="createYear"><spring:message code="create"/></a>
    <a href="calculate"><spring:message code="calculation"/></a>
</p>
</body>
