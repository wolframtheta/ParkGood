/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parkon;

import static Views.mainView.clockLabel;
import static Views.mainView.dateLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
 

/**
 *
 * @author Xavier
 */
public class Clock {
    
    public Clock(){
        Thread clock = new Thread() {
            public void run() {
                while (true) {
                    Calendar cal = new GregorianCalendar();
                    int second = cal.get(Calendar.SECOND);
                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR_OF_DAY);
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    int month = cal.get(Calendar.MONTH) + 1;
                    int year = cal.get(Calendar.YEAR);
                    if (month < 10)
                        dateLabel.setText(day + "-0" + month + "-" + year);
                    else if (day < 10)
                        dateLabel.setText("0" + day + "-" + month + "-" + year);
                    else 
                        dateLabel.setText(day + "-" + month + "-" + year);
                    if (second == 60) {
                        second = 0;
                        ++minute;
                    }
                    if (minute == 60) {
                        minute = 0;
                        ++hour;
                    }
                    if (hour == 24) hour = 0;
                    if (second < 10 && minute < 10 && hour < 10) 
                        clockLabel.setText("0" + hour + ":0" + minute + ":0" + second);
                    else if (minute < 10 && hour < 10)
                        clockLabel.setText("0" + hour + ":0" + minute + ":" + second);
                    else if (second < 10 && hour < 10)
                        clockLabel.setText("0" + hour + ":" + minute + ":0" + second);
                    else if (second < 10 && minute < 10)
                        clockLabel.setText(hour + ":0" + minute + ":0" + second);
                    else if (second < 10) 
                        clockLabel.setText(hour + ":" + minute + ":0" + second);
                    else if (minute < 10)
                        clockLabel.setText(hour + ":0" + minute + ":" + second);
                    else if (hour < 10)
                        clockLabel.setText("0" + hour + ":" + minute + ":" + second);
                    else
                        clockLabel.setText(hour + ":" + minute + ":" + second);
                    try{
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        clock.start();
    }


}
