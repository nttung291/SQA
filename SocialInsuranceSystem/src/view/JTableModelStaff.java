/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AccountCtr;
import dao.CompulsoryContractDAO;
import dao.Connection;
import dao.CustomerDAO;
import dao.VoluntaryContractDAO;
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
import model.CompulsoryContract;
import model.Customer;
import model.VoluntaryContract;
import utils.EncodeDecode;


/**
 *
 * @author nttungg
 */
public class JTableModelStaff extends JFrame{
    private DefaultTableModel dm;
    ArrayList<CompulsoryContract> compulsoryContracts;
    ArrayList<VoluntaryContract> voluntaryContracts;
    ArrayList<Customer> customers; 
    ArrayList<Customer> addedCustomers = new ArrayList<>();
    int requestNumber = 0;
    Vector values = new Vector();
            
    public JTableModelStaff() {
        super("Reponse Contract Table");
        Connection.createConnection();
        
        compulsoryContracts =  CompulsoryContractDAO.selectAllCompulsoryContract();
        voluntaryContracts = VoluntaryContractDAO.selectAllVoluntaryContract();
        customers = CustomerDAO.selectAllCustomer();
        
        if (compulsoryContracts.size() == 0 && voluntaryContracts.size() == 0) {
            int result = JOptionPane.showConfirmDialog(null, "No contract request at the moment!", "Message", JOptionPane.PLAIN_MESSAGE);
        }
        
        dm = new DefaultTableModel();
        Vector column = new Vector();
        column.add("Request Number");
        column.add("Request Type");
        column.add("Name");
        column.add("State");
        column.add("Payment Duration");
        column.add("Type Of Insurance");
        column.add("Cost");
        column.add("See Detail");
        
        insertContract();
        dm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column==1 || column==2 || column==3 || column==4 || column ==5 || column ==6) return false;
                return true;
            }
        };
        dm.setDataVector(values, column);

        JTable table = new JTable(dm);
        table.getColumn("See Detail").setCellRenderer(new ButtonStaffRenderer());
        table.getColumn("See Detail").setCellEditor(
            new ButtonStaffEditor(new JCheckBox(),dm, addedCustomers));
        table.getColumnModel().getColumn(2).setPreferredWidth(120);
        JScrollPane scroll = new JScrollPane(table);
        getContentPane().add(scroll);
        setSize(1000, 700);
    }
    
    private void insertContract() {
        if (compulsoryContracts.size() == 0 && voluntaryContracts.size() == 0) {
            JOptionPane.showMessageDialog(null, "No register contract request at the moment!", "Message", JOptionPane.PLAIN_MESSAGE);
        }

        for (int i=0;i<compulsoryContracts.size();i++) {
            if (compulsoryContracts.get(i).state != 1) {
                for (int j=0;j<customers.size();j++) {
                    if (customers.get(j).compulsoryContract != null) {
                        if (customers.get(j).compulsoryContract.id == compulsoryContracts.get(i).id) {
                            requestNumber = requestNumber+1;
                            Integer id = requestNumber;
                            String requestType;
                            if (customers.get(j).compulsoryContract.state == 0) {
                                requestType = "Register";
                            } else if (customers.get(j).compulsoryContract.state == 2) {
                                requestType = "Cancel";
                            } else {
                                requestType = "Update";
                            }
                            String name = customers.get(j).name;
                            Integer state = customers.get(j).compulsoryContract.state;
                            String paymentDuration;
                            if (customers.get(j).paymentDuration == 0) paymentDuration = "Monthly";
                            else paymentDuration = "Year";
                            String type = "Compulsory";
        
                            long longsalary = (long) (customers.get(j).salary * 25.5/100);
                            String cost = "";
                            cost = String.format("%,d", longsalary);
                            
                            Vector row = new Vector();
                            row.add(id);
                            row.add(requestType);
                            row.add(name);
                            row.add(state);
                            row.add(paymentDuration);
                            row.add(type);
                            row.add(cost);
                            row.add("See Detail");
                            values.add(row);
                            addedCustomers.add(customers.get(j));
                        }
                    }
                }
            }
        }
        
        for (int i=0;i<voluntaryContracts.size();i++) {
            if (voluntaryContracts.get(i).state != 1) {
                VoluntaryContract voluntaryContract = voluntaryContracts.get(i);
                for (int j=0;j<customers.size();j++) {
                    if (customers.get(j).voluntaryContract != null) {
                        if (customers.get(j).voluntaryContract.id == voluntaryContract.id) {
                            requestNumber = requestNumber+1;
                            Integer id = requestNumber;
                            String requestType;
                            if (customers.get(j).voluntaryContract.state == 0) {
                                requestType = "Register";
                            } else if (customers.get(j).voluntaryContract.state == 2) {
                                requestType = "Cancel";
                            } else {
                                requestType = "Update";
                            }
                            String name = customers.get(j).name;
                            Integer state = customers.get(j).voluntaryContract.state;
                            String paymentDuration;
                            if (customers.get(j).paymentDuration == 0) paymentDuration = "Monthly";
                            else paymentDuration = "Year";
                            String type = "Voluntary";
                            
                            long longsalary = (long) (customers.get(j).salary * 22/100);
                            String cost = "";
                            cost = String.format("%,d", longsalary);
                           
                            Vector row = new Vector();
                            row.add(id);
                            row.add(requestType);
                            row.add(name);
                            row.add(state);
                            row.add(paymentDuration);
                            row.add(type);
                            row.add(cost + " VND");
                            row.add("See Detail");
                            values.add(row);
                            addedCustomers.add(customers.get(j));
                        }
                    }
                }
            }
        }
    }
     
    public DefaultTableModel getDm() {
        return this.dm;
    }
}
/**
 * @version 1.0 11/09/98
 */

class ButtonStaffRenderer extends JButton implements TableCellRenderer {

  public ButtonStaffRenderer() {
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

class ButtonStaffEditor extends DefaultCellEditor implements ReponseContractFrame.RemoveRowListener {
  protected JButton button;

  private String label;
  private DefaultTableModel defaultTableModel; 
  private ArrayList<Customer> customers;
  private Account selectedAccount;
  private int affectedRow = -1;
  private boolean isPushed;

  public ButtonStaffEditor(JCheckBox checkBox, DefaultTableModel dm,  ArrayList<Customer> addedCustomers ) {
    super(checkBox);
    defaultTableModel = dm;
    customers = addedCustomers;
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
    affectedRow = row;
    isPushed = true;
    return button;
  }

  public Object getCellEditorValue() {
    if (isPushed) {
        ReponseContractFrame reponseFrame = new ReponseContractFrame();
        reponseFrame.setCustomer(customers.get(affectedRow));
        if (customers.get(affectedRow).compulsoryContract != null) {
            reponseFrame.setType(customers.get(affectedRow).compulsoryContract.state);
        } else if (customers.get(affectedRow).voluntaryContract != null) {
            reponseFrame.setType(customers.get(affectedRow).voluntaryContract.state);
        }
        reponseFrame.setListener(this);
        reponseFrame.initData();
        reponseFrame.setVisible(true);
    }
    isPushed = false;
    return "See Detail";
  }

  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }

    @Override
    public void onRemove() {
        defaultTableModel.removeRow(affectedRow);
        affectedRow = -1;
    }
}

