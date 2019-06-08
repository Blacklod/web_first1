<%@ page import="java.util.List" %>
<%@ page import="com.ystu.web_first.entities.Car" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ystu.web_first.model.Model" %>
<%@ page import="com.ystu.web_first.entities.*" %>
<%@ page import="com.ystu.web_first.Main" %>
<%@ page import="com.ystu.web_first.servlets.ShopServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08.06.2019
  Time: 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выбиерите автомобиль</title>
</head>
<body>
<%! private int ig = 0;%>
<%! private int g = 0;%>
<%! private List<Long> CarOrd;%>
<%! private List<Long> CarList;%>

<% String name = (String) request.getSession().getAttribute("userName"); %>
<c:set var="myName" value="<%=name.toString()%>"/>
<h2>Пользователь: ${myName}</h2>

<%! ArrayList<Car> carsView = new ArrayList<Car>();%>
<%carsView = Model.getInstance().getCars();%>
<%g=carsView.size();%>

<h1>Список авто:</h1>
<% if (request.getAttribute("list") == null) {%>
<% request.setAttribute("list", new ArrayList());%>
<%}%>

<% for (long i=1; i<=carsView.size(); i++) {%>
<% ((List)request.getAttribute("list")).add (Model.getInstance().getCarById(i));}%>

<table>
    <col width="170" valign="top">
    <col width="100" valign="top">
    <col width="120" valign="top">
    <col width="120" valign="top">
    <col width="120" valign="top">
    <col width="100" valign="top">
    <tr>
        <th>Наименование</th>
        <th>Цвет</th>
        <th>Двигатель</th>
        <th>Тип коробки</th>
        <th>Цена</th>
        <th>Купить</th>
    </tr>
    <%for (int j1=1; j1<=carsView.size(); j1++){%>
        <tr>
            <td align="center">
                <%=Model.getInstance().getCarById(j1).getName()%>
            </td>
            <td align="center">
                <%=Model.getInstance().getCarById(j1).getColor()%>
            </td>
            <td align="center">
                <%=Model.getInstance().getCarById(j1).getEngine()%>
            </td>
            <td align="center">
                <%=Model.getInstance().getCarById(j1).getKp()%>
            </td>
            <td align="center">
                <%=Model.getInstance().getCarById(j1).getPrice()%>
            </td>
            <td align="center">
                <form id=<%=j1%> name="BuyButton" method="post" action="/shop">
                    <input id="btn" type="submit" value=<%=j1%> name="button";/>
                </form>
            </td>
        </tr>
    <%}%>
</table>

<%((List)request.getAttribute("list")).clear(); %>
<% ig=0; %>

<h1>Корзина:</h1>
<%-- if (Data.getInstance().isBuy()==true) { --%>
<%--=Data.getInstance().getOrderById(1).getCustomer_id()--%>

<% Long id = (Long) request.getSession().getAttribute("idUser"); %>

<% CarOrd = Model.getInstance().getOrderByUser(id).getCars(); %>
<table>
    <col width="170" valign="top">
    <col width="100" valign="top">
    <col width="120" valign="top">
    <col width="120" valign="top">
    <col width="120" valign="top">
    <col width="100" valign="top">
    <tr>
        <th>Наименование</th>
        <th>Цвет</th>
        <th>Двигатель</th>
        <th>Тип коробки</th>
        <th>Цена</th>
            <%for (int j=0; j<CarOrd.size(); j++){ %>
    <tr>
        <td align="center">
            <%=Model.getInstance().getCarById(CarOrd.get(j)).getName()%>
        </td>
        <td align="center">
            <%=Model.getInstance().getCarById(CarOrd.get(j)).getColor()%>
        </td>
        <td align="center">
            <%=Model.getInstance().getCarById(CarOrd.get(j)).getEngine()%>
        </td>
        <td align="center">
            <%=Model.getInstance().getCarById(CarOrd.get(j)).getKp()%>
        </td>
        <td align="center">
            <%=Model.getInstance().getCarById(CarOrd.get(j)).getPrice()%>
        </td>
    </tr>
    <% } %>
</table>
<%-- } --%>
</body>
</html>
