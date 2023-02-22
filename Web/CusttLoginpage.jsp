<%-- 
    Document   : PatientLoginpage
    Created on : Jan 18, 2023, 3:51:33 PM
    Author     : Marc-Henry Moise Jr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
    <link rel="stylesheet" href="Styles.css">
    <title>Login Form</title>
  </head>
  
  <body>
  <div class="menu-bar">
      <h1 class="logo">New<span> Nails Salon</span></h1>
      <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Login<i class="fas fa-caret-down"></i></a>
            <div class="dropdown-menu">
                <ul>
                  <li><a href="AdmLoginPage.jsp">Admin</a></li>
                  <li>
                    <a href="CusttLoginpage.jsp">Customer<i class="fas fa-caret-right"></i></a>
                    
                    <div class="dropdown-menu-1">
                      <ul>
                        <li><a href="CusttLoginpage.jsp">Login</a></li>
                        <li><a href="CustRegForm.jsp">Register</a></li>
                      </ul>
                    </div>
                  </li>
                </ul>
              </div>
        </li>
        <li><a href="#">Blog</a>
        </li>
        <li><a href="#">Contact us</a></li>
      </ul>
    </div>
    <section class="hero">
      <div class="container">
        <form action="CustLoginServlet" method="post" >
            
          <div class="form__text">Login</div>

          <div class="form__group">
            <label for="text" class="form__label">CustomerID</label>
            <input
              type="text"
              placeholder="C***"
              name="CID"
              required
              class="form__input"
            />
          </div>

          <div class="form__group">
            <label for="password" class="form__label">Password</label>
            <input
              type="password"
              placeholder="********"
              name="password"
              required
              class="form__input"
            />
          </div>

          <div class="forgot">Forgot password ?</div>

          <div class="form__button">
            <button class="btn" type="submit">Login</button>
          </div>

        <div class="sign">Not yet member? <a href="CustRegForm.jsp" class ="signup">Signup now</a></div>
        </form>
  </div>
         
        
      </div>
    </section>
  </body>
  </form>
</html>