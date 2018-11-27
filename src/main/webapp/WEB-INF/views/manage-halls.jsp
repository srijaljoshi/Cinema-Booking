<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <jsp:include page="template-imports.jsp" />
    <title>Manage Users</title>
</head>

<body>

<jsp:include page="menu-template.jsp" />

<br><br><br><br><br>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title" id="exampleModalLabel">Add new movie</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    &times;
                </button>
            </div>
            <div class="modal-body">
                <form id="newMovieForm" action="/a/halls/new" method="post">
                    <div class="form-group">
                        <label>Hall ID</label>
                        <input type="number" name="id" class="form-control" placeholder="ID">
                        <br><br>
                        <label>Hall name</label>
                        <input type="text" name="name" class="form-control" placeholder="Title">
                    </div>
                    <div class="form-group">
                        <label>Total seats</label>
                        <input type="number" name="totalSeats" class="form-control" placeholder="Total Seats">
                        <br><br>
                        <label>Available Seats</label>
                        <input type="number" name="availableSeats" class="form-control" placeholder="Available Seats">
                    </div>
                    <button type="submit" class="btn btn-primary btn-sm">Submit</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn-sm btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn-sm btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>


<div class="container">

    <form action="#">
        <div class="form-group">
            <div class="row">
                <div class="col-md-3">
                    <input type="text" id="myInput" class="form-control" placeholder="Search Hall"> <br>
                    <input type="submit" class="btn btn-primary btn-sm">

                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#exampleModal">
                        Add new Hall
                    </button>

                </div>
            </div>
        </div>
    </form>

    <br><br>
    <table class="table table-hover" id="myTable">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Name</th>
            <th scope="col">Total Seats</th>
            <th scope="col">Available Seats</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${halls}" var="hall" >
            <tr zid="${hall.id}">
                <th scope="row" id="hallID">${hall.id}</th>
                <td>${hall.name}</td>
                <td>${hall.totalSeats}</td>
                <td>${hall.availableSeats}</td>
                <td><a class="btn btn-primary btn-sm" id="btn-edit-hall">Edit</a></td>
                <td><a href="#" class="btn btn-danger btn-sm btn-delete-hall">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%--To reuse the same movie.js code, I have not renamed movieID ot hallID or any other IDS--%>
<script src="<c:url value="/resources/js/hall.js" />" type="application/javascript">
</script>
</body>
</html>