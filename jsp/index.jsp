<%-- 
    Document   : index
    Created on : Jul 10, 2018, 12:47:36 PM
    Author     : Luka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
 <meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css">
<script> 
function polja()
{ 
var username = document.getElementById("username").value;
var password = document.getElementById("password").value;
if (username==null || username=="")
{ 
alert("Username cannot be blank"); 
return false; 
}
else if(password==null || password=="")
{ 
alert("Password cannot be blank"); 
return false; 
} 
}
</script> 

    </head>
    <body>
        <style>
            body{
                 background-image: url("https://www.nba.com/warriors/sites/warriors/files/20180423_local_warriors_san_jose_jl001.jpg");
                 height: 100%;
                 background-position: center;
                 background-repeat: no-repeat;
                 background-size: cover;
            }
        </style>
        
        <div class="tittle"><h1>Log in </h1></div>
       <div class="continer">
           <div class="left"></div>
           <div class="right">
           <div class="formBox">
               <form method="post" action="/WebApplication1/secondpage" onsubmit="return polja()" >
            <p>UserName</p>
            <input type="text" name="username" id="username">
            <p>Password</p>
            <input type="password" name="password" id="password">
            <input type="submit" value="login">
            <p  style="color:red;">${message}</p>
               
         </form>
           </div>
               </div>
           
            <style>
           .tittle{
               text-align: center;
               padding: 50px 0 20px;
           }
           .tittle h1{
               margin: 0;
               padding: 0;
               color: #666;
               text-transform: uppercase;
               font-size: 36px;
           }
           .continer{
               width: 50%;
               height: 400px;
               background: #357ae8;
               margin: 0 auto;
               border: 2px solid #fff;
               box-shadow: 0 15px rgba(0,0,0,.5);
           }
           .continer .left{
               float: left;
               width: 50%;
               height: 400px;
               background: url(https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/be2eff34879743.56e10809762c5.jpg);
               background-size: cover;
               box-sizing: border-box;
           }
           .continer .right{
               float: right;
               width: 50%;
               height: 400px;
               box-sizing: border-box;
               
           }
           .formBox{
               width: 100%;
               padding: 80px 40px;
               box-sizing: border-box;
               height: 400px;
               
           }
           .formBox p {
               margin: 0;
               padding: 0;
               font-weight: bold;
               
           }
           .formBox input{
               margin-bottom: 20px;
           }
           .formBox input[type="text"],
           .formBox input[type="Password"]
           {
               border: none;
               border-bottom: 2px ;
               outline: none;
               height: 30px;
               width: 100%;
           }
            .formBox input[type="text"]:focus,
           .formBox input[type="Password"]:focus
           {
               border-bottom: 2px;
           }
           .formBox input[type="submit"]
           {
               border: none;
               outline: none;
               height: 40px;
               color: #fff;
               background: #262626;
               cursor: pointer;
               width: 100%;
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
  height: 110px;
  color: white;
  text-align: center;
}
            </style>
        </div>

    </body>
</html>
