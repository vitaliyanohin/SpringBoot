<%--
  Created by IntelliJ IDEA.
  User: Vitaliy
  Date: 04.07.2019
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> New Product </title>
</head>
<body>
<form  action="/product/admin/create" method="post">
    <input name="product" type="text"/>
    <input name="description" type="text">
    <input name="price" type="text">
    <input type="submit">
</form>
</body>
</html>
