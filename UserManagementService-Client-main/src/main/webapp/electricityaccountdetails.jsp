<%@ page import="com.Account"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
   <head>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- Bootstrap CSS -->
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
   
      <script src="Components/jquery-3.2.1.min.js"></script>
      <script src="Components/accountdetails.js"></script>
      
      
      <title>User Service</title>
      <style>
         .show {
         display: "block";
         }
         .hide {
         display: "none";
         }
      </style>
   </head>
   <body>
      <!--Nevabr -->
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
         <div class="container-fluid">
            <a class="navbar-brand" href="#">User Management Service</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
            
               <form class="d-flex">
                  <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn btn-outline-success" type="submit">Search</button>
               </form>
            </div>
         </div>
      </nav>
      <!--end Nevbar -->
      <br>
      <div class="container">
      <div style="display: flex; flex-direction: row; justify-content: space-between">
      	<h3>Electricity Account Details Management Service</h3>
      	<button id="logoutButton" class="btn btn-danger">Logout</button>
      </div>
      <br>
      <form id="formAccount" name="formAccount" method="post" action="electricityaccountdetails.jsp">
      <div class="mb-3">
      <label for="accountno" class="form-label">Account Number</label>
      <input class="form-control" name="accountno" id="accountno" type="text" aria-describedby="usernameHelp">
   </div>
         <div class="mb-3" >
            <label for="premisesid" class="form-label">Premises ID</label>
            <input class="form-control" id="premisesid" name="premisesid" >
         </div>
         <div class="mb-3">
            <label for="areaoffice" class="form-label">Area Office</label>
            <input class="form-control" id="areaoffice" name="areaoffice">
         </div>
         
         <div>
            <div class="row">
               <div class="col">
                  <div class="mb-3">
                     <label for="tarifftype" class="form-label">Tariff Type</label>
                     <input class="form-control" id="tarifftype" name="tarifftype">
                  </div>
               </div>
               <div class="col">
                  
               </div>
            </div>
           
            <br>
            <input id="btnSave" name="btnSave" type="button" value="Save"
			 class="btn btn-primary">
           <input type="hidden" id="hidAccountIDSave" name="hidAccountIDSave" value="">
      </form>
      

    	<div id= "alertSuccess" class="alert alert-success"></div>
     	<div id = "alertError" class="alert alert-danger"></div>
     	<br>
        <br>   
        <div id ="divAccountsGrid">
  		<%
  			 Account accObj = new Account(); 
  	 		 out.print(accObj.readAccounts()); 
  		%>
  </div>
     
      </div>
      <!--grid -->
      <!--end grid -->
      
   </body>
</html>