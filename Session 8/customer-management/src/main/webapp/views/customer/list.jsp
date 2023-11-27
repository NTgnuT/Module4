
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tung2
  Date: 24/11/2023
  Time: 09:27
  To change this template use File | Settings | File Templates.

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        /*table, th, tr, td {*/

        /*    border-collapse: collapse;*/
        /*}*/
        table {
            padding: 8px;
            width: 80%;
            border-collapse: collapse;
        }

        th, td {
            padding: 5px;
            border: 1px solid #ddd;
            text-align: center; /* Căn giữa theo chiều ngang */
        }

        td {
            vertical-align: middle; /* Căn giữa theo chiều dọc */
        }

        a {
            margin: 5px;
            text-decoration: none;
        }
    </style>
</head>
<body>

    <h1>CUSTOMER LIST</h1>
    <div class="input-search">
        <form action="customer">
            <input type="text" name="inputSearch" value="${searchName}">
            <button type="submit" name="action" value="search">Search</button>
        </form>
    </div>


<table>
    <thead>
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>ADDRESS</td>
        <td>EMAIL</td>
        <td colspan="2">ACCTION</td>

    </tr>
    </thead>
    <tbody>
        <c:forEach items="${customer}" var="cus">
            <tr>
                <th>${cus.id}</th>
                <th>${cus.name}</th>
                <th>${cus.email}</th>
                <th>${cus.address}</th>
                <th>
                    <a href="customer?action=edit&id=${cus.id}">EDIT</a>
                </th>
                <th>
                    <a onclick="return confirm('Are you sure?')" href="customer?action=delete&id=${cus.id}">DELETE</a>
                </th>
            </tr>
        </c:forEach>
    </tbody>
</table>
    <a href="customer?action=create">ADD NEW CUSTOMER</a>

</body>
</html>
