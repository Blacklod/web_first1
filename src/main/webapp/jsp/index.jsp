<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="<c:url value="/styles/main.css"/>">
    <body>
        <h2>Hello World!</h2>

        <%! private int x = 0; %>

        Число обращений к странице: <%= ++x %>

        <c:set var="myName" value="Alex"/>
        <h1>${myName}</h1>

        <c:set var="x" value="<%=x%>" />
        <c:if test="${x < 10}">
            <p>True<p>
        </c:if>
        <c:if test="${x >= 10}">
            <p>False<p>
        </c:if>

        <br>
            <% ((List)request.getAttribute("list")).add(new Date()); %>

        <c:set var="num" scope="session" value="10"/>
        <c:choose>
            <c:when test="${num <= 0}">
                Если num <= 0
            </c:when>
            <c:when test="${num > 1000}">
                Если num > 1000
            </c:when>
            <c:otherwise>
                Если не одно условие не есть верно.
            </c:otherwise>
        </c:choose>

        <br>

        <c:forEach var="num" items="${list}">
            <p>${num}</p>
        </c:forEach>
    </body>
</html>
