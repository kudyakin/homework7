<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Creating new shop success</title>
    <style type="text/css">
        span {
            display: inline-block;
            width: 200px;
            text-align: left;
        }
    </style>
</head>
<body>
<div align="center">
    <a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
</div>
<div align="center">
    <h2>Creating new shop success</h2>
    <span>Name:</span><span>${shop.name}</span><br/>
    <span>Address:</span><span>${shop.address}</span><br/>
    <a href="${pageContext.request.contextPath}api/shop/create">Create new shop</a><br>
    <a href="${pageContext.request.contextPath}api/shop/all">View all shops</a><br>
    <a href="${pageContext.request.contextPath}api/shop/get">View shop by ID</a><br>
    <a href="${pageContext.request.contextPath}api/shop/delete">Delete shop</a><br>
</div>
<br>
</body>
</html>
