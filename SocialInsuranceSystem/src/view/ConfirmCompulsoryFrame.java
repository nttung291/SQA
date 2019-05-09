/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CompulsoryContractDAO;
import dao.Connection;
import dao.CustomerDAO;
import java.awt.Color;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.CompulsoryContract;
import model.Customer;

/**
 *
 * @author nttungg
 */
public class ConfirmCompulsoryFrame extends javax.swing.JFrame {
   
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    private void showError(String message) {
        JLabel l = new JLabel(message);
        l.setForeground(Color.red);
        JOptionPane.showMessageDialog(null, l, "Message", JOptionPane.ERROR_MESSAGE);
    }
    
     private int showSuccess(String message) {
        JLabel l = new JLabel(message);
        l.setForeground(Color.blue);
        int result = JOptionPane.showOptionDialog(null, message, "Message", JOptionPane.DEFAULT_OPTION ,JOptionPane.INFORMATION_MESSAGE, null,null,null);
        return result;
    }
    
    /**
     * Creates new form ConfirmCompulsoryFrame
     */
    public ConfirmCompulsoryFrame() {
        initComponents();
        Connection.createConnection();
        setLocationRelativeTo(null); 
        this.setTitle("Confirm Contract Register");
    }
    
    public void initData() {
      if (this.getCustomer() != null) {
        try {
            // The comma in the format specifier does the trick
            long longsalary = (long) (customer.salary * 8/100);
            String salary = String.format("%,d", longsalary);
            lbCost.setText(salary + " VND");
           
        } catch (NumberFormatException e) {
            System.out.println("NumberFormat");
        }
        lbName.setText(customer.name);
        lbComCode.setText(customer.compulsoryContract.companyCode);
        lbDob.setText(customer.dob);
        if (customer.paymentDuration == 0) {
           lbDuration.setText("Month");
        } else {
            lbDuration.setText("Year");
        }
        lbEmail.setText(customer.email);
         if (customer.sex) {
           lbGender.setText("Male");
        } else {
            lbGender.setText("Female");
        }
        lbTaxCode.setText(customer.taxCode);
        lbPhone.setText(customer.phoneNo);
        lbHometown.setText(customer.hometown.name);
        lbIdNum.setText(customer.idNumber);
        lbSocialNum.setText(customer.socialInsuranceNo);
        
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbSocialNum = new javax.swing.JLabel();
        lbPhone = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbDob = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbHometown = new javax.swing.JLabel();
        lbTaxCode = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbIdNum = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbDuration = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbCost = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbComCode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Confirm Contract");

        lbName.setText("Tung Nguyen");

        jLabel3.setText("Name :");

        jLabel8.setText("Social Insurance Number :");

        lbSocialNum.setText("10120301203");

        lbPhone.setText("84962962997");

        jLabel10.setText("Phone Number :");

        lbGender.setText("Male");

        jLabel4.setText("Gender :");

        jLabel6.setText("Date of birth :");

        lbDob.setText("29/01/1997");

        jLabel11.setText("Hometown :");

        lbHometown.setText("Yen Bai");

        lbTaxCode.setText("123123123");

        jLabel12.setText("Tax Code :");

        lbIdNum.setText("061092303");

        jLabel7.setText("ID Number :");

        jLabel9.setText("Email :");

        lbEmail.setText("nttung291@gmail.com");

        jLabel13.setText("Insurance Duration :");

        lbDuration.setText("Month");

        jLabel2.setText("Cost of insurance (VND):");

        lbCost.setText("0");

        jLabel14.setText("Company Code :");

        lbComCode.setText("00123123");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lbIdNum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbDob, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                                        .addGap(6, 6, 6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbComCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(6, 6, 6)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jButton1)
                                .addGap(139, 139, 139)
                                .addComponent(jButton2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(lbHometown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTaxCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDuration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbSocialNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(320, 320, 320))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(lbName)
                    .addComponent(lbSocialNum))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(lbGender)
                    .addComponent(lbPhone))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11)
                    .addComponent(lbDob)
                    .addComponent(lbHometown))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(lbIdNum)
                    .addComponent(lbTaxCode))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lbEmail)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lbDuration))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbComCode)
                    .addComponent(jLabel2)
                    .addComponent(lbCost))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(105, 105, 105))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int row = CompulsoryContractDAO.insertCompulsoryContract(customer.compulsoryContract);
        int result = 0;
        if (row != -1 && row !=0) {
            CompulsoryContract inseredContract = customer.compulsoryContract;
            inseredContract.id = row;
            Customer inCustomer = this.getCustomer();
            inCustomer.compulsoryContract = inseredContract;
            result = CustomerDAO.inserCompulsoryCustomer(inCustomer);
        }
        if (result != 0 && result != -1) {
           
            showSuccess("Your request is being validated. Please wait 1-2 days for validation. Thank you for register to our insurance service!");
            this.setVisible(false);
            CustomerMain customerMain = new CustomerMain();
            customerMain.setAcc(this.getCustomer().account);
            customerMain.setVisible(true);
        } else {
            showError("Register Failed!");
         
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        CustomerMain customerMain = new CustomerMain();
        customerMain.setAcc(this.getCustomer().account);
        customerMain.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbComCode;
    private javax.swing.JLabel lbCost;
    private javax.swing.JLabel lbDob;
    private javax.swing.JLabel lbDuration;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbHometown;
    private javax.swing.JLabel lbIdNum;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel lbSocialNum;
    private javax.swing.JLabel lbTaxCode;
    // End of variables declaration//GEN-END:variables
}
