<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
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
	   <title>Movie Details</title>
	</head>
<body>
	<jsp:include page="menu-template.jsp"/>
	<div class="container">
	   <div class="row top top-buffer">
	     <div class="col-md-3">
	       <h1>Movie Name</h1>
	       <img src="" width="200px" height="230px">
	       <p>2 HR 1 MIN | PG 13<p>
	     </div>
	     <div class="col-md-9">
	       <h2>Movie description</h2>
	       <p>${movie.description}</p>
	     </div>
	   </div>
	   <div class="row">
	     <div class="col-md-12">
	     	<form action="/u/book" method="get">
	     	<input type="number" name="movieId" />
		       <p>Select Date</p>
		       <input type="date" name="date" id="inputDate"><br>
		       <p>Select show time: </p>
		       <select name="time">
		       	<option value="9:00">9:00 am - 12:00 pm</option>
		       	<option value="2:00">2:00 pm - 5:00 pm</option>
		       	<option value="7:00">7:00 pm - 10:00 pm</option>
		       </select><br>
		       <input type="submit"/>
	       </form>
	     </div>
	   </div>
	 </div>
</body>
</html>