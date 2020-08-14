<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Swipe Fur Pet | Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/register.css">

</head>
<body>
    <!-- Navbar-->
    <header class="header">
        <nav class="navbar navbar-expand-lg navbar-light py-3">
        <div class="container">
            <!-- Navbar Brand -->
            <a href="pickRegister.html" class="navbar-brand">
            <img src="img/active-pets.svg" alt="logo" width="50">
            </a>
        </div>
        </nav>
    </header>
  
  
  <div class="container">
    <div class="row py-5 mt-4 align-items-center">
      <div class="col-md-5 pr-lg-5 mb-5 mb-md-0">
        <img src="img/login.svg" alt="" class="img-fluid mb-3 d-none d-md-block">
      </div>
  
      <!-- Registeration Form -->
      <div class="col-md-7 col-lg-6 ml-auto">
        <form action="edit.html" method="POST">
          <div class="row">
  
            <!-- Email Address -->
            <div class="input-group col-lg-12 mb-4">
              <div class="input-group-prepend">
                <span class="input-group-text bg-white px-4 border-md border-right-0">
                  <i class="fa fa-envelope text-muted"></i>
                </span>
              </div>
              <input id="email" type="email" name="email" placeholder="Email Address" class="form-control bg-white border-left-0 border-md">
            </div>

            <div class="col-lg-12 mb-4">
              <div id="email-invalid" class="text-danger missing-entries"></div>
              <h5><% if (request.getAttribute("exists")) { %>Email exists<%} %></h5>
            </div>

            <!-- Password -->
            <div class="input-group col-lg-12 mb-4">
                <div class="input-group-prepend">
                  <span class="input-group-text bg-white px-4 border-md border-right-0">
                    <i class="fa fa-lock text-muted"></i>
                  </span>
                </div>
                <input id="password" type="password" name="password" placeholder="Password" class="form-control bg-white border-left-0 border-md">
                <!-- <h5><% if (request.getAttribute("exists")) { %>Email exists<%} %></h5> -->
            </div>

            <div class="col-lg-12 mb-4">
              <div id="pw-invalid" class="text-danger missing-entries"></div>
            </div>
  
            <!-- Submit Button -->
            <div class="form-group col-lg-12 mx-auto mb-0">
              <button type="submit" class="btn btn-primary btn-block py-2">
                <span class="font-weight-bold">Login</span>
              </button>
            </div>
  
            <!-- Registration -->
            <div class="text-center w-100">
              <p class="text-muted font-weight-bold">Need an account? <a href="pickRegister.html" class="text-primary ml-2">Sign up!</a></p>
            </div>
  
          </div>
        </form>
      </div>
    </div>
  </div>
  
  
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <script src="js/login.js"></script>

</body>
</html>