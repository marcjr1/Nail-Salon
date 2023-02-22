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
public class Schedulelist {
    private List<Schedule> schedule;
    
    public Schedulelist(){
        schedule= new ArrayList<Schedule>();
    }
    
    public void addSchedule(Schedule sch){
        schedule.add(sch);
    }
    
    public List<Schedule>getDbSchedule() {
     
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1=DriverManager.getConnection("jdbc:ucanaccess://C://Users//Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");

            Statement stmt = con1.createStatement();
            String sql = "Select * from Schedule";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id=(rs.getInt("ID"));
                String naid=(rs.getString("nailArtistID"));
                String firstname=(rs.getString("firstName"));
                String lastname=(rs.getString("lastName"));
                String Schedule=(rs.getString("Schedule"));
                
                Schedule sched = new Schedule(id,naid,firstname,lastname,Schedule);
                schedule.add(sched);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return schedule;
    }
    public void displaySchedule(){
        for(int i = 0; i < schedule.size(); i++){
            schedule.get(i).display();
        }
    }
}
