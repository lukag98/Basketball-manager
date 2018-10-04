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
  
  <a href="Direktor" class="w3-button w3-bar-item">Home</a>
  <a href="Stadium" class="w3-button w3-bar-item">Stadium</a>
  <a href="Roster" class="w3-button w3-bar-item">Team</a>
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
        <table cellspacing="0" cellpadding="0" id="table_one" >
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
                
                <form action="/WebApplication1/Unesi">
                    <td><input type="text" name="ime"</td>             
                    <td><input type="text" name="prezime"></td>
                    <td><input type="text" name="pozicija"></td>
                    <td><input type="text" name="datum"></td>
                    <td><input type="text" name="plata"></td>
                    <td><input type="submit" name="submit" value="enter" ></td>
                   
                </form>
              
        </table>
           
      
             <table  cellspacing="0" cellpadding="0" id="table_two" >
              <tr>
                <th>Players</th>
            </tr>
            <tr>
     <th>Firstname</th>
                </tr>
            <c:forEach items="${listaigraca}" var="igrac">
                  <tr>
                    <td>${igrac.ime}</td>                  
                </tr>
                </c:forEach>
             </table>
              <table  cellspacing="0" cellpadding="0" id="table_two" >
            <tr>
                <th colspan="2">Managers</th>
            </tr>
            <tr>
     
    <th>Firstname</th>
    <th>Lastname</th>
  
                </tr>
              
            <c:forEach items="${listamenadzera}" var="menadzer" >
                
                <tr>
                    <td>${menadzer.ime}</td>
                    <td>${menadzer.prezime}</td>
                    
                    
                </tr>
                
            </c:forEach>
              <form action="/WebApplication1/UnesiM">
                 
                    <td><input type="text" name="mime"</td>             
                    <td><input type="text" name="mprezime"></td>
                    <td><input type="submit" name="submit" value="ent" style="width: 30px" ></td>
                   
                </form>
        </table >
       <table  cellspacing="0" cellpadding="0" id="table_three" >
           <tr>
               <th>*</th>
               <th>Firstname</th>
               <th>Lastname</th>
               <th>TranfserPrice($)</th>
           </tr>

            <c:forEach items="${listatransfera}" var="transfer">
                
                <tr>
                    <th>Tranfser</th>
                    <td>${transfer.ime}</td>
                    <td>${transfer.prezime}</td>
                    <td>${transfer.cena}</td>
                    
                    
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
               <th>*</th>
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
#table_two {
    display: inline-table;

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
        
           </section> 
  <footer class="w3-container w3-padding-64 w3-center w3-black w3-xlarge">
  <p class="w3-medium">
  <a target="_blank">Golden State Warriors</a>
  </p>
</footer>
        </div>
    </body>
</html>