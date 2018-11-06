<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registered Confirmation</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />" >
    <link rel="stylesheet" href="<c:url value="/resources/css/template.css" />" >
</head>

<body>

    <jsp:include page="menu-template.jsp" />

    <div class="container">
        <h1>ACCOUNT CONFIRMATION</h1>
        <p>Thank you for creating an account with us. Click
            <a href="/u/login">here</a> to sign in.</p>
    </div>
</body>

</html>