














<!doctype html>
<html lang="en">
   <head>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- Bootstrap CSS -->
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
      <link rel="stylesheet" href="styles.css">
      <link rel="stylesheet" type="text/css" href="Views/users.css">
      
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
      	<h4>User Service Management</h4>
      	<button id="logoutButton" class="btn btn-danger">Logout</button>
      </div>
      <br>
      
      
      <div class="head01">
         <h2>Customers</h2>
      </div>
      <center>
         <form action="insertsub" method="POST" onsubmit="checkpassword()">
            <button class="btn1" type="button" id="button1" href="subscriptionlibrary.jsp" name="beginner" onclick="loadData(button1)">
            
               <div class="name">
                  <h3>Electricity Consumers Details</h3>
               </div>
               <br><br>
               <div class="price">
                 
                  <br>
                  <a   class="pay" href="clientdetails.jsp">View</a>
               </div>
            </button>
            <button class="btn1" type="button" id="button2" name="standard" onclick="loadData(button2)">
               <div class="name">
                  <h3>Electricity Account Details</h3>
               </div>
               <br><br>
               <div class="price">
                
                  <br>
                  <a   class="pay" href="electricityaccountdetails.jsp">view</a>
               </div>
            </button>
           
            <h2 class="text01" id="header"></h2>
            <p class="text02" id="para"></p>
      </center>
      <br><br>
    
      </form>

     
    
      <!--grid -->
      <!--end grid -->
      <!-- Option 1: Bootstrap Bundle with Popper -->
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
      <script
         src="https://code.jquery.com/jquery-3.6.0.js"
         integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
         crossorigin="anonymous"></script>
      <script src="script.js"></script>
   </body>
</html>