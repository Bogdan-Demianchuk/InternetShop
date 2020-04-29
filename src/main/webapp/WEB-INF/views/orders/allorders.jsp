<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>All Orders</title>
</head>
<body>
<div class="container">
    <h1>All Orders</h1>
    <p><a href="${pageContext.request.contextPath}/InjectData">Generate a test data</a></p>
    <p><a href="${pageContext.request.contextPath}/products">to all products</a></p>
    <p><a href="${pageContext.request.contextPath}/users/all">to all users</a></p>
    <p><a href="${pageContext.request.contextPath}/">to First page</a></p>
    <table border="1">
        <tr>
            <th>Order ID</th>
            <th>Order name</th>
            <th>products in order</th>
            <th></th>
        </tr>
        <c:forEach var="order" items="${allOrders}">
            <tr>
                <td>
                    <c:out value="${order.orderId}"/>
                </td>
                <td>
                    <c:out value="${order.user.name}"/>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/vieworder?id=${order.orderId}"><button type="button">View order</button></a>

                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/shoppingcart/deleteproduct?id=${product.productId}"><button type="button">Delete order</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
