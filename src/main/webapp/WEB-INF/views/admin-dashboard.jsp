<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="template-imports.jsp" />
</head>
<body>

    <jsp:include page="menu-template.jsp" />

    <div class="container-fluid">
        <br><br>
        <h1 class="text-center">Hello Admin!</h1>
        <hr>
        <div class="row">

            <div class="col-xs-4 ">
                <h2 class="text-center"><a href="/a/movies">Manage Movies</a></h2>
            </div>
            <div class="col-xs-4 ">
                <h2 class="text-center"><a href="/a/halls">Manage Halls</a></h2>
            </div>
            <div class="col-xs-4 ">
                <h2 class="text-center"><a href="/a/users">Manage Users</a></h2>
            </div>
            <div class="col-xs-4 ">
                <h2 class="text-center"><a href="/a/promos">Manage Promos</a></h2>
            </div>
            <div class="col-xs-4 ">
                <h2 class="text-center"><a href="#">Manage Showtimes</a></h2>
            </div>
        </div>
    </div>

</body>
</html>