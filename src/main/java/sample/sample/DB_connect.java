package sample.sample;

import java.sql.*;

public class DB_connect {


    private static String host = "localhost";
    private static String socket = "MySQL";
    private static String port = "3306";
    private static String schema = "workshop";
    public String DB_URL = "jdbc:" + getSocket() + "://" + getHost() + ":" + getPort() + "/" + getSchema() +
            "?verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";
    private static  String DB_UName = "root";
    private static  String DB_UPassword = "vtvabc123";
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


    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        DB_connect.host = host;
    }

    public static String getSocket() {
        return socket;
    }

    public static void setSocket(String socket) {
        DB_connect.socket = socket;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        DB_connect.port = port;
    }


    public static String getSchema() {
        return schema;
    }

    public static void setSchema(String schema) {
        DB_connect.schema = schema;
    }

    public static String getDB_UName() {
        return DB_UName;
    }

    public static void setDB_UName(String DB_UName) {
        DB_connect.DB_UName = DB_UName;
    }

    public static String getDB_UPassword() {
        return DB_UPassword;
    }

    public static void setDB_UPassword(String DB_UPassword) {
        DB_connect.DB_UPassword = DB_UPassword;
    }


}
