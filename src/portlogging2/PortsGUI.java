/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portlogging2;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import portlogging2.PortGetting.Protocoll;
import static portlogging2.PortGetting.netStat;

/**
 *
 * @author falcu
 */
public class PortsGUI extends javax.swing.JFrame {

    /**
     * Creates new form PortsGUI
     *
     * @throws java.io.IOException
     */
    public PortsGUI() throws IOException {
        logFile = new File(System.getProperty("user.dir"), "log.txt");
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
        TrayMenuSet();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LISTENING = new javax.swing.JButton();
        ESTABLISHED = new javax.swing.JButton();
        TIME_WAIT = new javax.swing.JButton();
        BOUND = new javax.swing.JButton();
        CLOSE_WAIT = new javax.swing.JButton();
        ALL = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        portsView = new javax.swing.JTextArea();
        UDP = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setTitle("Logging Ports(As CMD)");
        setFocusable(false);

        LISTENING.setText("LISTENING");
        LISTENING.setFocusable(false);
        LISTENING.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LISTENINGActionPerformed(evt);
            }
        });

        ESTABLISHED.setText("ESTABLISHED");
        ESTABLISHED.setFocusable(false);
        ESTABLISHED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ESTABLISHEDActionPerformed(evt);
            }
        });

        TIME_WAIT.setText("TIME_WAIT");
        TIME_WAIT.setFocusable(false);
        TIME_WAIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIME_WAITActionPerformed(evt);
            }
        });

        BOUND.setText("BOUND");
        BOUND.setFocusable(false);
        BOUND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOUNDActionPerformed(evt);
            }
        });

        CLOSE_WAIT.setText("CLOSE_WAIT");
        CLOSE_WAIT.setFocusable(false);
        CLOSE_WAIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLOSE_WAITActionPerformed(evt);
            }
        });

        ALL.setText("ALL");
        ALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ALLActionPerformed(evt);
            }
        });

        jScrollPane1.setFocusable(false);
        jScrollPane1.setRequestFocusEnabled(false);

        portsView.setEditable(false);
        portsView.setColumns(20);
        portsView.setRows(5);
        jScrollPane1.setViewportView(portsView);

        UDP.setText("UDP");
        UDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UDPActionPerformed(evt);
            }
        });

        jButton1.setText("STOP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ESTABLISHED, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LISTENING, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TIME_WAIT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BOUND, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CLOSE_WAIT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ALL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LISTENING)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ESTABLISHED)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TIME_WAIT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BOUND)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CLOSE_WAIT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UDP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ALL)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Thread t1;
    Thread t2;
    Thread t3;
    Thread t4;
    Thread t5;
    Thread t6;
    Thread t7;
    File logFile;
    FileWriter fw;
    BufferedWriter bw;

    private void LISTENINGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LISTENINGActionPerformed
        LISTENING.setEnabled(false);
        t1 = new Thread() {
            @Override
            public void run() {
                super.run();
                portsView.setText("");
                portsView.append(String.format("%-22s %-22s %-22s %-22s %s", "Time", "Protocol", "Local Address", "Foreign Address", "Status") + "\n");
                while (t1.isAlive()) {
                    System.out.println("Thread is running...");
                    try {
                        for (Protocoll p : netStat()) {
                            if (p.status.equals(LISTENING.getText())) {
                                portsView.append(p.toString() + "\n");
                                fw = new FileWriter(logFile, true);
                                bw = new BufferedWriter(fw);
                                bw.append(p.toString());
                                bw.newLine();
                                bw.close();
                            }
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(PortsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        t1.start();
    }//GEN-LAST:event_LISTENINGActionPerformed

    private void ESTABLISHEDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ESTABLISHEDActionPerformed
        ESTABLISHED.setEnabled(false);
        t2 = new Thread() {
            @Override
            public void run() {
                super.run(); //To change body of generated methods, choose Tools | Templates.
                portsView.setText("");
                portsView.append(String.format("%-22s %-22s %-22s %-22s %s", "Time", "Protocol", "Local Address", "Foreign Address", "Status") + "\n");
                while (t2.isAlive()) {
                    System.out.println("Thread is running...");
                    try {
                        for (Protocoll p : netStat()) {
                            if (p.status.equals(ESTABLISHED.getText())) {
                                portsView.append(p.toString() + "\n");
                                fw = new FileWriter(logFile, true);
                                bw = new BufferedWriter(fw);
                                bw.append(p.toString());
                                bw.newLine();
                                bw.close();
                            }
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(PortsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        t2.start();
    }//GEN-LAST:event_ESTABLISHEDActionPerformed

    private void TIME_WAITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIME_WAITActionPerformed
        TIME_WAIT.setEnabled(false);
        t3 = new Thread() {
            @Override
            public void run() {
                super.run();
                portsView.setText("");
                portsView.append(String.format("%-22s %-22s %-22s %-22s %s", "Time", "Protocol", "Local Address", "Foreign Address", "Status") + "\n");
                while (t3.isAlive()) {
                    System.out.println("Thread is running...");
                    try {
                        for (Protocoll p : netStat()) {
                            if (p.status.equals(TIME_WAIT.getText())) {
                                portsView.append(p.toString() + "\n");
                                fw = new FileWriter(logFile, true);
                                bw = new BufferedWriter(fw);
                                bw.append(p.toString());
                                bw.newLine();
                                bw.close();
                            }
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(PortsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        t3.start();
    }//GEN-LAST:event_TIME_WAITActionPerformed

    private void BOUNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOUNDActionPerformed
        BOUND.setEnabled(false);
        t4 = new Thread() {
            @Override
            public void run() {
                super.run();
                portsView.setText("");
                portsView.append(String.format("%-22s %-22s %-22s %-22s %s", "Time", "Protocol", "Local Address", "Foreign Address", "Status") + "\n");
                while (t4.isAlive()) {
                    System.out.println("Thread is running...");
                    try {
                        for (Protocoll p : netStat()) {
                            if (p.status.equals(BOUND.getText())) {
                                portsView.append(p.toString() + "\n");
                                fw = new FileWriter(logFile, true);
                                bw = new BufferedWriter(fw);
                                bw.append(p.toString());
                                bw.newLine();
                                bw.close();
                            }
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(PortsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        t4.start();
    }//GEN-LAST:event_BOUNDActionPerformed

    private void CLOSE_WAITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLOSE_WAITActionPerformed
        CLOSE_WAIT.setEnabled(false);
        t5 = new Thread() {
            @Override
            public void run() {
                super.run();
                portsView.setText("");
                portsView.append(String.format("%-22s %-22s %-22s %-22s %s", "Time", "Protocol", "Local Address", "Foreign Address", "Status") + "\n");
                while (t5.isAlive()) {
                    System.out.println("Thread is running...");
                    try {
                        for (Protocoll p : netStat()) {
                            if (p.status.equals(CLOSE_WAIT.getText())) {
                                portsView.append(p.toString() + "\n");
                                fw = new FileWriter(logFile, true);
                                bw = new BufferedWriter(fw);
                                bw.append(p.toString());
                                bw.newLine();
                                bw.close();
                            }
                        }
                        t1.sleep(5000);
                    } catch (Exception ex) {
                        Logger.getLogger(PortsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        t5.start();
    }//GEN-LAST:event_CLOSE_WAITActionPerformed

    private void ALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ALLActionPerformed
        if (LISTENING.isEnabled()) {
            t1 = null;
            LISTENING.setEnabled(false);
        }
        if (ESTABLISHED.isEnabled()) {
            t2 = null;
            ESTABLISHED.setEnabled(false);
        }
        if (TIME_WAIT.isEnabled()) {
            t3 = null;
            TIME_WAIT.setEnabled(false);
        }
        if (BOUND.isEnabled()) {
            t4 = null;
            BOUND.setEnabled(false);
        }
        if (CLOSE_WAIT.isEnabled()) {
            t5 = null;
            CLOSE_WAIT.setEnabled(false);
        }
        if (UDP.isEnabled()) {
            t7 = null;
            UDP.setEnabled(false);
        }
        ALL.setEnabled(false);
        t6 = new Thread() {
            @Override
            public void run() {
                super.run();
                portsView.setText("");
                portsView.append(String.format("%-22s %-22s %-22s %-22s %s", "Time", "Protocol", "Local Address", "Foreign Address", "Status") + "\n");
                while (t6.isAlive()) {
                    System.out.println("Thread is running...");
                    try {
                        for (Protocoll p : netStat()) {                          
                                portsView.append(p.toString() + "\n");
                                fw = new FileWriter(logFile, true);
                                bw = new BufferedWriter(fw);
                                bw.append(p.toString());
                                bw.newLine();
                                bw.close();                         
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(PortsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        t6.start();
    }//GEN-LAST:event_ALLActionPerformed

    private void UDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UDPActionPerformed
        UDP.setEnabled(false);
        t7 = new Thread() {
            @Override
            public void run() {
                super.run();
                portsView.setText("");
                portsView.append(String.format("%-22s %-22s %-22s %-22s %s", "Time", "Protocol", "Local Address", "Foreign Address", "Status") + "\n");
                while (t7.isAlive()) {
                    System.out.println("Thread is running...");
                    try {
                        for (Protocoll p : netStat()) {
                            if (p.status.equals(UDP.getText())) {
                                portsView.append(p.toString() + "\n");
                                fw = new FileWriter(logFile, true);
                                bw = new BufferedWriter(fw);
                                bw.append(p.toString());
                                bw.newLine();
                                bw.close();

                            }
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(PortsGUI.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        t7.start();
    }//GEN-LAST:event_UDPActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!LISTENING.isEnabled()) {
            t1 = null;
            LISTENING.setEnabled(true);
        }
        if (!ESTABLISHED.isEnabled()) {
            t2 = null;
            ESTABLISHED.setEnabled(true);
        }
        if (!TIME_WAIT.isEnabled()) {
            t3 = null;
            TIME_WAIT.setEnabled(true);
        }
        if (!BOUND.isEnabled()) {
            t4 = null;
            BOUND.setEnabled(true);
        }
        if (!CLOSE_WAIT.isEnabled()) {
            t5 = null;
            CLOSE_WAIT.setEnabled(true);
        }
        if (!UDP.isEnabled()) {
            t7 = null;
            UDP.setEnabled(true);
        }
        if (!ALL.isEnabled()) {
            t6 = null;
            ALL.setEnabled(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private final PortGetting pg = new PortGetting();

    public final void TrayMenuSet() {
        TrayIcon trayIcon;
        if (SystemTray.isSupported()) {

            SystemTray tray = SystemTray.getSystemTray();

            ActionListener closeListener = (ActionEvent e) -> {
                System.exit(0);
            };

            ActionListener openListener = (ActionEvent e) -> {
                setVisible(true);
                this.setExtendedState(NORMAL);
            };

            PopupMenu popup = new PopupMenu();

            MenuItem openItem = new MenuItem("Open");
            MenuItem closeItem = new MenuItem("Close");

            closeItem.addActionListener(closeListener);
            openItem.addActionListener(openListener);
            popup.add(openItem);
            popup.add(closeItem);

            ImageIcon ii = new ImageIcon(this.getClass().getResource("/icons/scaled.png"));
            this.setIconImage(ii.getImage());
            trayIcon = new TrayIcon(this.getIconImage(), "Logging Ports", popup);

            trayIcon.addActionListener(closeListener);
            trayIcon.addActionListener(openListener);

            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println(e);
            }
            // ...
        } else {

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PortsGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PortsGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PortsGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PortsGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    new PortsGUI().setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(PortsGUI.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ALL;
    private javax.swing.JButton BOUND;
    private javax.swing.JButton CLOSE_WAIT;
    private javax.swing.JButton ESTABLISHED;
    private javax.swing.JButton LISTENING;
    private javax.swing.JButton TIME_WAIT;
    private javax.swing.JButton UDP;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea portsView;
    // End of variables declaration//GEN-END:variables
}
