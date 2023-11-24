<%--
  Created by IntelliJ IDEA.
  User: tung2
  Date: 22/11/2023
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form style="max-width: 400px; margin: 0 auto;" action="/student" method="post">
    <input type="hidden" name="action" value="edit">
    <h1>Sửa sinh viên</h1>
    <div>
        <label for="studentCode">Student Code:</label>
        <input type="text" id="studentCode" name="studentCode" value="${studentEdit.studentCode}" style="width: 100%; padding: 6px; border: 1px solid #ddd; border-radius: 4px;">
    </div>
    <div>
        <label for="studentName">Student Name:</label>
        <input type="text" id="studentName" name="studentName" value="${studentEdit.studentName}" style="width: 100%; padding: 6px; border: 1px solid #ddd; border-radius: 4px;">
    </div>
    <div>
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="${studentEdit.address}" style="width: 100%; padding: 6px; border: 1px solid #ddd; border-radius: 4px;">
    </div>
    <div>
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" value="${studentEdit.age}" style="width: 100%; padding: 6px; border: 1px solid #ddd; border-radius: 4px;">
    </div>
    <div>
        <label for="classRoom">Classroom:</label>
        <input type="text" id="classRoom" name="classRoom" value="${studentEdit.classRoom}" style="width: 100%; padding: 6px; border: 1px solid #ddd; border-radius: 4px;">
    </div>
    <div>
        <label>Gender:</label>
        <input type="radio" id="male" name="gender" value="male" ${studentEdit.gender ? "checked" : ""} style="margin-right: 5px;"><label for="male">Nam</label>
        <input type="radio" id="female" name="gender" value="female" ${!studentEdit.gender ? "checked" : ""} style="margin-left: 10px;"><label for="female">Nữ</label>
    </div>
    <div>
        <button type="submit" style="padding: 8px 16px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer;">Add</button>
    </div>
</form>
</body>
</html>
