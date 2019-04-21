/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AccountCtr;
import dao.AccountDAO;
import dao.Connection;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import model.Account;
import utils.EncodeDecode;


/**
 *
 * @author nttungg
 */
public class JTableModel extends JFrame{
    private DefaultTableModel dm;
    ArrayList<Account> account;
            
    public JTableModel() {
    super("Reponse Account Register Table");
    Connection.createConnection();
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    account =  AccountCtr.getAllAccountUnstate();
    
    if (account.size() == 0) {
        JOptionPane.showMessageDialog(null, "No register request at the moment!", "Message", JOptionPane.PLAIN_MESSAGE);
    }
    
    dm = new DefaultTableModel();
    Vector column = new Vector();
    column.add("Id");
    column.add("Username");
    column.add("Password");
    column.add("Role");
    column.add("State");
    column.add("Description");
    column.add("Decline");
    column.add("Accept");
  
    Vector values = new Vector();
        
    for (int i = 0; i < account.size(); i++){
        Integer id = account.get(i).id;
        String username = account.get(i).username;
        String password = account.get(i).password;
        Integer role = account.get(i).role;
        Integer state = account.get(i).state;
        String description = account.get(i).description;
        Vector row = new Vector();
        row.add(id);
        row.add(username);
        row.add(password);
        row.add(role);
        row.add(state);
        row.add(description);
        row.add("Decline");
        row.add("Accept");
        values.add(row);
    }
    dm.setDataVector(values, column);

    JTable table = new JTable(dm);
    table.getColumn("Decline").setCellRenderer(new ButtonRenderer());
    table.getColumn("Decline").setCellEditor(
        new ButtonEditor(new JCheckBox(),dm));
    table.getColumn("Accept").setCellRenderer(new ButtonRenderer());
    table.getColumn("Accept").setCellEditor(
        new ButtonEditor(new JCheckBox(), dm));
    JScrollPane scroll = new JScrollPane(table);
    getContentPane().add(scroll);
    setSize(1000, 700);
    setVisible(true);
  }
    
    public DefaultTableModel getDm() {
        return this.dm;
    }
    
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
            java.util.logging.Logger.getLogger(StaffMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JTableModel().setVisible(true);
            }
        });
    }
}
/**
 * @version 1.0 11/09/98
 */

class ButtonRenderer extends JButton implements TableCellRenderer {

  public ButtonRenderer() {
    setOpaque(true);
  }

  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Button.background"));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }
}

/**
 * @version 1.0 11/09/98
 */

class ButtonEditor extends DefaultCellEditor {
  protected JButton button;

  private String label;
  private DefaultTableModel defaultTableModel; 
  private Account selectedAccount;
  private int affectedRow = -1;
  private boolean isPushed;

  public ButtonEditor(JCheckBox checkBox, DefaultTableModel dm ) {
    super(checkBox);
    defaultTableModel = dm;
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }

  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    Integer id = (Integer) defaultTableModel.getValueAt(row, 0);
    String username = (String) defaultTableModel.getValueAt(row, 1);
    String password = (String) defaultTableModel.getValueAt(row, 2);
    Integer role = (Integer) defaultTableModel.getValueAt(row, 3);
    Integer state = (Integer) defaultTableModel.getValueAt(row, 4);
    String description = (String) defaultTableModel.getValueAt(row, 5);
    selectedAccount = new Account(username,password,role,state,description);
    selectedAccount.id = id;
    affectedRow = row;
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    return button;
  }

  public Object getCellEditorValue() {
    if (isPushed) {
        final JComponent[] inputs = new JComponent[] {
            new JLabel(label + ": Confirm?"),
        };  
        
        int result = JOptionPane.showConfirmDialog(null, inputs, "Confirm ?", JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            if (label == "Decline") {
                int deleteresult =  AccountDAO.deleteAllAccountByID(selectedAccount);
                 if (deleteresult == 1) {
                    defaultTableModel.removeRow(affectedRow);
                    affectedRow = -1;
                }
            } else if ( label == "Accept") {
                selectedAccount.state = 1;
                int updateresult =  AccountCtr.updateAccount(selectedAccount);
                if (updateresult != -1 && updateresult != 0) {
                    defaultTableModel.removeRow(affectedRow);
                    affectedRow = -1;
                }
              
            }
        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }
    }
    isPushed = false;
    return new String(label);
  }

  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}

