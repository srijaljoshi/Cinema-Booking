<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.io.*,java.util.*,app.models.*" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order Confirmation</title>
    <!-- <style>
        tab1 { padding-left: 4em; }
        body {
            margin: 0;
            font-family: Arial;
            background: url("background.jpg");
            background-repeat: no-repeat;
            background-size: cover; 
        }
        .topnav {
            overflow: hidden;
            background-color: #696969;
            height: 60px;
        }

        .topnav a {
            float: right;
            color: white;
            text-align: center;
            padding: 20px;
            text-decoration: none;
            font-size: 21px;
        }

        .topnav a:hover {
            background-color: lightgray;
            color: black;
        }

        .topnav a.active {
            background-color: red;
            color: white;
        }
        h1{
            color: white;
        }
        h2 {
            float: left;
            color: white;
            font-size:25px;
        }
        p{
            color:white;
            font-size: 20px;
        }
        .btn {
        background-color: gray;
        color: white;
        padding: 12px;
        margin: 10px 0;
        border: none;
        width: 50%;
        border-radius: 3px;
        cursor: pointer;
        font-size: 17px;
        }

        .btn:hover {
        background-color: #45a049;
        }
        
        .signInInfo{
            text-align: center;
            color:white;
        }
        .getEP{
            display: inline-block;
            text-align: left;
        }

        .signInInfo input[type="text"],[type="password"]{
            background: transparent;
            border: 0;
            outline: 0;
            border-bottom: 1px solid gray;
            color:white;
            width: 500px;
            font-size: 20px;
            
        }
        .signInInfo input[type="submit"]{
            background-color: gray;
            margin: 20px;
            color: white;
            border: none;
            font-size: 25px;
            width: 150px;
            
        }
    </style> -->

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/template.css" />">
</head>
<body>
    
    <!-- <div class="topnav">
        <h2>Movie Booking</h2>
        <a class="active" href="#sign in">Sign In</a>
        <a href="#register">Register</a>
        <a href="#about">About</a>
        <a href="#contact">Contact</a>
        <a href="#searchMovie">Search</a>
        <a href="#Browse All">Browse</a>
        <a href="#Home">Home</a>
    </div> -->
    
    
  <div class="navbar-inverse navbar-default navbar-fixed-top">
        <div class="container-fluid">
          <div class="navbar-brand"><a href="#" class="no-underline"><span>Movie Booking</span></a></div>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Home</a></li>
            <li><a href="">Browse All</a></li>
            <li><a href="">Search</a></li>
            <li><a href="">About</a></li>
            <li><a href="">Contact</a></li>
            <li><a href="">Sign Up</a></li>
            <li><a href="">Sign In</a></li>
          </ul>
        </div>
      </div>
    
    <div class="container">
    <h1>Order Confirmation</h1>
	<h2>Thanks for your purchase! A confirmation email has been sent</h2>
    <div class ="signInInfo">
        <br>
        <div class ="getEP">
            <h3>Movie: ${title}
			<br>
			Date: ${booking.showtime.date}
			<br>
			Time: ${booking.showtime.time}</h3>
			
			<p>Number of Tickets: ${booking.numberOfTickets}</p>
            <p>Seat Locations: 
            <c:forEach items="${booking.tickets}" var="ticket">
            	<c:out value="${ticket.seat.location}"/>
            </c:forEach>
			</p>
			
			<p>TOTAL <tab1>$<span>${booking.totalPrice}</span></tab1></p>
            <br>
            <br>
        </div>

            <br>
            <br>
            
    </div>
	<input type="submit" id="finishButton" value="Finish" class="btn">
    </div>
</body>
</html>
