<%-- 
    Document   : AdmDashBoard
    Created on : Jan 21, 2023, 3:32:53 PM
    Author     : Marc-Henry Moise Jr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BusinessObjects.Admins"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Alkatra&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="Admacc.css">
        <title>Admin Dashboard</title>
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
        <jsp:useBean id="A1" scope="session" class="BusinessObjects.Admins"/>
        <h2 style="position: relative;left: 175px; color: #ffffff;">
            <h1> Welcome  <jsp:getProperty property="firstname" name="A1"/>  </h1>
            <table class="content-table">
                <thead>
                    <tr>
                        <th>Admin Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>email</th>
                        <th>Phone Number</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><jsp:getProperty property="admin_id" name="A1"/></td>
                        <td><jsp:getProperty property="firstname" name="A1"/></td>
                        <td><jsp:getProperty property="lastname" name="A1"/></td>
                        <td><jsp:getProperty property="email" name="A1"/></td>
                        <td><jsp:getProperty property="phonenumber" name="A1"/></td>


                    </tr>

                </tbody>
            </table>
            <a href="Schedule.jsp"><button class="btn">View workers schedule</button></a>
            <a href="Procedures.jsp"><button class="btn"> View Procedures</button></a>
            <a href="AdmUpdatePage.jsp"><button class="btn">Update Profile</button></a>
               <form action="LogoutServletAdm" method="post"style="display: inline-block; margin-left: 8px;">
    <button type="submit" class="btn btn-danger">Logout</button>
</form>

    </body>
</html>
