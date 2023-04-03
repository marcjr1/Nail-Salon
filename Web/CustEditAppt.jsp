<%-- 
    Document   : CustEditAppt
    Created on : Mar 1, 2023, 1:51:08 PM
    Author     : Marc-Henry Moise Jr
--%>

<%@page import="BusinessObjects.Appointments"%>
<%@page import="BusinessObjects.Customers"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Alkatra&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="Anfr.css">

        <title>Edit Appointment Form</title>
    </head>
    <body>
        <%
            Customers c1;
            c1 = (Customers) session.getAttribute("c1");
            String cid = c1.getCustomer_ID();
            Appointments appt;
            appt = (Appointments) session.getAttribute("appt");
            String apt = appt.getcustomerId();
            String id = (String) session.getAttribute("id");


        %>

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

            <div class="form__text">Book Appointment</div>

            <form action="EditAppt2" method="POST">
                <p>
                    <label class="Nid">Pick a new date</label><br>
                    <input class="proc" type="date" name="date" value="<%=appt.getapptdt()%>" required>
                </p>
                <p>
                    <label class="Nid">Pick a new time </label><br>
                    <input class="proc" type="time" name="time" value="<%=appt.getapptdt()%>" required>
                </p>
                <p><label class="Nid">Choose a  procedure</label></p>
                <p>

                    <select class="proc" name="proc_code" required>Chiropractor 

                        <option value="<%=appt.getproccode()%>"><%=appt.getproccode()%></option>
                        <option value="P110">P110</option>
                        <option value="P111">P111</option>
                        <option value="P112">P112</option>
                        <option value="P113">P113</option>
                        <option value="P114">P114</option>

                    </select>
                </p>



                <p><label class="Nid">Choose a Nail ArtistId</label></p>
                <p>
                    <select class="proc" name="NailArtist" required>Nail Artists
                        <option value="<%=appt.getartists_Id()%>"><%=appt.getartists_Id()%></option>
                        <option value="W200">W200</option>
                        <option value="W201">W201</option>
                        <option value="W202">W202</option>
                        <option value="W203">W203</option>
                        <option value="W204">W204</option>
                        <option value="W205">W205</option>

                    </select>
                </p>
                <button type="button" class="btn" name="modal">Cancel</button>
                <button type="submit" class="btn"  name="submit">Edit Appointment</button>
            </form> 

        </div>
    </div>
    <script>
        alert("Sorry we are close on saturdays and sundays");
    </script>
    <%
        session.setAttribute("setID", id);
    %>
</body>
<%-- <p> Values entered: <%= patientID%> + ${param.date}  + ${param.NailArtist} + ${param.proc_code} </p> --%>


</html >

