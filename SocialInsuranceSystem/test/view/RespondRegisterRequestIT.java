/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.AccountDAO;
import dao.Connection;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import model.Account;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;

/**
 *
 * @author thinhnd
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RespondRegisterRequestIT {
    public RespondRegisterRequestIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Connection.createConnection();
        AccountDAO.deleteAllAccounts();
        AccountDAO.insertAccount(new Account("admin", "admin", 2, 1, "No description"));
        AccountDAO.insertAccount(new Account("habuimanh1", "Test@1234", 2, 0, "No description"));
        AccountDAO.insertAccount(new Account("thinhnd", "abc123", 2, 0, "No description"));
    }
    
    @After
    public void tearDown() {
        AccountDAO.deleteAllAccounts();
        AccountDAO.insertAccount(new Account("admin", "admin", 2, 1, "No description"));
        AccountDAO.insertAccount(new Account("habuimanh1", "Test@1234", 2, 0, "No description"));
        AccountDAO.insertAccount(new Account("thinhnd", "abc123", 2, 0, "No description"));
    }

    /**
     * Test of main method, of class JTableModel.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        JTableModel frame = new JTableModel();
    }
    
    @Test
    public void testCase2_noPendingAccounts() {
        // case: no account pending for approval
        // delete all current accounts
        // TODO: only update all to unpending
        AccountDAO.deleteAllAccounts();
        
        // open view for testing
        JTableModel rRR_View = new JTableModel();
        
        // check rows count
        int rowsCount = rRR_View.getDm().getRowCount();
        
        // check if it's okay
        assertEquals(rowsCount, 0);
    }
    
    @Test
    public void testCase3_testInfoShowCorrectly() {
        // case: test info displayed correctly
        // open view for testing
        JTableModel rRR_View = new JTableModel();
        
        // get data model
        DefaultTableModel rows = rRR_View.getDm();
        
        // check rows count
        int rowsCount = rRR_View.getDm().getRowCount();
        assertEquals(rowsCount, 2);
        
        // check data is okay
        Object firstRow_username = rows.getValueAt(0, 1);
        Object firstRow_role = rows.getValueAt(0, 3);
        
        assertEquals(firstRow_username, "habuimanh1");
        assertEquals(firstRow_role, 2);
    }
    
//    @Test
//    public void testCase4_
}
