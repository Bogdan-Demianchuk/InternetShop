
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Registration</title>
</head>
<body style="margin:70px;">
<div class="container">
    <jsp:include page="../${menus}"/>
<h1>Registration!</h1>
<form method="post" action="${pageContext.request.contextPath}/users/registration">
    <div class="form-group">
    Login <input class="form-control" required type="text" name="login">
    Password <input class="form-control" required type="password" name="pwd">
    Repeat your password <input class="form-control" required type="password" name="pwd-re">
    </div>
<button type="submit" <button  class="btn btn-secondary">Register</button>
    <h4 style="color:orangered">${massage}</h4>
</form>
</div>
</body>
</html>
