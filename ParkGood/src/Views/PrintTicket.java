/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Views;

import static Views.NormalCarExit.entryDateLabel;
import static Views.NormalCarExit.entryTimeLabel;
import static Views.NormalCarExit.exitDateLabel;
import static Views.NormalCarExit.exitTimeLabel;
import static Views.NormalCarExit.priceLabel;
import static parkgood.Main.connection;
import static parkgood.Main.st;
import static parkgood.Utilities.DBEntry;
import static parkgood.Utilities.messages;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import parkgood.TicketExit;
import parkgood.TicketFixedExit;
import parkgood.TicketMarkedExit;

/**
 *
 * @author Xavier
 */
public class PrintTicket extends javax.swing.JFrame {

    /**
     * Creates new form PrintTicket
     */
    public PrintTicket() {
        initComponents();
        this.setIconImage(new ImageIcon(this.getClass().getResource("/images/car-icon.png")).getImage());
        this.setLocationRelativeTo(null);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_ACCEPT, 0), "Accept"); 
        getRootPane().getActionMap().put("Accept", new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                TicketTextFieldActionPerformed(e);
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
        TicketTextField = new javax.swing.JTextField();
        PrintButton = new javax.swing.JButton();


    	setTitle(messages.getString("Application.0") + messages.getString("Application.7"));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("N�mero ticket");

        TicketTextField.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        TicketTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TicketTextFieldActionPerformed(evt);
            }
        });

        PrintButton.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        PrintButton.setText("Imprimir");
        PrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(TicketTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(PrintButton)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TicketTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(PrintButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TicketTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TicketTextFieldActionPerformed
        PrintButtonActionPerformed(evt);
    }//GEN-LAST:event_TicketTextFieldActionPerformed

    private void PrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintButtonActionPerformed
        try {
            String query = "SELECT * FROM `" + DBEntry + "` WHERE `ticket` = '" + TicketTextField.getText() + "'";
            
            st = connection.createStatement();
            ResultSet res = st.executeQuery(query);
            SimpleDateFormat formatDate2 = new SimpleDateFormat("dd/MM/yyyy");
            while (res.next()) {
                if (res.getInt("active") == 1) JOptionPane.showMessageDialog(null, "Aquest cotxe encara no ha sortit");
                else {
                    switch (res.getString("type")) {
                        case "Adelantat":
                                FixedCarExit FCE = new FixedCarExit();
                                FixedCarExit.ticketTextField.setText(TicketTextField.getText());
                                FixedCarExit.entryDateLabel.setText(formatDate2.format(res.getDate("entry_date")));
                                FixedCarExit.entryTimeLabel.setText(res.getTime("entry_time").toString());
                                FixedCarExit.exitDateLabel.setText(formatDate2.format(res.getDate("exit_date")));
                                FixedCarExit.exitTimeLabel.setText(res.getTime("exit_time").toString());
                                FixedCarExit.priceLabel.setText(res.getDouble("price") + "");
                                TicketFixedExit TFE = new TicketFixedExit();
                                break;
                        case "Segellat":
                                MarkedCarExit MCE = new MarkedCarExit();
                                MarkedCarExit.ticketTextField.setText(TicketTextField.getText());
                                MarkedCarExit.entryDateLabel.setText(formatDate2.format(res.getDate("entry_date")));
                                MarkedCarExit.entryTimeLabel.setText(res.getTime("entry_time").toString());
                                MarkedCarExit.exitDateLabel.setText(formatDate2.format(res.getDate("exit_date")));
                                MarkedCarExit.exitTimeLabel.setText(res.getTime("exit_time").toString());
                                MarkedCarExit.priceLabel.setText(res.getDouble("price") + "");
                                TicketMarkedExit TME = new TicketMarkedExit();
                                break;
                        default:
                                NormalCarExit NCE = new NormalCarExit();
                                NormalCarExit.ticketTextField.setText(TicketTextField.getText());
                                NormalCarExit.entryDateLabel.setText(formatDate2.format(res.getDate("entry_date")));
                                NormalCarExit.entryTimeLabel.setText(res.getTime("entry_time").toString());
                                NormalCarExit.exitDateLabel.setText(formatDate2.format(res.getDate("exit_date")));
                                NormalCarExit.exitTimeLabel.setText(res.getTime("exit_time").toString());
                                NormalCarExit.priceLabel.setText(res.getDouble("price") + "");
                                TicketExit TE = new TicketExit();
                                break;
                    }
                }
            }
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(PrintTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PrintButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PrintButton;
    private javax.swing.JTextField TicketTextField;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
