/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parkon;

import Views.NormalCarExit;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import static java.lang.Math.round;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import static parkon.Utilities.IVA;

/**
 *
 * @author Xavier
 */
public class TicketExit implements Printable {

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
        
        g.setFont(new Font("asdf", Font.BOLD, 14));
        g.drawString("GARATGE SALA" , 10, 16);
        g.setFont(new Font("asdf", Font.PLAIN, 9));
        g.drawString("C/ Galileu, 298", 130, 12);
        g.drawString("Barcelona 08028", 130, 23);
        g.drawString("Telf: 93 490 72 67", 130, 34);
        g.drawString("GARATGE SALA ROSTES, S.L.", 0, 25);
        g.drawString("CIF. B60908795", 0, 35);
        g.drawString("Número Rebut:  " + NormalCarExit.ticketTextField.getText(), 80, 80);
        g.drawString("Gràcies per la seva visita", 80, 260);
        g.drawLine(0, 45, 250, 45);
        g.drawString("REBUT DE SORTIDA", 80, 70);
        g.setFont(new Font("asdf", Font.PLAIN, 10));
        g.drawString("NUMERO DE VEHICLE", 0, 100);
        g.drawString("TOTAL", 0, 140);
        g.drawString("21% IVA", 0, 180);
        g.drawString("TOTAL IMPORT", 0, 220);
        g.drawString("DATA ENTRADA", 125, 100);
        g.drawString("HORA ENTRADA", 125, 140);
        g.drawString("DATA SORTIDA", 125, 180);
        g.drawString("HORA SORTIDA", 125, 220);
        g.setFont(new Font("asdf", Font.BOLD, 13));
        g.drawString(NormalCarExit.entryDateLabel.getText(), 135, 120); //ENTRY DATE
        g.drawString(NormalCarExit.entryTimeLabel.getText(), 135, 160); //ENTRY TIME
        g.drawString(NormalCarExit.exitDateLabel.getText(), 135, 200); //EXIT DATE
        g.drawString(NormalCarExit.exitTimeLabel.getText(), 135, 240); //EXIT TIME
        g.drawString(NormalCarExit.ticketTextField.getText(), 0, 120);
        Double d = 0.0;
        try {
            d = Utilities.round(Double.parseDouble(NormalCarExit.priceLabel.getText())/(1.0 + IVA()/100), 2);
        } catch (SQLException ex) {
            Logger.getLogger(TicketExit.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.drawString(Utilities.round(Double.parseDouble(NormalCarExit.priceLabel.getText()) - d, 2) + " €", 0, 200);
        g.drawString(NormalCarExit.priceLabel.getText() + " €", 0, 245);
        g.drawString(d + " €", 0, 160);
        g.setFont(new Font("asdf", Font.PLAIN, 8)); 
        g.drawString("(IVA Inclòs)", 0, 230);
        g.drawLine(0, 250, 250, 250);
        return PAGE_EXISTS;
    }
 
    public TicketExit () {
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
         System.out.printf("asdfasd");
        }
    }
 
 
}
