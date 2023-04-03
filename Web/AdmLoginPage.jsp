<%-- 
    Document   : AdmLoginPage
    Created on : Jan 20, 2023, 3:10:57 PM
    Author     : Marc-Henry Moise Jr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Alkatra&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="adm.css">
        <title>Admin Login Form</title>
    </head>

    <body>
           <div class="menu-bar">
            <h1 class="logo">New<span> Nails Salon</span></h1>
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="Procedures.jsp">Services</a></li>
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
                <li><a href="hours.html">Hours</a>
                </li>
                <li><a href="#">Contact us</a></li>
            </ul>
        </div>
        <section class="hero">
            <div class="container">
                <form action="AdmlogServlet" method="post" >

                    <div class="form__text">Admin Login</div>

                    <div class="form__group">
                        <label for="text" class="form__label">Admin ID</label>
                        <input
                            type="text"
                            placeholder="A***"
                            name="AdmID"
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

                    <div class="sign">Add a new Admin: <a href="AdmRegForm.jsp" class ="signup">Register now</a></div>
                </form>
            </div>


        </section>
    </body>

</html>