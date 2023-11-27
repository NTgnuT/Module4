<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tung2
  Date: 24/11/2023
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" cellspacing="0">
    <tr>
        <td>STT</td>
        <td>ID</td>
        <td>Name</td>
        <td>Status</td>

        <td colspan="2">Action</td>
    </tr>
    <c:forEach items='${list}' var="item" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${item.categoryId}</td>
            <td>${item.categoryName}</td>
            <td>${item.categoryStatus ? "Active" : "Close"}</td>
            <td>
                <a href="danh-muc?action=edit&id=${item.categoryId}">Edit</a>
            </td>
            <td>
                <a href="danh-muc?action=delete&id=${item.categoryId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="danh-muc?action=add">Thêm mới</a>
</body>
</html>
