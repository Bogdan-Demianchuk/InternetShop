<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Products</title>
</head>
<body style="margin:70px;">
<div class="container">
    <jsp:include page="../${menus}"/>
    <h1>All cards</h1>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID shopping carts</th>
            <th>User name</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach var="shoppingCart" items="${allShoppingCarts}">
            <tr>
                <td>
                    <c:out value="${shoppingCart.shoppingCartId}"/>
                </td>
                <td>
                    <c:out value="${shoppingCart.userId}"/>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/shoppingcart/getproducts?id=${shoppingCart.userId}"><button class="btn btn-secondary">Products in shopping cart</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
