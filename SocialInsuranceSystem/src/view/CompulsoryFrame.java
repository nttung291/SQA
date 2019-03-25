/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CompulsoryContractDAO;
import dao.Connection;
import dao.CustomerDAO;
import dao.HometownDAO;
import java.util.ArrayList;
import model.CompulsoryContract;
import model.Customer;
import model.Hometown;

/**
 *
 * @author nttungg
 */
public class CompulsoryFrame extends javax.swing.JFrame {
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    /**
     * Creates new form CompulsoryFrame
     */
    public CompulsoryFrame() {
        initComponents();
        Connection.createConnection();
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
        tfTax = new javax.swing.JTextField();
        tfCompany = new javax.swing.JTextField();
        tfSalary = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tax code :");

        jLabel2.setText("Company code :");

        jLabel3.setText("Salary :");

        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setText("Compulsory Social Insurance");

        jLabel5.setText("Message:");

        lbMessage.setText("No message");
        lbMessage.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfSalary, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                                    .addComponent(tfCompany)
                                    .addComponent(tfTax)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!checkEmptyBlank()) {
            lbMessage.setText("Informations can not be blank");
        } else if (!checkTaxNumber()) {
            lbMessage.setText("Tax code must equal 13 integer numbers from 100000000001 to 729999999999 and contain two first number must represent for a specific provincial  , please check your input again");
        } else if(!checkCompany()){
            lbMessage.setText("Company code must equal 10 integer numbers from 010000000 to 949999999, please check your input again");
        } else if (!checkSalary()) {
            
        } else {
            ArrayList<CompulsoryContract> ccs = CompulsoryContractDAO.selectAllCompulsoryContract();
            CompulsoryContract compulsoryContract = new CompulsoryContract(tfCompany.getText(),0, "No description");
            int row = CompulsoryContractDAO.insertCompulsoryContract(compulsoryContract);
            System.out.println(row);
            int result = 0;
            if (row != -1 && row !=0) {
                CompulsoryContract inseredContract = CompulsoryContractDAO.selectCompulsoryContractByID(row);
                Customer inserCustomer = this.getCustomer();
                inserCustomer.salary = Float.parseFloat(tfSalary.getText());
                inserCustomer.compulsoryContract = inseredContract;
                inserCustomer.taxCode = tfTax.getText();
                result = CustomerDAO.insertCustomer(inserCustomer);
            }
            if (result != 0 && result != -1) {
                 lbMessage.setText("Regiter Successed");
            } 
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean checkEmptyBlank() {
        if (tfTax.getText().equals("") || tfSalary.getText().equals("") || tfCompany.getText().equals("")) return false;
        return true;
    }
    
    private boolean checkTaxNumber() {
        for(int i=0; i < tfTax.getText().length(); i++) {
            if (tfTax.getText().charAt(i) > '9' || tfTax.getText().charAt(i) <'0') {
                return false;
            }
        } 
        if (tfTax.getText().length() != 13) return false;
        if (Integer.parseInt(tfTax.getText().substring(tfTax.getText().length()-1, tfTax.getText().length())) == 0) return false;
        if (Integer.parseInt(tfTax.getText().substring(0, 2)) != (this.getCustomer().hometown.ID)) return false;
        return true;
    }
    
     private boolean checkCompany() {
        for(int i=0; i < tfCompany.getText().length(); i++) {
            if (tfCompany.getText().charAt(i) > '9' || tfCompany.getText().charAt(i) <'0') {
                return false;
            }
        } 
        if (tfCompany.getText().length() != 10) return false;
        if (Integer.parseInt(tfCompany.getText().substring(0, 2)) != (this.getCustomer().hometown.ID)) return false;
        return true;
    }
    
     private boolean checkSalary() {
        Hometown hometown = this.getCustomer().hometown;
        Float salary;
        try {
            salary = Float.parseFloat(tfSalary.getText());
        } catch (Exception e) {
            lbMessage.setText("Salary is wrong format");
            return false;
        }
       
        if (hometown.section == 1 && (salary < 4472600 || salary > 29800000)){
            lbMessage.setText("Salary field must in section 1 range from 4.472.600 dong/month to 29.800.000 dong/month, please check your input again");
            return false;
        }
        if (hometown.section == 2 && (salary < 3969700 || salary > 29800000)) {
            lbMessage.setText("Salary field must in section 2 range from 3.969.700 dong/month to 29.800.000 dong/month, please check your input again");
            return false;
        }
        if (hometown.section == 3 && (salary < 3477500 || salary > 29800000)) {
            lbMessage.setText("Salary field must in section 2 range from 3.477.500 dong/month to 29.800.000 dong/month, please check your input again");
            return false;
        }
        if (hometown.section == 4 && (salary < 3124400 || salary > 29800000)) {
             lbMessage.setText("Salary field must in section 2 range from 3.124.400 dong/month to 29.800.000 dong/month, please check your input again");
            return false;
        }
        return true;
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompulsoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompulsoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompulsoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompulsoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompulsoryFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JTextField tfCompany;
    private javax.swing.JTextField tfSalary;
    private javax.swing.JTextField tfTax;
    // End of variables declaration//GEN-END:variables
}
