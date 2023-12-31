<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tung2
  Date: 29/11/2023
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h2 {
            color: #333;
        }

        a {
            text-decoration: none;
            color: #3498db;
        }

        a:hover {
            color: #207cca;
        }

        p {
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #e5e5e5;
        }

        td a {
            display: inline-block;
            padding: 5px 10px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
        }

        td a:hover {
            background-color: #207cca;
        }
    </style>
</head>
<body>
<h1>Product List</h1>
<p>
    <a href="product?action=add">Thêm mới danh mục</a>
</p>
<%--<form action="">--%>
<%--    <input type="text" name="name" value="${nameSearch}">--%>
<%--    <button type="submit" name="action" value="search">Search</button>--%>
<%--</form>--%>
<%--<button type="submit" name="action" value="sort">SORT</button>--%>
<table border="1" cellspacing="0">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>CategoryName</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach items='${listProduct}' var="item">
        <tr>
            <td>${item.productId}</td>
            <td>${item.productName}</td>
            <td>${item.price}</td>
            <td>${item.category.categoryName}</td>
            <td><a href="/product?action=edit&id=${item.productId}">Edit</a></td>
            <td><a href="/product?action=delete&id=${item.productId}" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
