<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="template-imports.jsp"/>
    <title>Search Movie</title>
</head>
<body>
<jsp:include page="menu-template.jsp"/>
<div class="container-fluid">

    <div class="row">
        <div class="col-lg-4 col-lg-offset-2">
            <br><br>
            <h1 class="text-center">Search Movie</h1>

            <%--Search form--%>
            <form class="form-group">
                <div class="input-group">
                    <input type="text" class="form-control" name="title" id="movieTitle">
                    <span class="input-group-btn">
                        <button class="btn btn-primary" type="submit" id="btn-search-movie">Go!</button>
                         <button class="btn btn-success" type="submit" id="btn-clear-movie">Clear</button>
                    </span>
                </div>
            </form>

            <!-- /input-group -->
        </div>
        <!-- /.col-lg-6 -->
    </div>

    <br> <br>

    <div class="row">
    <div id="searchResults">
        <%--fill this from ajax--%>
    </div>
    </div>
</div>

<script src="<c:url value="/resources/js/movie.js" /> "></script>
</body>
</html>