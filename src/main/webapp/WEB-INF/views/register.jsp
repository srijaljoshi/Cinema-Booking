<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href="<c:url value = "/resources/css/register.css" />"/>
    <link rel="stylesheet" href="<c:url value= "/resources/css/bootstrap.css" />"/>
    <link rel="stylesheet" href="<c:url value = "/resources/css/template.css" />"/>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
</head>
<body>

<jsp:include page="menu-template.jsp" />

<form action="register" method="post">
    <div class="container form-group">
        <p>Please fill out this form to create an account
        <p>
        <hr>
        <div class="row">
            <div class="col-md-6">
                <label for="firstName"><b>First Name:</b></label>
                <input type="text" class="form-control" name="firstName" required>
                <label for="lastName"><b>Last Name:</b></label>
                <input type="text" class="form-control" name="lastName" required>
                <label for="email"><b>Email:</b></label>
                <input type="text" class="form-control" name="email" required>
                <label for="street"><b>Street:</b></label>
                <input type="text" class="form-control" name="street" required>
                <label for="city"><b>City:</b></label>
                <input type="text" class="form-control" name="city" required>
                <label for="state"><b>State:</b></label>
                <input type="text" class="form-control" name="State" required>
                <label for="zipCode"><b>Zip Code:</b></label>
                <input type="text" class="form-control" name="zipCode" required>
                <label for="password"><b>Password:</b></label>
                <input type="password" class="form-control" name="password" required>
                <label for="psw-repeat"><b>Repeat Password:</b></label>
                <input type="password" class="form-control" name="psw-repeat" required>
            </div>
        </div>
        <p>By creating an account you agree to our Terms & Privacy</p>
        <button type="submit" class="registerbtn">Register</button>
    </div>
</form>
</body>
</html>