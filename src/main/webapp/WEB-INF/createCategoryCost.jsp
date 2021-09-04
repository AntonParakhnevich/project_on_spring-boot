<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Create category cost</title>
    <link rel="stylesheet" type="text/css" href="../style.css">
</head>
<body>
<div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
    <a class="btn2" href="${pageContext.request.contextPath}/createCost?idMonth=${idMonth}&year=${year}&language=en_US"><span>Eng</span></a>

    <a class="btn2" href="${pageContext.request.contextPath}/createCost?idMonth=${idMonth}&year=${year}&language=ru_RU"><span>Rus</span></a>

</div>

<h3 class="text-center"><spring:message code="newCategoryCost"/></h3>
<form class="text-center" method="post">

    <label><spring:message code="name"/></label><br>
    <input required placeholder="<spring:message code="name"/>" name="name"/><br>
    <label><spring:message code="amount"/></label><br>
    <input required placeholder="<spring:message code="amount"/>" name="amount" type="number" min="1"/><br>
    <label><spring:message code="binding"/></label><br>
    <input required placeholder="<spring:message code="binding"/>" name="binding" type="number" min="1" max="5"/><br>
<%--    <input type="submit" value="<spring:message code="create"/>"/>--%>

    <p></p>
    <input class="btn3" type="submit" value="<spring:message code="create"/> "/>
</form>
</body>
</html>

