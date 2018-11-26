<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="template-imports.jsp" />
    <title>Cinema EBooking</title>
</head>
<body>
    <jsp:include page="menu-template.jsp" />

    <%--<p>Customer: ${customer.firstName}</p>--%>

    <%--<c:if test="${logout} != null" >--%>
        <%--&lt;%&ndash;TODO: ADD A CSS CLASS &ndash;%&gt;--%>
        <%--<p class="flash-message">Logged out: ${logout}</p>--%>
    <%--</c:if>--%>

    <%--<% if(request.getAttribute("logout") != null) { %>--%>
        <%--<%= "Log out status: " + request.getAttribute("logout") %>--%>
        <%--<% request.removeAttribute("logout"); %>--%>
    <%--<% } %>--%>
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