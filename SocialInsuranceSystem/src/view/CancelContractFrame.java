/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CompulsoryContractDAO;
import dao.CustomerDAO;
import dao.VoluntaryContractDAO;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.Account;
import model.CompulsoryContract;
import model.Customer;
import model.VoluntaryContract;

/**Financial problem
 *
 * @author nttungg
 */
public class CancelContractFrame extends javax.swing.JFrame {
     UIManager um = new UIManager();
    private Customer customer;
    /**
     * Creates new form CancelContractFrame
     */
    public CancelContractFrame() {
        initComponents();
        setLocationRelativeTo(null); 
        this.setTitle("Cancel Contract");
    }

      public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
    
    public void initData(Customer cus) {
        if (cus != null) {
             lbName.setText(cus.name);
             lbDob.setText(cus.dob);
             lbSIN.setText(cus.socialInsuranceNo);
             if (cus.compulsoryContract != null) {
                 lbStartedDate.setText(cus.compulsoryContract.startedDate);
             } else if (cus.voluntaryContract != null) {
                 lbStartedDate.setText(cus.voluntaryContract.startedDate);
             } 
        }
    }
    
    public String getDescriptions() {
        String description = "";
        if (cbCompany.isSelected()) {
            description = description + "Company problem ";
        } 
        if (cbFinancial.isSelected()) {
            description = description + "Financial problem ";
        }
        if (cbPolicy.isSelected()) {
            description = description + "Policy problem ";
        }
        if (!taReason.getText().equals("")) {
             description = description + taReason.getText();
        }
        return description;
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

        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbFinancial = new javax.swing.JCheckBox();
        cbPolicy = new javax.swing.JCheckBox();
        cbCompany = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        taReason = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbAgree = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbDob = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbSIN = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbStartedDate = new javax.swing.JLabel();

        jLabel16.setText("jLabel16");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Cancel Contract");

        jLabel2.setText("Cancel Reason :");

        cbFinancial.setText("Financial problem");
        cbFinancial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFinancialActionPerformed(evt);
            }
        });

        cbPolicy.setText("Policy problem");
        cbPolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPolicyActionPerformed(evt);
            }
        });

        cbCompany.setText("Company problem");

        jLabel3.setText("Ohther Reason :");

        jButton1.setText("Cancel Contract");
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

        taReason.setColumns(20);
        taReason.setRows(5);
        jScrollPane3.setViewportView(taReason);

        jLabel6.setText("Money :");

        jLabel7.setText("0");

        cbAgree.setText("I agree with all the T&C and I want to cancel this contract");

        jLabel8.setText("Name: ");

        lbName.setText("Tung Nguyen");

        jLabel10.setText("Date Of Birth :");

        lbDob.setText("20/2/2019");

        jLabel12.setText("Social Insurance Number :");

        lbSIN.setText("0000000");

        jLabel14.setText("Started Date :");

        lbStartedDate.setText("20/2/2019");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(cbFinancial)
                                        .addGap(35, 35, 35)
                                        .addComponent(cbPolicy)
                                        .addGap(47, 47, 47)
                                        .addComponent(cbCompany))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane3))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbDob)
                                    .addComponent(lbName))
                                .addGap(123, 123, 123)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbStartedDate))
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbSIN))
                            .addComponent(cbAgree)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(69, 69, 69)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(jLabel1)))
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(130, 130, 130)
                .addComponent(jButton2)
                .addGap(229, 229, 229))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbName)
                    .addComponent(jLabel12)
                    .addComponent(lbSIN))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbDob)
                    .addComponent(jLabel14)
                    .addComponent(lbStartedDate))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbFinancial)
                    .addComponent(cbPolicy)
                    .addComponent(cbCompany))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(29, 29, 29)
                .addComponent(cbAgree)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbFinancialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFinancialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFinancialActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!cbAgree.isSelected()) {
            showError("You must agree with all the T&C");
           
        } else {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure want to cancel your contract? This action may affect your future benefit in insurance", "Message", JOptionPane.PLAIN_MESSAGE);
            int row = -1;
            if (result == JOptionPane.OK_OPTION) {
               if (customer.compulsoryContract != null) {
                    CompulsoryContract compulsoryContract = customer.compulsoryContract;
                    compulsoryContract.state = 2;
                    compulsoryContract.description = getDescriptions();
                    row = CompulsoryContractDAO.updateCompulsoryContract(compulsoryContract);
                } else if (customer.voluntaryContract != null) {
                    VoluntaryContract voluntaryContract = customer.voluntaryContract;
                    voluntaryContract.state = 2;
                    voluntaryContract.description = getDescriptions();
                    row = VoluntaryContractDAO.updateVoluntaryContract(voluntaryContract);
                }
                if (row != 0 && row != -1) {
                    showSuccess("Your request is being processed. Please wait 1-2 days for your confirmation. Thank you for using our insurance service!");
                  
                } 
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        CustomerMain customerMain = new CustomerMain();
        customerMain.setAcc(this.getCustomer().account);
        customerMain.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbPolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPolicyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPolicyActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbAgree;
    private javax.swing.JCheckBox cbCompany;
    private javax.swing.JCheckBox cbFinancial;
    private javax.swing.JCheckBox cbPolicy;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbDob;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbSIN;
    private javax.swing.JLabel lbStartedDate;
    private javax.swing.JTextArea taReason;
    // End of variables declaration//GEN-END:variables
}
