<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07.06.2019
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<div>
    <%
        if (request.getAttribute("userName") != null) {
            out.println("<p>Пользователь '" + request.getAttribute("userName") + "' добавлен!</p>");
        }
    %>
    <div>
        <form method="post">
            <label>Логин:
                <input type="text" name="name"><br />
            </label>
            <label>Пароль:
                <input type="password" name="pass"><br />
            </label>
            <button type="submit">Принять</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/hello'">Вернуться</button>
</div>
</body>
</html>
