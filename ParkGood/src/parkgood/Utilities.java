/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parkgood;

import Views.Floor0;
import static Views.Floor0.*;
import Views.Floor1;
import Views.FloorS1;
import Views.InfoCar;
import static Views.InfoCar.*;
import Views.MarkedCarExit;
import static Views.TimeDiscount.time_discount;
import Views.NormalCarExit;
import Views.mainView;
import com.mysql.jdbc.Messages;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Window;

import static java.lang.Math.ceil;
import static parkgood.Main.connection;
import static parkgood.Main.st;
import static parkgood.Utilities.messages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;

/**
 *
 * @author Xavier
 */
public class Utilities {
    public static boolean intro = false;
    public final static String DBName = "parking";
    public final static String DBUser = "root";
    public final static String DBPassword = "";
    public final static String DBUrl = "jdbc:mysql://localhost:3306/";
    public final static String DBDriver = "com.mysql.jdbc.Driver";
    public final static String DBEntry = "entrycars";
    public final static String DBExit = "exitcars";
    public final static String DBPrices = "prices";
    public final static String DBLogin = "users";
    public final static String DBPlaces = "places";
    public final static SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
    public final static SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    public static int COL_MORE = 4;
    public static int COL_ID = 0;
    public static int EXTRA1 = 1;
    public static int EXTRA0 = 0;
    public static int EXTRAS1 = -1;
    public static Image imageParkGood = new ImageIcon(Utilities.class.getResource("/images/car-icon.png")).getImage();
    
    public Properties getProperties() {
        try {
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream("prices.properties"));
            if (!properties.isEmpty())
                return properties;
            else
                return null;
        } catch (Exception e) {
            return null;
        }
 
    }
    
    public static ResourceBundle messages = ResourceBundle.getBundle("parkgood.messages");
    
    
    public static void hideColumn(int i, JTable Table) {
        Table.getColumnModel().getColumn(i).setMaxWidth(0);
        Table.getColumnModel().getColumn(i).setMinWidth(0);
        Table.getColumnModel().getColumn(i).setPreferredWidth(0);
    }
    
    
    public static void updateFloor0() {
        if (nameEmpty(place1.getText(), 0)) place1.setBackground(Color.green);
        else place1.setBackground(Color.red);
        if (nameEmpty(place2.getText(), 0)) place2.setBackground(Color.green);
        else place2.setBackground(Color.red);
        if (nameEmpty(place3.getText(), 0)) place3.setBackground(Color.green);
        else place3.setBackground(Color.red);
        if (nameEmpty(place4.getText(), 0)) place4.setBackground(Color.green);
        else place4.setBackground(Color.red);
        if (nameEmpty(place5.getText(), 0)) place5.setBackground(Color.green);
        else place5.setBackground(Color.red);
        if (nameEmpty(place6.getText(), 0)) place6.setBackground(Color.green);
        else place6.setBackground(Color.red);
        if (nameEmpty(place7.getText(), 0)) place7.setBackground(Color.green);
        else place7.setBackground(Color.red);
        if (nameEmpty(place8.getText(), 0)) place8.setBackground(Color.green);
        else place8.setBackground(Color.red);
        if (nameEmpty(place9.getText(), 0)) place9.setBackground(Color.green);
        else place9.setBackground(Color.red);
        if (nameEmpty(place10.getText(), 0)) place10.setBackground(Color.green);
        else place10.setBackground(Color.red);
        if (nameEmpty(place11.getText(), 0)) place11.setBackground(Color.green);
        else place11.setBackground(Color.red);
        if (nameEmpty(place12.getText(), 0)) place12.setBackground(Color.green);
        else place12.setBackground(Color.red);
        if (nameEmpty(place13.getText(), 0)) place13.setBackground(Color.green);
        else place13.setBackground(Color.red);
        if (nameEmpty(place14.getText(), 0)) place14.setBackground(Color.green);
        else place14.setBackground(Color.red);
        if (nameEmpty(place15.getText(), 0)) place15.setBackground(Color.green);
        else place15.setBackground(Color.red);
        if (nameEmpty(place16.getText(), 0)) place16.setBackground(Color.green);
        else place16.setBackground(Color.red);
        if (nameEmpty(place17.getText(), 0)) place17.setBackground(Color.green);
        else place17.setBackground(Color.red);
        if (nameEmpty(place18.getText(), 0)) place18.setBackground(Color.green);
        else place18.setBackground(Color.red);
        if (nameEmpty(place19.getText(), 0)) place19.setBackground(Color.green);
        else place19.setBackground(Color.red);
        if (nameEmpty(place20.getText(), 0)) place20.setBackground(Color.green);
        else place20.setBackground(Color.red);
        if (nameEmpty(place21.getText(), 0)) place21.setBackground(Color.green);
        else place21.setBackground(Color.red);
        if (nameEmpty(place22.getText(), 0)) place22.setBackground(Color.green);
        else place22.setBackground(Color.red);
        if (nameEmpty(place23.getText(), 0)) place23.setBackground(Color.green);
        else place23.setBackground(Color.red);
        if (nameEmpty(place24.getText(), 0)) place24.setBackground(Color.green);
        else place24.setBackground(Color.red);
        if (nameEmpty(place25.getText(), 0)) place25.setBackground(Color.green);
        else place25.setBackground(Color.red);
        if (nameEmpty(place26.getText(), 0)) place26.setBackground(Color.green);
        else place26.setBackground(Color.red);
        if (nameEmpty(place27.getText(), 0)) place27.setBackground(Color.green);
        else place27.setBackground(Color.red);
        if (nameEmpty(place28.getText(), 0)) place28.setBackground(Color.green);
        else place28.setBackground(Color.red);
        if (nameEmpty(place29.getText(), 0)) place29.setBackground(Color.green);
        else place29.setBackground(Color.red);
        if (nameEmpty(place30.getText(), 0)) place30.setBackground(Color.green);
        else place30.setBackground(Color.red);
        if (nameEmpty(place31.getText(), 0)) place31.setBackground(Color.green);
        else place31.setBackground(Color.red);
        if (nameEmpty(place32.getText(), 0)) place32.setBackground(Color.green);
        else place32.setBackground(Color.red);
        if (nameEmpty(place33.getText(), 0)) place33.setBackground(Color.green);
        else place33.setBackground(Color.red);
        if (nameEmpty(place34.getText(), 0)) place34.setBackground(Color.green);
        else place34.setBackground(Color.red);
        if (nameEmpty(place35.getText(), 0)) place35.setBackground(Color.green);
        else place35.setBackground(Color.red);
        if (nameEmpty(place36.getText(), 0)) place36.setBackground(Color.green);
        else place36.setBackground(Color.red);
        if (nameEmpty(place37.getText(), 0)) place37.setBackground(Color.green);
        else place37.setBackground(Color.red);
        
    }
    
    public static void updateFloor1() {
        if (nameEmpty(Floor1.place1.getText(), 100)) Floor1.place1.setBackground(Color.green);
        else Floor1.place1.setBackground(Color.red);
        if (nameEmpty(Floor1.place2.getText(), 100)) Floor1.place2.setBackground(Color.green);
        else Floor1.place2.setBackground(Color.red);
        if (nameEmpty(Floor1.place3.getText(), 100)) Floor1.place3.setBackground(Color.green);
        else Floor1.place3.setBackground(Color.red);
        if (nameEmpty(Floor1.place4.getText(), 100)) Floor1.place4.setBackground(Color.green);
        else Floor1.place4.setBackground(Color.red);
        if (nameEmpty(Floor1.place5.getText(), 100)) Floor1.place5.setBackground(Color.green);
        else Floor1.place5.setBackground(Color.red);
        if (nameEmpty(Floor1.place6.getText(), 100)) Floor1.place6.setBackground(Color.green);
        else Floor1.place6.setBackground(Color.red);
        if (nameEmpty(Floor1.place7.getText(), 100)) Floor1.place7.setBackground(Color.green);
        else Floor1.place7.setBackground(Color.red);
        if (nameEmpty(Floor1.place8.getText(), 100)) Floor1.place8.setBackground(Color.green);
        else Floor1.place8.setBackground(Color.red);
        if (nameEmpty(Floor1.place9.getText(), 100)) Floor1.place9.setBackground(Color.green);
        else Floor1.place9.setBackground(Color.red);
        if (nameEmpty(Floor1.place10.getText(), 100)) Floor1.place10.setBackground(Color.green);
        else Floor1.place10.setBackground(Color.red);
        if (nameEmpty(Floor1.place11.getText(), 100)) Floor1.place11.setBackground(Color.green);
        else Floor1.place11.setBackground(Color.red);
        if (nameEmpty(Floor1.place12.getText(), 100)) Floor1.place12.setBackground(Color.green);
        else Floor1.place12.setBackground(Color.red);
        if (nameEmpty(Floor1.place13.getText(), 100)) Floor1.place13.setBackground(Color.green);
        else Floor1.place13.setBackground(Color.red);
        if (nameEmpty(Floor1.place14.getText(), 100)) Floor1.place14.setBackground(Color.green);
        else Floor1.place14.setBackground(Color.red);
        if (nameEmpty(Floor1.place15.getText(), 100)) Floor1.place15.setBackground(Color.green);
        else Floor1.place15.setBackground(Color.red);
        if (nameEmpty(Floor1.place16.getText(), 100)) Floor1.place16.setBackground(Color.green);
        else Floor1.place16.setBackground(Color.red);
        if (nameEmpty(Floor1.place17.getText(), 100)) Floor1.place17.setBackground(Color.green);
        else Floor1.place17.setBackground(Color.red);
        if (nameEmpty(Floor1.place18.getText(), 100)) Floor1.place18.setBackground(Color.green);
        else Floor1.place18.setBackground(Color.red);
        if (nameEmpty(Floor1.place19.getText(), 100)) Floor1.place19.setBackground(Color.green);
        else Floor1.place19.setBackground(Color.red);
        if (nameEmpty(Floor1.place20.getText(), 100)) Floor1.place20.setBackground(Color.green);
        else Floor1.place20.setBackground(Color.red);
        if (nameEmpty(Floor1.place21.getText(), 100)) Floor1.place21.setBackground(Color.green);
        else Floor1.place21.setBackground(Color.red);
        if (nameEmpty(Floor1.place22.getText(), 100)) Floor1.place22.setBackground(Color.green);
        else Floor1.place22.setBackground(Color.red);
        if (nameEmpty(Floor1.place23.getText(), 100)) Floor1.place23.setBackground(Color.green);
        else Floor1.place23.setBackground(Color.red);
        if (nameEmpty(Floor1.place24.getText(), 100)) Floor1.place24.setBackground(Color.green);
        else Floor1.place24.setBackground(Color.red);
        if (nameEmpty(Floor1.place25.getText(), 100)) Floor1.place25.setBackground(Color.green);
        else Floor1.place25.setBackground(Color.red);
        if (nameEmpty(Floor1.place26.getText(), 100)) Floor1.place26.setBackground(Color.green);
        else Floor1.place26.setBackground(Color.red);
        if (nameEmpty(Floor1.place27.getText(), 100)) Floor1.place27.setBackground(Color.green);
        else Floor1.place27.setBackground(Color.red);
        if (nameEmpty(Floor1.place28.getText(), 100)) Floor1.place28.setBackground(Color.green);
        else Floor1.place28.setBackground(Color.red);
        if (nameEmpty(Floor1.place29.getText(), 100)) Floor1.place29.setBackground(Color.green);
        else Floor1.place29.setBackground(Color.red);
        if (nameEmpty(Floor1.place30.getText(), 100)) Floor1.place30.setBackground(Color.green);
        else Floor1.place30.setBackground(Color.red);
        if (nameEmpty(Floor1.place31.getText(), 100)) Floor1.place31.setBackground(Color.green);
        else Floor1.place31.setBackground(Color.red);
        if (nameEmpty(Floor1.place32.getText(), 100)) Floor1.place32.setBackground(Color.green);
        else Floor1.place32.setBackground(Color.red);
        if (nameEmpty(Floor1.place33.getText(), 100)) Floor1.place33.setBackground(Color.green);
        else Floor1.place33.setBackground(Color.red);
        if (nameEmpty(Floor1.place34.getText(), 100)) Floor1.place34.setBackground(Color.green);
        else Floor1.place34.setBackground(Color.red);
        if (nameEmpty(Floor1.place35.getText(), 100)) Floor1.place35.setBackground(Color.green);
        else Floor1.place35.setBackground(Color.red);
        if (nameEmpty(Floor1.place36.getText(), 100)) Floor1.place36.setBackground(Color.green);
        else Floor1.place36.setBackground(Color.red);
        if (nameEmpty(Floor1.place37.getText(), 100)) Floor1.place37.setBackground(Color.green);
        else Floor1.place37.setBackground(Color.red);
        if (nameEmpty(Floor1.place38.getText(), 100)) Floor1.place38.setBackground(Color.green);
        else Floor1.place38.setBackground(Color.red);
        if (nameEmpty(Floor1.place39.getText(), 100)) Floor1.place39.setBackground(Color.green);
        else Floor1.place39.setBackground(Color.red);
        if (nameEmpty(Floor1.place40.getText(), 100)) Floor1.place40.setBackground(Color.green);
        else Floor1.place40.setBackground(Color.red);
        if (nameEmpty(Floor1.place41.getText(), 100)) Floor1.place41.setBackground(Color.green);
        else Floor1.place41.setBackground(Color.red);
        if (nameEmpty(Floor1.place42.getText(), 100)) Floor1.place42.setBackground(Color.green);
        else Floor1.place42.setBackground(Color.red);
        if (nameEmpty(Floor1.place43.getText(), 100)) Floor1.place43.setBackground(Color.green);
        else Floor1.place43.setBackground(Color.red);
        if (nameEmpty(Floor1.place44.getText(), 100)) Floor1.place44.setBackground(Color.green);
        else Floor1.place44.setBackground(Color.red);
        if (nameEmpty(Floor1.place45.getText(), 100)) Floor1.place45.setBackground(Color.green);
        else Floor1.place45.setBackground(Color.red);
        if (nameEmpty(Floor1.place46.getText(), 100)) Floor1.place46.setBackground(Color.green);
        else Floor1.place46.setBackground(Color.red);
        if (nameEmpty(Floor1.place47.getText(), 100)) Floor1.place47.setBackground(Color.green);
        else Floor1.place47.setBackground(Color.red);
        if (nameEmpty(Floor1.place48.getText(), 100)) Floor1.place48.setBackground(Color.green);
        else Floor1.place48.setBackground(Color.red);
        if (nameEmpty(Floor1.place49.getText(), 100)) Floor1.place49.setBackground(Color.green);
        else Floor1.place49.setBackground(Color.red);
        if (nameEmpty(Floor1.place50.getText(), 100)) Floor1.place50.setBackground(Color.green);
        else Floor1.place50.setBackground(Color.red);
        if (nameEmpty(Floor1.place51.getText(), 100)) Floor1.place51.setBackground(Color.green);
        else Floor1.place51.setBackground(Color.red);
        if (nameEmpty(Floor1.place52.getText(), 100)) Floor1.place52.setBackground(Color.green);
        else Floor1.place52.setBackground(Color.red);
        if (nameEmpty(Floor1.place53.getText(), 100)) Floor1.place53.setBackground(Color.green);
        else Floor1.place53.setBackground(Color.red);
        if (nameEmpty(Floor1.place54.getText(), 100)) Floor1.place54.setBackground(Color.green);
        else Floor1.place54.setBackground(Color.red);
        if (nameEmpty(Floor1.place55.getText(), 100)) Floor1.place55.setBackground(Color.green);
        else Floor1.place55.setBackground(Color.red);
        if (nameEmpty(Floor1.place56.getText(), 100)) Floor1.place56.setBackground(Color.green);
        else Floor1.place56.setBackground(Color.red);
        if (nameEmpty(Floor1.place57.getText(), 100)) Floor1.place57.setBackground(Color.green);
        else Floor1.place57.setBackground(Color.red);
        if (nameEmpty(Floor1.place58.getText(), 100)) Floor1.place58.setBackground(Color.green);
        else Floor1.place58.setBackground(Color.red);
        if (nameEmpty(Floor1.place59.getText(), 100)) Floor1.place59.setBackground(Color.green);
        else Floor1.place59.setBackground(Color.red);
        if (nameEmpty(Floor1.place60.getText(), 100)) Floor1.place60.setBackground(Color.green);
        else Floor1.place60.setBackground(Color.red);
        if (nameEmpty(Floor1.place61.getText(), 100)) Floor1.place61.setBackground(Color.green);
        else Floor1.place61.setBackground(Color.red);
        
    }
    
    public static void updateFloorS1() {
        if (nameEmpty(FloorS1.place1.getText(), -Integer.parseInt(FloorS1.place1.getText())*2 -100)) FloorS1.place1.setBackground(Color.green);
        else FloorS1.place1.setBackground(Color.red);
        if (nameEmpty(FloorS1.place2.getText(), -Integer.parseInt(FloorS1.place2.getText())*2 -100)) FloorS1.place2.setBackground(Color.green);
        else FloorS1.place2.setBackground(Color.red);
        if (nameEmpty(FloorS1.place3.getText(), -Integer.parseInt(FloorS1.place3.getText())*2 -100)) FloorS1.place3.setBackground(Color.green);
        else FloorS1.place3.setBackground(Color.red);
        if (nameEmpty(FloorS1.place4.getText(), -Integer.parseInt(FloorS1.place4.getText())*2 -100)) FloorS1.place4.setBackground(Color.green);
        else FloorS1.place4.setBackground(Color.red);
        if (nameEmpty(FloorS1.place5.getText(), -Integer.parseInt(FloorS1.place5.getText())*2 -100)) FloorS1.place5.setBackground(Color.green);
        else FloorS1.place5.setBackground(Color.red);
        if (nameEmpty(FloorS1.place6.getText(), -Integer.parseInt(FloorS1.place6.getText())*2 -100)) FloorS1.place6.setBackground(Color.green);
        else FloorS1.place6.setBackground(Color.red);
        if (nameEmpty(FloorS1.place7.getText(), -Integer.parseInt(FloorS1.place7.getText())*2 -100)) FloorS1.place7.setBackground(Color.green);
        else FloorS1.place7.setBackground(Color.red);
        if (nameEmpty(FloorS1.place8.getText(), -Integer.parseInt(FloorS1.place8.getText())*2 -100)) FloorS1.place8.setBackground(Color.green);
        else FloorS1.place8.setBackground(Color.red);
        if (nameEmpty(FloorS1.place9.getText(), -Integer.parseInt(FloorS1.place9.getText())*2 -100)) FloorS1.place9.setBackground(Color.green);
        else FloorS1.place9.setBackground(Color.red);
        if (nameEmpty(FloorS1.place10.getText(), -Integer.parseInt(FloorS1.place10.getText())*2 -100)) FloorS1.place10.setBackground(Color.green);
        else FloorS1.place10.setBackground(Color.red);
        if (nameEmpty(FloorS1.place11.getText(), -Integer.parseInt(FloorS1.place11.getText())*2 -100)) FloorS1.place11.setBackground(Color.green);
        else FloorS1.place11.setBackground(Color.red);
        if (nameEmpty(FloorS1.place12.getText(), -Integer.parseInt(FloorS1.place12.getText())*2 -100)) FloorS1.place12.setBackground(Color.green);
        else FloorS1.place12.setBackground(Color.red);
        if (nameEmpty(FloorS1.place13.getText(), -Integer.parseInt(FloorS1.place13.getText())*2 -100)) FloorS1.place13.setBackground(Color.green);
        else FloorS1.place13.setBackground(Color.red);
        if (nameEmpty(FloorS1.place14.getText(), -Integer.parseInt(FloorS1.place14.getText())*2 -100)) FloorS1.place14.setBackground(Color.green);
        else FloorS1.place14.setBackground(Color.red);
        if (nameEmpty(FloorS1.place15.getText(), -Integer.parseInt(FloorS1.place15.getText())*2 -100)) FloorS1.place15.setBackground(Color.green);
        else FloorS1.place15.setBackground(Color.red);
        if (nameEmpty(FloorS1.place16.getText(), -Integer.parseInt(FloorS1.place16.getText())*2 -100)) FloorS1.place16.setBackground(Color.green);
        else FloorS1.place16.setBackground(Color.red);
        if (nameEmpty(FloorS1.place17.getText(), -Integer.parseInt(FloorS1.place17.getText())*2 -100)) FloorS1.place17.setBackground(Color.green);
        else FloorS1.place17.setBackground(Color.red);
        if (nameEmpty(FloorS1.place18.getText(), -Integer.parseInt(FloorS1.place18.getText())*2 -100)) FloorS1.place18.setBackground(Color.green);
        else FloorS1.place18.setBackground(Color.red);
        if (nameEmpty(FloorS1.place19.getText(), -Integer.parseInt(FloorS1.place19.getText())*2 -100)) FloorS1.place19.setBackground(Color.green);
        else FloorS1.place19.setBackground(Color.red);
        if (nameEmpty(FloorS1.place20.getText(), -Integer.parseInt(FloorS1.place20.getText())*2 -100)) FloorS1.place20.setBackground(Color.green);
        else FloorS1.place20.setBackground(Color.red);
        if (nameEmpty(FloorS1.place21.getText(), -Integer.parseInt(FloorS1.place21.getText())*2 -100)) FloorS1.place21.setBackground(Color.green);
        else FloorS1.place21.setBackground(Color.red);
        if (nameEmpty(FloorS1.place22.getText(), -Integer.parseInt(FloorS1.place22.getText())*2 -100)) FloorS1.place22.setBackground(Color.green);
        else FloorS1.place22.setBackground(Color.red);
        if (nameEmpty(FloorS1.place23.getText(), -Integer.parseInt(FloorS1.place23.getText())*2 -100)) FloorS1.place23.setBackground(Color.green);
        else FloorS1.place23.setBackground(Color.red);
        if (nameEmpty(FloorS1.place24.getText(), -Integer.parseInt(FloorS1.place24.getText())*2 -100)) FloorS1.place24.setBackground(Color.green);
        else FloorS1.place24.setBackground(Color.red);
        if (nameEmpty(FloorS1.place25.getText(), -Integer.parseInt(FloorS1.place25.getText())*2 -100)) FloorS1.place25.setBackground(Color.green);
        else FloorS1.place25.setBackground(Color.red);
        if (nameEmpty(FloorS1.place26.getText(), -Integer.parseInt(FloorS1.place26.getText())*2 -100)) FloorS1.place26.setBackground(Color.green);
        else FloorS1.place26.setBackground(Color.red);
        if (nameEmpty(FloorS1.place27.getText(), -Integer.parseInt(FloorS1.place27.getText())*2 -100)) FloorS1.place27.setBackground(Color.green);
        else FloorS1.place27.setBackground(Color.red);
        if (nameEmpty(FloorS1.place28.getText(), -Integer.parseInt(FloorS1.place28.getText())*2 -100)) FloorS1.place28.setBackground(Color.green);
        else FloorS1.place28.setBackground(Color.red);
        if (nameEmpty(FloorS1.place29.getText(), -Integer.parseInt(FloorS1.place29.getText())*2 -100)) FloorS1.place29.setBackground(Color.green);
        else FloorS1.place29.setBackground(Color.red);
        if (nameEmpty(FloorS1.place30.getText(), -Integer.parseInt(FloorS1.place30.getText())*2 -100)) FloorS1.place30.setBackground(Color.green);
        else FloorS1.place30.setBackground(Color.red);
        if (nameEmpty(FloorS1.place31.getText(), -Integer.parseInt(FloorS1.place31.getText())*2 -100)) FloorS1.place31.setBackground(Color.green);
        else FloorS1.place31.setBackground(Color.red);
        if (nameEmpty(FloorS1.place32.getText(), -Integer.parseInt(FloorS1.place32.getText())*2 -100)) FloorS1.place32.setBackground(Color.green);
        else FloorS1.place32.setBackground(Color.red);
        if (nameEmpty(FloorS1.place33.getText(), -Integer.parseInt(FloorS1.place33.getText())*2 -100)) FloorS1.place33.setBackground(Color.green);
        else FloorS1.place33.setBackground(Color.red);
        if (nameEmpty(FloorS1.place34.getText(), -Integer.parseInt(FloorS1.place34.getText())*2 -100)) FloorS1.place34.setBackground(Color.green);
        else FloorS1.place34.setBackground(Color.red);
        if (nameEmpty(FloorS1.place35.getText(), -Integer.parseInt(FloorS1.place35.getText())*2 -100)) FloorS1.place35.setBackground(Color.green);
        else FloorS1.place35.setBackground(Color.red);
        if (nameEmpty(FloorS1.place36.getText(), -Integer.parseInt(FloorS1.place36.getText())*2 -100)) FloorS1.place36.setBackground(Color.green);
        else FloorS1.place36.setBackground(Color.red);
        if (nameEmpty(FloorS1.place37.getText(), -Integer.parseInt(FloorS1.place37.getText())*2 -100)) FloorS1.place37.setBackground(Color.green);
        else FloorS1.place37.setBackground(Color.red);
        if (nameEmpty(FloorS1.place38.getText(), -Integer.parseInt(FloorS1.place38.getText())*2 -100)) FloorS1.place38.setBackground(Color.green);
        else FloorS1.place38.setBackground(Color.red);
        if (nameEmpty(FloorS1.place39.getText(), -Integer.parseInt(FloorS1.place39.getText())*2 -100)) FloorS1.place39.setBackground(Color.green);
        else FloorS1.place39.setBackground(Color.red);
        if (nameEmpty(FloorS1.place40.getText(), -Integer.parseInt(FloorS1.place40.getText())*2 -100)) FloorS1.place40.setBackground(Color.green);
        else FloorS1.place40.setBackground(Color.red);
        if (nameEmpty(FloorS1.place41.getText(), -Integer.parseInt(FloorS1.place41.getText())*2 -100)) FloorS1.place41.setBackground(Color.green);
        else FloorS1.place41.setBackground(Color.red);
        if (nameEmpty(FloorS1.place42.getText(), -Integer.parseInt(FloorS1.place42.getText())*2 -100)) FloorS1.place42.setBackground(Color.green);
        else FloorS1.place42.setBackground(Color.red);
        if (nameEmpty(FloorS1.place43.getText(), -Integer.parseInt(FloorS1.place43.getText())*2 -100)) FloorS1.place43.setBackground(Color.green);
        else FloorS1.place43.setBackground(Color.red);
        if (nameEmpty(FloorS1.place44.getText(), -Integer.parseInt(FloorS1.place44.getText())*2 -100)) FloorS1.place44.setBackground(Color.green);
        else FloorS1.place44.setBackground(Color.red);
        if (nameEmpty(FloorS1.place45.getText(), -Integer.parseInt(FloorS1.place45.getText())*2 -100)) FloorS1.place45.setBackground(Color.green);
        else FloorS1.place45.setBackground(Color.red);
        if (nameEmpty(FloorS1.place46.getText(), -Integer.parseInt(FloorS1.place46.getText())*2 -100)) FloorS1.place46.setBackground(Color.green);
        else FloorS1.place46.setBackground(Color.red);
        if (nameEmpty(FloorS1.place47.getText(), -Integer.parseInt(FloorS1.place47.getText())*2 -100)) FloorS1.place47.setBackground(Color.green);
        else FloorS1.place47.setBackground(Color.red);
        if (nameEmpty(FloorS1.place48.getText(), -Integer.parseInt(FloorS1.place48.getText())*2 -100)) FloorS1.place48.setBackground(Color.green);
        else FloorS1.place48.setBackground(Color.red);
        if (nameEmpty(FloorS1.place49.getText(), -Integer.parseInt(FloorS1.place49.getText())*2 -100)) FloorS1.place49.setBackground(Color.green);
        else FloorS1.place49.setBackground(Color.red);
        if (nameEmpty(FloorS1.place50.getText(), -Integer.parseInt(FloorS1.place50.getText())*2 -100)) FloorS1.place50.setBackground(Color.green);
        else FloorS1.place50.setBackground(Color.red);
        if (nameEmpty(FloorS1.place51.getText(), -Integer.parseInt(FloorS1.place51.getText())*2 -100)) FloorS1.place51.setBackground(Color.green);
        else FloorS1.place51.setBackground(Color.red);
        if (nameEmpty(FloorS1.place52.getText(), -Integer.parseInt(FloorS1.place52.getText())*2 -100)) FloorS1.place52.setBackground(Color.green);
        else FloorS1.place52.setBackground(Color.red);
        if (nameEmpty(FloorS1.place53.getText(), -Integer.parseInt(FloorS1.place53.getText())*2 -100)) FloorS1.place53.setBackground(Color.green);
        else FloorS1.place53.setBackground(Color.red);
        if (nameEmpty(FloorS1.place54.getText(), -Integer.parseInt(FloorS1.place54.getText())*2 -100)) FloorS1.place54.setBackground(Color.green);
        else FloorS1.place54.setBackground(Color.red);
        if (nameEmpty(FloorS1.place55.getText(), -Integer.parseInt(FloorS1.place55.getText())*2 -100)) FloorS1.place55.setBackground(Color.green);
        else FloorS1.place55.setBackground(Color.red);
        if (nameEmpty(FloorS1.place56.getText(), -Integer.parseInt(FloorS1.place56.getText())*2 -100)) FloorS1.place56.setBackground(Color.green);
        else FloorS1.place56.setBackground(Color.red);
        if (nameEmpty(FloorS1.place57.getText(), -Integer.parseInt(FloorS1.place57.getText())*2 -100)) FloorS1.place57.setBackground(Color.green);
        else FloorS1.place57.setBackground(Color.red);
        if (nameEmpty(FloorS1.place58.getText(), -Integer.parseInt(FloorS1.place58.getText())*2 -100)) FloorS1.place58.setBackground(Color.green);
        else FloorS1.place58.setBackground(Color.red);
        
    }
    
    public static Boolean nameEmpty(String a, int i) {
        Boolean r = false;
        try {
            id = (Integer.parseInt(a) + i);
            
            String query = "SELECT * FROM `" + DBPlaces + "` WHERE `ID` = '" + id + "'";
            st = connection.createStatement();
            ResultSet res = st.executeQuery(query);
            while(res.next()) {
                if(res.getString("name").equals("")) r = true;
                else r = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Floor0.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
    
    public static void readInfo(String a, int i) {
        try {
            id = (Integer.parseInt(a) + i);

            String query = "SELECT * FROM `" + DBPlaces + "` WHERE `ID` = '" + id + "'";
            st = connection.createStatement();
            InfoCar IC = new InfoCar();
            ResultSet res = st.executeQuery(query);
            while(res.next()) {
                NameTextField.setText(res.getString("name"));
                CarTextField.setText(res.getString("car"));
                PlateTextField.setText(res.getString("plate"));
                MoreTextArea.setText(res.getString("more"));
                PlaceLabel.setText(res.getString("name_place"));
            }
            query = "SELECT * FROM `" + DBLogin + "` WHERE `username` = '" + mainView.userConnected.getText() + "'";
            st = connection.createStatement();
            res = st.executeQuery(query);
            res.next();
            if (!res.getBoolean("edit_places")) {
                UpdateButton.setEnabled(false);
            }
                IC.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Floor0.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static double IVA() throws SQLException {
        return Double.parseDouble(messages.getString("IVA"));
    }
    
    public static double NormalPriceFirst() throws SQLException {
        return Double.parseDouble(messages.getString("NormalPriceFirst"));
    }
    
    public static double NormalPriceSecond() throws SQLException {
        return Double.parseDouble(messages.getString("NormalPriceSecond"));
    }
    
    public static double BigPriceFirst() throws SQLException {
        return Double.parseDouble(messages.getString("BigPriceFirst"));
    }
    
    public static double BigPriceSecond() throws SQLException {
        return Double.parseDouble(messages.getString("BigPriceSecond"));
    }
    
    
    
    
    
    
    
    
    public static Double round(Double numero, Integer decimales ) {
        return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
    }
    public static Integer day_year(Integer year) {
        GregorianCalendar calendar = new GregorianCalendar();
        if (calendar.isLeapYear(year)) 
            return 366;
        return 365;
    }
    public static Integer day_month(Integer month, Integer year) {
        Integer day = 1;
        GregorianCalendar calendar = new GregorianCalendar();
        if (calendar.isLeapYear(year)) {
            if (month == 2) day = 29;
            else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                day = 31;
            else 
                day = 30;
        }
        else {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                day = 31;
            else if (month == 2)
                day = 28;
            else 
                day = 30;
        }
        return day;
    }
    
    public static long final_time = 0;
    public static Double priceCalculator(String type) throws SQLException {
        String query = "";
        if (type.equals("Segellat Normal") || type.equals("Segellat Gran")) query = "SELECT * FROM `" + DBEntry + "` WHERE `ticket` = '" + MarkedCarExit.ticketTextField.getText() + "'";
        else query = "SELECT * FROM `" + DBEntry + "` WHERE `ticket` = '" + NormalCarExit.ticketTextField.getText() + "'";
        st = connection.createStatement();
        ResultSet res = st.executeQuery(query);
        java.util.Date date = new java.util.Date();
        double price = 0.0;
        
        while (res.next()) {
            Date date2 = new Date();
            date2.setMonth(res.getDate("entry_date").getMonth());
            date2.setDate(res.getDate("entry_date").getDate());
            date2.setHours(res.getTime("entry_time").getHours());
            date2.setMinutes(res.getTime("entry_time").getMinutes());
            date2.setSeconds(res.getTime("entry_time").getSeconds());
            
            
            Calendar calendar = new GregorianCalendar();
            calendar.set(date2.getYear() + 1900, date2.getMonth(), date2.getDate(), date2.getHours(), date2.getMinutes(), date2.getSeconds());
            Calendar actu = new GregorianCalendar();
            actu.setTime(date);
            
            final_time = ((actu.getTimeInMillis() - calendar.getTimeInMillis())/(60*1000)) + 1;
            
            
           
        }
        long final_time2 = final_time;
        switch (type) {
            
            case "Normal":
                if (final_time2 == 1) 
                    price += NormalPriceFirst();
                else if (final_time2 == 2)
                    price += NormalPriceFirst()*2;
                else {
                    price += NormalPriceFirst()*2;
                    final_time2 -= 2;
                    price += final_time2*NormalPriceSecond();
                }
                break;
                
            case "Segellat Normal":
                
                if (final_time2 - time_discount > 0) {
                    final_time2 -= time_discount;
                    if (final_time2 == 1) 
                        price += NormalPriceFirst();
                    else if (final_time2 == 2)
                        price += NormalPriceFirst()*2;
                    else {
                        price += NormalPriceFirst()*2;
                        final_time2 -= 2;
                        price += final_time2*NormalPriceSecond();
                    }
                }
                else
                    price = 0.0;
                break;
            
            case "Segellat Gran":
                 if (final_time2 - time_discount > 0) {
                    final_time2 -= time_discount;
                    if (final_time2 == 1) 
                        price += BigPriceFirst();
                    else if (final_time2 == 2)
                        price += BigPriceFirst()*2;
                    else {
                        price += BigPriceFirst()*2;
                        final_time2 -= 2;
                        price += final_time2*BigPriceSecond();
                    }
                }
                else 
                    price = 0.0;
                break;
                
            case "Gran":
                if (final_time2 == 1) 
                    price += BigPriceFirst();
                else if (final_time2 == 2)
                    price += BigPriceFirst()*2;
                else {
                    price += BigPriceFirst()*2;
                    final_time2 -= 2;
                    price += final_time2*BigPriceSecond();
                }
                break;
                
        }
        return round(price, 2);
    }
  
}


