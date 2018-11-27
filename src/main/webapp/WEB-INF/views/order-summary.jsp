<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.io.*,java.util.*,app.models.*" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %>
    

<!DOCTYPE html>
<html>
<head>
	<title>Order Summary</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/template.css" />">
    <script src="<c:url value="/resources/js/applyPromo.js?newversion" />"></script>
</head>
<body>
    <h1>Order Summary</h1>
    <div class="col-25">
		<div class="container">
		  <div class ="getEP">
	 			<c:if test = "${booking.discount == 0}">
		 			<c:if test="${error != null}">
	           	 	<p style="color:#e02100;"><c:out value="${error}"/></p>
        		</c:if>
	 			<form action="/u/apply-promo" method="get">
		 			<p>Enter Promo Code</p>
					<input type="text" name="promoCode" id="promoAdd" placeholder="Enter Promo Code" size="40" required/>
					<input type="submit" id="applyButton" value="Apply" class="btn"/>
				</form>
			</c:if>
		  </div>
		  <p>Price for tickets: $<span class="price" id="price">${booking.price}</span></p>
		  <p>Convenience Fees $<span class="fees">${booking.fees}</span></p>
		  <p>Tax $<span class="tax" id="tax">${booking.salesTax}</span></p>
		  <c:if test = "${booking.discount > 0}">
		 	<p>Discount $<span class="discount" id="discount">${booking.discount}</span></p>
		 </c:if>
		  <hr>
		  <p><b>TOTAL $<span class="price" id="total">${booking.totalPrice}</span></b></p>
		  	<center><input type="button" id="checkout" value="Checkout" class="btn"/>
          	<input type="button" id="cancel" value="Cancel" class="btn"/></center>
		</div>
	</div>
</body>
</html>