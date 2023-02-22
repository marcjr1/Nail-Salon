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
public class Admins {
    
   private String admin_id;
    private String firstname;
    private String lastname;
    private String email;
    private String phonenumber;
     private String passwd;
   
 
    
    // ======================== Constructors ============================
    public Admins() {  
        admin_id="";
        firstname = "";
        lastname = "";
        email = "";
        phonenumber="";
        passwd="";
        
    }
    public Admins(String adm, String pw, String fn, String ln, String em, String phone) {  
       admin_id=adm;
        passwd=pw;
        firstname = fn;
        lastname = ln;
        email = em;
        phonenumber=phone;
        
    }
    // ==================================  Behaviors ===============================
    public void setAdmin_id(String adm){admin_id=adm;}
    public String getAdmin_id() {return admin_id; }
    
    public void setPasswd(String pw){passwd=pw;}
    public String getPasswd() {return passwd; }
    
    public String getFirstname() { return firstname; }
    public void setFirstname(String fn) { firstname=fn; }
        
    public String getLastname() { return lastname; }
    public void setLastname(String ln) { lastname=ln; }

    public String getEmail() { return email; }
    public void setEmail(String em) { email=em; }
    
    public void setPhonenumber(String phone){phonenumber=phone;}
    public String getPhonenumber() {return phonenumber; }
    
   
    
    public void display() {
        System.out.println("id               = "+admin_id);
        System.out.println("passwd               = "+passwd);
        System.out.println("firstName               = "+ firstname);
        System.out.println("lastName                = "+ lastname);
        System.out.println("email             = "+ email);
        System.out.println("phonenumber          = "+phonenumber);
     
        System.out.println("============================="); 
    }
    
    // ++++++++++ DB Behaviors +++++++++++++
/**************************************************
* selectDB()gets one dentist from the DB
**************************************************/
    public void selectDB(String adm){
       admin_id = adm;
        //appt.selectDB(admin_id);
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1=DriverManager.getConnection("jdbc:ucanaccess://C://Users//Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");

            Statement stmt = con1.createStatement();
            String sql = "Select * from Admins where admin_id='"+getAdmin_id()+"'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
        
				 passwd  = rs.getString("password");
				 firstname = rs.getString("firstname");
				lastname = rs.getString("lastname");
				email  = rs.getString("email");
                               phonenumber = rs.getString("phonenumber");
                               
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//end selectDB()
    public void getappt(){
        
    }
 /**************************************************
* insertDB()inserts one dentist into the DB
**************************************************/
    public void insertDB(String adm, String fn, String ln, String em,  String phone,  String pw){
        setFirstname(fn);
        setLastname(ln);
        setEmail(em);
       admin_id=adm;
        passwd=pw;
        phonenumber=phone;
       
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1=DriverManager.getConnection("jdbc:ucanaccess://C://Users//Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");
            
            Statement stmt = con1.createStatement();
            String sql = "Insert into Admins(Admin_Id,FirstName,LastName,Email,PhoneNumber,Password) values('"+getAdmin_id()+"',"+
                                                      "'"+getFirstname()+"',"+ 
                                                      "'"+getLastname()+"',"+ 
                                                      "'"+getEmail()+"',"+ 
                                                      "'"+getPhonenumber()+"',"+ 
                                                      "'"+getPasswd()+"')"; 
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
* updateDB()updates one dentist from the DB
**************************************************/
    public void updateDB(){
           //updateDB() code goes here
             try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1 = DriverManager.getConnection("jdbc:ucanaccess://C://Users//Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");
            
            Statement stmt = con1.createStatement();
            String sql = "Update Admins set FirstName = '"+getFirstname() + "',"+ 
                                            " LastName ='"+getLastname()+"',"+
                                            " PhoneNumber ='"+getPhonenumber()+"',"+
                                            " Email='"+getEmail()+"'"+" WHERE Admin_Id ='"+getAdmin_id()+"'";
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
* DeleteDB()deletes one dentist from the DB
**************************************************/
    
    public void deleteDB(){
         
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1=DriverManager.getConnection("jdbc:ucanaccess://C://Users//Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");
            
            Statement stmt = con1.createStatement();
            String sql = "Delete from Admins where Admin_Id ='"+getAdmin_id()+"'";
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
        Admins A1 = new Admins();
        A1.selectDB("A100");
       A1.insertDB("A106","Ivon","Joseph","Kennesaw","iv@yahoo.fr","1234");
        
        A1.display();
        
        // Test DELETE
         //Dentist d2 = new  Dentist();
        //d2.selectDB("D201");
        //d2.deleteDB();  //"A902" is now removed from the database
        
        // Test INSERT
         //Dentist d3 = new  Dentist();
        //d3.insertDB("A999", "9999", "Bill", "Clinton", "bc@yahoo.com", "1313 Mockingbird Lane", "Cigna");
             // "A999" is now inserted into the Patient table
        
         
    }//end main
} //
