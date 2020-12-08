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
  <fieldset>
  <form action="AutorizationController" method="get">
    <input type="hidden" name="command" value="forward">
    enter login <br>
    <input type="text" name="login" value=""><br>
    enter password: <br>
    <input type="password" name="password" value=""><br>
    <input type="submit" value="Авторизация">
  </form>
  </fieldset>
  <br>
  <fieldset>
  <form action="RegistrationController" method="get">
    enter login <br>
    <input type="text" name="login" value=""><br>
    enter password: <br>
    <input type="password" name="password" value=""><br>
    <input type="submit" value="Регистрация">
  </form>
  </fieldset>
</html>
