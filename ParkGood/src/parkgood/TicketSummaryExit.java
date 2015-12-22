/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parkgood;

import Views.FixedCarExit;
import static Views.mainView.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import static parkgood.Main.connection;
import static parkgood.Main.st;
import static parkgood.Utilities.DBEntry;
import static parkgood.Utilities.IVA;
import static parkgood.Utilities.round;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xavier
 */
public class TicketSummaryExit implements Printable {

    /**
     * @param args the command line arguments
     */
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
 
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
 
        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
 
        /* Now we perform our rendering */
        

        SimpleDateFormat formatDate2 = new SimpleDateFormat("dd/MM/yyyy");
        g.setFont(new Font("asdf", Font.BOLD, 8));
        g.drawString(userConnected.getText(), 0, 10);
        g.drawString(dateLabel.getText(), 40, 10);//dia salida
        g.drawString(clockLabel.getText(), 120, 10);//hora salida
        try {
            String query = "SELECT * FROM `" + DBEntry + "` WHERE `active` = '0' ORDER BY `exit_date` ASC, `exit_time` ASC";
            st = connection.createStatement();
            ResultSet res = st.executeQuery(query);
            res.next();
//            g.drawString(formatDate2.format(res.getDate("entry_date")), 110, 10);
 //           g.drawString(res.getTime("entry_time").toString(), 145, 10);
        
            g.drawString("DIA.E" , 0, 20);
            g.drawString("HORA.E",37, 20);
            g.drawString("DIA.S", 70, 20);
            g.drawString("HORA.S", 110, 20);
            g.drawString("TIPO", 143, 20);
            g.drawString("PREU", 175, 20);
        
                int i = 0;
                query = "SELECT * FROM `" + DBEntry + "` WHERE `active` = '0' ORDER BY `exit_date` ASC, `exit_time` ASC";
                st = connection.createStatement();
                res = st.executeQuery(query);
                Double price = 0.0;
                while(res.next()) {
                    g.setFont(new Font("asdf", Font.PLAIN, 7));
                    g.drawString(formatDate2.format(res.getDate("entry_date")), 0, 35 + i*10);
                    g.drawString(res.getTime("entry_time").toString(), 37, 35 + i*10);
                    g.drawString(formatDate2.format(res.getDate("exit_date")), 70, 35 + i*10);
                    g.drawString(res.getTime("exit_time").toString(), 110, 35 + i*10);
                    g.drawString(res.getString("type"), 143, 35 + i*10);
                    g.drawString(res.getDouble("price") +"0", 175, 35 + i*10);
                    ++i;
                    price += res.getDouble("price");
                }
                g.drawLine(0, 35 + i*10, 250, 35 + i*10);
                g.setFont(new Font("asdf", Font.BOLD, 8));
                g.drawString("Total cobrat: " + round(price, 2) + " €", 0, 35 + i*10 + 10);
            } catch (SQLException ex) {
                Logger.getLogger(TicketSummaryExit.class.getName()).log(Level.SEVERE, null, ex);
            }
        return PAGE_EXISTS;
    }
 
    public TicketSummaryExit() {
        PrinterJob job = PrinterJob.getPrinterJob();
        
        PageFormat pf0 = new PageFormat();
        PageFormat pf1 = (PageFormat) pf0.clone();
        
        Paper p = new Paper();
        p.setImageableArea(0,0,0,0);
        pf1.setPaper(p);
        PageFormat pf2 = job.validatePage(pf1);
        job.setPrintable(this, pf2);
        try {
            job.print();
        } catch (PrinterException ex) {
        }
    }
 
 
}