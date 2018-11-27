<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/template.css" />">
    <title>Manage Users</title>
</head>

<body>
    <jsp:include page="menu-template.jsp" />
    <c:forEach items="${bookings}" var="booking" >
    	<div>
    		Booking id: ${booking.id}
    		
    	</div>
    </c:forEach>
</body>
</html>