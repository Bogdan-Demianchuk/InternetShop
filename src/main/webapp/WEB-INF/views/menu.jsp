<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <div class="btn-group fixed-top">
        <button type="button" class="btn btn-secondary" onclick="location.href='${pageContext.request.contextPath}/'">
            Index
        </button>
        <button type="button" class="btn btn-secondary"
                onclick="location.href='${pageContext.request.contextPath}/InjectData'">Generate data
        </button>
        <button type="button" class="btn btn-secondary"
                onclick="location.href='${pageContext.request.contextPath}/products'">All products
        </button>
        <button type="button" class="btn btn-secondary"
                onclick="location.href='${pageContext.request.contextPath}/users/all'">All users
        </button>
        <button type="button" class="btn btn-secondary"
                onclick="location.href='${pageContext.request.contextPath}/allorders'">All orders
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
</div>
<p></p>
</body>
</html>
