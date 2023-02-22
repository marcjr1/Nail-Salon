<%-- 
    Document   : CustomerDashboard
    Created on : Jan 21, 2023, 1:08:36 PM
    Author     : Marc-Henry Moise Jr
--%>

<%@page import="java.util.List"%>
<%@page import="BusinessObjects.Appointments"%>
<%@page import="BusinessObjects.Appointmentlist"%>
<%@page import="BusinessObjects.Appointmentlist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BusinessObjects.Customers"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
        <link rel="stylesheet" href="customeracc.css">
        <title>Customer Dashboard</title>
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

        <jsp:useBean id="c1" scope="session" class="BusinessObjects.Customers"/>
        <h2 style="position: relative;left: 175px; color: #ffffff;">
            <h1> Welcome  <jsp:getProperty property="fname" name="c1"/>  </h1>
        </h2>
        <table class="content-table"style="width:38.5%">
            <thead>
                <tr>
                    <th>Customer Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Address</th>
                    <th>email</th>

                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><jsp:getProperty property="customer_ID" name="c1"/></td>
                    <td><jsp:getProperty property="fname" name="c1"/></td>
                    <td><jsp:getProperty property="lname" name="c1"/></td>
                    <td><jsp:getProperty property="addr" name="c1"/></td>
                    <td><jsp:getProperty property="email" name="c1"/></td>


                </tr>

            </tbody>
        </table>

        <a href="BookAppointment.jsp"><button class="btn">Book Appointment</button></a>
        <a href="ViewAppt.jsp"><button class="btn">View Appointment</button></a>
        <a href="Procedures.jsp"><button class="btn"> View Procedures</button></a>
        <a href="UpdatePatientProfile.jsp"><button class="btn">Update Profile</button></a>
        
        <form action="BookAppointmentServlet" method="POST">
            <table class="content-table " style="width:80%">

                <%
                    Appointmentlist appt = new Appointmentlist();
                    List<Appointments> list = appt.getcustAppt(c1.getCustomer_ID());
                    if (list != null) {

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
                        <%--
                        <a class='btn btn-info btn-xs' href="PatientEditAppointmentServlet?id=<%=a.getId()%>"><span class="glyphicon glyphicon-edit "></span> Edit</a>
                        --%>
                        <a href="#" class="btn btn-danger btn-xs"><span
                                class="glyphicon glyphicon-remove"></span> Del</a>
                    </td>
                </tr>
                <%}
                
                }%>

            </table>
        </form> 
   
                <script>
                       <%
                        int list_lenght = list.size();
                       %>
                        var list_length = '<%=list_lenght%>';
                        var date = new Date();
                        var fulldate =  date;
                        
                        if(list_length){
                            alert("You don't have any appointment scheduled on " + fulldate);
                        }
                     
                </script>

    </body>
</html>
