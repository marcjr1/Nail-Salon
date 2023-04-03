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
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Alkatra&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="customeracc.css">
        <title>Customer Dashboard</title>
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
        <a href="Procedures.jsp"><button class="btn"> View Procedures</button></a>
        <a href="UpdateCustinfo.jsp"><button class="btn">Update Profile</button></a>
      <form action="LogoutServlet" method="post"style="display: inline-block; margin-left: 8px;">
    <button type="submit" class="btn btn-danger">Logout</button>
</form>

        <form action="BookAppointmentServlet" method="POST">
            <table class="table content-table " style="width:80%;">

                <%                    Appointmentlist appt = new Appointmentlist();
                    List<Appointments> list = appt.getcustAppt(c1.getCustomer_ID());
                    HttpSession sessionList = request.getSession();
                    sessionList.setAttribute("updatedAppt", appt);
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

                        <a class='btn btn-info btn-xs' href="EditAppt?id=<%=l.getiD()%>"><button type="button" class=" btn btn-primary glyphicon glyphicon-edit  ">Edit</button> </a>

                        <a href="deleteServlet?id=<%=l.getiD()%>" class="btn btn-danger btn-xs" id="delete"><span
                                class="glyphicon glyphicon-remove"></span> Del</a>
                    </td>
                </tr>
                <%}
                    }%>
                <h3 style="margin-top: 20px; display: inline-block; color: #664d03; background-color:#fff3cd; border-color:ffecb5; padding:.3rem 2rem; border-radius: 5px;" > You have <%=list.size()%> <%= list.size() > 1 ? " Appointments" : " Appointment"%> scheduled in your Appointment Cart </h2>     

            </table>
        </form>
        <script>
            // Get all the delete buttons
            const deleteButtons = document.querySelectorAll('#delete');

            // Add a click event listener to each delete button
            deleteButtons.forEach(button => {
                button.addEventListener('click', () => {
                    // Show an alert when the user clicks on the delete button
                    sweetAlert("Delete Complete", "This appointment has been deleted", "success");
                });
            });

        </script>

    </body>
</html>
