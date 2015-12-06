/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import static Views.mainView.modelActive;
import static parkgood.Main.connection;
import static parkgood.Main.st;
import static parkgood.Utilities.*;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

import parkgood.Utilities;

/**
 *
 * @author Xavier
 */
public class Extra extends javax.swing.JFrame {
    
    /**
     * Creates new form Extra
     */
    static int MAX = 0;
    static int MIN = 0;
    
    public static DefaultTableModel modelExtra = new DefaultTableModel();
    static Object[] row;
    public Extra(int i) {
        int mode = i;
        
        switch(mode) {
            
            case 0:
                MIN = 500;
                MAX = 699;
                break;
        }
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
        modelExtra = new DefaultTableModel();
        ExtraTable.setModel(modelExtra);
        modelExtra.addColumn("ID");
        modelExtra.addColumn("Nom");
        modelExtra.addColumn("Cotxe");
        modelExtra.addColumn("Matr�cula");
        modelExtra.addColumn("Altres");
        
        hideColumn(COL_ID, ExtraTable);
        hideColumn(COL_MORE, ExtraTable);
        ExtraTable.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ShowTextArea(ExtraTable.getSelectedRow());
                    
                }
                catch (Error ex){
                    Logger.getLogger(Extra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            private void ShowTextArea(int selectedRow) {
                MoreTextArea.setText(ExtraTable.getValueAt(selectedRow, COL_MORE).toString());
            }
            
        
        });
        try {
            createExtraTable();
        } catch (SQLException ex) {
            Logger.getLogger(Extra.class.getName()).log(Level.SEVERE, null, ex);
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
    	setTitle(messages.getString("Application.0") + messages.getString("Application.11"));
        jScrollPane1 = new javax.swing.JScrollPane();
        ExtraTable = new javax.swing.JTable();
        CreateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        MoreTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        ExtraTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        ExtraTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nom", "Cotxe", "Matricula", "Altres"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ExtraTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ExtraTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ExtraTable);
        if (ExtraTable.getColumnModel().getColumnCount() > 0) {
            ExtraTable.getColumnModel().getColumn(0).setResizable(false);
            ExtraTable.getColumnModel().getColumn(1).setResizable(false);
            ExtraTable.getColumnModel().getColumn(2).setResizable(false);
            ExtraTable.getColumnModel().getColumn(3).setResizable(false);
            ExtraTable.getColumnModel().getColumn(3).setPreferredWidth(0);
            ExtraTable.getColumnModel().getColumn(4).setResizable(false);
        }

        CreateButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        CreateButton.setText("Crear");
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        DeleteButton.setText("Eliminar");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        EditButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        EditButton.setText("Editar");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        MoreTextArea.setColumns(20);
        MoreTextArea.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        MoreTextArea.setRows(5);
        jScrollPane2.setViewportView(MoreTextArea);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("M�s");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CreateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EditButton)
                        .addGap(126, 126, 126)
                        .addComponent(DeleteButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CreateButton)
                            .addComponent(DeleteButton)
                            .addComponent(EditButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed
        new CreateExtraPlace(EXTRA1).setVisible(true);
    }//GEN-LAST:event_CreateButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        if (ExtraTable.getSelectedRow()== -1) JOptionPane.showMessageDialog(null, "Has de seleccionar una fila!");
        else {
            Object a = ((int)ExtraTable.getValueAt(ExtraTable.getSelectedRow(), COL_ID) + MIN);
            EditExtraPlace EEP = new EditExtraPlace(a);
            EEP.setVisible(true);   
        }
    }//GEN-LAST:event_EditButtonActionPerformed
    
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed

       
        if (ExtraTable.getSelectedRow()== -1) JOptionPane.showMessageDialog(null, "Has de seleccionar una fila!");
        else {
            int info = JOptionPane.showConfirmDialog(null, "Estàs segur d'eliminar aquesta entrada", "Confirmació", JOptionPane.YES_NO_OPTION);
            if (info == JOptionPane.YES_OPTION) {
                try {
                    Object a = ((int)ExtraTable.getValueAt(ExtraTable.getSelectedRow(), COL_ID) + MIN);
                    String query = "DELETE FROM `" + DBPlaces + "` WHERE `ID` = '" + a + "'";
                    st = connection.createStatement();
                    st.execute(query);
                    resetExtraTable();
                    createExtraTable();
                } catch (SQLException ex) {
                    Logger.getLogger(Extra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    public static void createExtraTable() throws SQLException {
        row = new Object[modelExtra.getColumnCount()];
        String query = "SELECT * FROM `" + DBPlaces + "` WHERE `ID` >= " + MIN + " AND `ID` <= " + MAX + " AND `name` != ''";
        st = connection.createStatement();
        ResultSet res = st.executeQuery(query);
        while (res.next()) {
            for (int i = 0; i < modelExtra.getColumnCount(); i++) {
                if (i == 0) row[0] = res.getInt("ID") - MIN;
                else row[i] = res.getObject(i + 2); 
            }
            modelExtra.addRow(row);
            ExtraTable.setModel(modelExtra);
        }
    }

    public static void resetExtraTable() {
        modelExtra = new DefaultTableModel();
        ExtraTable.setModel(modelExtra);
        modelExtra.addColumn("ID");
        modelExtra.addColumn("Nom");
        modelExtra.addColumn("Cotxe");
        modelExtra.addColumn("Matrícula");
        modelExtra.addColumn("Altres");
        hideColumn(COL_ID, ExtraTable);
        hideColumn(COL_MORE, ExtraTable);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    public static javax.swing.JTable ExtraTable;
    private javax.swing.JTextArea MoreTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    
}
