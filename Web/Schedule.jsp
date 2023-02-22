<%-- 
    Document   : Schedule
    Created on : Feb 8, 2023, 3:51:31 PM
    Author     : Marc-Henry Moise Jr
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BusinessObjects.Schedule"%>
<%@page import="BusinessObjects.Schedulelist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
        <link rel="stylesheet" href="sched.css">
        <title>Schedule</title>
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
       
        <table class="content-table " style="width:80%; position: relative; left: 10%; margin-top: 5%">
            
            <%
                Schedulelist schedules = new Schedulelist();
                List<Schedule> list = schedules.getDbSchedule();
                
                for(Schedule l :  list) {%>
             
                <thead class="thead-light">
                <tr>
                    <th>Id</th>
                    <th>NailArtist Id</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Schedule</th>
                    <th class="">Action</th>
                </tr>
            </thead>
            <tr>
                <td><%=l.getId()%></td>
                <td><%=l.getnaid()%></td>
                <td><%=l.getfirstname()%></td>
                <td><%=l.getlastname()%></td>
                <td><%=l.getSchedule()%></td>
                <td class="">
                    <a class='btn btn-info btn-xs' href="PatientEditAppointmentServlet?id=<span class="glyphicon glyphicon-edit "></span> Edit</a>
                    <a href="#" class="btn btn-danger btn-xs"><span
                            class="glyphicon glyphicon-remove"></span> Del</a>
                </td>
            </tr>
            <%}%>
        %>
            
        </table>
    </body>
</html>
