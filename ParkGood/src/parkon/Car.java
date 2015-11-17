/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parkon;

import Views.NormalCarEntry;
import Views.FixedCarEntry;
import Views.mainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import static parkon.Main.*;
import static parkon.Utilities.*;

/**
 *
 * @author Xavier
 */
public class Car {

    public static String entryTime = "";
    public static String entryDate = "";
    
    public Car(String type) throws SQLException {
        if ("Adelantat".equals(type)) {
            FixedCarEntry fCE = new FixedCarEntry();
            java.util.Date date = new java.util.Date();
            SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatDate2 = new SimpleDateFormat("dd/MM/yyyy");
            entryTime = formatTime.format(date);
            entryDate = formatDate.format(date);
            FixedCarEntry.entryTimeLabel.setText(entryTime);
            FixedCarEntry.entryDateLabel.setText(formatDate2.format(date));
            fCE.setVisible(true);
            
            String query = "SELECT `ticket` FROM `" + DBEntry + "` ORDER BY `ticket` DESC LIMIT 1";
            st = connection.createStatement();
            ResultSet res = st.executeQuery(query);
            while (res.next()) 
                FixedCarEntry.ticketLabel.setText(res.getInt("ticket")+1 + "");
        }
        else {
            java.util.Date date = new java.util.Date();
            SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatDate2 = new SimpleDateFormat("dd/MM/yyyy");
            entryTime = formatTime.format(date);
            entryDate = formatDate.format(date);
            final NormalCarEntry entryTicket = new NormalCarEntry();
            String query = "INSERT INTO `" + DBEntry + "` VALUES ('0', '" + entryTime + "', '" + entryDate + "', '" + entryTime + "', '" + entryDate + "', '" + type + "', '0.0', '1')";
            st.executeUpdate(query);
            entryTicket.setVisible(true);
            query = "SELECT `ticket` FROM `" + DBEntry + "` ORDER BY `ticket` DESC LIMIT 1";
            st = connection.createStatement();
            ResultSet res = st.executeQuery(query);
            while (res.next()) 
                entryTicket.entryTicketLabel.setText(res.getInt("ticket") + "");
            entryTicket.entryDate.setText(formatDate2.format(date));
            entryTicket.entryTime.setText(entryTime);
            mainView.updateActiveTable();
            javax.swing.Timer t = new javax.swing.Timer(4000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    entryTicket.setVisible(false);
                }
            });
            
            t.start();
            TicketNormalEntry TFE = new TicketNormalEntry();
            
        }
        
    }
    
}
