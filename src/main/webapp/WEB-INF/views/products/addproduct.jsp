<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Title</title>
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
    <h3>Add product</h3>
    <form method="post" action="${pageContext.request.contextPath}/products/add">
        <div class="form-group">
        Name <input class="form-control" required type="text" name="name">
        Prise <input class="form-control" required type="text" name="price">
        </div>
        <a href="${pageContext.request.contextPath}/products"><button class="btn btn-primary" type="submit" >Add product</button></a>
    </form>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Product name</th>
            <th>Price</th>
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
                    <a href="${pageContext.request.contextPath}/deleteProduct?id=${product.productId}"><button class="btn btn-secondary">Delete from shop</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
