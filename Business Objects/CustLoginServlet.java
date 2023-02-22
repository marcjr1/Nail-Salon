/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObjects;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CustLoginServlet", urlPatterns = {"/CustLoginServlet"})
public class CustLoginServlet extends HttpServlet {

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
        String Cid;
        String ppw;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           Cid= request.getParameter("CID");
         ppw= request.getParameter("password");
         System.out.println("PID = "+ Cid);
         System.out.println("Pssd = "+ ppw);
         
          Customers c1;
           c1 = new Customers();
           	
           c1.selectDB(Cid);
         
          Appointments appt = new Appointments ();
          c1.updateDB();
           
           System.out.println("Id ="+c1.getCustomer_ID());
           System.out.println("Pw  ="+c1.getPpw());
            String Id=c1.getCustomer_ID()+"";
           String Pw = c1.getPpw() +"";
           
             HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("c1", c1);
            ses1.setAttribute("appt", appt);
            //ses1.setAttribute("appt", appt);
            System.out.println("Customer added to Session/scheduling accountlookup.jsp");
			
		if ( Cid.equals(Id)&&ppw.equals(Pw)) {	
             //Step #6 - Use RequestDispatcher to forward to JStudentLookup.jsp
              
             RequestDispatcher rd = request.getRequestDispatcher("CustomerDashboard.jsp");
             rd.forward(request, response);  
            
                }
                else {
			
             //Step #6 - Use RequestDispatcher to forward to JStudentLookup.jsp
             RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.html");
             rd.forward(request, response);  
                }
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
