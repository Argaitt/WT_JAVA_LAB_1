<%--
  Created by IntelliJ IDEA.
  User: trolo
  Date: 11/25/2020
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <form action="ViewController" method="get">
    <input type="hidden" name="command" value="forward">
    enter login <br>
    <input type="text" name="login" value=""><br>
    enter password: <br>
    <input type="password" name="password" value=""><br>
    <input type="submit" value="Отправить">
    or<br>
  </form>
  <form action="ForwardRegistrationController" method="post">
    <input type="submit" value="Регистрация">
  </form>
</html>
