package view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sms.SMS;

/**
 *
 * @author Bruno Gressler da Silveira
 * @version 1
 * @since 23/03/2025
 */
public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jMenuBarMain = new javax.swing.JMenuBar();
        jMenuExit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Linux OS");
        setBackground(new java.awt.Color(204, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/sms24.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(487, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(375, Short.MAX_VALUE))
        );

        jMenuExit.setText("Sair");
        jMenuExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuExitMouseClicked(evt);
            }
        });
        jMenuBarMain.add(jMenuExit);

        setJMenuBar(jMenuBarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenuExitMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        try {
            this.sendSMS();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
    public void sendSMS() throws Exception {
        byte op;
        String phone = null;
        do {
            try {
                op = Byte.parseByte(JOptionPane.showInputDialog(null, "----------------SMS-------------------\n"
                        + "0 - Desligar\n"
                        + "1 - EU -> 99357-2517\n"
                        + "2 - MAE -> 99536-8329\n"
                        + "---------------------------------------", "", JOptionPane.QUESTION_MESSAGE));
            } catch (NumberFormatException e) {
                if (e.getMessage().contains("For input string")) {
                    throw new NumberFormatException("DIGITE UMA OPÇÃO DO MENU\n"
                            + "SISTEMA ENCERRADO");
                }
                throw new NumberFormatException(e.getMessage() + "\n"
                        + "SISTEMA ENCERRADO");
            }

            switch (op) {
                case 0:
                    JOptionPane.showMessageDialog(
                            null, "SISTEMA ENCERRADO", "", JOptionPane.INFORMATION_MESSAGE
                    );
                    System.exit(0);
                    break;
                case 1:
                case 2:
                    String msg = JOptionPane.showInputDialog(null, "Menssagem: ", "", JOptionPane.QUESTION_MESSAGE);
                    if ("".equals(msg)) {
                        JOptionPane.showMessageDialog(null, "Menssagem vazio", "ERRO", JOptionPane.ERROR_MESSAGE);
                        throw new Exception("Menssagem vazio");
                    }
                    SMS sms = new SMS();
                    switch (op) {
                        case 1:
                            phone = "993572517";
                            break;
                        case 2:
                            phone = "995368329";
                            break;
                    }
                    sms.setPhone(phone);
                    sms.setMenssage(msg);
                    sms.enviarSMS();
                    break;
                    case 3:
                default:
                    break;
            }
        } while (op != 0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBarMain;
    private javax.swing.JMenu jMenuExit;
    // End of variables declaration//GEN-END:variables
}
