/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AccountCtr;
import dao.Connection;
import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import model.Account;
import utils.EncodeDecode;

/**
 *
 * @author nttungg
 */
public class LoginFrame extends javax.swing.JFrame {
   
    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
        setLocationRelativeTo(null); 
        Connection.createConnection();
        this.setTitle("Login");
    }		

    public void setTfPassword(String tfPassword) {		
        this.tfPassword.setText(tfPassword);		
    }		

 
    public void setTfUsername(String tfUsername) {		
        this.tfUsername.setText(tfUsername);		
    }		
    
    public JButton getLoginButton() {		
        return btLogin;		
    }
    
    private void showError(String message) {
        JLabel l = new JLabel(message);
        l.setForeground(Color.red);
        JOptionPane.showMessageDialog(null, l, "Message", JOptionPane.ERROR_MESSAGE);
    }
    
     private int showSuccess(String message) {
        JLabel l = new JLabel(message);
        l.setForeground(Color.blue);
        int result = JOptionPane.showOptionDialog(null, l, "Message", JOptionPane.DEFAULT_OPTION ,JOptionPane.INFORMATION_MESSAGE, null,null,null);
        return result;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btLogin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfPassword = new javax.swing.JPasswordField();
        tfUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btLogin.setText("Login");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        jLabel2.setText("Password :");

        tfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsernameActionPerformed(evt);
            }
        });

        jLabel1.setText("User name :");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setText("Login");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(25, 25, 25)
                                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel2)
                                .addGap(25, 25, 25)
                                .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btLogin)
                                .addGap(93, 93, 93)
                                .addComponent(jButton1)
                                .addGap(91, 91, 91))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(jLabel5)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1))
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2))
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLogin)
                    .addComponent(jButton1))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUsernameActionPerformed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        if (!checkEmptyBlank()) {
            showError("Informations cannot be blank, please fill enough informations");
        } else {
            try {
                int result = AccountCtr.loginAccount(tfUsername.getText(), EncodeDecode.encodeString(tfPassword.getText()));
                if (result == 0) {
                    Account acc = AccountCtr.getAccount(tfUsername.getText(), EncodeDecode.encodeString(tfPassword.getText()));
                    CustomerMain customerMain = new CustomerMain();
                    customerMain.setAcc(acc);
                    customerMain.setVisible(true);
                    this.setVisible(false);

                } else if (result == 1) {
                    showSuccess("Login Successed");
                    new StaffMain().setVisible(true);
                    this.setVisible(false);
                } else if (result == 2){
                    showSuccess("Login Successed");
                    new AdminMain().setVisible(true);
                    this.setVisible(false);
                } else if (result == -1) {
                    showError("Account has not registed, please sign-up to be able to login");
                } else if (result == -2) {
                    showError("Password is incorrect, please check your password again!");
                }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(RegisterAccount.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btLoginActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        StartFrame startFrame = new StartFrame();
        startFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public boolean checkEmptyBlank() {
        if (tfUsername.getText().equals("") || tfPassword.getText().equals("")) return false;
            return true;
    }
        
    public JButton getBtLogin() {
        return btLogin;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JPasswordField getTfPassword() {
        return tfPassword;
    }

    public JTextField getTfUsername() {
        return tfUsername;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
