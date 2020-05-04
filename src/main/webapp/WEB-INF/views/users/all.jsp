<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>All users</title>
</head>
<body style="margin:70px;">
<div class="container">
    <jsp:include page="../menu.jsp"/>
    <h1>All users</h1>
    <table class="table table-hover">
        <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
        </thead>
    <c:forEach var="user" items="${allUsers}">
        <tr>
            <td>
                <c:out value="${user.userId}"/>
            </td>
            <td>
                <c:out value="${user.name}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/deleteUser?id=${user.userId}"><button class="btn btn-secondary">Delete</button></a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
