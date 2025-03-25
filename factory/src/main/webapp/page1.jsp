<%@ page import="com.example.demo3.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page1</title>
</head>
<body>
<%
    HttpSession session1 = request.getSession(false);
    User user = (User) session1.getAttribute("user");
%>
<a href="logout.do">Logout</a>

<span>Welcome <%= user.getLogin() %></span>
<form action="action-un.do" method="post">
    <label for="attribut1">attribut 1</label>
    <input name="attribut1" id="attribut1" type="text">
    <label for="attribut2">attribut 2</label>
    <input name="attribut2" id="attribut2" type="text">
    <button type="submit">ok</button>
</form>

<% if (user.getAttribut1() != null && user.getAttribut2() != null) { %>
<ul>
    <li><%= user.getAttribut1() %></li>
    <li><%= user.getAttribut2() %></li>
</ul>
<%}%>
</body>
</html>
