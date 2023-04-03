<%-- 
    Document   : CustRegForm
    Created on : Jan 20, 2023, 8:04:11 PM
    Author     : Marc-Henry Moise Jr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BusinessObjects.Customers"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Alkatra&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="cfr.css">
        <title>Customer Register Form</title>
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
        <div class="container">
            <form action="CustRegServlet" method="post" >
                <div class="form__text">Register</div>
                <jsp:useBean id="c1" scope="session" class="BusinessObjects.Customers"/>
                <div class="form__group">
                    <input
                        type="text"
                        class="form__input"
                        placeholder="Customer ID"
                        name="Customer ID"
                        required
                        />
                    <label for="Customer ID" class="form__label">
                        Customer ID
                    </label>
                </div>
                <div class="form__group">
                    <input
                        type="text"
                        class="form__input"
                        placeholder="First Name"
                        name="firstname"
                        required
                        />
                    <label for="firstname" class="form__label">
                        First Name
                    </label>
                </div>
                <div class="form__group">
                    <input
                        type="text"
                        class="form__input"
                        placeholder="Last Name"
                        name="lastname"
                        required
                        />
                    <label for="lastname" class="form__label">
                        Last Name
                    </label>
                </div>
                <div class="form__group">
                    <input
                        type="text"
                        class="form__input"
                        placeholder="Address"
                        name="Address"
                        required
                        />
                    <label for="Address" class="form__label">
                        Address
                    </label>
                </div>
                <div class="form__group">
                    <input
                        type="email"
                        class="form__input"
                        placeholder="Email"
                        name="email"
                        required
                        />
                    <label for="email" class="form__label">
                        Email
                    </label>
                </div>

                <div class="form__group">
                    <input
                        type="password"
                        class="form__input"
                        placeholder="Password"
                        name="password"
                        required
                        />
                    <label for="password" class="form__label">
                        Password
                    </label>
                </div>
                <div class="form__button">
                    <button class="btn" type="submit">Submit</button>
                </div>
                <div class="form__social">
                    <div class="sign">Or Sign up using</div>
                    <div class="social__icon">
                        <i class="fab fa-facebook-f"></i>
                        <i class="fab fa-twitter"></i>
                        <i class="fab fa-google"></i>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
