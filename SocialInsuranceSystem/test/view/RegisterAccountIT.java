/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author habui
 */
public class RegisterAccountIT {
    
    public RegisterAccountIT() {
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
     * Test of getTfUsername method, of class RegisterAccount.
     */
    @Test
    public void testGetTfUsername() {
        System.out.println("getTfUsername");
        RegisterAccount instance = new RegisterAccount();
        String expResult = "";
        String result = instance.getTfUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTfPassword method, of class RegisterAccount.
     */
    @Test
    public void testSetTfPassword() {
        System.out.println("setTfPassword");
        String tfPassword = "";
        RegisterAccount instance = new RegisterAccount();
        instance.setTfPassword(tfPassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTfUsername method, of class RegisterAccount.
     */
    @Test
    public void testSetTfUsername() {
        System.out.println("setTfUsername");
        String tfUsername = "";
        RegisterAccount instance = new RegisterAccount();
        instance.setTfUsername(tfUsername);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTfConfirmPassword method, of class RegisterAccount.
     */
    @Test
    public void testGetTfConfirmPassword() {
        System.out.println("getTfConfirmPassword");
        RegisterAccount instance = new RegisterAccount();
        JPasswordField expResult = null;
        JPasswordField result = instance.getTfConfirmPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTfConfirmPassword method, of class RegisterAccount.
     */
    @Test
    public void testSetTfConfirmPassword() {
        System.out.println("setTfConfirmPassword");
        String tfConfirmPassword = "";
        RegisterAccount instance = new RegisterAccount();
        instance.setTfConfirmPassword(tfConfirmPassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getjButton1 method, of class RegisterAccount.
     */
    @Test
    public void testGetjButton1() {
        System.out.println("getjButton1");
        RegisterAccount instance = new RegisterAccount();
        JButton expResult = null;
        JButton result = instance.getjButton1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
