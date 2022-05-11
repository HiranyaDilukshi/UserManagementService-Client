<%@ page import="com.User"%>

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
      <script src="Components/userdetails.js"></script>
      
      <title>User Service</title>
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
      	<h3>Electricity Consumers Details Management</h3>
      	<button id="logoutButton" class="btn btn-danger">Logout</button>
      </div>
      <br>
      <form id="formUser" name="formUser" method="post" action="clientdetails.jsp">
      <div class="mb-3">
      <label for="accountno" class="form-label">Account Number</label>
      <input class="form-control" name="accountno" id="accountno" type="text" aria-describedby="usernameHelp">
   </div>
   <div class="mb-3">
         <div class="mb-3">
            <label for="username" class="form-label">User Name</label>
            <input class="form-control" name="username" id="username" type="text" aria-describedby="usernameHelp">
         </div>
         <div class="mb-3">
         <div class="mb-3">
            <label for="useremail" class="form-label">User Email</label>
            <input class="form-control" name="useremail" id="useremail" type="text" aria-describedby="usernameHelp">
         </div>
         <div>
            <div class="row">
               <div class="col">
                  <div class="mb-3">
                     <label for="userphone" class="form-label">Contact Number</label>
                     <input class="form-control" name="userphone" id="userphone" type="text" aria-describedby="contactnoHelp">
                  </div>
               </div>
               <div class="col">
                  <div class="col">
                     <div class="mb-3">
                        <label for="useraddress" class="form-label">User Address</label>
                        <input class="form-control"  name="useraddress" type="text" id="useraddress" aria-describedby="addressHelp" >
                     </div>
                  </div>
               </div>
            </div>
          
            <div class="mb-3">
               <label for="usernic" class="form-label">User NIC</label>
               <input class="form-control" id="usernic" name="usernic" type="text" aria-describedby="nicHelp">
            </div>
          
            <br>
            <input id="btnSave" name="btnSave" type="button" value="Save"
			 class="btn btn-primary">
            <input type="hidden" id="hidUserIDSave" name="hidUserIDSave" value="">
          						 
          
      </form>
     
     

  	<div id= "alertSuccess" class="alert alert-success"></div>
   	<div id = "alertError" class="alert alert-danger"></div>
      
      
      <div id ="divUsersGrid">
		<%
			 User userObj = new User(); 
	 		 out.print(userObj.readUsers()); 
		%>
</div>
   
	
   

      </div>
      <!--grid -->
      <!--end grid -->
      <!-- Option 1: Bootstrap Bundle with Popper -->
    
   </body>
</html>