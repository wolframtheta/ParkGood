/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Views;

import static parkgood.Main.connection;
import static parkgood.Main.st;
import static parkgood.Utilities.*;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import parkgood.Main;
import parkgood.TicketExit;
import parkgood.Utilities;

/**
 *
 * @author Xavier
 */
public class NormalCarExit extends javax.swing.JDialog {

    /**
     * Creates new form NormalCarExit
     */
    public NormalCarExit() {
        initComponents();
        intro = false;
        cashedNormalButton.setText("<html><p>Rebut</p><p>Cobrat F1</p></html>"); 
        printNormalButton.setText("<html><p>Imprimir</p><p>Rebut F2</p></html>"); 
        this.setIconImage(Utilities.imageParkGood);
        this.setLocationRelativeTo(null);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_ACCEPT, 0), "Accept"); 
        getRootPane().getActionMap().put("Accept", new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                ticketTextFieldActionPerformed(e);
            }
        });
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Escape"); 
        getRootPane().getActionMap().put("Escape", new AbstractAction(){ 
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
            }
        });
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "F1"); 
        getRootPane().getActionMap().put("F1", new AbstractAction(){ 
            public void actionPerformed(ActionEvent e)
            {
                cashedNormalButtonActionPerformed(e);
            }
        });
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "F2"); 
        getRootPane().getActionMap().put("F2", new AbstractAction(){ 
            public void actionPerformed(ActionEvent e)
            {
                printNormalButtonActionPerformed(e);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        minutesLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ticketTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        entryDateLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        entryTimeLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        exitDateLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        exitTimeLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        priceLabel = new javax.swing.JLabel();
        cashedNormalButton = new javax.swing.JButton();
        printNormalButton = new javax.swing.JButton();

        setTitle("ParkGood 2014 - Sortida cotxe (normal/gran)");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("INTRODUEIX NOMBRE DE VEHICLE");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel2.setText("DATA D'ENTRADA DE VEHICLE");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel3.setText("HORA D'ENTRADA DE VEHICLE");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel4.setText("DATA DE SORTIDA DE VEHICLE");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel5.setText("HORA DE SORTIDA DE VEHICLE");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel6.setText("IMPORT A COBRAR");

        minutesLabel.setText("Minuts");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 60)); // NOI18N
        jLabel7.setText("GARATGE SALA");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel9.setText("Sortida de Vehicle");

        ticketTextField.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        ticketTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ticketTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.setBackground(java.awt.Color.black);
        jPanel2.setForeground(java.awt.Color.blue);

        entryDateLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        entryDateLabel.setForeground(java.awt.Color.blue);
        entryDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(entryDateLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(entryDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.setBackground(java.awt.Color.white);

        entryTimeLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        entryTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(entryTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(entryTimeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(187, 187, 187));

        exitDateLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        exitDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(187, 187, 187));

        exitTimeLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        exitTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTimeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(java.awt.Color.red);

        priceLabel.setBackground(java.awt.Color.white);
        priceLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        priceLabel.setForeground(java.awt.Color.white);
        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(priceLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        cashedNormalButton.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        cashedNormalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashedNormalButtonActionPerformed(evt);
            }
        });

        printNormalButton.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        printNormalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printNormalButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(minutesLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel9))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addComponent(jLabel3))
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ticketTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cashedNormalButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(printNormalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addComponent(jLabel9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ticketTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cashedNormalButton)
                    .addComponent(printNormalButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(minutesLabel))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ticketTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketTextFieldActionPerformed
        if (!intro) {
            try {
                String count = "SELECT COUNT(`ticket`) AS `count` FROM `" + DBEntry + "` WHERE `ticket` = '" + Integer.parseInt(ticketTextField.getText()) + "' AND `type` = 'Adelantat' AND `active` = 1";
                st = connection.createStatement();
                ResultSet res = st.executeQuery(count);
                res.next();
                if (res.getInt("count") > 0) {
                    JOptionPane.showMessageDialog(null, "Aquest cotxe és adelantat");
                }
                else {

                    count = "SELECT COUNT(`ticket`) AS `count` FROM `" + DBEntry + "` WHERE `ticket` = '" + Integer.parseInt(ticketTextField.getText()) + "' AND `active` = 1";
                    st = connection.createStatement();
                    res = st.executeQuery(count);
                    res.next();
                    if (res.getInt("count") != 0) {
                        java.util.Date date = new java.util.Date();
                        String exitTime = formatTime.format(date);
                        String exitDate = formatDate.format(date);
                        String update = "UPDATE `entrycars` SET `exit_time` = '" + exitTime + "', `exit_date` = '" + exitDate + "' WHERE `ticket` = '" + Integer.parseInt(ticketTextField.getText()) + "'";
                        PreparedStatement preparedStmt = connection.prepareStatement(update);
                        preparedStmt.executeUpdate();
                        String query = "SELECT * FROM `" + DBEntry + "` WHERE `ticket` = '" + Integer.parseInt(ticketTextField.getText()) + "' AND `active` = 1";
                        st = connection.createStatement();
                        res = st.executeQuery(query);


                        SimpleDateFormat formatDate2 = new SimpleDateFormat("dd/MM/yyyy");
                        while (res.next()) {
                            double price = priceCalculator(res.getString("type"));
                            switch(res.getString("type")) {
                                case "Normal":
                                    if (price > Double.parseDouble(messages.getString("MaxPriceNormal"))) price = Double.parseDouble(messages.getString("MaxPriceNormal"));
                                    break;
                                case "Gran":
                                    if (price > Double.parseDouble(messages.getString("MaxPriceBig"))) price = Double.parseDouble(messages.getString("MaxPriceBig"));
                                    break;
                            }
                            
                            update = "UPDATE `entrycars` SET `price` = '" + price + "' WHERE `ticket` = '" + Integer.parseInt(ticketTextField.getText()) + "'";
                            preparedStmt = connection.prepareStatement(update);
                            preparedStmt.executeUpdate();

                            entryDateLabel.setText(formatDate2.format(res.getDate("entry_date")));
                            entryTimeLabel.setText(res.getTime("entry_time").toString());
                            exitDateLabel.setText(formatDate2.format(res.getDate("exit_date")));
                            exitTimeLabel.setText(res.getTime("exit_time").toString());
                            priceLabel.setText(price + "");
                            minutesLabel.setText(final_time + " Minuts");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Aquest número de ticket no existeix");
                        this.setVisible(false); 
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(NormalCarExit.class.getName()).log(Level.SEVERE, null, ex);
            }
            intro = true;
        }
        else cash();
    }//GEN-LAST:event_ticketTextFieldActionPerformed

    private void cashedNormalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashedNormalButtonActionPerformed
        
   
        cash();
        
    }//GEN-LAST:event_cashedNormalButtonActionPerformed

    private void printNormalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printNormalButtonActionPerformed
        TicketExit tE = new TicketExit();
        cash();
    }//GEN-LAST:event_printNormalButtonActionPerformed

    
    void cash() {
        String query = "UPDATE `entrycars` SET `active` = '0' WHERE `ticket` = '" + Integer.parseInt(ticketTextField.getText()) + "'";
        try {    
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.executeUpdate();
            mainView.resetHistoryTable();
            mainView.createHistoryTable();
            mainView.resetActiveTable();
            mainView.createActiveTable();
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(NormalCarExit.class.getName()).log(Level.SEVERE, null, ex);
        }
        intro = false;
        this.setVisible(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cashedNormalButton;
    public static javax.swing.JLabel entryDateLabel;
    public static javax.swing.JLabel entryTimeLabel;
    public static javax.swing.JLabel exitDateLabel;
    public static javax.swing.JLabel exitTimeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel minutesLabel;
    public static javax.swing.JLabel priceLabel;
    private javax.swing.JButton printNormalButton;
    public static javax.swing.JTextField ticketTextField;
    // End of variables declaration//GEN-END:variables
}
