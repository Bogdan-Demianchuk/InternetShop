<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Order by ${userName}</title>
</head>
<body style="margin:70px;">
<div class="container">
    <jsp:include page="../menu.jsp"/>
    <h1>Order</h1>
    <h2>Thank ${userName} for your order it number №${orderId} don't forget it</h2>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>product ID</th>
            <th>product name</th>
            <th>product price</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach var="product" items="${allProductsInOrder}">
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
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
