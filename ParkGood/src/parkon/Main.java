/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parkon;

import Views.Floor1;
import Views.Login;
import Views.MarkedCarExit;
import Views.NormalCarExit;
import Views.Presentation;
import Views.mainView;
import static java.lang.Math.ceil;
import java.sql.*;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static parkon.Utilities.*;

/**
 *
 * @author Xavier
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static Connection connection;
    public static Statement st;
    static DefaultTableModel dtmEjemplo;
    static JTable tblEjemplo;
    static JScrollPane scpEjemplo;
    public static void main(String[] args) throws SQLException {
        Connect connect = new Connect();
        connect.connection(DBName, DBUser, DBPassword, DBUrl, DBDriver);
        
        /*String query = "CREATE TABLE IF NOT EXISTS `entry_cars`"
                + "("
                + ""
                + ")";
        st = connection.createStatement();
        st.executeUpdate(query);*/
        
        Presentation presentation = new Presentation();
        presentation.setVisible(true);
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            
        }
        presentation.setVisible(false);
        Login login = new Login();
        login.setVisible(true);
    }
    
        
}


