<%@ taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <table class="table table-hover ">
                <thead class="thead-inverse">
                <tr>
                    <th>STT</th>
                    <th>NAME</th>
                    <th>STATUS</th>
                    <th colspan="2">Action</th>
                </tr>
                </thead>
                <tbody>
                <e:forEach items="${listCate}" var="item">
                    <tr>
                        <td scope="row">${item.categoryId}</td>
                        <td>${item.categoryName}</td>
                        <td>${item.status ? "Active" : "Block"}</td>
                        <td>
                            <a href="category/edit/${item.categoryId}" class="btn btn-warning">Edit</a>
                        </td>
                        <td>
                            <a href="category/change/${item.categoryId}" class="btn ${item.status ? "btn-primary" : "btn-danger"}">${item.status ? "Active" : "Block"}</a>
                        </td>
                    </tr>
                </e:forEach>
                </tbody>
            </table>
            <a href="category-add" class="btn btn-primary">ADD</a>
        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>