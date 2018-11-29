<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.io.*,java.util.*,app.models.*" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Booking Showtime</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/booking.css" />">
	<jsp:include page="template-imports.jsp"/>
	<script src="<c:url value="/resources/js/edit-profile.js?newversion" />"></script>    
</head>
<body>
    <jsp:include page="menu-template.jsp"/>
    <div class="container">
    <table>
    	<tr><th><h1>Edit profile</h1></th></tr>
    	<tr><td>Change first name:</td><td> <input type="text" value="${customer.firstName}" name="first-name" id="input-first"/></td><td><input type="button" value="Change" id="first-name"/></td></tr>
    	<tr><td>Change last name:</td><td> <input type="text" value="${customer.lastName}" name="last-name" id="input-last"/></td><td><input type="button" value="Change" id="last-name"/></td></tr>
    	<tr><td>Change email:</td><td> <input type="text" value="${customer.email}" name="email" id="input-email"/></td><td><input type="button" value="Change" id="email"/></td></tr>
		<tr><td>Change password:</td><td> <input type="password" value="${customer.password}" name="password" id="input-password"/></td><td><input type="button" value="Change" id="password"/></td></tr> 
		 <tr><td>Promotion subscription</td>
		 	<td>
		 	<c:choose>
		 	<c:when test="${customer.enrolledForPromotions == 1}">
		 		<input type="radio" name="subscription" value="Subscibe" checked/> Subscribe<br>
		 		<input type="radio" name="subscription" value="Unsubscribe" onclick="unsubscribe()"/> Unsubscribe
		 	</c:when>
		 	<c:when test="${customer.enrolledForPromotions == 0}">
		 		<input type="radio" name="subscription" value="Subscibe" onclick="subscribe()"/> Subscribe<br>
		 		<input type="radio" name="subscription" value="Unsubscribe" checked/> Unsubscribe
		 		</c:when>
		 	</c:choose>
		 	</td>
		 	</tr>
	 </table>
	 <!-- <table>
		 <tr><th><h1>Enter New Credit Card Information</h1></th></tr>
		 <tr><td>Enter credit card number:</td><td> <input type="text"/></td></tr>
		 <tr><td>Enter expiration month:</td><td> <input type="text"/></td></tr>
		 <tr><td>Enter expiration year:</td><td> <input type="text"/></td></tr>
		 <tr><td>Enter security code:</td><td> <input type="text"/></td></tr>
	</table>  -->  
    </div>
</body>
</html>