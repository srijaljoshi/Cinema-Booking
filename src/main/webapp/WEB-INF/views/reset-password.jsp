<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <title>Sign In</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/template.css" />">
</head>

<body>


    <jsp:include page="menu-template.jsp"/>

    <div class="container">
        <h1>Reset Password</h1>
        <p>Please enter a new password for your account.</p>

        <%-- IF ERROR IN LOGIN --%>
        <c:if test="${error != null}">
            <p style="color:#e02100;"><c:out value="${error}"/></p>
        </c:if>


        <p style="color:#ff981a;">${param.get(error)}</p>

        <form action="reset/" method="post">
            <br>
            <div class="getEP">
                <p>Enter new password:</p>
                <input type="password" name="password" id="password" placeholder="email address" size="40">
                <br>
                <br>
                <p>Re-enter password:</p>
                <input type="password" name="check" id="password" placeholder="password" size="40">
                <br>
                <br>
                <input type='hidden' name="id" value="${customer.id}"/>
                <input type="hidden" name="token" value="${customer.token}"/>
            </div>
            <br>
            <br>
            <input type="submit" class="btn btn-sm btn-primary" value="Reset Password">
        </form>
    </div>
</body>

</html>