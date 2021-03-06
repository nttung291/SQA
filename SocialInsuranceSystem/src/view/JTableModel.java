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
    JTable table;
            
    public JTableModel() {
    super("Reponse Account Register Table");
    Connection.createConnection();
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setInitTable();
    JScrollPane scroll = new JScrollPane(table);
    getContentPane().add(scroll);
    setSize(1000, 700);
    setVisible(true);
    }
    
    public DefaultTableModel getDm() {
        return this.dm;
    }
    
    public void setInitTable() {
        account =  AccountCtr.getAllAccountUnstate();
    
        if (account.size() == 0) {
            JOptionPane.showMessageDialog(null, "No register request at the moment!", "Message", JOptionPane.PLAIN_MESSAGE);
        }

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
        dm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column==1 || column==2 || column==3 || column==4 || column ==5) return false;
                return true;
            }
        };
        dm.setDataVector(values, column);

        table = new JTable(dm);
        table.getColumn("Decline").setCellRenderer(new ButtonRenderer());
        table.getColumn("Decline").setCellEditor(
            new ButtonEditor(new JCheckBox(),dm,table));
        table.getColumn("Accept").setCellRenderer(new ButtonRenderer());
        table.getColumn("Accept").setCellEditor(
            new ButtonEditor(new JCheckBox(), dm,table));

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
  private JTable table;

  private String label;
  private DefaultTableModel defaultTableModel; 
  private Account selectedAccount;
  private int affectedRow = -1;
  private boolean isPushed;

  public ButtonEditor(JCheckBox checkBox, DefaultTableModel dm , JTable tbl) {
    super(checkBox);
    defaultTableModel = dm;
    table = tbl;
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          try {
              fireEditingStopped();
          } catch(ArrayIndexOutOfBoundsException ex) {

          }
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
                try {
                    int deleteresult =  AccountDAO.deleteAccountByID(selectedAccount.id);
                    if (deleteresult == 1) {
                        stopCellEditing();
                        defaultTableModel.removeRow(affectedRow);
                        affectedRow = -1;
                    }
                } catch(ArrayIndexOutOfBoundsException e) {

                }
            } else if (label == "Accept") {
                try {
                    selectedAccount.state = 1;
                    int updateresult =  AccountCtr.updateAccount(selectedAccount);
                    if (updateresult != -1 && updateresult != 0) {
                        stopCellEditing();
                        defaultTableModel.removeRow(affectedRow);
                        affectedRow = -1;
                    }
                } catch(ArrayIndexOutOfBoundsException e) {
                        
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

