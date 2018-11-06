<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    test
</head>
<body>
<p>Customer name: ${customer.firstName}</p>


<c:out value="${error}"/>

<p><c:out value="${logout}"/></p>
</body>
</html>