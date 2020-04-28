<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Products</title>
</head>
<body>
<div class="container">
<h1>All products</h1>
<p><a href="${pageContext.request.contextPath}/InjectData">Generate a test data</a></p>
<p><a href="${pageContext.request.contextPath}/products">to all products</a></p>
<p><a href="${pageContext.request.contextPath}/users/all">to all users</a></p>
<p><a href="${pageContext.request.contextPath}/">to First page</a></p>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Product name</th>
        <th>Price</th>
    </tr>
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
                <a href="${pageContext.request.contextPath}/products/addtocard?id=${product.productId}">Add to shopping card</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/deleteProduct?id=${product.productId}">Delete from shop</a>
            </td>
        </tr>
    </c:forEach>
</table>
<button><a href="${pageContext.request.contextPath}/products/add">Add new product</a></button>
</div>
</body>
</html>
