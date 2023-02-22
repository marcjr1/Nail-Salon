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
public class Procedurelist {
    private List<Procedures> proc;
    public Procedurelist(){
        proc= new ArrayList<Procedures>();
    }
    public void addProc(Procedures proced){
        proc.add(proced);
}
    public List<Procedures>getproceduresDb(){
        
     try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1=DriverManager.getConnection("jdbc:ucanaccess://C://Users//Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");

            Statement stmt = con1.createStatement();
            String sql = "Select * from Procedures";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
               
                String Proccode=(rs.getString("procCode"));
                String ProcName=(rs.getString("procName"));
                String Procdesc=(rs.getString("procDesc"));
                String price=(rs.getString("Cost"));
                
                Procedures sched = new Procedures(Proccode,ProcName,Procdesc,price);
                proc.add(sched);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return proc;
    }
     public void displayProcedures(){
        for(int i = 0; i < proc.size(); i++){
            proc.get(i).display();
        }
    }
}