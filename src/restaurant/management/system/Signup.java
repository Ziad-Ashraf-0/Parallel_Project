/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package restaurant.management.system;

import javax.swing.JOptionPane;
import model.User;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author mohamedkhaled
 */
public class Signup extends javax.swing.JFrame {

    /**
     * Creates new form SignUp
     */
    public Signup() {
        initComponents();
        btnsave.setEnabled(false);
    }
    public void clear(){
        txtn1.setText("");
        txte1.setText("");
        txtm1.setText("");
        txtp1.setText("");
        btnsave.setEnabled(false);
    }
    
    public void validateFields()
    {
        String name=txtn1.getText();
        String email=txte1.getText();
        String password=txtp1.getText();
        String mobileno=txtm1.getText();
        if((!(name=="")) && email.endsWith(".com") &&mobileno.length()==11 &&!(password==""))
            btnsave.setEnabled(true);
        else
            btnsave.setEnabled(false);
            
            
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
        txtn1 = new javax.swing.JTextField();
        txte1 = new javax.swing.JTextField();
        txtm1 = new javax.swing.JTextField();
        txtp1 = new javax.swing.JPasswordField();
        btnsave = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        btnForgot = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("signup");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 37, 71, 43));

        jLabel2.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel2.setText("name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 101, -1, -1));

        jLabel3.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel3.setText("email");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 164, -1, -1));

        jLabel4.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel4.setText("mobile no");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel5.setText("password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 305, -1, -1));

        txtn1.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        txtn1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtn1KeyReleased(evt);
            }
        });
        getContentPane().add(txtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 98, 552, -1));

        txte1.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        txte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txte1ActionPerformed(evt);
            }
        });
        txte1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txte1KeyReleased(evt);
            }
        });
        getContentPane().add(txte1, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 164, 552, -1));

        txtm1.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        txtm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtm1ActionPerformed(evt);
            }
        });
        txtm1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtm1KeyReleased(evt);
            }
        });
        getContentPane().add(txtm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 227, 552, -1));

        txtp1.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        txtp1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtp1KeyReleased(evt);
            }
        });
        getContentPane().add(txtp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 302, 556, -1));

        btnsave.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        btnsave.setText("save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 427, -1, -1));

        btnclear.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        btnclear.setText("clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        getContentPane().add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 427, -1, -1));

        btnexit.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        btnexit.setText("exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        getContentPane().add(btnexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 427, -1, -1));

        btnForgot.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        btnForgot.setText("forgot password?");
        btnForgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForgotActionPerformed(evt);
            }
        });
        getContentPane().add(btnForgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 527, -1, -1));

        btnLogin.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        btnLogin.setText("login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 527, -1, -1));

        jLabel7.setText("jLabel7");
        jLabel7.setMaximumSize(new java.awt.Dimension(1500, 1000));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, -12, 5560, 3670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txte1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txte1ActionPerformed

    private void txtm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtm1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtm1ActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        int a=JOptionPane.showConfirmDialog(null,"are sure for exiting?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0)
            System.exit(0);
        
        
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        final String HOST = "127.0.0.1";
        final int PORT = 4040;
        //User user=new User();
        //user.setName(txtn1.getText());
        //user.setEmail(txte1.getText());
        //user.setMobileno(txtm1.getText());
        // user.setPassword(txtp1.getText());
        JSONObject obj = new JSONObject();      
        obj.put("type","signup");
        obj.put("name",txtn1.getText());
        obj.put("email",txte1.getText());
        obj.put("password",txtp1.getText());
        obj.put("mobile",txtm1.getText()); 
        
         
        try (
            Socket socket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            //Scanner in = new Scanner(socket.getInputStream());           
        ) {
            out.println(obj.toString());
            System.out.println(obj.toString());
            socket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
        
        //UserDao.save(user);
        clear();       
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
clear();        // TODO add your handling code here:
    }//GEN-LAST:event_btnclearActionPerformed

    private void txtn1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtn1KeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtn1KeyReleased

    private void txte1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txte1KeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txte1KeyReleased

    private void txtm1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtm1KeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtm1KeyReleased

    private void txtp1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtp1KeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtp1KeyReleased

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnForgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForgotActionPerformed
         setVisible(false);
        new ForgotPassword().setVisible(true);
    }//GEN-LAST:event_btnForgotActionPerformed

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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnForgot;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txte1;
    private javax.swing.JTextField txtm1;
    private javax.swing.JTextField txtn1;
    private javax.swing.JPasswordField txtp1;
    // End of variables declaration//GEN-END:variables
}
