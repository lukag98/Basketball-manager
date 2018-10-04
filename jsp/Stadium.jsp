<%-- 
    Document   : Stadium
    Created on : Jul 13, 2018, 1:55:44 PM
    Author     : Grupa5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
       <meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css">
    </head>
    <body>
        <!-- Navigation -->
<nav class="w3-bar w3-black">
  <a href="Direktor" class="w3-button w3-bar-item">Home</a>
  <a href="Stadium" class="w3-button w3-bar-item">Stadium</a>
  <a href="Roster" class="w3-button w3-bar-item">Team</a>
  <a href="index" class="w3-button w3-bar-item">Logout</a>
  
</nav> 
       
  <img class="mySlides" src="https://c1.staticflickr.com/9/8348/8248822128_42e0a631f6_b.jpg" width="100%" height="600">
  
  <c:forEach items="${hala}" var="hala">
      <h2 align="center">Stadium: ${hala.naziv}</h2>
      <h2 align="center">Capacity: ${hala.kapacitet}</h2>
      <h2 align="center">Address: ${hala.adresa}</h2>
      </c:forEach> 
  
    </body>
</html>
