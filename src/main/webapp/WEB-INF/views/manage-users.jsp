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
    <title>Manage Users</title>
</head>

<body>

    <jsp:include page="menu-template.jsp" />

    <br><br><br><br><br>

    <div class="container">
        <form action="#">
            <div class="form-group">
                <div class="row">
                    <div class="col-md-3">
                        <input type="text" id="myInput" class="form-control" placeholder="Search User"> <br>
                        <input type="submit" class="btn btn-primary btn-sm">
                    </div>
                </div>
            </div>
        </form>

        <br><br>
        <table class="table table-hover" id="myTable">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Status</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${customers}" var="customer" >
                <tr>
                    <th scope="row">${customer.id}</th>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td><input class="btn btn-primary btn-sm" type="submit" value="Edit"></td>
                    <td><input class="btn btn-danger btn-sm" type="submit" value="Suspend"></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <script src="<c:url value="/resources/js/search.js" />" type="application/javascript"></script>
</body>
</html>