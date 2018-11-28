<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <jsp:include page="template-imports.jsp"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/template.css" />">
    <script src="<c:url value="/resources/js/history1.js?newversion" />"></script>
    <title>Manage Users</title>
</head>

<body>
    <jsp:include page="menu-template.jsp"/>
    <div class="container">
    <h1>Booking Order History</h1>
    <table class="table table-striped table-dark">
    <c:forEach items="${bookings}" var="booking" >
    <tr id="${booking.id}">
    	<td>
    		<p>Booking id: ${booking.id}</p>
    		<p>Showdate: ${booking.showtime.date} at ${booking.showtime.time}</p>
    		<p>Total paid: $${booking.totalPrice}</p>
    		<c:if test = "${booking.couponId != '0'}">
    			<p>Used promo id: ${booking.couponId}</p>
    		</c:if>
    		</td>
    		<td>
    		<p>Tickets:</p>
    		<c:forEach items="${booking.tickets}" var="ticket">
    			<p>Ticket ID: ${ticket.id}</p>
    			<p>Ticket Category: ${ticket.type}</p>
    			<p>Seat location: ${ticket.seat.location}</p>
    		</c:forEach>
		</td>
		<td style="text-align: center; vertical-align: middle;">
		<input type="button" value="Print" onclick="print()"/>
		<input type="button" value="Refund"  onclick="refund()"/>
		<div style="display: none">${booking.id}</div>
		</td>
			</tr>
    </c:forEach>
    </table>
    </div>
</body>
</html>