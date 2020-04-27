
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Registration!</h1>
<form method="post" action="${pageContext.request.contextPath}/registration">
    Login <input type="text" name="login">
    Pasword <input type="password" name="pwd">
    Repeat your pasword <input type="password" name="pwd-re">
<button type="submit">Register</button>
    <h4 style="color:orangered">${massage}</h4>
</form>
</body>
</html>
