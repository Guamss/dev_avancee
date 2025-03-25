<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form method="post" action="login.do">
    <label for="login">login</label>
    <input name="login" id="login" type="text">
    <label for="password">password</label>
    <input name="password" id="password" type="password">
    <button type="submit">Se connecter</button>
</form>

</body>
</html>