<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>User Login</h2>

<form action="login" method="post">
    Username: <input type="text" name="username" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <input type="submit" value="Login">
</form>

<p style="color:red;">
<%= request.getAttribute("msg") == null ? "" : request.getAttribute("msg") %>
</p>

<a href="register.jsp">Go to Register</a>

</body>
</html>
