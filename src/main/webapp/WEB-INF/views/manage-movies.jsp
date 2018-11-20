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
                    <input type="text" id="myInput" onkeyup="myFunction()"  class="form-control" placeholder="Search Movie"> <br>
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
                <th scope="row">${movie.id}</th>
                <td>${movie.title}</td>
                <td>${movie.director}</td>
                <td>${movie.rating}</td>
                <td><input class="btn btn-primary btn-sm" type="submit" value="Edit"></td>
                <td><input class="btn btn-danger btn-sm" type="submit" value="Delete"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    function myFunction() {
        // Declare variables
        var input, filter, table, tr, td, i;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
        tr = table.getElementsByTagName("tr");

        // Loop through all table rows, and hide those who don't match the search query
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
            if (td) {
                if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = ""; //reset display css property if filtered and is in the view
                    console.log("Filtered " + i);
                } else {
                    // If not what the user wanted then set display property to none to make it invisible
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>
</body>
</html>