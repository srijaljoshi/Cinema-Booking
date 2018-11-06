<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
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
    <title>Cinema EBooking</title>
</head>
<body>
    <jsp:include page="menu-template.jsp" />

    <%--<p>Customer: ${customer.firstName}</p>--%>

    <c:if test="${logout} != null" >
        <%--TODO: ADD A CSS CLASS --%>
        <p class="flash-message">Logged out: ${logout}</p>
    </c:if>

    <% if(request.getAttribute("logout") != null) { %>
        <%= "Log out status: " + request.getAttribute("logout") %>
    <% } %>
    <div class="jumbotron">
        <div class="content">
            <p>Featured Movie</p>
            <img src="http://www.fallenarisemusic.com/wp-content/uploads/2017/08/Enjoy-online-movies-for-your-mind-relaxation.jpg"
                 alt="" class="img-responsive">
        </div>
    </div>
    <div class="container container-fluid">
        <div class="row">
            <div class="col-md-3 col-xs-6">
                <img src="https://amc-theatres-res.cloudinary.com/image/upload/f_auto,fl_lossy,h_600,q_auto,w_400/v1/amc-cdn/production/2/movies/56400/56403/PosterDynamic/46537.jpg"
                     alt="movie 1" class="img-thumbnail">
                <p>Movie 1</p>
            </div>

            <div class="col-md-3 col-xs-6">
                <img src="https://amc-theatres-res.cloudinary.com/image/upload/f_auto,fl_lossy,h_600,q_auto,w_400/v1/amc-cdn/production/2/movies/56400/56403/PosterDynamic/46537.jpg"
                     alt="movie 1" class="img-thumbnail">
                <p>Movie 1</p>
            </div>
            <div class="col-md-3 col-xs-6">
                <img src="https://amc-theatres-res.cloudinary.com/image/upload/f_auto,fl_lossy,h_600,q_auto,w_400/v1/amc-cdn/production/2/movies/56400/56403/PosterDynamic/46537.jpg"
                     alt="movie 1" class="img-thumbnail">
                <p>Movie 1</p>
            </div>
            <div class="col-md-3 col-xs-6">
                <img src="https://amc-theatres-res.cloudinary.com/image/upload/f_auto,fl_lossy,h_600,q_auto,w_400/v1/amc-cdn/production/2/movies/56400/56403/PosterDynamic/46537.jpg"
                     alt="movie 1" class="img-thumbnail">
                <p>Movie 1</p>
            </div>
            <div class="col-md-3 col-xs-6">
                <img src="https://amc-theatres-res.cloudinary.com/image/upload/f_auto,fl_lossy,h_600,q_auto,w_400/v1/amc-cdn/production/2/movies/56400/56403/PosterDynamic/46537.jpg"
                     alt="movie 1" class="img-thumbnail">
                <p>Movie 1</p>
            </div>


        </div>
    </div>
</body>
</html>