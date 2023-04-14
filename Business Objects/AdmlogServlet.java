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
@WebServlet(name = "AdmlogServlet", urlPatterns = {"/AdmlogServlet"})
public class AdmlogServlet extends HttpServlet {

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
      String AdmId;
        String ppw;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            AdmId= request.getParameter("AdmID");
         ppw= request.getParameter("password");
         System.out.println("AdmID = "+ AdmId);
         System.out.println("Pssd = "+ ppw);
         
          Admins A1;
           A1 = new Admins();
           	
           A1.selectDB(AdmId);
         
          //Appointment appt = new Appointment ();
          A1.updateDB();
           
           System.out.println("Id ="+A1.getAdmin_id());
           System.out.println("Pw  ="+A1.getPasswd());
            String Id=A1.getAdmin_id()+"";
           String Pw = A1.getPasswd()+"";
           
             HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("A1", A1);
            //ses1.setAttribute("appt", appt);
            System.out.println("Adm added to Session/scheduling accountlookup.jsp");
			
		if ( AdmId.equals(Id)&&ppw.equals(Pw)) {	
             //Step #6 - Use RequestDispatcher to forward to JStudentLookup.jsp
              
             RequestDispatcher rd = request.getRequestDispatcher("AdmDashBoard.jsp");
             rd.forward(request, response);  
            
                }
                else {
			
             //Step #6 - Use RequestDispatcher to forward to JStudentLookup.jsp
             RequestDispatcher rd = request.getRequestDispatcher("AdmErrorPage.html");
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
    