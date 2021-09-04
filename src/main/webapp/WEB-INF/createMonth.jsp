<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../style.css">
</head>
<body>
<h3 class="text-center"><spring:message code="newMonth"/></h3>

<form class="text-center" method="post">
    <label><spring:message code="month"/></label><br>
    <input name="month" required placeholder="<spring:message code="month"/>" type="month" max="${maxMonth}"/><br>

    <p></p>
    <input class="btn3" type="submit" value="<spring:message code="create"/>"/>
    <a class="btn3" href="year?year=${year}" ><spring:message code="back"/></a>
</form>

</body>
</html>
