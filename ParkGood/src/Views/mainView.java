/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Views;

import static parkgood.Main.connection;
import static parkgood.Main.st;
import static parkgood.Utilities.*;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

import parkgood.Car;
import parkgood.Clock;
import parkgood.TicketSummaryExit;

/**
 *
 * @author Xavier
 */
public class mainView extends javax.swing.JFrame {

    /**
     * Creates new form mainView
     */
    public static DefaultTableModel modelActive = new DefaultTableModel();
    public static DefaultTableModel modelHistory = new DefaultTableModel();
    static SimpleDateFormat formatDate2 = new SimpleDateFormat("dd/MM/yyyy");
    static Object[] row;
    
    public mainView() {
        initComponents();
        
        getRootPane().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_F1:
					normalButtonActionPerformed();
					break;
				case KeyEvent.VK_F2:
					bigButtonActionPerformed();
					break;
				case KeyEvent.VK_F4:
					fixedButtonActionPerformed();
					break;
				case KeyEvent.VK_F5:
					exitCarsButtonActionPerformed();
					break;
				case KeyEvent.VK_F6:
					exitFixedButtonActionPerformed();
					break;
				case KeyEvent.VK_F8:
					exitMarkedButtonActionPerformed();
					break;
				case KeyEvent.VK_F11:
					printTicketButtonActionPerformed();
					break;
				default:
					break;
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {}
		});
        printTicketButton.setText("<html><p>Imprimir ticket</p><p>a escollir F11</p></html>"); 
        exitCarsButton.setText("<html><p>Normal</p><p>Gran</p><p>Especial F5</p></html>");
        modelActive = new DefaultTableModel();
        activeTable.setModel(modelActive);
        modelActive.addColumn("Ticket");
        modelActive.addColumn("H. Entrada");
        modelActive.addColumn("D. Entrada");
        activeTable.setEnabled(false);
        modelHistory = new DefaultTableModel();
        historyTable.setModel(modelHistory);
        modelHistory.addColumn("Ticket");
        modelHistory.addColumn("H. Entrada");
        modelHistory.addColumn("D. Entrada");
        modelHistory.addColumn("H. Sortida");
        modelHistory.addColumn("D. Sortida");
        modelHistory.addColumn("Tipo");
        modelHistory.addColumn("Import");
        historyTable.setEnabled(false);
        
        
        try {
            createActiveTable();
            createHistoryTable();
        } catch (SQLException ex) {
            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        Clock clock = new Clock();
    }

    
    public static void updateHistoryTable(Integer ticket) throws SQLException {
        row = new Object[modelHistory.getColumnCount()];
        String query = "SELECT * FROM `" + DBEntry + "` WHERE `active` = '0' AND `ticket` = '" + ticket + "'";
        st = connection.createStatement();
        ResultSet res = st.executeQuery(query);
        while (res.next()) {
            for (int i = 0; i < modelHistory.getColumnCount(); i++) {
                if (i == 2) 
                    row[2] = formatDate2.format(res.getDate("entry_date"));
                else if (i == 4)
                    row[4] = formatDate2.format(res.getDate("exit_date"));
                else if (i == 6) 
                    row[6] = res.getDouble("price");
                else 
                    row[i] = res.getObject(i + 1);
            }
            modelHistory.addRow(row);
            historyTable.setModel(modelHistory);
        }
    }
    public static void createHistoryTable() throws SQLException {
        row = new Object[modelHistory.getColumnCount()];
        String query = "SELECT * FROM `" + DBEntry + "` WHERE `active` = '0'";
        st = connection.createStatement();
        ResultSet res = st.executeQuery(query);
        while (res.next()) {
            for (int i = 0; i < modelHistory.getColumnCount(); i++) {
                if (i == 2) 
                    row[2] = formatDate2.format(res.getDate("entry_date"));
                else if (i == 4)
                    row[4] = formatDate2.format(res.getDate("exit_date"));
                else if (i == 6) 
                    row[6] = res.getDouble("price");
                else 
                    row[i] = res.getObject(i + 1);
            }
            modelHistory.addRow(row);
            historyTable.setModel(modelHistory);
        }
    }
    public static void updateActiveTable() throws SQLException {
        row = new Object[modelActive.getColumnCount()];
        String query = "SELECT * FROM `" + DBEntry + "` ORDER BY `ticket` DESC LIMIT 1";
        st = connection.createStatement();
        ResultSet res = st.executeQuery(query);
        
        while (res.next()) {
            for (int i = 0; i < modelActive.getColumnCount(); i++) {
                if (i == 2) 
                    row[2] = formatDate2.format(res.getDate("entry_date"));
                else if (i == 3) 
                    row[3] = res.getObject(6);
                else row[i] = res.getObject(i + 1);
            }
            modelActive.addRow(row);
            activeTable.setModel(modelActive);
        }
    }

    public static void createActiveTable() throws SQLException {
        row = new Object[modelActive.getColumnCount()];
        String query = "SELECT * FROM `" + DBEntry + "` WHERE `active` = 1";
        st = connection.createStatement();
        ResultSet res = st.executeQuery(query);
        while (res.next()) {
            for (int i = 0; i < modelActive.getColumnCount(); i++) {
                if (i == 2) 
                    row[2] = formatDate2.format(res.getDate("entry_date"));
                else if (i == 3) row[3] = res.getObject(6);
                
                else row[i] = res.getObject(i + 1);
            }
            modelActive.addRow(row);
            activeTable.setModel(modelActive);
        }
    }

    static void resetActiveTable() {
        modelActive = new DefaultTableModel();
        activeTable.setModel(modelActive);
        modelActive.addColumn("Ticket");
        modelActive.addColumn("H. Entrada");
        modelActive.addColumn("D. Entrada");
        activeTable.setEnabled(false);
    }
    static void resetHistoryTable() {
        modelHistory = new DefaultTableModel();
        historyTable.setModel(modelHistory);
        modelHistory.addColumn("Ticket");
        modelHistory.addColumn("H. Entrada");
        modelHistory.addColumn("D. Entrada");
        modelHistory.addColumn("H. Sortida");
        modelHistory.addColumn("D. Sortida");
        modelHistory.addColumn("Tipo");
        modelHistory.addColumn("Import");
        historyTable.setEnabled(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        floor1Button = new javax.swing.JButton();
        floor0Button = new javax.swing.JButton();
        floorS1Button = new javax.swing.JButton();
        bigButton = new javax.swing.JButton();
        normalButton = new javax.swing.JButton();
        fixedButton = new javax.swing.JButton();
        printTicketButton = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        activeTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        historyTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        exitFixedButton = new javax.swing.JButton();
        exitCarsButton = new javax.swing.JButton();
        exitMarkedButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userConnected = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        clockLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(messages.getString("Application.0") + messages.getString("Application.3"));
        setIconImages(null);

        jButton2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton2.setText("Sortir");
        jButton2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				jButton2ActionPerformed();
			}
		});
        
        

        settingsButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        settingsButton.setText("Configuració");
        settingsButton.setEnabled(false);
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed();
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""))), "Parking", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        floor1Button.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        floor1Button.setText("Planta 1");
        floor1Button.setToolTipText("");
        floor1Button.setPreferredSize(new java.awt.Dimension(70, 23));
        floor1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floor1ButtonActionPerformed();
            }
        });

        floor0Button.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        floor0Button.setText("Planta 0");
        floor0Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floor0ButtonActionPerformed();
            }
        });

        floorS1Button.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        floorS1Button.setText("Planta -1");
        floorS1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floorS1ButtonActionPerformed();
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(floor0Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(floor1Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(floorS1Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(floor1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(floor0Button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(floorS1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(settingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(settingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        bigButton.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        bigButton.setText("Gran F2");
        bigButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bigButtonActionPerformed();
            }
        });

        normalButton.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        normalButton.setText("Normal F1");
        normalButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				normalButtonActionPerformed();				
			}
		});

        fixedButton.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        fixedButton.setText("Adelantat F4");
        fixedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixedButtonActionPerformed();
            }
        });

        printTicketButton.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        printTicketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printTicketButtonActionPerformed();
            }
        });

        activeTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        activeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ticket", "H. Entrada", "D. Entrada", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        activeTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(activeTable);
        if (activeTable.getColumnModel().getColumnCount() > 0) {
            activeTable.getColumnModel().getColumn(0).setResizable(false);
            activeTable.getColumnModel().getColumn(1).setResizable(false);
            activeTable.getColumnModel().getColumn(2).setResizable(false);
            activeTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jTabbedPane4.addTab("Dipòsit", jScrollPane3);

        historyTable.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        historyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Ticket", "H. Entrada", "D. Entrada", "H. Sortida", "D. Sortida", "Tipo", "Import"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        historyTable.setColumnSelectionAllowed(true);
        historyTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(historyTable);
        historyTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (historyTable.getColumnModel().getColumnCount() > 0) {
            historyTable.getColumnModel().getColumn(0).setResizable(false);
            historyTable.getColumnModel().getColumn(1).setResizable(false);
            historyTable.getColumnModel().getColumn(2).setResizable(false);
            historyTable.getColumnModel().getColumn(3).setResizable(false);
            historyTable.getColumnModel().getColumn(4).setResizable(false);
            historyTable.getColumnModel().getColumn(5).setResizable(false);
            historyTable.getColumnModel().getColumn(6).setResizable(false);
        }

        jTabbedPane4.addTab("Historial", jScrollPane4);

        exitFixedButton.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        exitFixedButton.setText("Adelantat F6");
        exitFixedButton.setMaximumSize(new java.awt.Dimension(73, 25));
        exitFixedButton.setMinimumSize(new java.awt.Dimension(73, 25));
        exitFixedButton.setPreferredSize(new java.awt.Dimension(73, 25));
        exitFixedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitFixedButtonActionPerformed();
            }
        });

        exitCarsButton.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        exitCarsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitCarsButtonActionPerformed();
            }
        });

        exitMarkedButton.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        exitMarkedButton.setText("Segellat F8");
        exitMarkedButton.setOpaque(false);
        exitMarkedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMarkedButtonActionPerformed();
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 3, 36)); // NOI18N
        jLabel4.setText("Sortida vehicles");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitMarkedButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitCarsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitFixedButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitCarsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitMarkedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitFixedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setText("Usuari:");

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 36)); // NOI18N
        jLabel3.setText("Entrada vehicles");

        userConnected.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        userConnected.setText("asfdas");

        clockLabel.setFont(new java.awt.Font("Calibri", 1, 50)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 50)); // NOI18N
        jLabel2.setText("GARATGE SALA");

        dateLabel.setFont(new java.awt.Font("Calibri", 1, 50)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userConnected)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fixedButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(printTicketButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(normalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bigButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clockLabel)
                        .addGap(42, 42, 42)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(clockLabel)
                                    .addComponent(dateLabel)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(normalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bigButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fixedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(printTicketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userConnected))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void floor1ButtonActionPerformed() {//GEN-FIRST:event_floor1ButtonActionPerformed
        Floor1 floor1 = new Floor1();
        floor1.setVisible(true);
    }//GEN-LAST:event_floor1ButtonActionPerformed

    private void floor0ButtonActionPerformed() {//GEN-FIRST:event_floor0ButtonActionPerformed
        Floor0 floor0 = new Floor0();
        floor0.setVisible(true);
    }//GEN-LAST:event_floor0ButtonActionPerformed

    private void floorS1ButtonActionPerformed() {//GEN-FIRST:event_floorS1ButtonActionPerformed
        FloorS1 floorS1 = new FloorS1();
        floorS1.setVisible(true);
    }//GEN-LAST:event_floorS1ButtonActionPerformed

    private void jButton2ActionPerformed() {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            TicketSummaryExit TSE = new TicketSummaryExit();
            String query = "DELETE FROM `" + DBEntry + "`WHERE `active` = '0'";
            st = connection.createStatement();
            st.execute(query);
            if (mainView.modelActive.getRowCount() == 0) {
            	query = "DELETE FROM `" + DBEntry + "`";
                st = connection.createStatement();
                st.execute(query);
	            query = "ALTER TABLE `" + DBEntry + "` auto_increment = 1";
	            st = connection.createStatement();
	            st.execute(query);
            }else {
            	JOptionPane.showMessageDialog(null, "No s'han pogut borrar les entrades! Encara hi han cotxes actius");
            }
            Login login = new Login();
            login.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bigButtonActionPerformed() {//GEN-FIRST:event_bigButtonActionPerformed
        try {
            Car car = new Car("Gran");
        } catch (SQLException ex) {
            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bigButtonActionPerformed
    
    private void normalButtonActionPerformed() {//GEN-FIRST:event_normalButtonActionPerformed
        try {
            Car car = new Car("Normal");
        } catch (SQLException ex) {
            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }//GEN-LAST:event_normalButtonActionPerformed

    private void settingsButtonActionPerformed() {//GEN-FIRST:event_settingsButtonActionPerformed
        Settings settings = new Settings();
        settings.setVisible(true);
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void printTicketButtonActionPerformed() {//GEN-FIRST:event_printTicketButtonActionPerformed
        PrintTicket PT = new PrintTicket();
        PT.setVisible(true);
    }//GEN-LAST:event_printTicketButtonActionPerformed

    private void exitCarsButtonActionPerformed() {//GEN-FIRST:event_exitCarsButtonActionPerformed
        NormalCarExit nCE = new NormalCarExit();
        nCE.setVisible(true);
    }//GEN-LAST:event_exitCarsButtonActionPerformed

    private void fixedButtonActionPerformed() {//GEN-FIRST:event_fixedButtonActionPerformed
        
        try {
            Car car = new Car("Adelantat");
        } catch (SQLException ex) {
            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fixedButtonActionPerformed

    private void exitMarkedButtonActionPerformed() {//GEN-FIRST:event_exitMarkedButtonActionPerformed
        MarkedCarExit MCE = new MarkedCarExit();
        MCE.setVisible(true);
    }//GEN-LAST:event_exitMarkedButtonActionPerformed

    private void exitFixedButtonActionPerformed() {//GEN-FIRST:event_exitFixedButtonActionPerformed
        FixedCarExit FCE = new FixedCarExit();
        FCE.setVisible(true);
    }//GEN-LAST:event_exitFixedButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable activeTable;
    private javax.swing.JButton bigButton;
    public static javax.swing.JLabel clockLabel;
    public static javax.swing.JLabel dateLabel;
    private javax.swing.JButton exitCarsButton;
    private javax.swing.JButton exitFixedButton;
    private javax.swing.JButton exitMarkedButton;
    private javax.swing.JButton fixedButton;
    private javax.swing.JButton floor0Button;
    private javax.swing.JButton floor1Button;
    private javax.swing.JButton floorS1Button;
    public static javax.swing.JTable historyTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JButton normalButton;
    private javax.swing.JButton printTicketButton;
    public javax.swing.JButton settingsButton;
    public static javax.swing.JLabel userConnected;
    // End of variables declaration//GEN-END:variables

    
}
