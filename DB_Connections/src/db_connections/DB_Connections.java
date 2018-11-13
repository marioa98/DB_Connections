package db_connections;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB_Connections {
    
    public static boolean testConnection(String host, String port, String db, String user, String pwd){
        String path = "jdbc:mysql://"+host+":"+port+"/"+db+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try{
            Connection c = DriverManager.getConnection(path, user, pwd);
            c.close();
            return true;
            
        }catch(Exception e){
            return false;
        }
    }
    
    public static void getConnection(){
        
    }
    
    public static void runScript(){
        
    }
}
