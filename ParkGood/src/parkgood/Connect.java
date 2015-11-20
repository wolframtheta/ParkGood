/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parkgood;

import static parkgood.Main.connection;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Xavier
 */
public class Connect {

    Connection myConnection;
    PreparedStatement query;
    ResultSet date;
    
    
    
    public void connection(String DB, String user, String password, String url, String driver) {
        
        
        try {
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url + DB,user,password); 
             
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }
    
    
}
