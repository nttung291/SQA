/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CompulsoryContractDAO;
import dao.Connection;
import dao.CustomerDAO;
import dao.VoluntaryContractDAO;
import java.awt.Color;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.CompulsoryContract;
import model.Customer;
import model.VoluntaryContract;

/**
 *
 * @author nttungg
 */
public class ConfirmVoluntaryFrame extends javax.swing.JFrame {
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    private void initTableData() {
        DefaultTableModel dm = (DefaultTableModel) tb_customer.getModel();
        Vector row = new Vector();
        row.add(customer.name);
        if (customer.sex) row.add("Male");
        else row.add("Female");
        row.add(customer.dob);
        row.add(customer.idNumber);
        row.add(customer.socialInsuranceNo);
        row.add(customer.email);
        row.add(customer.phoneNo);
        row.add(customer.hometown.name);
        row.add(customer.taxCode);
        row.add(customer.salary);
        if (customer.paymentDuration == 0) row.add("Month");
        else row.add("Year");
        dm.insertRow(0,row);
        tb_customer.setModel(dm);
    }
    
    /**
     * Creates new form ConfirmCompulsoryFrame
     */
    public ConfirmVoluntaryFrame() {
        initComponents();
        Connection.createConnection();
        setLocationRelativeTo(null); 
    }
    
    public void initData() {
      if (this.getCustomer() != null) {
        lb_cost.setText(String.valueOf(customer.salary * 22/100));
        initTableData();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_customer = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lb_cost = new javax.swing.JLabel();
        lbMessage = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

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

        tb_customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Gender", "Date of birth", "ID Number", "Social Insurance Number", "Email", "Phone ", "Hometown", "Tax Code", "Salary", "Insurance Duration"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_customer);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Confirm Contract");

        jLabel2.setText("Cost of insurance :");

        lb_cost.setText("0");

        lbMessage.setText("No message");
        lbMessage.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel5.setText("Message:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jButton1)
                        .addGap(77, 77, 77)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(30, 30, 30)
                        .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lb_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(96, 96, 96)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lb_cost))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int row = VoluntaryContractDAO.insertVoluntaryContract(customer.voluntaryContract);
        int result = 0;
        if (row != -1 && row !=0) {
            VoluntaryContract inseredContract = customer.voluntaryContract;
            inseredContract.id = row;
            Customer inCustomer = this.getCustomer();
            inCustomer.voluntaryContract = inseredContract;
            result = CustomerDAO.inserVoluntaryCustomer(inCustomer);
        }
        if (result != 0 && result != -1) {
            lbMessage.setBackground(Color.red);
            lbMessage.setText("Your request is being validated. Please wait 1-2 days for validation. Thank you for register to our insurance service!");
        } else {
            lbMessage.setText("Register Failed!");
            lbMessage.setBackground(Color.red);
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
            java.util.logging.Logger.getLogger(ConfirmVoluntaryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmVoluntaryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmVoluntaryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmVoluntaryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfirmVoluntaryFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lb_cost;
    private javax.swing.JTable tb_customer;
    // End of variables declaration//GEN-END:variables
}