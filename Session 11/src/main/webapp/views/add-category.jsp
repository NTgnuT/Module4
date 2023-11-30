<%--
  Created by IntelliJ IDEA.
  User: tung2
  Date: 29/11/2023
  Time: 08:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <h1 class="text-center text-danger">Thêm mới danh muc </h1>
            <form action="<%=request.getContextPath()%>/category" method="POST">

                <div class="form-group">
                    <label for="categoryName">Ten danh muc</label>
                    <input type="text" class="form-control" id="categoryName" name="categoryName">
                </div>

                <div class="form-group">
                    <label >Status: </label>

                    <input type="radio" id="Active" name="status" checked value="true">
                    <label for="Active">Đang bán</label>

                    <input type="radio" id="IsActive" name="status"  value="false">
                    <label for="IsActive">Ngừng bán</label><br>
                </div>

                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
