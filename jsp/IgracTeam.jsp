<%-- 
    Document   : Roster
    Created on : Jul 13, 2018, 2:41:21 PM
    Author     : Grupa5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   
    <head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css">

    </head>
    <body>
         <nav class="w3-bar w3-black">
  
  <a href="Igrac" class="w3-button w3-bar-item">Home</a>
  <a href="IgracTeam" class="w3-button w3-bar-item">Team</a>
   <a href="index" class="w3-button w3-bar-item">Logout</a>
  
  
</nav> 
        <style>
 body{
     background-color: #f2f2f2;   
            }

         <%-- okvir tabele --%>
table, td, th {
    border: 1px solid black;
}

table {
    border-collapse: collapse;
    width: 100%;
}

th {
    height: 50px;
    background-color: #ffffff;
}
td{
     background-color: #dddddd;
}
</style>
        <div id="contents" >
        <table cellspacing="0" cellpadding="0" id="table_one">
              <tr>
                <th colspan="5">Players</th>
            </tr>
            <tr>
    <th>Firstname</th>
    <th>Lastname</th>
    <th>Position</th>
    <th>Dob</th>
    <th>Salary</th>
    
                </tr>
            <c:forEach items="${listaigraca}" var="igrac">
                
                <tr>
                    <td>${igrac.ime}</td>
                    <td>${igrac.prezime}</td>
                    <td>${igrac.pozicija}</td>
                    <td>${igrac.datumRodjenja}</td>
                    <td>${igrac.plata}</td>
                </tr>
                
            </c:forEach>
                
        </table>
       
           
  
            <table  cellspacing="0" cellpadding="0" id="table_four" >
           <tr>
               <th>*</th>
               <th>Firstname</th>
               <th>Lastname</th>
               <th>Age</th>
           </tr>
            <c:forEach items="${listatrenera}" var="trener">
                
                <tr>
                    <th>Coach</th>
                    <td>${trener.ime}</td>
                    <td>${trener.prezime}</td>
                    <td>${trener.godine}</td>
                    
                    
                </tr>
                
            </c:forEach>
                
        </table> 
              <table  cellspacing="0" cellpadding="0" id="table_four" >
           <tr>
               <th>*</td>
               <th>Firstname</th>
               <th>Lastname</th>
               <th>Date of Birth</th>
           </tr>
            <c:forEach items="${pomocni}" var="pomocni">
                
                <tr>
                    <th>2ndCoach</th>
                    <td>${pomocni.ime}</td>
                    <td>${pomocni.prezime}</td>
                    <td>${pomocni.datumrodjenja}</td>
                    
                    
                </tr>
                
            </c:forEach>
                
        </table> 
        
      <div class="clear"></div>
      </div>
        <style> <%-- pozicija tabele(centar)--%>
            #contents {
   
    margin: auto;
    width: 60%;
    padding: 100px;
    
    }

#contents table {
    width: 390px;
    }

#table_one {
    float: left;
    }

.class {
    clear: both;
    }
    #table_three{
        margin: auto;
       
        
    }
    #table_four{
         margin: auto;
        
    }
    
        </style>
        <div class="footer">
            <p>Golden State Warriors</p>
            <style>
                .footer {
  position: absolute;
  right: 0;
  bottom: 0;
  left: 0;
  padding: 1rem;
  background-color: black;
  text-align: center;
  height: 100px;
  color: white;
  text-align: center;
}
            </style>
        </div>
    </body>
</html>