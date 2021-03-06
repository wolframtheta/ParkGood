/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Views;

import static Views.InfoCar.*;
import static parkgood.Main.connection;
import static parkgood.Main.st;
import static parkgood.Utilities.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import parkgood.Utilities;

/**
 *
 * @author Xavier
 */
public class Floor0 extends javax.swing.JFrame {

    /**
     * Creates new form Floor0
     * @param parent
     * @param modal
     */
    public static Integer id = 0;
    public Floor0() {
        initComponents();
        this.setIconImage(Utilities.imageParkGood);
        this.setLocationRelativeTo(null);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Esc"); 
        getRootPane().getActionMap().put("Esc", new AbstractAction(){ 
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
            }
        });
        updateFloor0();
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	setTitle(messages.getString("Application.0") + messages.getString("Application.9"));
        jLabel1 = new javax.swing.JLabel();
        place1 = new javax.swing.JButton();
        place2 = new javax.swing.JButton();
        place3 = new javax.swing.JButton();
        place4 = new javax.swing.JButton();
        place5 = new javax.swing.JButton();
        place6 = new javax.swing.JButton();
        place7 = new javax.swing.JButton();
        place8 = new javax.swing.JButton();
        place9 = new javax.swing.JButton();
        place10 = new javax.swing.JButton();
        place11 = new javax.swing.JButton();
        place12 = new javax.swing.JButton();
        place13 = new javax.swing.JButton();
        place14 = new javax.swing.JButton();
        place15 = new javax.swing.JButton();
        place16 = new javax.swing.JButton();
        place17 = new javax.swing.JButton();
        place18 = new javax.swing.JButton();
        place19 = new javax.swing.JButton();
        place20 = new javax.swing.JButton();
        place21 = new javax.swing.JButton();
        place22 = new javax.swing.JButton();
        place23 = new javax.swing.JButton();
        place24 = new javax.swing.JButton();
        place25 = new javax.swing.JButton();
        place26 = new javax.swing.JButton();
        place27 = new javax.swing.JButton();
        place28 = new javax.swing.JButton();
        place29 = new javax.swing.JButton();
        place30 = new javax.swing.JButton();
        place31 = new javax.swing.JButton();
        place32 = new javax.swing.JButton();
        place33 = new javax.swing.JButton();
        place34 = new javax.swing.JButton();
        place35 = new javax.swing.JButton();
        place36 = new javax.swing.JButton();
        place37 = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setTitle("ParkGood 2014 - Planta 0");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel1.setText("PLANTA 0");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	try {
            	 String query = "SELECT * FROM `" + DBLogin + "` WHERE `username` = '" + mainView.userConnected.getText() + "'";
                 st = connection.createStatement();
                 ResultSet res = st.executeQuery(query);
                 res.next();
                 if (res.getBoolean("extra_floor")) jLabel1MouseClicked(evt);
            	}catch(SQLException ex) {
            Logger.getLogger(Floor0.class.getName()).log(Level.SEVERE, null, ex);
            
            }
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 200, 60));

        place1.setText("1");
        place1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place1ActionPerformed(evt);
            }
        });
        getContentPane().add(place1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 570, 30, -1));

        place2.setText("2");
        place2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place2ActionPerformed(evt);
            }
        });
        getContentPane().add(place2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 20, 30));

        place3.setText("3");
        place3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place3ActionPerformed(evt);
            }
        });
        getContentPane().add(place3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 20, 30));

        place4.setText("4");
        place4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place4ActionPerformed(evt);
            }
        });
        getContentPane().add(place4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 30, -1));

        place5.setText("5");
        place5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place5ActionPerformed(evt);
            }
        });
        getContentPane().add(place5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 30, -1));

        place6.setText("6");
        place6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place6ActionPerformed(evt);
            }
        });
        getContentPane().add(place6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 30, -1));

        place7.setText("7");
        place7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place7ActionPerformed(evt);
            }
        });
        getContentPane().add(place7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 20, 30));

        place8.setText("8");
        place8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place8ActionPerformed(evt);
            }
        });
        getContentPane().add(place8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 20, 30));

        place9.setText("9");
        place9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place9ActionPerformed(evt);
            }
        });
        getContentPane().add(place9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 20, -1));

        place10.setText("10");
        place10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place10ActionPerformed(evt);
            }
        });
        getContentPane().add(place10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 20, 30));

        place11.setText("11");
        place11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place11ActionPerformed(evt);
            }
        });
        getContentPane().add(place11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 20, 20));

        place12.setText("12");
        place12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place12ActionPerformed(evt);
            }
        });
        getContentPane().add(place12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 20, 30));

        place13.setText("13");
        place13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place13ActionPerformed(evt);
            }
        });
        getContentPane().add(place13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 40, -1));

        place14.setText("14");
        place14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place14ActionPerformed(evt);
            }
        });
        getContentPane().add(place14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 40, -1));

        place15.setText("15");
        place15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place15ActionPerformed(evt);
            }
        });
        getContentPane().add(place15, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 40, -1));

        place16.setText("16");
        place16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place16ActionPerformed(evt);
            }
        });
        getContentPane().add(place16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 40, -1));

        place17.setText("17");
        place17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place17ActionPerformed(evt);
            }
        });
        getContentPane().add(place17, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 30, -1));

        place18.setText("18");
        place18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place18ActionPerformed(evt);
            }
        });
        getContentPane().add(place18, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 40, -1));

        place19.setText("19");
        place19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place19ActionPerformed(evt);
            }
        });
        getContentPane().add(place19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 40, -1));

        place20.setText("20");
        place20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place20ActionPerformed(evt);
            }
        });
        getContentPane().add(place20, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 30, -1));

        place21.setText("21");
        place21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place21ActionPerformed(evt);
            }
        });
        getContentPane().add(place21, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 40, -1));

        place22.setText("22");
        place22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place22ActionPerformed(evt);
            }
        });
        getContentPane().add(place22, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 40, -1));

        place23.setText("23");
        place23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place23ActionPerformed(evt);
            }
        });
        getContentPane().add(place23, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 30, -1));

        place24.setText("24");
        place24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place24ActionPerformed(evt);
            }
        });
        getContentPane().add(place24, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 30, -1));

        place25.setText("25");
        place25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place25ActionPerformed(evt);
            }
        });
        getContentPane().add(place25, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 20, 20));

        place26.setText("26");
        place26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place26ActionPerformed(evt);
            }
        });
        getContentPane().add(place26, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, 20, 20));

        place27.setText("27");
        place27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place27ActionPerformed(evt);
            }
        });
        getContentPane().add(place27, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, 20, 20));

        place28.setText("28");
        place28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place28ActionPerformed(evt);
            }
        });
        getContentPane().add(place28, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 150, 20, 20));

        place29.setText("29");
        place29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place29ActionPerformed(evt);
            }
        });
        getContentPane().add(place29, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 20, 40));

        place30.setText("30");
        place30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place30ActionPerformed(evt);
            }
        });
        getContentPane().add(place30, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, 20, 40));

        place31.setText("31");
        place31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place31ActionPerformed(evt);
            }
        });
        getContentPane().add(place31, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, 20, 30));

        place32.setText("32");
        place32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place32ActionPerformed(evt);
            }
        });
        getContentPane().add(place32, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 30, -1));

        place33.setText("33");
        place33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place33ActionPerformed(evt);
            }
        });
        getContentPane().add(place33, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, 30, -1));

        place34.setText("34");
        place34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place34ActionPerformed(evt);
            }
        });
        getContentPane().add(place34, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 30, -1));

        place35.setText("35");
        place35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place35ActionPerformed(evt);
            }
        });
        getContentPane().add(place35, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 30, -1));

        place36.setText("36");
        place36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place36ActionPerformed(evt);
            }
        });
        getContentPane().add(place36, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 20, -1));

        place37.setText("37");
        place37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place37ActionPerformed(evt);
            }
        });
        getContentPane().add(place37, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, 20, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/planta0.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 890, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void place13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place13ActionPerformed
        
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place13ActionPerformed

    private void place14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place14ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place14ActionPerformed

    private void place15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place15ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place15ActionPerformed

    private void place16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place16ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place16ActionPerformed

    private void place17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place17ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place17ActionPerformed

    private void place18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place18ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place18ActionPerformed

    private void place19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place19ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place19ActionPerformed

    private void place20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place20ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place20ActionPerformed

    private void place21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place21ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place21ActionPerformed

    private void place22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place22ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place22ActionPerformed

    private void place23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place23ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place23ActionPerformed

    private void place2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place2ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place2ActionPerformed

    private void place25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place25ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place25ActionPerformed

    private void place26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place26ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place26ActionPerformed

    private void place29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place29ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place29ActionPerformed

    private void place30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place30ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place30ActionPerformed

    private void place31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place31ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place31ActionPerformed

    private void place24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place24ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place24ActionPerformed

    private void place32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place32ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place32ActionPerformed

    private void place33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place33ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place33ActionPerformed

    private void place34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place34ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place34ActionPerformed

    private void place1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place1ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place1ActionPerformed

    private void place5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place5ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place5ActionPerformed

    private void place6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place6ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place6ActionPerformed

    private void place35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place35ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place35ActionPerformed

    private void place36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place36ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place36ActionPerformed

    private void place12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place12ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place12ActionPerformed

    private void place3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place3ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place3ActionPerformed

    private void place7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place7ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place7ActionPerformed

    private void place8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place8ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place8ActionPerformed

    private void place9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place9ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place9ActionPerformed

    private void place10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place10ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place10ActionPerformed

    private void place11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place11ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place11ActionPerformed

    private void place4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place4ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place4ActionPerformed

    private void place37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place37ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place37ActionPerformed

    private void place27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place27ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place27ActionPerformed

    private void place28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place28ActionPerformed
        readInfo(evt.getActionCommand(), 0);
    }//GEN-LAST:event_place28ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Extra E = new Extra(0);
        E.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JButton place1;
    public static javax.swing.JButton place10;
    public static javax.swing.JButton place11;
    public static javax.swing.JButton place12;
    public static javax.swing.JButton place13;
    public static javax.swing.JButton place14;
    public static javax.swing.JButton place15;
    public static javax.swing.JButton place16;
    public static javax.swing.JButton place17;
    public static javax.swing.JButton place18;
    public static javax.swing.JButton place19;
    public static javax.swing.JButton place2;
    public static javax.swing.JButton place20;
    public static javax.swing.JButton place21;
    public static javax.swing.JButton place22;
    public static javax.swing.JButton place23;
    public static javax.swing.JButton place24;
    public static javax.swing.JButton place25;
    public static javax.swing.JButton place26;
    public static javax.swing.JButton place27;
    public static javax.swing.JButton place28;
    public static javax.swing.JButton place29;
    public static javax.swing.JButton place3;
    public static javax.swing.JButton place30;
    public static javax.swing.JButton place31;
    public static javax.swing.JButton place32;
    public static javax.swing.JButton place33;
    public static javax.swing.JButton place34;
    public static javax.swing.JButton place35;
    public static javax.swing.JButton place36;
    public static javax.swing.JButton place37;
    public static javax.swing.JButton place4;
    public static javax.swing.JButton place5;
    public static javax.swing.JButton place6;
    public static javax.swing.JButton place7;
    public static javax.swing.JButton place8;
    public static javax.swing.JButton place9;
    // End of variables declaration//GEN-END:variables

    
}
