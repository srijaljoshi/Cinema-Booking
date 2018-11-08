<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Dashboard</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/template.css" />">
</head>
<body>

    <jsp:include page="menu-template.jsp" />

    <div class="container-fluid">
        <h2>Hello Admin!</h2>
        <div class="row">
            <div class="col-sm-2 red-bdr">
                <h2>Manage Movies</h2>
            </div>
            <div class="col-sm-2 red-bdr">
                <h2>Manage Halls</h2>
            </div>
            <div class="col-sm-2 red-bdr">
                <h2>Manage Users</h2>
            </div>
            <div class="col-sm-2 red-bdr">
                <h2>Manage Showtimes</h2>
            </div>
            <div class="col-sm-2 red-bdr">
                <h2>View Report</h2>
            </div>
        </div>
    </div>

</body>
</html>