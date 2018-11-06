<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<c:if test="${sessionScope.customer != null}" >
    <div class="navbar-inverse navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-brand"><a href="#" class="no-underline"><span>Movie Booking</span></a></div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/">Home</a></li>
                <li><a href="">Browse All</a></li>
                <li><a href="">Search</a></li>
                <li><a href="/u/logout">Logout</a></li>
                <li><a>Hello, ${sessionScope.customer.firstName}</a></li>
            </ul>
        </div>
    </div>
</c:if>

<c:if test="${sessionScope.customer == null}" >
    <div class="navbar-inverse navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-brand"><a href="#" class="no-underline"><span>Movie Booking</span></a></div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/">Home</a></li>
                <li><a href="">Browse All</a></li>
                <li><a href="">Search</a></li>
                <li><a href="/u/register">Sign Up</a></li>
                <li><a href="/u/login">Login</a></li>
                <li><a>Hello, User</a></li>
            </ul>
        </div>
    </div>
</c:if>

<c:if test="${sessionScope.admin!= null}" >
    <div class="navbar-inverse navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-brand"><a href="#" class="no-underline"><span>Movie Booking</span></a></div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Manage Movies</a></li>
                <li><a href="">Manage Users</a></li>
                <li><a href="">Mange Seats</a></li>
                <li><a href="">Manage Showtimes</a></li>
                <li><a href="">Yada Yada</a></li>
                <li><a href="/a/logout">Logout</a></li>
                <li><a>Hello, ${sessionScope.admin.firstName}</a></li>
            </ul>
        </div>
    </div>
</c:if>
