<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Cart List</title>
</head>
<body>
<div align="center">
<a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
</div>
<h1 align="center">All carts</h1>

<div align="center">
    <table border="1">
        <tr>
            <th>Cart ID</th>
            <th>Sum</th>
            <th>Person ID</th>
        </tr>
        <c:forEach  items="${all}" var ="cart">
            <tr>
                <td>${cart.cartId}</td>
                <td>${cart.sum}</td>
                <td>${cart.person.getId()}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>