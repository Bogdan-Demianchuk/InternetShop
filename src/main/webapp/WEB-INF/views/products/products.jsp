<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Products</title>
</head>
<body style="margin:70px;">
<div class="container">
    <jsp:include page="../menu.jsp"/>
    <h1>All products</h1>
<table class="table table-hover table-dark">
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
                <a href="${pageContext.request.contextPath}/products/addtocart?id=${product.productId}"><button class="btn btn-secondary">Add to shopping card</button></a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
