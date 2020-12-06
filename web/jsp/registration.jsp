<%--
  Created by IntelliJ IDEA.
  User: trolo
  Date: 12/3/2020
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ViewController" method="get">
    Registration<br>
    <input type="hidden" name="command" value="forward">
    enter your login <br>
    <input type="text" name="login" value=""><br>
    enter your password: <br>
    <input type="password" name="password" value=""><br>
    <input type="submit" value="Отправить">
</form>
</body>
</html>
