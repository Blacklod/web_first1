<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07.06.2019
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователи</title>
</head>
<body>
<ul>
    <%
        List<String> names = (List<String>) request.getAttribute("userNames");

        if (names != null && !names.isEmpty()) {
            out.println("<ui>");
            for (String s : names) {
                out.println("<li>" + s + "</li>");
            }
            out.println("</ui>");
        } else out.println("<p>There are no users yet!</p>");
    %>
</ul>
</body>
</html>
