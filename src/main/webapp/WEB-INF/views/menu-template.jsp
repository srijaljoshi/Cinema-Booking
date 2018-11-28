<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<c:if test="${sessionScope.customer != null}" >
    <div class="navbar-inverse navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-brand"><a href="#" class="no-underline"><span>Movie Booking</span></a></div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/">Home</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Browse Movies
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/movies_playing">Now Playing</a></li>
                        <li><a href="/movies_soon">Coming Soon</a></li>
                    </ul>
                </li>
                <li><a href="/u/search">Search Movie</a></li>
                <li><a href="/u/logout">Logout</a></li>

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">${sessionScope.customer.firstName}
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/u/edit-profile">Edit Profile</a></li>
                        <li><a href="/u/order-history">View Order History</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</c:if>

<c:if test="${sessionScope.customer == null}" >
    <div class="navbar-inverse navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-brand"><a href="" class="no-underline"><span>Movie Booking</span></a></div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/">Home</a></li>
                <li class="nav-item"><a href="">Browse Movies</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Movies
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/movies_playing">Now Playing</a></li>
                        <li><a href="/coming_soon">Coming Soon</a></li>
                    </ul>
                </li>
                <li><a href="/search">Search Movie</a></li>
                <li><a href="/u/register">Sign Up</a></li>
                <li><a href="/u/login">Login</a></li>
                <li><a>Hello, User</a></li>
            </ul>
        </div>
    </div>
</c:if>

<c:if test="${sessionScope.admin != null}" >
    <div class="navbar-inverse navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-brand"><a href="/a/dashboard" class="no-underline"><span>Movie Booking</span></a></div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/a/movies">Manage Movies</a></li>
                <li><a href="/a/users">Manage Users</a></li>
                <li><a href="/a/halls">Manage Halls</a></li>
                <%--<li><a href="">Manage Showtimes</a></li>--%>
                <%--<li><a href="">Manage Seats</a></li>--%>
                <li><a href="/a/logout">Logout</a></li>
                <li><a>Hello, ${sessionScope.admin.firstName}</a></li>
            </ul>
        </div>
    </div>
</c:if>
