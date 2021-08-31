
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:forEach items="${AllFamily}" var="family">
    <tr>
        <th>
            ${family.login}
        </th>
    </tr>
</c:forEach>
</body>
</html>
