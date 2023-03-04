<%-- 
    Document   : ViewAppt
    Created on : Feb 17, 2023, 2:54:54 PM
    Author     : Marc-Henry Moise Jr
--%>



<%@page import="BusinessObjects.Customers"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BusinessObjects.Appointments"%>
<%@page import="BusinessObjects.Appointmentlist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
        <link rel="stylesheet" href="sched.css">

        <title>Adm Register Form</title>
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

        <!--<div class="container">-->

        <div class="form__text">Book Appointment</div>
        <form action="BookAppointmentServlet" method="POST">
            <table class="content-table " style="width:80%">

                <%
                    Customers c1 = (Customers) session.getAttribute("c1");
                    Appointmentlist appt = new Appointmentlist();
                    List<Appointments> list = appt.getcustAppt(c1.getCustomer_ID());
                    for (Appointments l : list) {%>
                <thead class="thead-light">
                    <tr>
                        <th>Appointment</th>
                        <th> Customer Id</th>
                        <th>Procedure Code</th>
                        <th>NailArtist Id</th>
                        <th class="">Action</th>
                    </tr>
                </thead>
                <tr>
                    <td><%=l.getapptdt()%></td>
                    <td><%=l.getcustomerId()%></td>
                    <td><%=l.getproccode()%></td>
                    <td><%=l.getartists_Id()%></td>

                    <td class=" d-none text-center">
                        
                        <a class='btn btn-info btn-xs' href="EditAppt"><span class="glyphicon glyphicon-edit "></span> Edit</a>
                       
                        <a href="#" class="btn btn-danger btn-xs"><span
                                class="glyphicon glyphicon-remove"></span> Del</a>
                    </td>
                </tr>
                <%}
                %>
            </table>
        </form> 
    </div>
</div>
<%-- <p> Values entered: <%= patientID%> + ${param.date}  + ${param.NailArtist} + ${param.proc_code} </p> --%>

</body>
</html> 
