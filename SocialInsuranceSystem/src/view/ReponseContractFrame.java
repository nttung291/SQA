/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CompulsoryContractDAO;
import dao.CustomerDAO;
import dao.VoluntaryContractDAO;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.CompulsoryContract;
import model.Customer;
import model.VoluntaryContract;

/**
 *
 * @author nttungg
 */
public class ReponseContractFrame extends javax.swing.JFrame implements ReponseContractForm.ResponseContractListener{
    private Customer customer;
    private boolean isAccepted;
     private RemoveRowListener listener;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setListener(RemoveRowListener listener) {
        this.listener = listener;
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
        if (customer.compulsoryContract != null) {
            row.add(customer.compulsoryContract.companyCode);
        } else {
              row.add("No Company Code");
        }
        row.add(customer.salary);
        if (customer.paymentDuration == 0) row.add("Month");
        else row.add("Year");
        row.add(String.valueOf((customer.salary * 25.5/100)));
        dm.insertRow(0,row);
        tb_customer.setModel(dm);
    }
    
    /**
     * Creates new form ConfirmCompulsoryFrame
     */
    public ReponseContractFrame() {
        initComponents();
        setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void initData() {
      if (this.getCustomer() != null) {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Accept");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Decline");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tb_customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Gender", "Date of birth", "ID Number", "Social Insurance Number", "Email", "Phone ", "Hometown", "Tax Code", "Company Code", "Salary", "Insurance Duration", "Cost"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_customer);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Confirm Contract");

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
                .addContainerGap(376, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(96, 96, 96)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       ReponseContractForm reponseContractForm = new ReponseContractForm();
       reponseContractForm.setListener(this);
       reponseContractForm.setLabelButton("Accept");
       reponseContractForm.setVisible(true);
       isAccepted = true;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       ReponseContractForm reponseContractForm = new ReponseContractForm();
       reponseContractForm.setListener(this);
       reponseContractForm.setLabelButton("Decline");
       reponseContractForm.setVisible(true);
       isAccepted = false;
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
            java.util.logging.Logger.getLogger(ReponseContractFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReponseContractFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReponseContractFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReponseContractFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReponseContractFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_customer;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onClicked() {
        int row = -1;
        if (isAccepted) {
            if (customer.compulsoryContract != null) {
                CompulsoryContract compulsoryContract = customer.compulsoryContract;
                compulsoryContract.state = 1;
                row = CompulsoryContractDAO.updateCompulsoryContract(compulsoryContract);
            } else if (customer.voluntaryContract != null) {
                VoluntaryContract voluntaryContract = customer.voluntaryContract;
                voluntaryContract.state = 1;
                row = VoluntaryContractDAO.updateVoluntaryContract(voluntaryContract);
            }
            if (row != 0 && row != -1) {
        
                int result = JOptionPane.showConfirmDialog(null, "Finished!", "Message", JOptionPane.PLAIN_MESSAGE);
                
                this.listener.onRemove();
                if (result == JOptionPane.OK_OPTION) {
                    this.setVisible(false);
                }
            }
        } else {
             if (customer.compulsoryContract != null) {
                CompulsoryContract compulsoryContract = customer.compulsoryContract;
                int deleteCus = CustomerDAO.deleteCustomerByID(customer);
                int deleteCon = 0;
                if (deleteCus == 1){
                    deleteCon = CompulsoryContractDAO.deleteCompulsoryContractByID(compulsoryContract);
                }
                if (deleteCon == 1) {
                    row = 1;
                }
            } else if (customer.voluntaryContract != null) {
                VoluntaryContract voluntaryContract = customer.voluntaryContract;
                int deleteCus = CustomerDAO.deleteCustomerByID(customer);
                int deleteCon = 0;
                if (deleteCus == 1){
                    deleteCon = VoluntaryContractDAO.deleteVoluntaryContractByID(voluntaryContract);
                }
                if (deleteCus == 1) {
                    row = 1;
                }
            }
            if (row != 0 && row != -1) {
        
                int result = JOptionPane.showConfirmDialog(null, "Finished!", "Message", JOptionPane.PLAIN_MESSAGE);
                
                this.listener.onRemove();
                if (result == JOptionPane.OK_OPTION) {
                    this.setVisible(false);
                }
            }
        }
    }
    
    public interface RemoveRowListener {
      public void onRemove();
    }
}