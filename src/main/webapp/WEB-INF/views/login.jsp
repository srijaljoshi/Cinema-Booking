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
        <h1>Sign In</h1>
        <p>Welcome back valued customer! Sign in to purchase tickets and gain access to exclusive deals and offers.</p>

        <%-- IF ERROR IN LOGIN --%>
        <c:if test="${error != null}">
            <p style="color:#e02100;"><c:out value="${error}"/></p>
        </c:if>


        <%-- FROM an earlier tryout where I used request parameters instead of session FlashAttributes--%>
        <%--<% if(request.getParameter("error") != null) {%>--%>
            <%--<%= request.getParameter("error") %>--%>
        <%--<% } %>--%>


        <p style="color:#ff981a;">${param.get(error)}</p>

        <form action="login" method="post">
            <br>
            <div class="getEP">
                <p>Enter your email address:</p>
                <input type="text" name="email" id="emailAdd" placeholder="email address" size="40">
                <br>
                <p>Enter your password:</p>
                <input type="password" name="password" id="password" placeholder="password" size="40">
                <br>
                <br>
                <input type="checkbox" id=creds>
                <label for="creds">Remember my credentials</label>
            </div>
            <br>
            <br>
            <input type="submit" class="btn btn-sm btn-primary" value="Log In">
            <input type="submit" class="btn btn-sm btn-danger" value="Cancel">
        </form>
        <br>
        <a href="/u/forgot-password" >Forgot Password</a>
    </div>
    
</body>

</html>