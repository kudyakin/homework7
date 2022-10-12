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

    <nav class="menu">

        <a href="${pageContext.request.contextPath}api/person/create">Create new person</a><br>
        <a href="${pageContext.request.contextPath}api/person/all">View all persons</a><br>
        <a href="${pageContext.request.contextPath}api/person/get">View person by ID</a><br>
        <a href="${pageContext.request.contextPath}api/person/update">Update person</a><br>
        <a href="${pageContext.request.contextPath}api/person/delete">Delete person</a><br>




    </nav>
</div>
</body>
</html>