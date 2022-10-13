<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update product</title>
    <style type="text/css">
        label {
            display: inline-block;
            width: 200px;
            margin: 5px;
            text-align: left;
        }
        input[type=text], input[type=password], select {
            width: 200px;
        }
        button {
            padding: 10px;
            margin: 10px;
        }
    </style>
</head>
<body>
<div align="center">
    <a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
</div>
<div align="center">
    <h2>Update product</h2>
    <form:form action="update" method="post" modelAttribute="product">

        <form:label path="productId">Id:</form:label>
        <form:input required="required" path="productId"/><br/>

        <form:label path="name">Name:</form:label>
        <form:input required="required" path="name"/><br/>

        <form:label path="price">Price:</form:label>
        <form:input required="required" path="price"/><br/>

        <form:label path="shopId">Shop ID:</form:label>
        <form:input required="required" path="shopId"/><br/>

        <form:button>Update</form:button>
    </form:form>

</div>
</body>
</html>