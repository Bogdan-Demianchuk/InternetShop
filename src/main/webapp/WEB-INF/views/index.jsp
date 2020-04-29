<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Hello mate!</title>
</head>
<body style="margin:70px;">
<div class="container">
    <div class="btn-group fixed-top" >
        <button type="button" class="btn btn-secondary" onclick="location.href='${pageContext.request.contextPath}/'">Index</button>
        <button type="button" class="btn btn-secondary" onclick="location.href='${pageContext.request.contextPath}/InjectData'">Generate data</button>
        <button type="button" class="btn btn-secondary" onclick="location.href='${pageContext.request.contextPath}/products'">All products</button>
        <button type="button" class="btn btn-secondary" onclick="location.href='${pageContext.request.contextPath}/users/all'">All users</button>
        <button type="button" class="btn btn-secondary" onclick="location.href='${pageContext.request.contextPath}/allorders'">All orders</button>
        <button type="button" class="btn btn-secondary" onclick="location.href='${pageContext.request.contextPath}/shoppingcart'">Shopping cart</button>
        <button type="button" class="btn btn-secondary" onclick="location.href='${pageContext.request.contextPath}/users/registration'">Registration</button>
    </div>
    <h1>Hello world! Now ${date}</h1>

</div>
</body>
</html>
