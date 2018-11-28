<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="template-imports.jsp" />
    <title>Coming soon</title>
</head>
<body>
<jsp:include page="menu-template.jsp" />

<br><br>

<h1 class="movie-title"> Coming Soon </h1>
<div class="container container-fluid">
    <div class="row">

        <c:forEach var="movie" items="${movies}" >
            <div class="col-md-3 col-xs-6">
                <img src="${movie.trailerPicture}" class="img-thumbnail trailer-image">
                <div class="movie-description">
                    <p>${movie.title}</p>
                    <p><a href="/movie/${movie.id}" class="btn btn-default btn-sm">See Details</a></p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>