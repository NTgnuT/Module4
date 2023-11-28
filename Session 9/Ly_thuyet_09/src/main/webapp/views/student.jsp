<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tung2
  Date: 27/11/2023
  Time: 16:15
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
    <h1>Danh sách sinh viên</h1>
    <p>
        <a href="student?action=add">Thêm mới học sinh</a>
    </p>
    <form action="">
        <input type="text" name="name" value="${nameSearch}">
        <button type="submit" name="action" value="search">Search</button>
    </form>
    <button type="submit" name="action" value="sort">SORT</button>
    <table border="1" cellspacing="0">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Email</td>
            <td>Birthday</td>
            <td>Address</td>
            <td colspan="2">Action</td>
        </tr>
        <c:forEach items='${list}' var="item">
            <tr>
                <td>${item.studentId}</td>
                <td>${item.studentName}</td>
                <td>${item.email}</td>
                <td>${item.birthday}</td>
                <td>${item.address}</td>
                <td><a href="/student?action=edit&id=${item.studentId}">Edit</a></td>
                <td><a href="/student?action=delete&id=${item.studentId}" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
