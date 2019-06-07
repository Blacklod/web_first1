<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ystu.web_first.entities.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ystu.web_first.servlets.HelloServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
    <meta charset="utf-8" />

    <body>
    <%! private int ig = 0;%>
    <h2>Авторизация</h2>
    <form id=<%=ig%> name="LoginShop" method="get">
        <p>Логин:<input type="text" name="login" /></p>
        <p>Пароль:<input type="password" name="pass" /></p>
        <p><input type="submit" name="submit" value="Вход" /></p>
    </form>

    <br>
    <% if (request.getAttribute("msgAut") != null) {%>
    <% String messageAut = (String) request.getAttribute("msgAut"); %>
    <c:set var="msgAutView" value="<%=messageAut.toString()%>"/>
    <h3>${msgAutView}</h3>
    <%}%>
    <br>

    <div>       <!-- content -->
        <div>    <!-- buttons holder -->
            <button onclick="location.href='/list'">Список пользователей</button>
            <button onclick="location.href='/add'">Регистрация</button>
        </div>
    </div>
    </body>
</html>
