<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h2>Showing all users</h2>
<table>

    <thead>
    <th>S.N.</th>
    <th>Email</th>
    <th>Name</th>
    <th>Password</th>
    </thead>

    <c:forEach var="customer" items="${customers}">

        <tr>
            <td>${customer.id}</td>
            <td>${customer.email}</td>
            <td>${customer.firstName} ${customer.lastName}</td>
            <td>${customer.password}</td>
            <td><a href="/users/${customer.id}/delete"
                   onclick="confirmDelete()">Delete</a></td>
        </tr>

    </c:forEach>
</table>

<hr>

<form action="/addUser" method="post">
    <div>
        <label>Enter email: </label> <input type="text" name="email">
        <br>
        <br>
        <label>Enter password: </label> <input type="password" name="password">
        <br>
        <br>
        <label>Enter username: </label> <input type="text"
                                               name="username"> <br>
        <br> <input type="submit">
    </div>
</form>

<script>
    function confirmDelete() {
        return confirm("Are you sure?");
    }
</script>
</body>
</html>