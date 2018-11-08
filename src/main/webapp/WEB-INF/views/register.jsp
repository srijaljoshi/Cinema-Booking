<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>

    <style>

        body {
            margin: 0;
            font-family: Arial;
            background: url("<c:url value="/resources/img/background.jpg" />");
            background-repeat: no-repeat;
            background-size: cover;
            overflow: scroll;
            background-attachment: fixed;
        }
        h1{
            color: white;
        }
        h2 {
            float: left;
            color: white;
            font-size:25px;
        }
        b{
            color:white;
            font-size: 20px;
        }
        p{
            color:white;
            font-size: 20px;
        }
        .formGroup{
            text-align:center;
            margin: 0;
        }
        .row input[type="text"],input[type="password"], input[type="email"]{
            background: transparent;
            border: 0;
            outline: 0;
            border-bottom: 1px solid gray;
            color:white;
            font-size: 20px;
            width: 400px;
        }
        .formGroup button[type="submit"]{
            text-align: center;
            background-color: gray;
            color: white;
            border: none;
            font-size: 20px;
            width: 200px;
            margin: 20px;
            cursor: pointer;
        }
    </style>

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />" >
    <link rel="stylesheet" href="<c:url value="/resources/css/template.css" />">
</head>
<body>

<script language = 'javascript'>
    function check(input){
        if (input.value != document.getElementById('password').value) {
            input.setCustomValidity('Password Must be Matching.');
        } else {
            // input is valid -- reset the error message
            input.setCustomValidity('');
        }
    }

</script>

<jsp:include page="menu-template.jsp" />

<form action="register" method="POST">
    <div class="formGroup">
        <h1 style = "color:white;">Register For An Account</h1>
        <div class="row">
            <center>
                <label for="firstName"><b>First Name:</b></label>
                <br>
                <input type="text" class="form-control" name="firstName" placeholder="First Name" pattern="[A-Za-z]+" required>
                <br>
                <br>
                <label for="lastName"><b>Last Name:</b></label>
                <br>
                <input type="text" class="form-control" name="lastName" placeholder="Last Name" pattern="[A-Za-z]+" required>
                <br>
                <br>
                <label for="email"><b>Email:</b></label>
                <br>
                <input type="email" class="form-control" name="email" placeholder="Email" required>
                <br>
                <br>
                <label for="street"><b>Street:</b></label>
                <br>
                <input type="text" class="form-control" name="street" placeholder="Street" required>
                <br>
                <br>
                <label for="city"><b>City:</b></label>
                <br>
                <input type="text" class="form-control" name="city" placeholder="City" required>
                <br>
                <br>
                <label for="state"><b>State:</b></label>
                <br>
                <input type="text" class="form-control" name="state" placeholder="State" required>
                <br>
                <br>
                <label for="zipCode"><b>Zip Code:</b></label>
                <br>
                <input type="text" class="form-control" name="zipCode"  pattern="[0-9]+" title="Need 5 digits" placeholder="Zip Code" required>
                <br>
                <br>
                <label for="password"><b>Password:</b></label>
                <br>
                <input type="password" id = "password" class="form-control" name="password" placeholder="*****" required>
                <br>
                <br>
                <label for="psw-repeat"><b>Repeat Password:</b></label>
                <br>
                <input type="password" id="repeatPassword" class="form-control" name="psw-repeat" oninput="check(this)" placeholder="*****" required>
                <br>

                <input type="checkbox" name="promo" value="yes" checked> <span style="color:white;">Get promotional emails</span>
                <br>
            </center>

        </div>
        <br>
        <p>By creating an account you agree to our Terms & Privacy</p>
        <button type="submit" class="registerbtn" onclick="regConfirm.html">Register</button>
        </center>
    </div>
</form>
</body>
</html>