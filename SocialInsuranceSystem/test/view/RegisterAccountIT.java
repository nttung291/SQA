/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.AccountDAO;
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
        AccountDAO.disableAutoCommit();
    }
    
    @After
    public void tearDown() {
        AccountDAO.rollback();
    }
    
    @Test 
    public void testCase1_TestViewNamInputInput(){
        RegisterAccount rA_View=new RegisterAccount();
        rA_View.setTfUsername("habuimanh1");
        String usernameInputValue=rA_View.getTfUsername();
        assertEquals("habuimanh1", usernameInputValue);
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
    public void testCase5_IncorrectUserNameInput(){
        RegisterAccount rA_View=new RegisterAccount();
        rA_View.setTfUsername("habuimanh");
        rA_View.setTfPassword("Test@1234");
        rA_View.setTfConfirmPassword("Test@1234");
        rA_View.getjButton1().doClick();
        String msg=rA_View.getLbMessage();
        assertEquals(msg, "This name field must not contain any special character, please check your input again");
        Color color = rA_View.getLbMessageColor();
        assertEquals(color, Color.RED);
    }
    
    @Test 
    public void testCase7_IncorrectPasswordInput(){
        RegisterAccount rA_View=new RegisterAccount();
        rA_View.setTfUsername("habuimanh1");
        rA_View.setTfPassword("Test1234");
        rA_View.setTfConfirmPassword("Test1234");
        rA_View.getjButton1().doClick();
        String msg=rA_View.getLbMessage();
        assertEquals(msg, "This password field must contain at least one number, special character such as (!,#,$,^,&,..) and not enough at least 8 characters, please check your input again");
        Color color = rA_View.getLbMessageColor();
        assertEquals(color, Color.RED);
    }
    
    
    @Test 
    public void testCase9_CorrectTwoPasswordsInput(){
        RegisterAccount rA_View=new RegisterAccount();
        rA_View.setTfUsername("habuimanh1");
        rA_View.setTfPassword("Test@1234");
        rA_View.setTfConfirmPassword("Test@134");
        rA_View.getjButton1().doClick();
        String msg=rA_View.getLbMessage();
        assertEquals(msg, "Two passwords are not exactly same, please check your input again");
    }
    @Test 
    public void testCase4_6_8_TestCorrectInputForAccountRegister(){
        RegisterAccount rA_View=new RegisterAccount();
        rA_View.setTfUsername("habuimanh1");
        rA_View.setTfPassword("Test@1234");
        rA_View.setTfConfirmPassword("Test@1234");
        rA_View.getjButton1().doClick();
        String msg=rA_View.getLbMessage();
        assertEquals(msg, "Register Successfully");
    }
    @Test 
    public void testCase_10_11_TestUsernameInputSameWithUsernameInDatabase(){
        RegisterAccount rA_View=new RegisterAccount();
        rA_View.setTfUsername("habuimanh1");
        rA_View.setTfPassword("Test@1234");
        rA_View.setTfConfirmPassword("Test@1234");
        rA_View.getjButton1().doClick();
        
        RegisterAccount rA_View2=new RegisterAccount();
        rA_View2.setTfUsername("habuimanh1");
        rA_View2.setTfPassword("Test@1234");
        rA_View2.setTfConfirmPassword("Test@1234");
        rA_View2.getjButton1().doClick();
        String msg=rA_View2.getLbMessage();
        assertEquals(msg, "Account has been existed already");
    }
    
}
