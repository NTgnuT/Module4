<%--
  Created by IntelliJ IDEA.
  User: tung2
  Date: 22/11/2023
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Danh sách sinh viên</h1>
    <table border="1" cellpadding="0">
        <thead>
            <tr>
                <th>Mã sinh viên</th>
                <th>Tên sinh viên</th>
                <th>Địa chỉ</th>
                <th>Tuổi</th>
                <th>Lớp học</th>
                <th>Giới tính</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${students}" var="st">
                <tr>
                    <td>${st.studentCode}</td>
                    <td>${st.studentName}</td>
                    <td>${st.address}</td>
                    <td>${st.age}</td>
                    <td>${st.classRoom}</td>
                    <td>${st.gender ? "Nam" : "Nữ"}</td>
                    <td>
                        <a href="student?action=edit&id=${st.studentCode}">Edit</a>
                    </td>
                    <td>
                        <a onclick="return confirm('Bạn có muốn xóa không?')" href="student?action=delete&id=${st.studentCode}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="student?action=add">Thêm mới sinh viên</a>
</body>
</html>
