package sample.sample;

import java.sql.*;

public class DB_connect {
    //Constants
    public static final String DB_URL = "jdbc:MySQL://localhost:3306/workshop" +
            "?verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";
    public static final String DB_UName = "root";
    public static final String DB_UPassword = "Vtvabc123!";
    public Boolean connected = false;
    public static Connection connection = null;  // obj for connection

    DB_connect() {



        try
        {
            Class.forName ("com.mysql.cj.jdbc.Driver");  //search for driver
            connection = DriverManager.getConnection(DB_URL, DB_UName, DB_UPassword); // get connection to database
        } catch (SQLException e)
        {
            System.err.println("Cannot connect to Database " + DB_URL);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Err ClassNotFound"); // usually, it's work if driver not found
            e.printStackTrace();
        }

        if (connection != null)
        {
            connected = true;
        }
    }

}
