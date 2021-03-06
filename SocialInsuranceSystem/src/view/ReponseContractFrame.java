/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CompulsoryContractDAO;
import dao.CustomerDAO;
import dao.VoluntaryContractDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private int type;
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

    public void setType(int type) {
        this.type = type;
    }
    
    private void initTableData() {
        lbName.setText(customer.name);
        if (customer.sex) lbGender.setText("Male");
        else lbGender.setText("Female");
        lbDob.setText(customer.dob);
        lbIdNum.setText(customer.idNumber);
        lbSocialNum.setText(customer.socialInsuranceNo);
        lbEmail.setText(customer.email);
        lbPhone.setText(customer.phoneNo);
        lbHometown.setText(customer.hometown.name);
        lbTaxCode.setText(customer.taxCode);
        if (customer.compulsoryContract != null) {
            lbComCode.setText(customer.compulsoryContract.companyCode);
            lbDes.setText(customer.compulsoryContract.description);
        } else {
            lbComCode.setText("No Company Code");
            lbDes.setText(customer.voluntaryContract.description);
        }
        try {
            // The comma in the format specifier does the trick
            long longsalary = (long) customer.salary;
            String salary = String.format("%,d", longsalary);
            lbSalary.setText(salary + " VND");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormat");
        }
        
        if (customer.paymentDuration == 0) lbDuration.setText("Month");
        else lbDuration.setText("Year");
        
         try {
            // The comma in the format specifier does the trick
            long longsalary = (long) (customer.salary * 25.5/100);
            String salary = String.format("%,d", longsalary);
            lbCost.setText(salary + " VND");
           
        } catch (NumberFormatException e) {
            System.out.println("NumberFormat");
        }
       
    }
    
    /**
     * Creates new form ConfirmCompulsoryFrame
     */
    public ReponseContractFrame() {
        initComponents();
        setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Reponse Contract");
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

        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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
        lbName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbSocialNum = new javax.swing.JLabel();
        lbPhone = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        lbComCode = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbDob = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbHometown = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbSalary = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbDes = new javax.swing.JLabel();

        jLabel16.setText("jLabel16");

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

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Confirm Contract");

        lbTaxCode.setText("123123123");

        jLabel12.setText("Tax Code :");

        lbIdNum.setText("061092303");

        jLabel7.setText("ID Number :");

        jLabel9.setText("Email :");

        lbEmail.setText("nttung291@gmail.com");

        jLabel13.setText("Insurance Duration :");

        lbDuration.setText("Month");

        jLabel2.setText("Cost of insurance :");

        lbCost.setText("0");

        lbName.setText("Tung Nguyen");

        jLabel3.setText("Name :");

        jLabel8.setText("Social Insurance Number :");

        lbSocialNum.setText("10120301203");

        lbPhone.setText("84962962997");

        jLabel10.setText("Phone Number :");

        jLabel14.setText("Company Code :");

        lbGender.setText("Male");

        lbComCode.setText("00123123");

        jLabel4.setText("Gender :");

        jLabel6.setText("Date of birth :");

        lbDob.setText("29/01/1997");

        jLabel11.setText("Hometown :");

        lbHometown.setText("Yen Bai");

        jLabel5.setText("Salary(VND): ");

        lbSalary.setText("0");

        jLabel15.setText("Contract Description :");

        lbDes.setText("No descriptions");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbComCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbIdNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbDes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCost, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTaxCode, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbHometown, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSocialNum, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90))))
            .addGroup(layout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(jLabel1)
                .addGap(52, 340, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(77, 77, 77)
                .addComponent(jButton2)
                .addGap(276, 276, 276))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbName)
                    .addComponent(jLabel8)
                    .addComponent(lbSocialNum))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbGender)
                    .addComponent(jLabel10)
                    .addComponent(lbPhone))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbDob)
                    .addComponent(jLabel11)
                    .addComponent(lbHometown))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbIdNum)
                    .addComponent(jLabel12)
                    .addComponent(lbTaxCode))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbEmail)
                    .addComponent(jLabel13)
                    .addComponent(lbDuration))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbComCode)
                    .addComponent(jLabel2)
                    .addComponent(lbCost))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbSalary)
                    .addComponent(jLabel15)
                    .addComponent(lbDes))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(43, 43, 43))
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
    
    public void acceptRegister(int row, String dateString) {
        if (customer.compulsoryContract != null) {
                CompulsoryContract compulsoryContract = customer.compulsoryContract;
                compulsoryContract.state = 1;
                compulsoryContract.startedDate = dateString;
                row = CompulsoryContractDAO.updateCompulsoryContract(compulsoryContract);
            } else if (customer.voluntaryContract != null) {
                VoluntaryContract voluntaryContract = customer.voluntaryContract;
                voluntaryContract.state = 1;
                voluntaryContract.startedDate = dateString;
                row = VoluntaryContractDAO.updateVoluntaryContract(voluntaryContract);
            }
            if (row != 0 && row != -1) {
        
                int result = JOptionPane.showConfirmDialog(null, "Finished!", "Message", JOptionPane.PLAIN_MESSAGE);
                
                this.listener.onRemove();
                if (result == JOptionPane.OK_OPTION) {
                    this.setVisible(false);
            }
        }
    }
    
    public void declineRegister(int row) {
        if (customer.compulsoryContract != null) {
                CompulsoryContract compulsoryContract = customer.compulsoryContract;
                int deleteCus = CustomerDAO.deleteCustomerByID(customer.id);
                int deleteCon = 0;
                if (deleteCus == 1){
                    deleteCon = CompulsoryContractDAO.deleteCompulsoryContractByID(compulsoryContract.id);
                }
                if (deleteCon == 1) {
                    row = 1;
                }
            } else if (customer.voluntaryContract != null) {
                VoluntaryContract voluntaryContract = customer.voluntaryContract;
                int deleteCus = CustomerDAO.deleteCustomerByID(customer.id);
                int deleteCon = 0;
                if (deleteCus == 1){
                    deleteCon = VoluntaryContractDAO.deleteVoluntaryContractByID(voluntaryContract.id);
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
    
    public void declineCancel(int row) {
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
    }
    
    public void acceptCancel(int row) {
         if (customer.compulsoryContract != null) {
                CompulsoryContract compulsoryContract = customer.compulsoryContract;
                int deleteCus = CustomerDAO.deleteCustomerByID(customer.id);
                int deleteCon = 0;
                if (deleteCus == 1){
                    deleteCon = CompulsoryContractDAO.deleteCompulsoryContractByID(compulsoryContract.id);
                }
                if (deleteCon == 1) {
                    row = 1;
                }
            } else if (customer.voluntaryContract != null) {
                VoluntaryContract voluntaryContract = customer.voluntaryContract;
                int deleteCus = CustomerDAO.deleteCustomerByID(customer.id);
                int deleteCon = 0;
                if (deleteCus == 1){
                    deleteCon = VoluntaryContractDAO.deleteVoluntaryContractByID(voluntaryContract.id);
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
    
     public void acceptUpdate(int row) {
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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbComCode;
    private javax.swing.JLabel lbCost;
    private javax.swing.JLabel lbDes;
    private javax.swing.JLabel lbDob;
    private javax.swing.JLabel lbDuration;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbHometown;
    private javax.swing.JLabel lbIdNum;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel lbSalary;
    private javax.swing.JLabel lbSocialNum;
    private javax.swing.JLabel lbTaxCode;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onClicked() {
        int row = -1;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
        String dateString = dateFormat.format(date);
        
        if (type == 0) {
            if (isAccepted) acceptRegister(row, dateString);
            else declineRegister(row);
        } else if (type == 2) {
            if (isAccepted) acceptCancel(row);
            else declineCancel(row);
        } else if (type == 3){
            acceptUpdate(row);
        }
    }
    
    public interface RemoveRowListener {
      public void onRemove();
    }
}
