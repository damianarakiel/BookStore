<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Moja Strona</title>
</head>
<body>
    <form action="/book" method="POST" target="_blank">
        <br/>
        Title: <input type="text" name="title"/>
        <br/>
        ISBN: <input type="text" name="ISBN"/>
        <input type="submit" value="Post"/>
    </form>
</body>
</html>
