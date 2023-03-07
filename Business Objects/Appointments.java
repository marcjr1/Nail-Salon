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
public class Appointments {

    private String apptdt;
    private String CustomerId;
    private String artists_Id;
    private String proccode;
    private int iD;

    public Appointments() {
        apptdt = "";
        CustomerId = "";
        artists_Id = "";
        proccode = "";
        iD = 0;

    }

    public Appointments(int id, String apt, String Cid, String proc, String aId) {
        iD = id;
        apptdt = apt;
        CustomerId = Cid;
        proccode = proc;
        artists_Id = aId;
    }

    public void setapptdt(String apt) {
        apptdt = apt;
    }

    public String getapptdt() {
        return apptdt;
    }

    public void setcustomerId(String Cid) {
        CustomerId = Cid;
    }

    public String getcustomerId() {
        return CustomerId;
    }

    public void setartists_Id(String aId) {
        artists_Id = aId;
    }

    public String getartists_Id() {
        return artists_Id;
    }

    public void setproccode(String proc) {
        proccode = proc;
    }

    public String getproccode() {
        return proccode;
    }

    /**
     * @return the iD
     */
    public int getiD() {
        return iD;
    }

    /**
     * @param iD the iD to set
     */
    public void setiD(int iD) {
        this.iD = iD;
    }

    public void display() {
        System.out.println("id              = " + getiD());
        System.out.println("apptDateTime              = " + getapptdt());

        System.out.println("Customer Id             = " + getcustomerId());

        System.out.println("NailArtist Id             = " + getartists_Id());

        System.out.println("Proccode                = " + getproccode());

        System.out.println("=============================");
    }
    // ++++++++++ DB Behaviors +++++++++++++

    /**
     * ************************************************
     * selectDB()gets one patient appointment from the DB
     * ************************************************
     */
    public void selectDB(String Cid) {
        CustomerId = Cid;
        //appt.selectDB(pid);
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1 = DriverManager.getConnection("jdbc:ucanaccess://C://Users//Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");

            Statement stmt = con1.createStatement();
            String sql = "Select * from Appointments where CustomerId='" + getcustomerId() + "'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            setiD(rs.getInt("id"));
            setapptdt(rs.getString("apptdateTime"));
            setartists_Id(rs.getString("artists_Id"));
            setproccode(rs.getString("procCode"));

        } catch (Exception e) {
            System.out.println(e);
        }
    } //end selectDB()

    public void selectID(int apid) {
        iD = apid;
        //appt.selectDB(pid);
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1 = DriverManager.getConnection("jdbc:ucanaccess://C://Users//Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");

            Statement stmt = con1.createStatement();
            String sql = "Select * from Appointments where id='" + getiD() + "'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                do {
                    setapptdt(rs.getString("apptdateTime"));
                    setcustomerId(rs.getString("CustomerId"));
                    setartists_Id(rs.getString("artists_Id"));
                    setproccode(rs.getString("procCode"));
                } while (rs.next());
            } else {
                setapptdt("NO APPOINTMENT AT THIS TIME");
                setcustomerId("NO CUSTOMER ID AT THIS MOMENT");
                setartists_Id("NO CUSTOMER ID AT THIS MOMENT");
                setproccode("NO PROCODE AT THIS MOMENT");         
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    } //end selectDB()

    /**
     * ***********************************************************
     * selectDentistDB()gets one dentist appointment from the DB
     * ************************************************************
     */
    /**
     * ***************************************************
     * insertDB()inserts one patient appointment into the DB
     * ****************************************************
     */
    public void insertDB(String apt, String Cid, String proc, String aId) {
        apptdt = apt;
        CustomerId = Cid;
        proccode = proc;
        artists_Id = aId;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1 = DriverManager.getConnection("jdbc:ucanaccess://C://Users//Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");

            Statement stmt = con1.createStatement();
            String sql = "Insert into Appointments(apptdateTime,CustomerId,procCode,artists_Id) values('" + getapptdt() + "',"
                    + "'" + getcustomerId() + "',"
                    + "'" + getproccode() + "',"
                    + "'" + getartists_Id() + "')";
            System.out.println(sql);
            int n1 = stmt.executeUpdate(sql);
            if (n1 == 1) {
                System.out.println("INSERT Successful!!!");
            } else {
                System.out.println("INSERT FAILED***********");
            }
            con1.close();
        } catch (Exception e1) {
            System.out.println(e1);
        }
    }//end insertDB()

    /**
     * ******************************************************
     * updateDB()updates one patient appointment from the DB
     * *******************************************************
     */
    public void updateDB() {
        //updateDB() code goes here
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1 = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");

            Statement stmt = con1.createStatement();
            String sql = "Update Appointments set apptdateTime ='" + getapptdt() + "',"
                    + "procCode='" + getproccode() + "',"
                    + "" + "artists_Id='" + getartists_Id() + "' "
                    + "Where id=" + getiD() + "";
            System.out.println(sql);
            int n = stmt.executeUpdate(sql);
            if (n == 1) {
                System.out.println("UPDATE Successful!!!");
            } else {
                System.out.println("UPDATE FAILED***********");
            }
            con1.close();
        } catch (Exception e1) {
            System.out.println(e1);
        }
    }//end updateDB()

    /**
     * ************************************************
     * DeleteDB()deletes one patient appointment from the DB
     * ************************************************
     */
    public void deleteDB() {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1 = DriverManager.getConnection("jdbc:ucanaccess://C://Users//Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");

            Statement stmt = con1.createStatement();
            String sql = "Delete from Appointments where CustomerId='" + getcustomerId() + "'";
            System.out.println(sql);
            int n = stmt.executeUpdate(sql);
            if (n == 1) {
                System.out.println("DELETE Successful!!!");
            } else {
                System.out.println("DELETE FAILED***********");
            }
            con1.close();
        } catch (Exception e1) {
            System.out.println(e1);
        }
    }// end deleteDB()

    public void deleteidDB() {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1 = DriverManager.getConnection("jdbc:ucanaccess://C://Users//Marc-Henry Moise Jr/Documents/CTCNailSalonMDB.accdb");

            Statement stmt = con1.createStatement();
            String sql = "Delete from Appointments where id='" + getiD() + "'";
            System.out.println(sql);
            int n = stmt.executeUpdate(sql);
            if (n == 1) {
                System.out.println("DELETE Successful!!!");
            } else {
                System.out.println("DELETE FAILED***********");
            }
            con1.close();
        } catch (Exception e1) {
            System.out.println(e1);
        }
    }// end deleteDB()

    public static void main(String args[]) {
        //  TESTER CODE
        // Test SELECT
        //Appointmentlist apt = new Appointmentlist();

        Appointments appt = new Appointments();
        Appointments appt1 = new Appointments();
        appt.selectID(3);
        //appt.setapptdt("2023-06-05");
        //appt.updateDB();
        //appt.insertDB("12/45/45","C108","P114","W202");
        //appt.setapptdt("08/25/2000");
        //appt.updateDB();
        appt.display();
        // Test DELETE
        //"A902" is now removed from the database
        // Test INSERT
        // Patient p3 = new Patient();
        //  p3.insertDB("A999", "9999", "Bill", "Clinton", "bc@yahoo.com", "1313 Mockingbird Lane", "Cigna");
        // "A999" is now inserted into the Patient table
    }//end main

}
