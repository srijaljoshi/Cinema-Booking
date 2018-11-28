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
                <form id="newMovieForm" action="/a/movies/new" method="post">
                    <div class="form-group">
                        <label>Movie Title</label>
                        <input type="text" name="title" class="form-control" placeholder="Title">
                    </div>
                    <div class="form-group">
                        <label>Director</label>
                        <input type="text" name="director" class="form-control" placeholder="Director">
                        <br>
                        <label>Trailer Video</label>
                        <input type="text" name="trailerVideo" class="form-control" placeholder="Trailer Video link">
                        <br>
                        <label>Trailer Picture</label>
                        <input type="text" name="trailerPicture" class="form-control" placeholder="Trailer Picture link">
                        <br>
                    </div>
                    <div class="form-group">
                        <label>Synopsis</label>
                        <textarea class="form-control" name="synopsis">Enter the movie synopsis</textarea>
                        <br>
                        <label>Duration</label>
                        <input class="form-control" type="text" name="duration"  placeholder="Duration">
                    </div>
                    <div class="form-group">
                        <label for="selectRating">Rating</label>
                        <select name="rating" class="form-control" id="selectRating">
                            <option>G</option>
                            <option>PG-13</option>
                            <option>R</option>
                        </select>
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

<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title">Edit Movie</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    &times;
                </button>
            </div>
            <div class="modal-body">
                <form id="editMovieForm" action="/a/movies/edit" method="post">
                    <div class="form-group">
                        <label>Movie Title</label>
                        <input type="text" name="title" class="form-control" placeholder="Title">
                    </div>
                    <div class="form-group">
                        <label>Director</label>
                        <input type="text" name="director" class="form-control" placeholder="Director">
                        <br>
                        <label>Trailer Video</label>
                        <input type="text" name="trailerVideo" class="form-control" placeholder="Trailer Video link">
                        <br>
                        <label>Trailer Picture</label>
                        <input type="text" name="trailerPicture" class="form-control" placeholder="Trailer Picture link">
                        <br>
                    </div>
                    <div class="form-group">
                        <label>Synopsis</label>
                        <textarea class="form-control" name="synopsis">Enter the movie synopsis</textarea>
                        <br>

                        <label>Duration</label>
                        <input class="form-control" type="text" name="duration" >
                    </div>
                    <div class="form-group">
                        <label for="selectRating">Rating</label>
                        <select name="rating" class="form-control" id="selectRatingUpdate">
                            <option>G</option>
                            <option>PG-13</option>
                            <option>R</option>
                        </select>
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
                    <input type="text" id="myInput" class="form-control" placeholder="Search Movie"> <br>
                    <input type="submit" class="btn btn-primary btn-sm">

                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#exampleModal">
                        Add new Movie
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
            <th scope="col">Title</th>
            <th scope="col">Synopsis</th>
            <th scope="col">Director</th>
            <th scope="col">Rating</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${movies}" var="movie" >
            <tr zid="${movie.id}">
                <th scope="row" id="movieID">${movie.id}</th>
                <td>${movie.title}</td>
                <td>${movie.synopsis}</td>
                <td>${movie.director}</td>
                <td>${movie.rating}</td>
                <td><a class="btn btn-primary btn-sm btn-edit-movie"  data-toggle="modal" data-target="#exampleModal">Edit</a></td>
                <td><a href="#" class="btn btn-danger btn-sm btn-delete-movie">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="<c:url value="/resources/js/movie.js" />" type="application/javascript">
</script>
</body>
</html>