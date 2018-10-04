<%-- 
    Document   : secondpage
    Created on : Jul 10, 2018, 12:48:22 PM
    Author     : Luka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css">

</head>
<body>
    <nav class="w3-bar w3-black">
  <a href="Direktor" class="w3-button w3-bar-item">Home</a>
  <a href="Stadium" class="w3-button w3-bar-item">Stadium</a>
  <a href="Roster" class="w3-button w3-bar-item">Team</a>
  <a href="index" class="w3-button w3-bar-item">Logout</a>
  
</nav> 
 <!-- Navigation -->
<nav class="w3-bar w3-black">
  
</nav> 
 <!-- Slide Show -->
<section>
  <img class="mySlides" src="https://www.nba.com/warriors/sites/warriors/files/getty-images-968727724.jpg" width="100%" height="700">
  <img class="mySlides" src="https://www.nba.com/warriors/sites/warriors/files/getty-images-968727700.jpg" width="100%" height="700">
  <img class="mySlides" src="https://www.nba.com/warriors/sites/warriors/files/getty-images-968727684.jpg" width="100%" height="700">
</section>
<section class="w3-container w3-center w3-content" style="max-width:600px">
  <h2 class="w3-wide">Golden State Warriors</h2>
  <p class="w3-opacity"><i>Basketball team</i></p>
  <p class="w3-justify">The Golden State Warriors are an American professional basketball team based 
 in the San Francisco Bay Area in Oakland, California. The Warriors compete in the National Basketball Association 
 (NBA) as a member of the league's Western Conference Pacific Division. The Warriors play their home games at the Oracle Arena 
 in Oakland. The Warriors have reached ten NBA Finals, winning six NBA championships in 1947,[b] 1956, 1975, 2015, 2017, and 2018. 
 Golden State's six NBA championships are tied for third-most in NBA history with the Chicago Bulls, and behind only the 
 Boston Celtics (17) and Los Angeles Lakers (16).</p>
 
        <table>
            <tr>
                <th>Name</th>
    <th>Founded</th>
    <th>Championships</th>
    <th>Team Payroll</th>
    <th>Team Payroll Rank</th>
                </tr>
            <c:forEach items="${listakluba}" var="klub">
                
                <tr>
                    <td>${klub.naziv}</td>
                    <td>${klub.osnivanje}</td>
                    <td>${klub.trofeji}</td>
                    <td>${klub.isplata}</td>
                    <td>${klub.rank}</td>
                    
                </tr>
                
            </c:forEach>
                
        </table>
  <style>
      table, td, th {
    border: 1px solid black;
}
  </style>
</section>
 
   <section class="w3-row-padding w3-center w3-light-grey">
  <article class="w3-third">
      <c:forEach items="${listadresova}" begin="0"end="0" var="dresovi"><p>${dresovi.boja}</p><p>${dresovi.brend}</p></c:forEach>
    <img src="https://images.footballfanatics.com/FFImage/thumb.aspx?i=/productimages/_2802000/ff_2802252_full.jpg&w=340"  style="width:100%">
  </article>
  <article class="w3-third">
     <c:forEach items="${predsednik}" var="predsednik"><p>${predsednik.ime}</p><p>${predsednik.prezime}</p></c:forEach>
    <img src="https://i2.wp.com/jenniferbrownspeaks.com/wp-content/uploads/2017/04/RickWelts_4x6.jpg?fit=800%2C1200"  style="width:70%">
  </article>
  <article class="w3-third">
  <c:forEach items="${listadresova}" begin="1" end="1" var="dresovi"><p>${dresovi.boja}</p><p>${dresovi.brend}</p></c:forEach>
    <img src="https://images.footballfanatics.com/FFImage/thumb.aspx?i=/productimages/_2800000/ff_2800758_full.jpg&w=340"  style="width:100%">
  </article>
</section> 
  <footer class="w3-container w3-padding-64 w3-center w3-black w3-xlarge">
  <p class="w3-medium">
  <a target="_blank">Golden State Warriors</a>
  </p>
</footer>
 <script>
// Automatic Slideshow
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}
    x[myIndex-1].style.display = "block";
    setTimeout(carousel, 4000);
}
</script>

 
</body>
</html>
