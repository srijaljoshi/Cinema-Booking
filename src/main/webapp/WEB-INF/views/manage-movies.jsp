<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/template.css" />">
    <title>Manage Users</title>
</head>

<body>

<jsp:include page="menu-template.jsp" />

<br><br><br><br><br>

<div class="container">
    <form action="#">
        <div class="form-group">
            <div class="row">
                <div class="col-md-3">
                    <input type="text" id="myInput" class="form-control" placeholder="Search Movie"> <br>
                    <input type="submit" class="btn btn-primary btn-sm">
                </div>
            </div>
        </div>
    </form>

    <br><br>
    <table class="table table-hover" id="myTable">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Title</th>
            <th scope="col">Director</th>
            <th scope="col">Rating</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${movies}" var="movie" >
            <tr>
                <th scope="row" id="movieID">${movie.id}</th>
                <td>${movie.title}</td>
                <td>${movie.director}</td>
                <td>${movie.rating}</td>
                <td><a class="btn btn-primary btn-sm" id="btn-edit-movie">Edit</a></td>
                <td><a href="#" class="btn btn-danger btn-sm" id="btn-delete-movie">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="<c:url value="/resources/js/movie.js" />" type="application/javascript">
</script>
</body>
</html>