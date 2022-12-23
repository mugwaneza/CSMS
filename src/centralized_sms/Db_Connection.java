/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralized_sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author bernard.ndaruhutse
 */
public class Db_Connection {
    
    
 
    public static Connection connectDb() {
        
        try {
            
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/csms_db", "postgres", "root");
             return conn;
          }
        
        catch (  SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
}
