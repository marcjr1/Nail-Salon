/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObjects;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marc-Henry Moise Jr
 */
@WebServlet(name = "EditAppt2", urlPatterns = {"/EditAppt2"})
public class EditAppt2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            HttpSession sessionList = request.getSession();
           
           //List<Appointments> appt = (List<Appointments>)session.getAttribute("appt");
            String id = (String)session.getAttribute("setID");
            String date,time,proc_code,NailArtist;
            List<Appointments> getcustAppt = (List<Appointments>)sessionList.getAttribute("Session_list");
            date = request.getParameter("date");
            time= request.getParameter("time");
            proc_code = request.getParameter("proc_code");
            NailArtist = request.getParameter("NailArtist");
            String DateTime=date +" "+time;
            
           
            out.println(id);
           out.println(getcustAppt);
            out.println(date + " " + proc_code + " " + NailArtist);
            
            Appointments appt = new Appointments();
          
            
            appt.selectID(Integer.parseInt(id));           
            appt.setapptdt(DateTime);
            
            appt.setproccode(proc_code);
            appt.setartists_Id(NailArtist);
            appt.updateDB();
             
            
            session.setAttribute("appt", appt);
           
            
           RequestDispatcher dp = request.getRequestDispatcher("CustomerDashboard.jsp");
            dp.forward(request, response);
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
