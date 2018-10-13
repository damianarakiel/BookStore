<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>book</title>
</head>
<body>
<br/>
<c:out value="Tytuł ${title}"/>
<br/>
<c:out value="ISBN ${ISBN}"/>
<%--ISBN <%= request.getAttribute("ISBN") %>!--%>
</body>
</html>