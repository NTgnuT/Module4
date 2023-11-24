<%--
  Created by IntelliJ IDEA.
  User: tung2
  Date: 22/11/2023
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Tên</th>
        <th>Sinh nhật</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="t">
        <tr>
            <td>${t.name}</td>
            <td>${t.birthday}</td>
            <td>${t.address}</td>
            <td>
                <img src="${t.picture}">
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
