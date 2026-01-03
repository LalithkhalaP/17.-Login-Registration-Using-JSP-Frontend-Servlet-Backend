<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>

<h2>User Registration</h2>

<form action="register" method="post">
    Username: <input type="text" name="username" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <input type="submit" value="Register">
</form>

<p style="color:green;">
<%= request.getAttribute("msg") == null ? "" : request.getAttribute("msg") %>
</p>

<a href="login.jsp">Go to Login</a>

</body>
</html>
