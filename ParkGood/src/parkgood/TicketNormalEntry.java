/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parkgood;

import Views.MarkedCarExit;
import Views.NormalCarEntry;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 *
 * @author Xavier
 */
public class TicketNormalEntry implements Printable {
    
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
        g.drawString("GARATGE SALA" , 0, 16);
        g.setFont(new Font("asdf", Font.PLAIN, 9));
        g.drawString("C/ Galileo, 298, Barcelona", 110, 12);
        g.drawString("08028 Tel 93 490 72 67", 110, 23);
        g.drawString("Resguard dipòsit", 110, 70);
        g.drawString("de vehicle", 120, 80);
        g.drawLine(0, 30, 250, 30);
        g.setFont(new Font("asdf", Font.PLAIN, 10));
        g.drawString("DATA ENTRADA", 0, 50);
        g.drawString("HORA ENTRADA", 0, 90);
        g.drawString("NUMERO DE VEHICLE", 0, 130);
        g.setFont(new Font("asdf", Font.BOLD, 13));
        g.drawString(NormalCarEntry.entryDate.getText(), 0, 70);
        g.drawString(NormalCarEntry.entryTime.getText(), 0, 110);
        g.drawString(NormalCarEntry.entryTicketLabel.getText(), 0, 150);
        g.setFont(new Font("asdf", Font.BOLD, 10));
        g.drawString("AQUEST TICKET ÉS OBLIGATORI", 20, 170);
        g.drawString("PRESENTARLO AL RETIRAR EL VEHICLE", 0, 180);
        g.setFont(new Font("asdf", Font.ITALIC, 8));
        g.drawString("EL PROPIETARI DEIXA", 110, 100);
        g.drawString("LES CLAUS DEL VEHICLE", 100, 110);
        g.setFont(new Font("asdf", Font.PLAIN, 11));
        g.drawString("TICKET ENTRADA", 100, 50);
        return PAGE_EXISTS;
    }
 
    public TicketNormalEntry () {
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
            job.print();
        } catch (PrinterException ex) {
         System.out.printf("asdfasd");
        }
    }

    
     
    
    
}
