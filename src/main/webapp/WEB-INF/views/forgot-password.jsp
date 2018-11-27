<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <title>Sign In</title>

    <jsp:include page="template-imports.jsp" />
</head>

<body>


    <jsp:include page="menu-template.jsp"/>

    <div class="container">
        <h1>Forgot Password</h1>
		<p>Enter your password to reset your password from your email account</p>
        <%-- IF ERROR IN LOGIN --%>
        <c:if test="${error != null}">
            <p style="color:#e02100;"><c:out value="${error}"/></p>
        </c:if>


        <p style="color:#ff981a;">${param.get(error)}</p>

        <form action="forgot" method="post">
            <br>
            <div class="getEP">
                <p>Enter your email address:</p>
                <input type="text" name="email" id="emailAdd" placeholder="email address" size="40">
                <br>
            </div>
            <br>
            <br>
            <input type="submit" class="btn btn-sm btn-primary" value="Reset Password">
        </form>
    </div>
</body>

</html>