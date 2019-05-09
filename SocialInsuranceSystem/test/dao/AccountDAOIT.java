///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dao;
//
//import static dao.Connection.connection;
//import java.sql.PreparedStatement;
//import java.util.ArrayList;
//import model.Account;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author habui
// */
//public class AccountDAOIT {
//
//    public AccountDAOIT() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//        Connection.createConnection();
//        Connection.disableAutoCommit();
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        //Delete all records
//        String sql = "DELETE FROM Account";
//        try{
//            PreparedStatement ps = connection.prepareStatement(sql);
//            int rowCount=ps.executeUpdate();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @After
//    public void tearDown() {
//        Connection.rollback();
//    }
//
//    @Test
//    public void testSelectAllAccount() {
//        Account account1=createAccount();
//        Account account2=createAccount();
//        AccountDAO.insertAccount(account1);
//        AccountDAO.insertAccount(account2);
//        ArrayList<Account> listAccounts=AccountDAO.selectAllAccount();
//        assertEquals(listAccounts.size(), 2);
//        Account accountInDB=AccountDAO.selectAllAccount().get(0);
//        assertEquals(accountInDB.username, account1.username);
//        assertEquals(accountInDB.password, account1.password);
//        assertEquals(accountInDB.role, account1.role);
//        assertEquals(accountInDB.state, account1.state);
//        assertEquals(accountInDB.description, account1.description);
//        accountInDB=AccountDAO.selectAllAccount().get(1);
//        assertEquals(accountInDB.username, account2.username);
//        assertEquals(accountInDB.password, account2.password);
//        assertEquals(accountInDB.role, account2.role);
//        assertEquals(accountInDB.state, account2.state);
//        assertEquals(accountInDB.description, account2.description);
//    }
//
//    @Test
//    public void testSelectAllAccount_EmptyAccount() {
//        ArrayList<Account> listAccounts=AccountDAO.selectAllAccount();
//        assertEquals(listAccounts.size(), 0);
//    }
//
//    public Account createAccount(){
//        String username="buimanhha";
//        String password="Test@12345";
//        int role=0;
//        int state=0;
//        String description="";
//        Account account = new Account(username,password,role,state,description);
//        return account;
//    }
//
//    @Test
//    public void testInsertAccount() {
//        Account account=createAccount();
//        int expResult = 1;
//        int result = AccountDAO.insertAccount(account);
//        assertEquals(expResult, result);
//        Account accountInDB=AccountDAO.selectAllAccount().get(0);
//        assertEquals(accountInDB.username, account.username);
//        assertEquals(accountInDB.password, account.password);
//        assertEquals(accountInDB.role, account.role);
//        assertEquals(accountInDB.state, account.state);
//        assertEquals(accountInDB.description, account.description);
//    }
//
//    @Test
//    public void testUpdateAccount() {
//        Account account=createAccount();
//        int expResult = 1;
//        AccountDAO.insertAccount(account);
//        account=AccountDAO.selectAllAccount().get(0);
//        account.username="usernameupdated";
//        account.password="123";
//        account.role=3;
//        account.state=1;
//        account.description="description";
//        int result = AccountDAO.updateAccount(account);
//        assertEquals(expResult, result);
//        Account accountInDB=AccountDAO.selectAllAccount().get(0);
//        assertEquals(accountInDB.username, account.username);
//        assertEquals(accountInDB.password, account.password);
//        assertEquals(accountInDB.role, account.role);
//        assertEquals(accountInDB.state, account.state);
//        assertEquals(accountInDB.description, account.description);
//    }
//
//    @Test
//    public void testUpdateAccount_WrongId() {
//        Account account=createAccount();
//        AccountDAO.insertAccount(account);
//        account=AccountDAO.selectAllAccount().get(0);
//        account.username="usernameupdated";
//        account.password="123";
//        account.role=3;
//        account.state=1;
//        account.description="description";
//        account.id=-1;
//        int result = AccountDAO.updateAccount(account);
//        assertEquals(0, result);
//    }
//
//    @Test
//    public void testDeleteAccountByID() {
//        Account account=createAccount();
//        AccountDAO.insertAccount(account);
//        account=AccountDAO.selectAllAccount().get(0);
//        int expResult = 1;
//        int result = AccountDAO.deleteAccountByID(account.id);
//        assertEquals(expResult, result);
//        Account accountInDB= AccountDAO.selectAccountByID(account.id);
//        assertEquals(accountInDB, null);
//    }
//
//    @Test
//    public void testDeleteAccountByID_NotInTheDatabase() {
//        int result = AccountDAO.deleteAccountByID(-1);
//        assertEquals(0, result);
//    }
//
//    @Test
//    public void testSelectAccountByID() {
//        Account account=createAccount();
//        AccountDAO.insertAccount(account);
//        account=AccountDAO.selectAllAccount().get(0);
//        Account accountInDB= AccountDAO.selectAccountByID(account.id);
//        assertEquals(accountInDB.username, account.username);
//        assertEquals(accountInDB.password, account.password);
//        assertEquals(accountInDB.role, account.role);
//        assertEquals(accountInDB.state, account.state);
//        assertEquals(accountInDB.description, account.description);
//    }
//
//    @Test
//    public void testSelectAccountByID_NotInTheDatabase() {
//        Account account=createAccount();
//        AccountDAO.insertAccount(account);
//        account=AccountDAO.selectAllAccount().get(0);
//        Account accountInDB= AccountDAO.selectAccountByID(-1);
//        assertEquals(accountInDB, null);
//    }
//}
