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

/**
 *
 * @author Marc-Henry Moise Jr
 */
public class Customers {
      private String customer_ID;
    private String ppw;
    private String fname;
    private String lname;
    private String email;
    private String addr;
  
 
    
    
    // ======================== Constructors ============================
    public Customers() {  
        customer_ID="";
        ppw="";
        fname = "";
        lname = "";
        email = "";
        addr="";
        
    }
    public Customers(String id, String pw, String fn, String ln, String em, String ad) {  
        customer_ID=id;
        ppw=pw;
        fname = fn;
        lname = ln;
        email = em;
        addr=ad;
      
    }
    // ==================================  Behaviors ===============================
    public void setCustomer_ID(String id){customer_ID=id;}
    public String getCustomer_ID() {return customer_ID; }
    
    public void setPpw(String pw){ppw=pw;}
    public String getPpw() {return ppw; }
    
    public String getFname() { return fname; }
    public void setFname(String fn) { fname=fn; }
        
    public String getLname() { return lname; }
    public void setLname(String ln) { lname=ln; }

    public String getEmail() { return email; }
    public void setEmail(String em) { email=em; }
    
    public void setAddr(String ad){addr=ad;}
    public String getAddr() {return addr; }
    
 
    
    public void display() {
        System.out.println("Customer ID                = "+getCustomer_ID());
        System.out.println("Customer PW                = "+getPpw());
        System.out.println("First Name                = "+ getFname());
        System.out.println("Last Name                 = "+ getLname());
        System.out.println("EMail Address             = "+ getEmail());
        System.out.println("Customer Addr              = "+getAddr());
       
        System.out.println("============================="); 
    }
    
    // ++++++++++ DB Behaviors +++++++++++++
    
/**************************************************
* selectDB()gets one patient from the DB
**************************************************/
    public void selectDB(String id){
        customer_ID = id;
        //appt.selectDB(customer_ID);
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1=DriverManager.getConnection("jdbc:ucanaccess://C://Users//Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");

            Statement stmt = con1.createStatement();
            String sql = "Select * from Customer where customer_ID='"+getCustomer_ID()+"'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            setPpw(rs.getString("password"));
            setFname(rs.getString("firstname"));
            setLname(rs.getString("lastname"));
            setAddr(rs.getString("address"));
            setEmail(rs.getString("email"));
           
            
          
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//end selectDB()
    public void getappt(){
        
    }
    
 /**************************************************
* insertDB()inserts one patient into the DB
**************************************************/
    public void insertDB(String id,String fn, String ln, String ad, String em, String pw){
        setFname(fn);
        setLname(ln);
        setEmail(em);
        customer_ID=id;
        ppw=pw;
        addr=ad;
      
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1=DriverManager.getConnection("jdbc:ucanaccess://C://Users//Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");
            
            Statement stmt = con1.createStatement();
            String sql = "Insert into Customer(customer_ID,firstname,lastname,address,email,Password) values('"+getCustomer_ID()+"',"+
                                                      "'"+getFname()+"',"+ 
                                                      "'"+getLname()+"',"+ 
                                                      "'"+getAddr()+"',"+ 
                                                      "'"+getEmail()+"',"+ 
                                                      "'"+getPpw()+"')"; 
            System.out.println(sql);
            int n1 = stmt.executeUpdate(sql);
            if (n1==1)
                System.out.println("INSERT Successful!!!");
            else
                System.out.println("INSERT FAILED***********");
            con1.close();
        }
        catch(Exception e1){
            System.out.println(e1);
        }
    }//end insertDB()
/**************************************************
* updateDB()updates one patient from the DB
**************************************************/   
    public void updateDB(){
           //updateDB() code goes here
             try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1 = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");
            
            Statement stmt = con1.createStatement();
            String sql = "Update Customer set firstname = '"+getFname() + "',"+ 
                                            " lastname ='"+getLname()+"',"+
                                            " address='"+getAddr()+"',"+
                                            " email='"+getEmail()+"'"
                                            + "WHERE customer_ID='"+getCustomer_ID()+"'";
            
            
            System.out.println(sql);
            int n = stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("UPDATE Successful!!!");
            else
                System.out.println("UPDATE FAILED***********");
            con1.close();
        }
        catch(Exception e1){
            System.out.println(e1);
        }
    }//end updateDB()

/**************************************************
* DeleteDB()deletes one patient from the DB
**************************************************/
    
    public void deleteDB(){
         
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1=DriverManager.getConnection("jdbc:ucanaccess://C://Users//Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");
            
            Statement stmt = con1.createStatement();
            String sql = "Delete from Customer where customer_ID='"+getCustomer_ID()+"'";
            System.out.println(sql);
            int n = stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("DELETE Successful!!!");
            else
                System.out.println("DELETE FAILED***********");
            con1.close();
        }
        catch(Exception e1){
            System.out.println(e1);
        }
    }//end deleteDB()
    
    public static void main(String args[]) {
         //  TESTER CODE
        // Test SELECT
      Customers C1= new Customers();
      Customers C2= new Customers();
        C2.insertDB("C110","Ivon","Joseph","Kennesaw","iv@yahoo.fr","1234");
      C1.selectDB("C100");
       C1.setEmail("jdh@yahoo.com");
       C1.updateDB();
      C1.display();
      
         
        // Test DELETE
        //Patient p2 = new Patient();
       // p2.selectDB("A902");
       // p2.deleteDB();  //"A902" is now removed from the database
        
        // Test INSERT
        //Patient p3 = new Patient();
       //p3.insertDB("A567", "8888", "Bill", "Clinton", "bc@yahoo.com", "1313 Mockingbird Lane", "Cigna");
       // "A999" is now inserted into the Patient table
        
         
    }//end main
}


