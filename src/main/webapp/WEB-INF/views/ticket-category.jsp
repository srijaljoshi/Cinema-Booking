<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.io.*,java.util.*,app.models.*" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %>
    

<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="x-ua-compatible" content="ie=edge">
	<link rel="stylesheet" href="<c:url value="/resources/css/booking.css" />">
	<jsp:include page="template-imports.jsp"/>
   	<script src="<c:url value="/resources/js/tickets.js?newversion" />"></script>
</head>
  <body id="demo">
   <jsp:include page="menu-template.jsp" />
  <div class="container top top-buffer">
        <h1>Amount of Tickets</h1>
        <p>Enter the number of tickets you want to book:</p>
        Adults (18+): <input type="button" value="-" class="decrement" id="adultMinus"></button>0<input type="button" value="+" class="increment" id="adultPlus"></button><br>
        Children (0 - 17): <input type="button" value="-" class="decrement" id="childMinus"></button>0<input type="button" value="+" class="increment" id="childPlus"></button><br>
        Senior (65+) <input type="button" value="-" class="decrement" id="seniorMinus"></button>0<input type="button" value="+" class="increment" id="seniorPlus"></button><br>
        <button type="buton" value="button" id="submit">Continue</button>
        <input type="button" value="Cancel"><br>

    </div>
  </body>
</html>
  