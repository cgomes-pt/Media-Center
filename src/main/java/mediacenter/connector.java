/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacenter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Rengar
 */
public class connector {
    
        private static String USERNAME;
        private static String PASSWORD ;
        private static String SERVERNAME;
        private static String DATABASE;
    
    public connector() {
        USERNAME = "root";
        PASSWORD = "root";
        SERVERNAME = "localhost";
        DATABASE = "media";
    }
 
    
    /**
     *
     * @return Connection
     * @throws SQLException
     */
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://"+SERVERNAME+"/"+DATABASE+"?useTimezone=true&serverTimezone=UTC",USERNAME,PASSWORD);
    }
    
    public static void close(Connection c) throws SQLException {
        if(c!=null && !c.isClosed()) c.close();
        
    }
     
}
