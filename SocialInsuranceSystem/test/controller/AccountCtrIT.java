package controller;

import dao.AccountDAO;
import dao.Connection;
import static dao.Connection.connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.Account;
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
public class AccountCtrIT {
    
    public AccountCtrIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Connection.createConnection();
        Connection.disableAutoCommit();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         //Delete all records
        String sql = "DELETE FROM Account";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            int rowCount=ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @After
    public void tearDown() {
        Connection.rollback();
    }

    @Test
    public void testCheckUserByName() {
        Account account1=new Account("habui","Test@1234",0,0,"description");
        Account account2=new Account("habui2","Test@1234",0,0,"description");;
        AccountDAO.insertAccount(account1);
        AccountDAO.insertAccount(account2);
        boolean result=AccountCtr.checkUserByName("habui");
        assertEquals(true, result);
    } 
    @Test
    public void testCheckUserByName_AccountEmpty() {
        boolean result=AccountCtr.checkUserByName("habui");
        assertEquals(false, result);
    } 
    @Test
    public void testCheckUserByName_NoteEqualAnyNameInDB() {
        Account account1=new Account("habui","Test@1234",0,0,"description");
        Account account2=new Account("habui2","Test@1234",0,0,"description");;
        AccountDAO.insertAccount(account1);
        AccountDAO.insertAccount(account2);
        boolean result=AccountCtr.checkUserByName("habui3");
        assertEquals(false, result);
    }

    @Test
    public void testGetAllAccountUnstate() {
        Account account1=new Account("habui","Test@1234",0,0,"description");
        Account account2=new Account("habui2","Test@1234",0,0,"description");
        Account account3=new Account("habui3","Test@1234",1,1,"description");
        AccountDAO.insertAccount(account1);
        AccountDAO.insertAccount(account2);
        AccountDAO.insertAccount(account3);
        ArrayList result=AccountCtr.getAllAccountUnstate();
        assertEquals(2, result.size());
    }
    
    @Test
    public void testGetAllAccountUnstate_AllAcountStated() {
        Account account1=new Account("habui","Test@1234",0,1,"description");
        Account account2=new Account("habui2","Test@1234",0,1,"description");
        Account account3=new Account("habui3","Test@1234",1,1,"description");
        AccountDAO.insertAccount(account1);
        AccountDAO.insertAccount(account2);
        AccountDAO.insertAccount(account3);
        ArrayList result=AccountCtr.getAllAccountUnstate();
        assertEquals(0, result.size());
    }
    
    @Test
    public void testGetAllAccountUnstate_AccountEmpty() {
        ArrayList result=AccountCtr.getAllAccountUnstate();
        assertEquals(0, result.size());
    }

    @Test
    public void testLoginAccount() {
        Account account1=new Account("habui","Test@1234",4,1,"description");
        Account account2=new Account("habui2","Test@1234",0,1,"description");
        Account account3=new Account("habui3","Test@1234",1,1,"description");
        AccountDAO.insertAccount(account1);
        AccountDAO.insertAccount(account2);
        AccountDAO.insertAccount(account3);
        int role=AccountCtr.loginAccount("habui", "Test@1234");
        assertEquals(4, role);
    }
    
    @Test
    public void testLoginAccount_InCorrectUsername() {
        Account account1=new Account("habui","Test@1234",4,1,"description");
        Account account2=new Account("habui2","Test@1234",0,1,"description");
        Account account3=new Account("habui3","Test@1234",1,1,"description");
        AccountDAO.insertAccount(account1);
        AccountDAO.insertAccount(account2);
        AccountDAO.insertAccount(account3);
        int role=AccountCtr.loginAccount("habui4", "Test@1234");
        assertEquals(-1, role);
    }
    
    @Test
    public void testLoginAccount_EmptyAccount() {
        int role=AccountCtr.loginAccount("habui4", "Test@1234");
        assertEquals(-1, role);
    }
    
    @Test
    public void testLoginAccount_CorrectUsernameAndInCorrecrtPassword() {
        Account account1=new Account("habui","Test@1234",4,1,"description");
        Account account2=new Account("habui2","Test@1234",0,1,"description");
        Account account3=new Account("habui3","Test@1234",1,1,"description");
        AccountDAO.insertAccount(account1);
        AccountDAO.insertAccount(account2);
        AccountDAO.insertAccount(account3);
        int role=AccountCtr.loginAccount("habui", "Test@124");
        assertEquals(-2, role);
    }
    @Test
    public void testLoginAccount_CorrectUsernamePasswordButUnState() {
        Account account1=new Account("habui","Test@1234",4,0,"description");
        Account account2=new Account("habui2","Test@1234",0,1,"description");
        Account account3=new Account("habui3","Test@1234",1,1,"description");
        AccountDAO.insertAccount(account1);
        AccountDAO.insertAccount(account2);
        AccountDAO.insertAccount(account3);
        int role=AccountCtr.loginAccount("habui", "Test@1234");
        assertEquals(-1, role);
    }
    
    @Test
    public void testGetAccount() {
        Account account1=new Account("habui","Test@1234",4,0,"description");
        Account account2=new Account("habui2","Test@1234",0,1,"description");
        Account account3=new Account("habui3","Test@1234",1,1,"description");
        AccountDAO.insertAccount(account1);
        AccountDAO.insertAccount(account2);
        AccountDAO.insertAccount(account3);
        account1=AccountDAO.selectAllAccount().get(0);
        Account accountDB=AccountCtr.getAccount("habui", "Test@1234");
        assertEquals(account1.username, accountDB.username);
        assertEquals(account1.password, accountDB.password);
        assertEquals(account1.id, accountDB.id);
        assertEquals(account1.description, accountDB.description);
        assertEquals(account1.role, accountDB.role);
        assertEquals(account1.state, accountDB.state);
    }

    @Test
    public void testGetAccount_AccountEmpty() {
        Account accountDB=AccountCtr.getAccount("habui", "Test@1234");
        assertEquals(null, accountDB);
    }
    
    @Test
    public void testGetAccount_AccountEmpty_InCorrecUserName() {
        Account account1=new Account("habui","Test@1234",4,0,"description");
        Account account2=new Account("habui2","Test@1234",0,1,"description");
        Account account3=new Account("habui3","Test@1234",1,1,"description");
        AccountDAO.insertAccount(account1);
        AccountDAO.insertAccount(account2);
        AccountDAO.insertAccount(account3);
        Account accountDB=AccountCtr.getAccount("habui4", "Test@1234");
        assertEquals(null, accountDB);
    }
        
    @Test
    public void testGetAccount_AccountEmpty_CorrecUserName_InCorrectPassword() {
        Account account1=new Account("habui","Test@1234",4,0,"description");
        Account account2=new Account("habui2","Test@1234",0,1,"description");
        Account account3=new Account("habui3","Test@1234",1,1,"description");
        AccountDAO.insertAccount(account1);
        AccountDAO.insertAccount(account2);
        AccountDAO.insertAccount(account3);
        Account accountDB=AccountCtr.getAccount("habui", "Test@123");
        assertEquals(null, accountDB);
    }
    @Test
    public void testGetAccount_AccountEmpty_InCorrecUserName_InCorrectPassword() {
        Account account1=new Account("habui","Test@1234",4,0,"description");
        Account account2=new Account("habui2","Test@1234",0,1,"description");
        Account account3=new Account("habui3","Test@1234",1,1,"description");
        AccountDAO.insertAccount(account1);
        AccountDAO.insertAccount(account2);
        AccountDAO.insertAccount(account3);
        Account accountDB=AccountCtr.getAccount("habu5i", "Test@1235");
        assertEquals(null, accountDB);
    }

    @Test
    public void testRegisterAccount() {
        Account account1=new Account("habui","Test@1234",4,0,"description");
        Account account2=new Account("habui2","Test@1234",0,1,"description");
        Account account3=new Account("habui3","Test@1234",1,1,"description");
        AccountDAO.insertAccount(account1);
        AccountDAO.insertAccount(account2);
        AccountDAO.insertAccount(account3);
        int result=AccountCtr.registerAccount("habui4", "Test@1234", 0, 0, "description");
        assertEquals(1,result);
    }
    @Test
    public void testRegisterAccount_SameName() {
        Account account1=new Account("habui","Test@1234",4,0,"description");
        Account account2=new Account("habui2","Test@1234",0,1,"description");
        Account account3=new Account("habui3","Test@1234",1,1,"description");
        AccountDAO.insertAccount(account1);
        AccountDAO.insertAccount(account2);
        AccountDAO.insertAccount(account3);
        int result=AccountCtr.registerAccount("habui", "Test@1234", 0, 0, "description");
        assertEquals(-2, result);
    }   
    
}
