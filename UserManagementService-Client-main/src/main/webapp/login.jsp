<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/logindetails.js"></script>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

<title>Login Service</title>
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





<div class="container" style="padding: 50px">
<div class="jumbotron">
  <form id="formLogin">
  <div class="form-group">
    <label for="username">Username</label>
    <input id="txtUsername" name="txtUsername" type="text">
   
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input id="txtPassword" name="txtPassword" type="password">
  </div>
  <div style="margin-top: 40px">
  <input id="btnLogin" name="btnLogin" type="button" value="Login"
  class="btn btn-primary">
  </div>
 
</form>
</div>
  		</div>
  		
  		

</body>
</html>