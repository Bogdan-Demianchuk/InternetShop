
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Registration</title>
</head>
<body>
<div class="container">
<h1>Registration!</h1>
<p><a href="${pageContext.request.contextPath}/InjectData">Generate a test data</a></p>
<p><a href="${pageContext.request.contextPath}/products">to all products</a></p>
<p><a href="${pageContext.request.contextPath}/users/all">to all users</a></p>
<p><a href="${pageContext.request.contextPath}/">to First page</a></p>
<form method="post" action="${pageContext.request.contextPath}/users/registration">
    Login <input required type="text" name="login">
    Password <input required type="password" name="pwd">
    Repeat your password <input required type="password" name="pwd-re">
<button type="submit">Register</button>
    <h4 style="color:orangered">${massage}</h4>
</form>
</div>
</body>
</html>
