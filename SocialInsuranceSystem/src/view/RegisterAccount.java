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
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.JTextField;
import model.Account;
import utils.EncodeDecode;

/**
 *
 * @author nttungg
 */
public class RegisterAccount extends javax.swing.JFrame {
    private int role = 0;
    private UIManager um = new UIManager();

    /**
     * Creates new form RegisterAccount
     */
    public RegisterAccount() {
        initComponents();
        Connection.createConnection();
        setLocationRelativeTo(null); 
        this.setTitle("Register Account");
    }	

    public String getTfUsername() {
        return tfUsername.getText();
    }

    public void setTfPassword(String tfPassword) {		
        this.tfPassword.setText(tfPassword);		
    }		

    public void setTfUsername(String tfUsername) {		
        this.tfUsername.setText(tfUsername);;		
    }		

    public JPasswordField getTfConfirmPassword() {		
        return tfConfirmPassword;		
    }		

    public void setTfConfirmPassword(String tfConfirmPassword) {		
        this.tfConfirmPassword.setText(tfConfirmPassword);		
    }		

    public JButton getjButton1() {		
        return jButton1;		
    }
    
    private void showError(String message) {
        um.put("OptionPane.messageForeground", Color.red);
        JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.ERROR_MESSAGE);
    }
    
     private int showSuccess(String message) {
        um.put("OptionPane.messageForeground", Color.BLUE);
        int result = JOptionPane.showOptionDialog(null, message, "Message", JOptionPane.DEFAULT_OPTION ,JOptionPane.INFORMATION_MESSAGE, null,null,null);
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

        jLabel1 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cb_role = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tfPassword = new javax.swing.JPasswordField();
        tfConfirmPassword = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("User name :");

        tfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsernameActionPerformed(evt);
            }
        });

        jLabel2.setText("Password :");

        jLabel3.setText("Confirm password :");

        jLabel4.setText("Role :");

        cb_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Insurance Staff", "Admin" }));
        cb_role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_roleActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setText("Register Account");

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfUsername)
                    .addComponent(tfPassword)
                    .addComponent(tfConfirmPassword)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cb_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 189, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(78, 78, 78)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(271, 271, 271))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean checkEmptyBlank() {
        if (tfConfirmPassword.getText().equals("") || tfUsername.getText().equals("") || tfPassword.getText().equals("")) return false;
        return true;
    }
    
    
    private boolean checkConfirmPassword() {
        return tfPassword.getText().equals(tfConfirmPassword.getText()); 
    }
    
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"; 
    private boolean checkValidPassword() {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        return pattern.matcher(tfPassword.getText()).matches();
    }
    
    private static final String USERNAME_PATTERN = "^[a-z0-9._-]{3,15}$"; 
    private boolean checkValidUsername() {
         Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        return pattern.matcher(tfUsername.getText()).matches();
    }
    
    private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUsernameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!checkEmptyBlank()) {
            showError("Informations can not be blank");
          
        } else if (!checkConfirmPassword()) {
            showError("Password does not match");
          
        } else if (!checkValidPassword()) {
            showError("<html> Password has least one number, one lowercase characters, one uppercase characters  and a special character such as (!,#,$,^,&,..) and at least 8 characters </html>");
          
        } else if (!checkValidUsername()) {
            showError("Username can not be special characters");
        }
        else {
            try {
                int result = AccountCtr.registerAccount(tfUsername.getText(), EncodeDecode.encodeString(tfPassword.getText()), cb_role.getSelectedIndex(), 0, "No descriptions");
                 if (result == -1) {
                    showError("Register Failed");
         
                 } else if (result == -2) {
                    showError("Account has already");
                   
                 } else {
                    if (showSuccess("Register Successed") == JOptionPane.OK_OPTION) {
                        this.setVisible(false);
                        LoginFrame loginFrame = new LoginFrame();
                        loginFrame.setVisible(true);
                    }
                 }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(RegisterAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb_roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_roleActionPerformed
 
    }//GEN-LAST:event_cb_roleActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        StartFrame startFrame = new StartFrame();
        startFrame.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_role;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField tfConfirmPassword;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
