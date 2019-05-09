/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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
public class LoginFrameIT {
    public LoginFrameIT() {
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

    @Test
    public void testbtnLoginActionPerformed_BlankInput() {
        LoginFrame loginFrm=new LoginFrame();
        loginFrm.getBtLogin().doClick();
        loginFrm.setTfUsername("");
        loginFrm.setTfPassword("");
//        String msg=loginFrm
        fail("Cannot get mess/age dialog");
    }
    @Test
    public void testCheckEmptyBlank_NotEmpty() {
        LoginFrame loginFrm=new LoginFrame();
        loginFrm.setTfUsername("habui");
        loginFrm.setTfPassword("Test@1234");
        boolean result=!loginFrm.checkEmptyBlank();
        assertEquals(false, result);
    }
    @Test
    public void testCheckEmptyBlank() {
        LoginFrame loginFrm=new LoginFrame();
        loginFrm.setTfUsername("");
        loginFrm.setTfPassword("");
        boolean result=!loginFrm.checkEmptyBlank();
        assertEquals(true, result);
    }
    
}
