<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Products in shopping cart ${userName}</title>
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
    <h1>All products in shopping cart ${userName}</h1>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>product ID</th>
            <th>product name</th>
            <th>product price</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach var="product" items="${allProducts}">
            <tr>
                <td>
                    <c:out value="${product.productId}"/>
                </td>
                <td>
                    <c:out value="${product.name}"/>
                </td>
                <td>
                    <c:out value="${product.price}"/>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/shoppingcart/deleteproduct?id=${product.productId}"><button class="btn btn-secondary">Delete product from cart</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/doorder"> <button type="button">Make order</button></a>
</div>
</body>
</html>
