package db_connections;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DB_Connections {
    
    public static String testConnection(String host, String port, String db, String user, String pwd){
        String path = "jdbc:mysql://"+host+":"+port+"/"+db+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try{
            Connection c = DriverManager.getConnection(path, user, pwd);
            c.close();
            return null;
            
        }catch(SQLException e){
            return e.toString();
        }
    }
    
    public static boolean testConnectionPostgres(String host, String port, String db, String user, String pwd){
        Connection conn = null;
        String url = "jdbc:postgresql://" + host + ":" + port + "/" + db;
        try {
            conn = DriverManager.getConnection(url, user, pwd);
            conn.close();
            return true;
        } catch(SQLException e ) {
            return false;
        }
    }
    
    public static void getConnection(){
        
    }
    
    public static void runScript(){
        
    }
}
