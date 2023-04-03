<%-- 
    Document   : BookAppointment
    Created on : Feb 6, 2023, 11:22:30 AM
    Author     : Marc-Henry Moise Jr
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Alkatra&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="Anfr.css">
        <title>Appointment Form</title>
    </head>
    <body>
        <%
            Calendar calendar = Calendar.getInstance();
            String dayName = new SimpleDateFormat("EEEE").format(calendar.getTime());
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

            <form action="BookAppointmentServlet" method="POST">
                <p>
                    <label class="Nid">Pick a date</label><br>
                    <input class="proc" type="date" name="date" required>
                <p>
                    <label class="Nid">Pick a Time</label><br>
                    <input class="proc" type="time" name="time" required>
                </p>
                </p>
                <p><label class="Nid">Choose a  procedure</label></p>
                <p>

                    <select class="proc" name="proc_code" required>Chiropractor 

                        <option value="">None</option>
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
                        <option value="None">None</option>
                        <option value="W200">W200</option>
                        <option value="W201">W201</option>
                        <option value="W202">W202</option>
                        <option value="W203">W203</option>
                        <option value="W204">W204</option>
                        <option value="W205">W205</option>

                    </select>
                </p>
                <button type="button" class="btn" name="modal">Cancel</button>
                <button type="submit" class="btn"  name="submit">Confirm Appointment</button>
            </form> 

        </div>
    </div>
    <script>
        sweetAlert("Sorry", "We are close on saturday and sunday !", "warning");
    </script>
</body>
<%-- <p> Values entered: <%= patientID%> + ${param.date}  + ${param.NailArtist} + ${param.proc_code} </p> --%>


</html >
