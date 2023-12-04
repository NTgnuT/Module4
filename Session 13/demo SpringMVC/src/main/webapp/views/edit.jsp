<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Create new customer</h1>
<p>
    <a href="/customer/getAll">Back to customer list</a>
</p>
<form method="post" action="/customer/edit">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Id: </td>
                <td><input type="text" name="id" value="${cusEdit.id}" id="id" readonly></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" value="${cusEdit.name}" id="name"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" value="${cusEdit.email}" id="email"></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="address" value="${cusEdit.address}" id="address"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Edit customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>