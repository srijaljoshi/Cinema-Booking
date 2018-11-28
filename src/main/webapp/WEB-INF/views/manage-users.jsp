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
                <tr zid="${customer.id}">
                    <th id="userID" scope="row">${customer.id}</th>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.statusID}</td>
                    <td><a class="btn btn-primary btn-sm btn-edit-user">Edit</a></td>
                    <c:if test="${customer.statusID == 1}" >
                        <td>
                            <a href="/a/users/${customer.id}/suspend" class="btn btn-info btn-sm">Suspend</a>
                            <button class="btn btn-danger btn-sm btn-delete-user">Delete</button>
                        </td>
                    </c:if>
                    <c:if test="${customer.statusID == 2}" >
                        <td>
                            <a href="/a/users/${customer.id}/reactivate" class="btn btn-success btn-sm">Activate</a>
                            <button class="btn btn-danger btn-sm btn-delete-user">Delete</button>
                        </td>
                    </c:if>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <script src="<c:url value="/resources/js/search.js" />" type="application/javascript"></script>
    <script src="<c:url value="/resources/js/customer.js" />" type="application/javascript"></script>
</body>
</html>