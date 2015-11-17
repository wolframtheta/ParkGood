/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import static Views.Extra.*;
import static Views.Floor0.id;
import static Views.InfoCar.CarTextField;
import static Views.InfoCar.MoreTextArea;
import static Views.InfoCar.NameTextField;
import static Views.InfoCar.PlateTextField;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import static java.lang.System.exit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import static parkon.Main.connection;
import static parkon.Main.st;
import static parkon.Utilities.DBLogin;
import static parkon.Utilities.DBPlaces;

/**
 *
 * @author Xavier
 */
public class EditExtraPlace extends javax.swing.JFrame {

    Object num;
    public EditExtraPlace(Object id) {
        num = id;
        try {
            initComponents();
            this.setIconImage(new ImageIcon(this.getClass().getResource("/images/car-icon.png")).getImage());
            this.setLocationRelativeTo(null);
            
            getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                    KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Esc");
            getRootPane().getActionMap().put("Esc", new AbstractAction(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    setVisible(false);
                }
            });
            String query = "SELECT * FROM `" + DBLogin + "` WHERE `username` = '" + mainView.userConnected.getText() + "'";
            st = connection.createStatement();
            ResultSet res = st.executeQuery(query);
            res.next();
            if (!res.getBoolean("edit_places")) {
                UpdateButton.setEnabled(false);
            }
            
            query = "SELECT * FROM `" + DBPlaces + "` WHERE `ID` = '" + num + "'";
            st = connection.createStatement();
            res = st.executeQuery(query);
            res.next();
            NameTextField.setText(res.getString("name"));
            CarTextField.setText(res.getString("car"));
            PlateTextField.setText(res.getString("plate"));
            MoreTextArea.setText(res.getObject("more") + "");
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EditExtraPlace.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        MoreTextArea = new javax.swing.JTextArea();
        UpdateButton = new javax.swing.JButton();
        NameTextField = new javax.swing.JTextField();
        CarTextField = new javax.swing.JTextField();
        PlateTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        MoreTextArea.setColumns(20);
        MoreTextArea.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        MoreTextArea.setRows(5);
        jScrollPane1.setViewportView(MoreTextArea);

        UpdateButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        UpdateButton.setText("Actualitzar");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        NameTextField.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        CarTextField.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        PlateTextField.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Nom");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Cotxe");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Matrícula");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Altres");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(PlateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(CarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(UpdateButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(UpdateButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
       try {
            String update = "UPDATE `" + DBPlaces + "` SET `name` = '" + NameTextField.getText() + "', `car`  = '" + CarTextField.getText() + "', `plate` = '" + PlateTextField.getText() + "', `more` = '" + MoreTextArea.getText() + "' WHERE `ID` = '" + num + "'";
            PreparedStatement preparedStmt = connection.prepareStatement(update);
            preparedStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dades actualitzades!");
            this.setVisible(false);
            resetExtraTable();
            createExtraTable();
        } catch (SQLException ex) {
            Logger.getLogger(InfoCar.class.getName()).log(Level.SEVERE, null, ex);
        }
       this.setVisible(false);
    }//GEN-LAST:event_UpdateButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CarTextField;
    private javax.swing.JTextArea MoreTextArea;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JTextField PlateTextField;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}