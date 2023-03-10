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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
    <link rel="stylesheet" href="Admacc.css">
    <title>Admin Dashboard</title>
  </head>
  <body>
  <div class="menu-bar">
      <h1 class="logo">New<span> Nails Salon</span></h1>
      <ul>
        <li><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Login<i class="fas fa-caret-down"></i></a>
            <div class="dropdown-menu">
                <ul>
                  <li><a href="#">Admin</a></li>
                  <li>
                    <a href="#">Customer<i class="fas fa-caret-right"></i></a>
                    
                    <div class="dropdown-menu-1">
                      <ul>
                        <li><a href="#">Login</a></li>
                        <li><a href="#">Register</a></li>
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
	   <a href="Schedule.jsp"><button>View workers schedule</button></a>
                <a href="OurProcedures.jsp"><button> View Procedures</button></a>
                <a href="UpdatePatientProfile.jsp"><button>Update Profile</button></a>
                <a href="UpdateAppointment.jsp"><button>Edit Appointment</button></a>
	  </body>
</html>
