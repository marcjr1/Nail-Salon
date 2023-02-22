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
public class Schedule {
    private int Id;
    private String naid;
    private String firstname; 
    private String lastname;
    private String schedule;
    public Schedulelist allSched;
    
    public Schedule() {
        
     int Id=0;
    String naid="";
    String firstname="";
    String lastname="";
    String schedule="";
}
      
 
public Schedule(int id,String nid, String fn, String ln, String sch){
    Id=id;
    naid=nid;
    firstname= fn;
    lastname=ln;
    schedule=sch;
}
public void setId(int id){Id=id;}
    public int  getId() {return Id; }
public void setnaid(String nid){naid=nid;}
    public String getnaid() {return naid; }

    public void setfirstname(String fn){firstname=fn;}
    public String getfirstname() {return firstname; }
    
    public void setlastname(String ln){lastname=ln;}
    public String getlastname() {return lastname; }
    
    public void setSchedule(String cost){schedule=cost;}
    public String getSchedule() {return schedule; }
       
    
    public void display() {
        System.out.println("Table Id            = "+getId());
        System.out.println("Nail Artist Id            = "+getnaid());
        System.out.println(" First Name               = "+getfirstname());
        System.out.println(" Last Name              = "+ getlastname());
        System.out.println("Schedule                = "+ getSchedule());
        System.out.println("============================="); 
    }
/**************************************************
* selectDB()gets one procedure from the DB
**************************************************/
      public void selectDB(String nid){
        naid=nid;
        //appt.selectDB(pid);
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1=DriverManager.getConnection("jdbc:ucanaccess://C://Users//Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");

            Statement stmt = con1.createStatement();
            String sql = "Select * from Schedule where nailArtistID='"+getnaid()+"'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            setfirstname(rs.getString(2));
            setlastname(rs.getString(3));
            setSchedule(rs.getString(4));
          
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
   
      public static void  main(String[] args){
       
         Schedulelist sched = new Schedulelist();
         sched.getDbSchedule();
         sched.displaySchedule();
        
       
         
         
      }
}

