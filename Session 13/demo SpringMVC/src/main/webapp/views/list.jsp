<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tung2
  Date: 01/12/2023
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            text-decoration: underline;
            color: #0056b3;
        }

    </style>
</head>
<body>
</h1>
<p>
    <a href="/customer/create">Create new customer</a>
</p>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach items='${cusList}' var="cus" >
        <tr>
            <td>${cus.id}</td>
            <td>${cus.name}</td>
            <td>${cus.email}</td>
            <td>${cus.address}</td>
            <td><a href="/customer/edit?idEdit=${cus.id}">Edit</a></td>
            <td><a href="/customer/delete?idDelete=${cus.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
</body>
</html>
