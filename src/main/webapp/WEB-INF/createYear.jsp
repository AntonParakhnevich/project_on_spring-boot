<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
    <a class="btn2" href="${pageContext.request.contextPath}/createYear?language=en_US"><span>Eng</span></a>
    <a class="btn2" href="${pageContext.request.contextPath}/createYear?language=ru_RU"><span>Rus</span></a>
</div>
<h3><spring:message code="newYear"/></h3>
<form method="post">
    <label><spring:message code="year"/></label><br>
    <input name="year" required placeholder="<spring:message code="year"/>" type="number" min="2000" max="${maxYear}"/><br>
    <input type="submit" value="<spring:message code="create"/>" style="display: inline"/>
    <a href="index" style="display: inline"><spring:message code="back"/></a>
</form>
</body>
</html>
