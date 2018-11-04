<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <title>Sign In</title>
  
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/template.css">
</head>

<body>
  <div class="navbar-inverse navbar-default navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-brand">
        <a href="#" class="no-underline">
          <span>Movie Booking</span>
        </a>
      </div>
      <ul class="nav navbar-nav navbar-right">
        <li>
          <a href="#">Home</a>
        </li>
        <li>
          <a href="">Browse All</a>
        </li>
        <li>
          <a href="">Search</a>
        </li>
        <li>
          <a href="">About</a>
        </li>
        <li>
          <a href="">Contact</a>
        </li>
        <li>
          <a href="">Sign Up</a>
        </li>
        <li>
          <a href="">Sign In</a>
        </li>
      </ul>
    </div>
  </div>

  <div class="container">
    <h1>Sign In</h1>
    <p>Welcome back valued customer! Sign in to purchase tickets and gain access to exclusive deals and offers.</p>
    <form action="loginForm" method="post">
      <br>
      <div class="getEP">
        <p>Enter your email address:</p>
        <input type="text" name="email" id="emailAdd" placeholder="email address" size="40">
        <br>
        <p>Enter your password:</p>
        <input type="password" name="password" id="password" placeholder="password" size="40">
        <br>
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
</body>

</html>