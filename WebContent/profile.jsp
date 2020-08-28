<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Swipe Fur Pet | Profile</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
    <%@ page import="java.io.PrintWriter,
    java.sql.Connection,
    java.sql.DriverManager,
    java.sql.PreparedStatement,
    java.sql.ResultSet,
    java.sql.SQLException"%>
    <%
      Integer petID = (Integer) session.getAttribute("petID");
      String img = null;
      String pet_Name = null;
      String shelter_Name = null;
      String city = null;
      String petType = null;
      String size = null;
      String age = null;
      Integer children = 0;
      Integer dogs = 0;
      Integer cats = 0;
      String shelterID = null;
      String email = null;
      String phone = null;
      String link = null;
      Connection c = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql://localhost/SwipeFurPets?user=root&password=root&useLegacyDatetimeCode=false&serverTimezone=UTC");
        ps = c.prepareStatement("select * from Pet where PET_ID=" + petID);
        rs = ps.executeQuery();
        rs.next();
        img = rs.getString("ImgLink");
        pet_Name = rs.getString("Pet_Name");
        petType = rs.getString("PetType");
        size = rs.getString("Size");
        age = rs.getString("Age");
        children = rs.getInt("Children");
        dogs = rs.getInt("Dogs");
        cats = rs.getInt("Cats");
        shelterID = rs.getString("Rescue_ID");
        ps = c.prepareStatement("select * from Rescue where Rescue_ID=" + shelterID);
        rs = ps.executeQuery();
        rs.next();
        shelter_Name = rs.getString("Organization_Name");
        city = rs.getString("City");
        email = rs.getString("Email");
        phone = rs.getString("Phone");
        link = rs.getString("Link");
      } catch(SQLException e) {
        System.out.println("sqle: " + e.getMessage());
      } finally {
        if (rs != null)
          rs.close();
        if (ps != null)
          ps.close();
        if (c != null)
          c.close();
      }
    %>
</head>
<body>
    <!-- Navbar-->
    <header class="header">
      <nav class="navbar navbar-expand-lg navbar-light py-3">
      <div class="container">
          <!-- the nav bar if the person logged in is adopter -->
          <!-- Navbar Brand -->
          <a href="main.html" class="navbar-brand">
          <img src="img/pets.svg" alt="logo" width="50">
          </a>
          <a href="chat.html" class="navbar-brand" width="50"><img src="img/chat.svg" width="50"></a>

          <a href="edit.html" class="navbar-brand" width="50"><img src="img/edit.svg" width="50"></a>
      </div>
      </nav>
  </header>

    <aside class="profile-card">
  
    <header>
      
      <!-- here’s the avatar -->
      <!-- <a href="#"> -->
          <!-- insert image -->
        <img src="<%= img %>">
      <!-- </a> -->
  
      <!--    pet name    -->
      <h1><%= pet_Name %></h1>
      
      <!--    Shelter name    -->
      <h2><%= shelter_Name %>></h2>

      <!--    city    -->
      <h2><%= city %></h2>
      
    </header>
    
    <!-- pet information -->
    <div class="profile-bio">
      
      <p><span class="info-title">Species: </span><%= petType %></p>
      <p><span class="info-title">Size: </span><%= size %></p>
      <p><span class="info-title">Age: </span><%= age %></p>
      
    </div>
    
    <!-- good with children/dogs/cats -->
    <ul id="compatibility" class="profile-social-links">

        <!-- the graphics are 
              active-child.svg
              active-dog.svg
              active-cat.svg
              child.svg
              dog.svg
              cat.svg
          if the boolean is true, use the appropriate one with active- otherwise use regular one
         -->
        <!-- good with children-->
      <li>
        <a>
          <% if(children == 1) { %>
          <img src="img/active-child.svg" class="icon-svg">
          <% } else { %>
          <img src="img/child.svg" class="icon-svg">
          <% } %>
        </a>
      </li>
      
      <!-- good with dog  -->
      <li>
        <a>
          <% if(dogs == 1) { %>
          <img src="img/active-dog.svg.svg" class="icon-svg">
          <% } else { %>
          <img src="img/dog.svg.svg" class="icon-svg">
          <% } %>
        </a>
      </li>
      
      <!-- good with cat -->
      <li>
        <a>
          <% if(cats == 1) { %>
          <img src="img/active-cat.svg.svg" class="icon-svg">
          <% } else { %>
          <img src="img/cat.svg.svg" class="icon-svg">
          <% } %>
        </a>
      </li>
    </ul>

    <!-- pet information -->
    <div class="profile-bio">
      <h4>Shelter Info</h4>
      <p><span class="info-title"><i class="fa fa-users" aria-hidden="true"></i>
        : </span><%= shelterID %></p>
      <p><span class="info-title"><i class="fa fa-envelope" aria-hidden="true"></i>
        : </span><%= email %></p>
      <p><span class="info-title"><i class="fa fa-phone" aria-hidden="true"></i>
        : </span><%= phone %></p>
      <p><span class="info-title"><i class="fa fa-link" aria-hidden="true"></i>
        : </span><a href="#" class="shelterWebsite"><%= link %></a></p>
      
    </div>
    
  </aside>


    <script src="./js/jquery-3.3.1.min.js?9673"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <script>
        $(function () {
            $('input, select').on('focus', function () {
                $(this).parent().find('.input-group-text').css('border-color', '#80bdff');
            });
            $('input, select').on('blur', function () {
                $(this).parent().find('.input-group-text').css('border-color', '#ced4da');
            });
        });

    </script>

</body>
</html>