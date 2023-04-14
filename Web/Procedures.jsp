<%-- 
    Document   : Procedures
    Created on : Feb 9, 2023, 12:08:05 AM
    Author     : Marc-Henry Moise Jr
--%>

<%@page import="BusinessObjects.Procedures"%>
<%@page import="java.util.List"%>
<%@page import="BusinessObjects.Procedurelist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Alkatra&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="sched.css">
        <title>Services</title>
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

        <table class="content-table" style="width:70%; position: relative; left: 5%; margin-top: 8%;">

            <%
                Procedurelist proc = new Procedurelist();
                List<Procedures> list = proc.getproceduresDb();

                for (Procedures l : list) {%>

            <thead class="thead-light">
                <tr>
                    <th>ProcCode</th>
                    <th>ProcName</th>
                    <th>ProcDesc</th>
                    <th>Cost</th>
                    
                </tr>
            </thead>
            <tr>
                <td><%=l.getprocCode()%></td>
                <td><%=l.getprocName()%></td>
                <td><%=l.getprocDesc()%></td>
                <td><%=l.getCost()%></td>

              
            </tr>
            <%}%>


        </table>
    </body>
</html>