package sample.sample;

import java.sql.*;

public class DB_connect {

    public static   String host = "localhost";
    public static  String socket = "MySQL";
    public static String port = "3306";
    public String DB_URL = "jdbc:" + getSocket() + "://" + getHost() + ":" + getPort() + "/workshop" +
            "?verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";
    public static  String DB_UName = "root";
    public static  String DB_UPassword = "root";
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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

}
