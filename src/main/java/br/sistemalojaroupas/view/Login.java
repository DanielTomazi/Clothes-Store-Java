package br.sistemalojaroupas.view;

import br.sistemalojaroupas.db.DB;
import br.sistemalojaroupas.model.dao.UserDao;
import br.sistemalojaroupas.model.dao.exceptions.LoginException;
import br.sistemalojaroupas.model.entities.User;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    private static User user;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setBackground(new Color(0,0,0,0));
        pnl_background.setBackground(new Color(0,0,0,0));
        
        DB.start();
    }
    
    public static User getLoggedUser() {
        return user;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_background = new javax.swing.JPanel();
        btn_close = new javax.swing.JLabel();
        btn_login = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnl_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_powerOff.png"))); // NOI18N
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }
        });
        pnl_background.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, -1, -1));

        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_login.png"))); // NOI18N
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_loginMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_loginMouseReleased(evt);
            }
        });
        pnl_background.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(109, 81, 232));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Acessar");
        pnl_background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(662, 100, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Bem vindo ao Sistema.");
        pnl_background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        txt_user.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_user.setBorder(null);
        txt_user.setOpaque(false);
        pnl_background.add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 212, 290, 30));

        txt_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_password.setBorder(null);
        txt_password.setOpaque(false);
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });
        pnl_background.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 309, 300, 30));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/telaLogin.png"))); // NOI18N
        pnl_background.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(pnl_background, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        int op;
        op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(op == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_btn_closeMouseClicked

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_loginMouseClicked

    private void btn_loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseEntered
        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_loginEscuro.png")));
    }//GEN-LAST:event_btn_loginMouseEntered

    private void btn_loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseExited
        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_login.png")));
    }//GEN-LAST:event_btn_loginMouseExited

    private void btn_loginMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseReleased
        //verifica se o login e a senha estão corretos 
        try {
            user = UserDao.verify(txt_user.getText(), new String(txt_password.getPassword()));
            new Home().main(null);
            this.dispose();
        }
        catch (LoginException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Falha de Autenticação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_loginMouseReleased

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btn_loginMouseReleased(null);
        }
    }//GEN-LAST:event_txt_passwordKeyPressed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel btn_close;
    private javax.swing.JLabel btn_login;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel pnl_background;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
