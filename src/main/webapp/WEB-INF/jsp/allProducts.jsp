<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Product List</title>
</head>
<body>
<div align="center">
<a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
</div>
<h1 align="center">All products</h1>

<div align="center">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Shop ID</th>
        </tr>
        <c:forEach  items="${all}" var ="product">
            <tr>
                <td>${product.productId}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.shop.getId()}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>