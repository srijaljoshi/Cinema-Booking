<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <title>Login as Admin</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/template.css" />">
</head>

<body>


    <jsp:include page="menu-template.jsp"/>

    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <h1>Login as Admin</h1>
                <%-- IF ERROR IN LOGIN --%>
                <c:if test="${error != null}">
                    <p style="color:#e02100;"><c:out value="${error}"/></p>
                </c:if>


                <%-- FROM an earlier tryout where I used request parameters instead of session FlashAttributes--%>
                <%--<% if(request.getParameter("error") != null) {%>--%>
                    <%--<%= request.getParameter("error") %>--%>
                <%--<% } %>--%>


                <form class="form-group" action="/a/login" method="post">
                    <br>
                    <div class="getEP">
                        <p>Enter your email address:</p>
                        <input class="form-control" type="text" name="email" id="emailAdd" placeholder="email address" size="40">
                        <br>
                        <p>Enter your password:</p>
                        <input class="form-control" type="password" name="password" id="password" placeholder="password" size="40">
                        <br>
                        <input type="checkbox" id=creds>
                        <label for="creds">Remember my credentials</label>
                    </div>
                    <br>
                    <br>
                    <input type="submit" class="btn btn-sm btn-primary" value="Log In">
                    <input type="submit" class="btn btn-sm btn-danger" value="Cancel">
                </form>
            </div>
        </div>
    </div>
</body>

</html>