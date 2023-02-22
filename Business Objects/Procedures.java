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
public class Procedures {
    
    private String procCode;
    private String procName; 
    private String procDesc;
    private String Cost;
      
  
public Procedures() {
    String procCode="";
    String procName="";
    String procDesc="";
    String Cost="";
}
public Procedures(String code, String name, String Desc, String cost){
    procCode=code;
    procName= name;
    procDesc=Desc;
    Cost=cost;
}
public void setprocCode(String code){procCode=code;}
    public String getprocCode() {return procCode; }

    public void setprocName(String name){procName=name;}
    public String getprocName() {return procName; }
    
    public void setprocDesc(String Desc){procDesc=Desc;}
    public String getprocDesc() {return procDesc; }
    
    public void setCost(String cost){Cost=cost;}
    public String getCost() {return Cost; }
       
    
    public void display() {
        System.out.println("procCode               = "+getprocCode());
        System.out.println(" procName               = "+getprocName());
        System.out.println(" procDesc                = "+ getprocDesc());
        System.out.println("Cost                = "+ getCost());
        System.out.println("============================="); 
    }
/**************************************************
* selectDB()gets one procedure from the DB
**************************************************/
      public void selectDB(String code){
        procCode=code;
        //appt.selectDB(pid);
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1=DriverManager.getConnection("jdbc:ucanaccess://C://Users//Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");

            Statement stmt = con1.createStatement();
            String sql = "Select * from Procedures where procCode='"+getprocCode()+"'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            setprocName(rs.getString(2));
            setprocDesc(rs.getString(3));
            setCost(rs.getString(4));
          
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
      public static void  main(String[] args){
          //Procedures proc1= new Procedures();
          //proc1.selectDB("P110");
          //proc1.display();
          Procedurelist proc = new Procedurelist();
          proc.getproceduresDb();
          proc.displayProcedures();
      }
}
