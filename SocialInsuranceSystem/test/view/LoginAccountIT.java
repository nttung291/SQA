/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.JButton;
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
public class LoginAccountIT {
    
    public LoginAccountIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class RegisterAccount.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        LoginFrame.main(args);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void testCase2_testBlankInput_blankPassword() {
        // case: username available, password blank
        LoginFrame lA_View = new LoginFrame();
        lA_View.setTfUsername("thinhnd");
        lA_View.setTfPassword("");
        
        // click button
        lA_View.getLoginButton().doClick();
        
        // check case
        String msg = lA_View.getLbMessage();
        assertEquals(msg, "Informations can not be blank");
    }
    
    @Test
    public void testCase2_testBlankInput_blankUsername() {
        // case: password available, username blank
        LoginFrame lA_View = new LoginFrame();
        lA_View.setTfUsername("");
        lA_View.setTfPassword("12345678");
        
        // click button
        lA_View.getLoginButton().doClick();
        
        // check case
        String msg = lA_View.getLbMessage();
        assertEquals(msg, "Informations can not be blank");
    }
    
    @Test
    public void testCase2_testBlankInput_bothBlank() {
        // case: both input blank
        LoginFrame lA_View = new LoginFrame();
        lA_View.setTfUsername("");
        lA_View.setTfPassword("");
        
        // click button
        lA_View.getLoginButton().doClick();
        
        // check case
        String msg = lA_View.getLbMessage();
        assertEquals(msg, "Informations can not be blank");
    }
    
    @Test
    public void testCase3_correctPasswordUsernameInput() {
        // case: username and password are correct
        LoginFrame lA_View = new LoginFrame();
        lA_View.setTfUsername("habuimanh1");
        lA_View.setTfPassword("Test@1234");
        
        // click button
        lA_View.getLoginButton().doClick();
        
        // check if form is closed 
        boolean isClosed = !lA_View.isVisible();
        assertEquals(isClosed, true);
    }
    
    @Test
    public void testCase4_correctUsernameIncorrectPassword() {
        // case: correct username, incorrect password
        LoginFrame lA_View = new LoginFrame();
        lA_View.setTfUsername("habuimanh1");
        lA_View.setTfPassword("Test@12345");
        
        // click button
        lA_View.getLoginButton().doClick();
        
        // check case
        String msg = lA_View.getLbMessage();
        assertEquals(msg, "Wrong password");
    }
    
    @Test
    public void testCase5_incorrectUsernameCorrectPassword() {
        // case: incorrect username, correct password
        LoginFrame lA_View = new LoginFrame();
        lA_View.setTfUsername("habu imanh");
        lA_View.setTfPassword("Test@1234");
        
        // click button
        lA_View.getLoginButton().doClick();
        
        // check case
        String msg = lA_View.getLbMessage();
        assertEquals(msg, "Account has not registed");
    }
    
    @Test
    public void testCase6_incorrectPasswordAndUsername() {
        // case: incorrect username and password
        LoginFrame lA_View = new LoginFrame();
        lA_View.setTfUsername("habu imanh");
        lA_View.setTfPassword("Test@12345");
        
        // click button
        lA_View.getLoginButton().doClick();
        
        // check case
        String msg = lA_View.getLbMessage();
        assertEquals(msg, "Account has not registed");
    }
}