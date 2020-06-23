<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon" href="https://s.ytimg.com/yts/img/favicon-vfl8qSV2F.ico" type="image/x-icon">
    <style>
        body {
            background: url("https://images.unsplash.com/photo-1592232610506-9426553027d8?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80") no-repeat;
            background-size: cover;
            color: #fff;
        }
    </style>
</head>
<body>
<div class="btn-group fixed-top">
    <button type="button" class="btn btn-secondary" onclick="location.href='${pageContext.request.contextPath}/'">
        Index
    </button>
    <button type="button" class="btn btn-secondary"
            onclick="location.href='${pageContext.request.contextPath}/inject-data'">Generate data
    </button>
    <button type="button" class="btn btn-secondary"
            onclick="location.href='${pageContext.request.contextPath}/products'">View products
    </button>
    <button type="button" class="btn btn-secondary"
            onclick="location.href='${pageContext.request.contextPath}/products/add'">Edit products
    </button>
    <button type="button" class="btn btn-secondary"
            onclick="location.href='${pageContext.request.contextPath}/users'">All users
    </button>
    <button type="button" class="btn btn-secondary"
            onclick="location.href='${pageContext.request.contextPath}/orders'">All orders
    </button>
    <button type="button" class="btn btn-secondary"
            onclick="location.href='${pageContext.request.contextPath}/shoppingcart'">Shopping cart
    </button>
    <button type="button" class="btn btn-secondary"
            onclick="location.href='${pageContext.request.contextPath}/users/registration'">Registration
    </button>
    <button type="button" class="btn btn-secondary"
            onclick="location.href='${pageContext.request.contextPath}/login'">Login
    </button>
    <button type="button" class="btn btn-secondary"
            onclick="location.href='${pageContext.request.contextPath}/logout'">Logout
    </button>
</div>
<p></p>
</body>
</html>
