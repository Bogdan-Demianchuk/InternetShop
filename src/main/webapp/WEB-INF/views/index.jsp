<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Hello mate!</title>
</head>
<body>
<div class="container">
    <h1>Hello world! Now ${date}</h1>
    <p><a href="${pageContext.request.contextPath}/InjectData">Generate a test data</a></p>
    <p><a href="${pageContext.request.contextPath}/products">to all products</a></p>
    <p><a href="${pageContext.request.contextPath}/users/all">to all users</a></p>
    <p><a href="${pageContext.request.contextPath}/">to first page</a></p>
    <p><a href="${pageContext.request.contextPath}/users/registration">registration</a></p>
</div>
</body>
</html>
