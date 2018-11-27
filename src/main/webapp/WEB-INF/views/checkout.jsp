<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.io.*,java.util.*,app.models.*" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %>
    

<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/template.css" />">
  <style>
    body {
      margin: 0;
      font-family: Arial;
      /* background-repeat: no-repeat; */
      background-size: cover;
    }

    .topnav {
      overflow: hidden;
      background-color: #696969;
      height: 60px;
    }

    .topnav a {
      float: right;
      color: black;
      text-align: center;
      padding: 20px;
      text-decoration: none;
      font-size: 21px;
    }

    .topnav a:hover {
      background-color: transparent;
      color: black;
    }

    .topnav a.active {
      background-color: red;
      color: black;
    }

    h1 {
      color: black;
    }

    h2 {
      float: left;
      color: black;
      font-size: 25px;
    }

    p {
      color: black;
      font-size: 20px;
    }

    * {
      box-sizing: border-box;
    }

    .row {
      display: -ms-flexbox;
      /* IE10 */
      display: flex;
      -ms-flex-wrap: wrap;
      /* IE10 */
      flex-wrap: wrap;
      margin: 0 -16px;
    }

    .col-25 {
      -ms-flex: 25%;
      /* IE10 */
      flex: 25%;
    }

    .col-50 {
      -ms-flex: 50%;
      /* IE10 */
      flex: 50%;
    }

    .col-75 {
      -ms-flex: 75%;
      /* IE10 */
      flex: 75%;
    }

    .col-25,
    .col-50,
    .col-75 {
      padding: 0 16px;
    }

    .container {
      background-color: transparent;
      padding: 5px 20px 15px 20px;
      border-radius: 3px;
    }

    input[type=text] {
      color: black;
      width: 100%;
      margin-bottom: 20px;
      padding: 12px;
      border: 1px solid #ccc;
      border-radius: 3px;
    }

    label {
      color: black;
      margin-bottom: 10px;
      display: block;
    }

    .icon-container {
      margin-bottom: 20px;
      padding: 7px 0;
      font-size: 24px;
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

    .getEP {
      display: inline-block;
      text-align: left;
      color: black;
    }

    a {
      color: #2196F3;
    }

    hr {
      border: 1px solid lightgrey;
    }

    span.price {
      float: right;
      color: grey;
    }

    /* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */

    @media (max-width: 800px) {
      .row {
        flex-direction: column-reverse;
      }
      .col-25 {
        margin-bottom: 20px;
      }
    }
  </style>
  
</head>
 <body>
  <jsp:include page="menu-template.jsp" />
  <div class="container">
    <h1 style="color: black;">Confirm Purchase</h1>

    <div class="row">
      <div class="col-75">
        <div class="container">
              <div class="col-50">
              <form action="/u/payment" method="post">
                <h3 style="color:black;">Payment</h3>
                <p>Total payment: $<span>${booking.totalPrice}</span></p>
                <label for="fname">Accepted Cards</label>
                <div class="icon-container">
                  <i class="fa fa-cc-visa" style="color:navy;"></i>
                  <i class="fa fa-cc-amex" style="color:blue;"></i>
                  <i class="fa fa-cc-mastercard" style="color:red;"></i>
                  <i class="fa fa-cc-discover" style="color:orange;"></i>
                </div>
                <label for="cname">Name on Card</label>
                 <input type="text" id="cname" name="name" placeholder="John More Doe"> 

                 <!--<div class="getEP">
                  <input type="checkbox" style="color:black;">Use Saved Card Ending in 1234 
                </div>-->
                <br>
                <br>

                <label for="ccnum">Credit card number</label>
                <input type="text" id="ccnum" name="cardNumber" placeholder="1111-2222-3333-4444">
                <label for="expmonth">Exp Month</label>
                <input type="text" id="expmonth" name="month" placeholder="September">
                <div class="row">
                  <div class="col-50">
                    <label for="expyear">Exp Year</label>
                    <input type="text" id="expyear" name="year" placeholder="2018">
                  </div>
                  <div class="col-50">
                    <label for="cvv">CVV</label>
                    <input type="text" id="cvv" name="cvv" placeholder="352">
                  </div>
                </div>
                <input type="submit" value="Confirm Purchase" class="btn">
                <input type="button" value="Cancel Purchase" class="btn btn-danger">
                </form>
              </div>
            </div>
            <!-- <input type="button" value="Confirm Purchase" class="btn"> -->
          <!--<input type="button" value="Cancel Purchase" class="btn btn-danger">  -->
        </div>
      </div>

    </div>
  </body>
</html>