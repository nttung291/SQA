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
     * Test of main method, of class RegisterAccount.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RegisterAccount.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test 
    public void testCase2_TestBlankInput(){
        RegisterAccount rA_View=new RegisterAccount();
        rA_View.setTfUsername("habuimanh1");
        rA_View.setTfPassword("Test@1234");
        JButton button = rA_View.getjButton1();
        boolean isEnabled=button.isEnabled();
        assertEquals(isEnabled, false);
    }
    
    @Test 
    public void testCase3_TestBlankInput(){
        RegisterAccount rA_View=new RegisterAccount();
        rA_View.setTfUsername("habuimanh1");
        rA_View.setTfPassword("Test@1234");
        rA_View.setTfConfirmPassword("Test@134");
        JButton button = rA_View.getjButton1();
        boolean isEnabled=button.isEnabled();
        assertEquals(isEnabled, true);
    }

    @Test 
    public void testCase4_CorrectUserNameInput(){
        RegisterAccount rA_View=new RegisterAccount();
        rA_View.setTfUsername("habuimanh1");
        String msg=rA_View.getLbMessage();
        assertEquals(msg, "No message");
    }
    
    @Test 
    public void testCase5_IncorrectUserNameInput(){
        RegisterAccount rA_View=new RegisterAccount();
        rA_View.setTfUsername("habuimanh");
        String msg=rA_View.getLbMessage();
        assertEquals(msg, "No message");
        Color color = rA_View.getLbMessageColor();
        assertEquals(color, Color.RED);
    }
    
    @Test 
    public void testCase6_CorrectPasswordInput(){
        RegisterAccount rA_View=new RegisterAccount();
        rA_View.setTfPassword("Test@1234");
        String msg=rA_View.getLbMessage();
        assertEquals(msg, "No message");
    }
    
    @Test 
    public void testCase7_IncorrectPasswordInput(){
        RegisterAccount rA_View=new RegisterAccount();
        rA_View.setTfPassword("Test1234");
        String msg=rA_View.getLbMessage();
        assertEquals(msg, "This password field must contain at least one number, special character such as (!,#,$,^,&,..) and not enough at least 8 characters, please check your input again");
        Color color = rA_View.getLbMessageColor();
        assertEquals(color, Color.RED);
    }
    
    @Test 
    public void testCase8_CorrectTwoPasswordsInput(){
        RegisterAccount rA_View=new RegisterAccount();
        rA_View.setTfPassword("Test@1234");
        rA_View.setTfConfirmPassword("Test@1234");
        String msg=rA_View.getLbMessage();
        assertEquals(msg, "No message");
    }
    
    @Test 
    public void testCase9_CorrectTwoPasswordsInput(){
        RegisterAccount rA_View=new RegisterAccount();
        rA_View.setTfPassword("Test@1234");
        rA_View.setTfConfirmPassword("Test@134");
        String msg=rA_View.getLbMessage();
        assertEquals(msg, "Two passwords are not exactly same, please check your input again");
    }
    
}
