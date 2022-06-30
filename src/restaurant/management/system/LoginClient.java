/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package restaurant.management.system;

import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import model.User;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author mohamedkhaled
 */
public class LoginClient extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public LoginClient() {
        initComponents();
        btnlogin2.setEnabled(false);
    }

    public void clear() {
        txte2.setText("");

        txtp2.setText("");
        btnlogin2.setEnabled(false);
    }

    public void validateFields() {

        String email = txte2.getText();
        String password = txtp2.getText();

        if (email.endsWith(".com") && !password.equals("")) {
            btnlogin2.setEnabled(true);
        } else {
            btnlogin2.setEnabled(false);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txte2 = new javax.swing.JTextField();
        txtp2 = new javax.swing.JPasswordField();
        btnlogin2 = new javax.swing.JButton();
        btnclear2 = new javax.swing.JButton();
        btnexit2 = new javax.swing.JButton();
        btnforget2 = new javax.swing.JButton();
        btnsignup2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("login");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 43, -1, -1));

        jLabel2.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel2.setText("email");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 116, -1, -1));

        jLabel3.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel3.setText("password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 186, -1, -1));

        txte2.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        txte2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txte2KeyReleased(evt);
            }
        });
        getContentPane().add(txte2, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 116, 369, -1));

        txtp2.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        txtp2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtp2KeyReleased(evt);
            }
        });
        getContentPane().add(txtp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 183, 369, -1));

        btnlogin2.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        btnlogin2.setText("login");
        btnlogin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogin2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnlogin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 259, -1, -1));

        btnclear2.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        btnclear2.setText("clear");
        btnclear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclear2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnclear2, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 259, -1, -1));

        btnexit2.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        btnexit2.setText("exit");
        btnexit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexit2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnexit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 259, -1, -1));

        btnforget2.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        btnforget2.setText("forget password?");
        btnforget2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnforget2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnforget2, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 329, -1, -1));

        btnsignup2.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        btnsignup2.setText("signup");
        btnsignup2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignup2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnsignup2, new org.netbeans.lib.awtextra.AbsoluteConstraints(533, 329, -1, -1));

        jLabel4.setText("Client");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlogin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogin2ActionPerformed
        // TODO add your handling code here:
        String email = txte2.getText();
        String password = txtp2.getText();
        User user = null;
        final String HOST = "127.0.0.1";
        final int PORT = 4040;
        JSONObject obj = new JSONObject();
        obj.put("type", "signin");
        obj.put("password", password);
        obj.put("email", email);

        try (
            Socket socket = new Socket(HOST, PORT);  PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  Scanner in = new Scanner(socket.getInputStream());) {
            out.println(obj.toString());
            System.out.println(obj.toString());
            String input = in.nextLine();
            System.out.println(input);
            JSONParser parser = new JSONParser();
            JSONObject json;
            try {
               
                json = (JSONObject) parser.parse(input);
                String status = (String) json.get("status");
                if (status.equalsIgnoreCase("false")) {
                JOptionPane.showMessageDialog(null, "incorrect username or password", "Message", JOptionPane.ERROR_MESSAGE);

               } else {
                
                setVisible(false);
                String email1 = (String) json.get("email");
                String balance = (String) json.get("balance");
                new Home(email1,balance).setVisible(true);
       
              }
            } catch (ParseException ex) {
                Logger.getLogger(LoginClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
      
            

        } catch (IOException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnlogin2ActionPerformed

    private void btnsignup2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignup2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Signup().setVisible(true);
    }//GEN-LAST:event_btnsignup2ActionPerformed

    private void btnexit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexit2ActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "are sure for exiting?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }

    }//GEN-LAST:event_btnexit2ActionPerformed

    private void txte2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txte2KeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txte2KeyReleased

    private void txtp2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtp2KeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtp2KeyReleased

    private void btnclear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclear2ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnclear2ActionPerformed

    private void btnforget2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnforget2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new ForgotPassword().setVisible(true);
    }//GEN-LAST:event_btnforget2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowOpened

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
                new LoginClient().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclear2;
    private javax.swing.JButton btnexit2;
    private javax.swing.JButton btnforget2;
    private javax.swing.JButton btnlogin2;
    private javax.swing.JButton btnsignup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txte2;
    private javax.swing.JPasswordField txtp2;
    // End of variables declaration//GEN-END:variables
}
