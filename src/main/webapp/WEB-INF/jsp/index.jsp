<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Internet Shop (Homework 6)</title>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<div align="center">
    <h1>${message}</h1>

        <h2>Persons</h2>
        <a href="${pageContext.request.contextPath}api/person/create">Create new person</a><br>
        <a href="${pageContext.request.contextPath}api/person/all">View all persons</a><br>
        <a href="${pageContext.request.contextPath}api/person/get">View person by ID</a><br>
        <a href="${pageContext.request.contextPath}api/person/update">Update person</a><br>
        <a href="${pageContext.request.contextPath}api/person/delete">Delete person</a><br>

        <h2>Products</h2>
        <a href="${pageContext.request.contextPath}api/product/create">Create new product</a><br>
        <a href="${pageContext.request.contextPath}api/product/all">View all products</a><br>
<%--        <a href="${pageContext.request.contextPath}api/product/get">View product by ID</a><br>--%>
<%--        <a href="${pageContext.request.contextPath}api/product/update">Update product</a><br>--%>
<%--        <a href="${pageContext.request.contextPath}api/product/delete">Delete product</a><br>--%>

        <h2>Carts</h2>
        <a href="${pageContext.request.contextPath}api/cart/create">Create new cart</a><br>
        <a href="${pageContext.request.contextPath}api/cart/all">View all carts</a><br>
<%--        <a href="${pageContext.request.contextPath}api/cart/get">View cart by ID</a><br>--%>
<%--        <a href="${pageContext.request.contextPath}api/cart/delete">Delete cart</a><br>--%>
<%--        <a href="${pageContext.request.contextPath}api/cart/add">Add product to cart</a><br>--%>
<%--        <a href="${pageContext.request.contextPath}api/cart/remove">Remove product from cart</a><br>--%>
<%--        <a href="${pageContext.request.contextPath}api/cart/clean">Clean cart</a><br>--%>

        <h2>Shops</h2>
        <a href="${pageContext.request.contextPath}api/shop/create">Create new shop</a><br>
        <a href="${pageContext.request.contextPath}api/shop/all">View all shops</a><br>
        <a href="${pageContext.request.contextPath}api/shop/get">View shop by ID</a><br>
        <a href="${pageContext.request.contextPath}api/shop/delete">Delete shop</a><br>

</div>
</body>
</html>