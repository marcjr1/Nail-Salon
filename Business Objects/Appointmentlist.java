/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marc-Henry Moise Jr
 */
public class Appointmentlist {
    
    private List<Appointments> appt;
    //private Customers c1;
    //String cusID = c1.getCustomer_ID();
    
    public Appointmentlist(){
       appt = new ArrayList<Appointments>();
   }
    public void addAppt (Appointments Appt){
       appt.add(Appt);
   }
   public List<Appointments> getcustAppt(String custId){
       
           // cusID = custId;
            try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1=DriverManager.getConnection("jdbc:ucanaccess://C://Users//Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");

            Statement stmt = con1.createStatement();
            String sql = "Select * from Appointments where CustomerId='"+ custId +"'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                
                String date=(rs.getString("apptdateTime"));
                String cust = (rs.getString("CustomerId"));
                String Proc=(rs.getString("procCode"));
                String naid=(rs.getString("artists_Id"));
                             
                Appointments apt = new Appointments(date,custId, Proc,naid);
                appt.add(apt);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return appt;
   }
   public void displayappointmentslist(){
       for (int i=0; i<appt.size(); i++) {
           appt.get(i).display();
       }
   }
   public static void main (String args[]){
       Appointmentlist apt= new Appointmentlist();
       apt.getcustAppt("C102");
       apt.displayappointmentslist();
       
   }
    
}
