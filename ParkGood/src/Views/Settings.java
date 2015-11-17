/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Views;

import static Views.MarkedCarExit.ticketTextField;
import static Views.mainView.modelActive;
import static Views.mainView.row;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import static parkon.Main.connection;
import static parkon.Main.st;
import static parkon.Utilities.*;

/**
 *
 * @author Xavier
 */
public class Settings extends javax.swing.JFrame {

    static Object[] row;
    public static DefaultTableModel modelUser = new DefaultTableModel();
    static void userTableCreate() throws SQLException {
        String query = "SELECT * FROM `" + DBLogin + "`";
        ResultSet res = st.executeQuery(query);
        res.next();
        modelUser = new DefaultTableModel();
        usersTable.setModel(modelUser);
        modelUser.addColumn("ID");
        modelUser.addColumn("Usuari");
        modelUser.addColumn("Contrassenya");

        usersTable.setEnabled(false);
        row = new Object[modelUser.getColumnCount()]; 
        st = connection.createStatement();
        res = st.executeQuery(query);
        while (res.next()) {
            for (int i = 0; i < modelUser.getColumnCount(); ++i)
                row[i] = res.getString(i + 1);
            modelUser.addRow(row);
            usersTable.setModel(modelUser);
        }
    }

    static void updateComboBox() {
        try {
            String query = "SELECT * FROM `" + DBLogin + "`";
            ResultSet res = st.executeQuery(query);
            UserComboBox.removeAllItems();
            UserComboBox.addItem("Tria un usuari");
            while(res.next()) {
                UserComboBox.addItem(res.getString("username"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Creates new form Settings
     */
    public Settings() {
        initComponents();
        this.setIconImage(new ImageIcon(this.getClass().getResource("/images/car-icon.png")).getImage());
            this.setLocationRelativeTo(null);
        try {
            modelUser = new DefaultTableModel();
            usersTable.setModel(modelUser);
            modelUser.addColumn("ID");
            modelUser.addColumn("Usuari");
            modelUser.addColumn("Contrassenya");
            
            usersTable.setEnabled(false);
            
            row = new Object[modelUser.getColumnCount()];
            String query = "SELECT * FROM `" + DBLogin + "`";
            st = connection.createStatement();
            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                for (int i = 0; i < modelUser.getColumnCount(); ++i)
                    row[i] = res.getString(i+1);
                modelUser.addRow(row);
                usersTable.setModel(modelUser);
            }
            
            
            getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Escape"); 
            getRootPane().getActionMap().put("Escape", new AbstractAction(){ 
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });
            
            IVATextField.setText((int)IVA() + "");
            FirstNormalTextField.setText(NormalPriceFirst() + "");
            FirstBigTextField.setText(BigPriceFirst() + "");
            SecondBigTextField.setText(BigPriceSecond() + "");
            SecondNormalTextField.setText(NormalPriceSecond() + "");
            Settings.updateComboBox();
            query = "SELECT * FROM `" + DBLogin + "` WHERE `username` = '" + mainView.userConnected.getText() + "'";
            st = connection.createStatement();
            res = st.executeQuery(query);
            res.next();
            newUserButton.setEnabled(res.getBoolean("add_delete_users"));
            deleteUserButton.setEnabled(res.getBoolean("add_delete_users"));
            DeleteCounterButton.setEnabled(res.getBoolean("delete_counter"));
            UserComboBox.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        FirstNormalTextField = new javax.swing.JTextField();
        SecondNormalTextField = new javax.swing.JTextField();
        FirstBigTextField = new javax.swing.JTextField();
        SecondBigTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        IVATextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        newUserButton = new javax.swing.JButton();
        deleteUserButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        SettingsCheckBox = new javax.swing.JCheckBox();
        ExitCheckBox = new javax.swing.JCheckBox();
        AddDeleteCheckBox = new javax.swing.JCheckBox();
        UserComboBox = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        PlacesCheckBox = new javax.swing.JCheckBox();
        UpdatePermissionsUser = new javax.swing.JButton();
        DeleteCounterCheckBox = new javax.swing.JCheckBox();
        DeleteCounterButton = new javax.swing.JButton();

        setTitle("ParkGood 2014 - Configuració");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setText("IVA");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel2.setText("Cotxe Normal");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel3.setText("Cotxe Gran");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setText("Primers dos minuts");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel5.setText("Minuts successius");

        FirstNormalTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        FirstNormalTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        SecondNormalTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        SecondNormalTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        FirstBigTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        FirstBigTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        FirstBigTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstBigTextFieldActionPerformed(evt);
            }
        });

        SecondBigTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        SecondBigTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel6.setText("€/min");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel7.setText("€/min");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel8.setText("€/min");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel9.setText("€/min");

        IVATextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        IVATextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel10.setText("%");

        SaveButton.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        SaveButton.setText("Guardar");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IVATextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(117, 117, 117)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FirstNormalTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                    .addComponent(SecondNormalTextField)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 91, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 67, Short.MAX_VALUE)
                                        .addComponent(SaveButton))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(42, 42, 42)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SecondBigTextField)
                                            .addComponent(FirstBigTextField))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(IVATextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(FirstNormalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FirstBigTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(SecondNormalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SecondBigTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(SaveButton)
                .addGap(38, 38, 38))
        );

        jTabbedPane1.addTab("Preus", jPanel1);

        newUserButton.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        newUserButton.setText("Nou usuari");
        newUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserButtonActionPerformed(evt);
            }
        });

        deleteUserButton.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        deleteUserButton.setText("Eliminar usuari");
        deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserButtonActionPerformed(evt);
            }
        });

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Usuari", "Contrassenya"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersTable.setColumnSelectionAllowed(true);
        usersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(usersTable);
        usersTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (usersTable.getColumnModel().getColumnCount() > 0) {
            usersTable.getColumnModel().getColumn(0).setResizable(false);
            usersTable.getColumnModel().getColumn(0).setPreferredWidth(0);
            usersTable.getColumnModel().getColumn(1).setResizable(false);
            usersTable.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 320, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(230, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(newUserButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteUserButton)
                .addContainerGap(153, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Empleats", jPanel2);

        SettingsCheckBox.setText("Configuració");
        SettingsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsCheckBoxActionPerformed(evt);
            }
        });

        ExitCheckBox.setText("Sortir");

        AddDeleteCheckBox.setText("Afegir/Eliminar empleats");

        UserComboBox.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        UserComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        UserComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserComboBoxActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel11.setText("Permisos dels empleats");

        PlacesCheckBox.setText("Editar places");

        UpdatePermissionsUser.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        UpdatePermissionsUser.setText("Actualitzar permisos");
        UpdatePermissionsUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatePermissionsUserActionPerformed(evt);
            }
        });

        DeleteCounterCheckBox.setText("Borrar contador");

        DeleteCounterButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        DeleteCounterButton.setText("Borrar contador tickets");
        DeleteCounterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteCounterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UpdatePermissionsUser)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(UserComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SettingsCheckBox)
                                    .addComponent(ExitCheckBox))))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(AddDeleteCheckBox)
                                .addComponent(PlacesCheckBox)
                                .addComponent(DeleteCounterCheckBox))
                            .addComponent(DeleteCounterButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SettingsCheckBox)
                    .addComponent(AddDeleteCheckBox)
                    .addComponent(UserComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExitCheckBox)
                    .addComponent(PlacesCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DeleteCounterCheckBox)
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdatePermissionsUser)
                    .addComponent(DeleteCounterButton))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Permisos", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FirstBigTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstBigTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstBigTextFieldActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        try {
            String query = "UPDATE " + DBPrices + " SET `IVA` = '" + IVATextField.getText() + "', NormalPriceFirst = '" + FirstNormalTextField.getText() + "', NormalPriceSecond = '" + SecondNormalTextField.getText() + "', BigPriceFirst = '" + FirstBigTextField.getText() + "', BigPriceSecond = '" + SecondBigTextField.getText() + "'";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Valors actualitzats!", "Preus", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void newUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUserButtonActionPerformed
        Register register = new Register();
        register.setVisible(true);
    }//GEN-LAST:event_newUserButtonActionPerformed

    private void deleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserButtonActionPerformed
        DeleteUser deleteUser = new DeleteUser();
        deleteUser.setVisible(true);
    }//GEN-LAST:event_deleteUserButtonActionPerformed

    private void SettingsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SettingsCheckBoxActionPerformed

    private void UserComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserComboBoxActionPerformed
        
            try {
                String selection = (String)UserComboBox.getSelectedItem();
                if (selection != "Tria un usuari") {
                    String query = "SELECT * FROM `" + DBLogin + "` WHERE `username` = '" + selection + "'";
                    st = connection.createStatement();
                    ResultSet res = st.executeQuery(query);
                    res.next();
                        SettingsCheckBox.setSelected(res.getBoolean("settings"));
                        AddDeleteCheckBox.setSelected(res.getBoolean("add_delete_users"));
                        ExitCheckBox.setSelected(res.getBoolean("exit"));
                        PlacesCheckBox.setSelected(res.getBoolean("edit_places"));
                        DeleteCounterCheckBox.setSelected(res.getBoolean("delete_counter"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }//GEN-LAST:event_UserComboBoxActionPerformed

    private void UpdatePermissionsUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatePermissionsUserActionPerformed
        try {
            int settings = 0, users = 0, exit = 0, edit = 0, delete = 0;
            if (SettingsCheckBox.isSelected()) settings = 1;
            if (AddDeleteCheckBox.isSelected()) users = 1;
            if (ExitCheckBox.isSelected()) exit = 1;
            if (PlacesCheckBox.isSelected()) edit = 1;
            if (DeleteCounterCheckBox.isSelected()) delete = 1;
            System.out.print((String)UserComboBox.getSelectedItem());
            String query = "UPDATE `" + DBLogin + "` SET `settings` = '" + settings + "', `add_delete_users` = '" + users + "', `exit` = '" + exit + "', `edit_places` = '" + edit + "' WHERE `username` = '" + (String)UserComboBox.getSelectedItem() +  "'";
            System.out.print(query);
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Permisos actualitzats!");
        } catch (SQLException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UpdatePermissionsUserActionPerformed

    private void DeleteCounterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteCounterButtonActionPerformed
        try {
            int info = JOptionPane.showConfirmDialog(null, "Estàs segur d'eliminar les entrades?", "Confirmació", JOptionPane.YES_NO_OPTION);
            if (info == JOptionPane.YES_OPTION) {
                String query = "DELETE FROM `" + DBEntry + "`";
                st = connection.createStatement();
                st.execute(query);
                query = "ALTER TABLE `" + DBEntry + "` auto_increment = 1";
                st = connection.createStatement();
                st.execute(query);
                mainView.resetHistoryTable();
                mainView.createHistoryTable();
                mainView.resetActiveTable();
                mainView.createActiveTable();
                JOptionPane.showMessageDialog(null, "Entrades borrades!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_DeleteCounterButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox AddDeleteCheckBox;
    private javax.swing.JButton DeleteCounterButton;
    private javax.swing.JCheckBox DeleteCounterCheckBox;
    private javax.swing.JCheckBox ExitCheckBox;
    private javax.swing.JTextField FirstBigTextField;
    private javax.swing.JTextField FirstNormalTextField;
    private javax.swing.JTextField IVATextField;
    private javax.swing.JCheckBox PlacesCheckBox;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField SecondBigTextField;
    private javax.swing.JTextField SecondNormalTextField;
    private javax.swing.JCheckBox SettingsCheckBox;
    private javax.swing.JButton UpdatePermissionsUser;
    static javax.swing.JComboBox UserComboBox;
    private javax.swing.JButton deleteUserButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton newUserButton;
    public static javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
