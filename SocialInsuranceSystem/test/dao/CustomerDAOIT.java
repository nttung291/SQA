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
//import model.CompulsoryContract;
//import model.Customer;
//import model.Hometown;
//import model.VoluntaryContract;
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
//public class CustomerDAOIT {
//
//    public CustomerDAOIT() {
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
//        String sql = "DELETE FROM Customer";
//        try{
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.executeUpdate();
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
//    private Customer createCustomer(){
//        Account account=new Account("habui","Test@1234",1,1,"");
//        AccountDAO.insertAccount(account);
//        account=AccountDAO.selectAllAccount().get(0);
//        CompulsoryContract compulsoryContract=new CompulsoryContract("10", 0, "", "23/5/2019");
//        CompulsoryContractDAO.insertCompulsoryContract(compulsoryContract);
//        compulsoryContract=CompulsoryContractDAO.selectAllCompulsoryContract().get(0);
//        VoluntaryContract voluntaryContract=new VoluntaryContract(0, "", "23/5/2019");
//        VoluntaryContractDAO.insertVoluntaryContract(voluntaryContract);
//        voluntaryContract=VoluntaryContractDAO.selectAllVoluntaryContract().get(0);
//        Hometown hometown=new Hometown(1, "Yen Bai", 0);
//        HometownDAO.insertHometown(hometown);
//        hometown=HometownDAO.selectAllHometown().get(0);
//        return new Customer(account,
//                compulsoryContract,
//                voluntaryContract, hometown,
//                "Bui Manh Ha", true, "17/12/1997", "061092688", "20233421", "hb.buimanhha@gmail",
//                "0858171297", 0, "111", 5000);
//    }
//
//    @Test
//    public void testSelectAllCustomer() {
//        Customer customer1=createCustomer();
//        Customer customer2=createCustomer();
//        CustomerDAO.inserCompulsoryCustomer(customer1);
//        CustomerDAO.inserCompulsoryCustomer(customer2);
//        ArrayList<Customer> listCustomer=CustomerDAO.selectAllCustomer();
//        assertEquals(2, listCustomer.size());
//        Customer customerDB=CustomerDAO.selectAllCustomer().get(0);
//        assertEquals(customer1.dob,customerDB.dob);
//        assertEquals(customer1.email,customerDB.email);
//        assertEquals(customer1.idNumber,customerDB.idNumber);
//        assertEquals(customer1.paymentDuration,customerDB.paymentDuration);
//        assertEquals(String.valueOf(customer1.salary),String.valueOf(customerDB.salary));
//        assertEquals(customer1.phoneNo,customerDB.phoneNo);
//        assertEquals(customer1.taxCode,customerDB.taxCode);
//        assertEquals(customer1.account.id,customerDB.account.id);
//        assertEquals(customer1.account.username,customerDB.account.username);
//        assertEquals(customer1.account.state,customerDB.account.state);
//        assertEquals(customer1.account.password,customerDB.account.password);
//        assertEquals(customer1.account.role,customerDB.account.role);
//        assertEquals(customer1.hometown.ID,customerDB.hometown.ID);
//        assertEquals(customer1.hometown.name,customerDB.hometown.name);
//        assertEquals(customer1.hometown.section,customerDB.hometown.section);
//        assertEquals(customer1.compulsoryContract.id,customerDB.compulsoryContract.id);
//        assertEquals(customer1.compulsoryContract.companyCode,customerDB.compulsoryContract.companyCode);
//        assertEquals(customer1.compulsoryContract.description,customerDB.compulsoryContract.description);
//        assertEquals(customer1.compulsoryContract.startedDate,customerDB.compulsoryContract.startedDate);
//        assertEquals(customer1.compulsoryContract.state,customerDB.compulsoryContract.state);
//        customerDB=CustomerDAO.selectAllCustomer().get(1);
//        assertEquals(customer2.dob,customerDB.dob);
//        assertEquals(customer2.email,customerDB.email);
//        assertEquals(customer2.idNumber,customerDB.idNumber);
//        assertEquals(customer2.paymentDuration,customerDB.paymentDuration);
//        assertEquals(String.valueOf(customer2.salary),String.valueOf(customerDB.salary));
//        assertEquals(customer2.phoneNo,customerDB.phoneNo);
//        assertEquals(customer2.taxCode,customerDB.taxCode);
//        assertEquals(customer2.account.id,customerDB.account.id);
//        assertEquals(customer2.account.username,customerDB.account.username);
//        assertEquals(customer2.account.state,customerDB.account.state);
//        assertEquals(customer2.account.password,customerDB.account.password);
//        assertEquals(customer2.account.role,customerDB.account.role);
//        assertEquals(customer2.hometown.ID,customerDB.hometown.ID);
//        assertEquals(customer2.hometown.name,customerDB.hometown.name);
//        assertEquals(customer2.hometown.section,customerDB.hometown.section);
//        assertEquals(customer2.compulsoryContract.id,customerDB.compulsoryContract.id);
//        assertEquals(customer2.compulsoryContract.companyCode,customerDB.compulsoryContract.companyCode);
//        assertEquals(customer2.compulsoryContract.description,customerDB.compulsoryContract.description);
//        assertEquals(customer2.compulsoryContract.startedDate,customerDB.compulsoryContract.startedDate);
//        assertEquals(customer2.compulsoryContract.state,customerDB.compulsoryContract.state);
//    }
//    @Test
//    public void testSelectAllCustomer_EmptyCustomer() {
//        ArrayList<Customer> listCustomer=CustomerDAO.selectAllCustomer();
//        assertEquals(listCustomer.size(), 0);
//    }
//
//    @Test
//    public void testUpdateCompulsoryCustomer() {
//        Customer customer=createCustomer();
//        CustomerDAO.inserCompulsoryCustomer(customer);
//        customer=CustomerDAO.selectAllCustomer().get(0);
//        customer.dob="12/23/2018";
//        customer.email="emagil@gmail.com";
//        customer.idNumber="12323";
//        customer.name="Test";
//        customer.paymentDuration=2;
//        customer.phoneNo="12323";
//        customer.salary=1232;
//        customer.sex=false;
//        customer.socialInsuranceNo="1111111";
//        customer.taxCode="123232";
//        CompulsoryContract contract2=new CompulsoryContract("111", 0, "11", "23/4/2013");
//        CompulsoryContractDAO.insertCompulsoryContract(contract2);
//        contract2=CompulsoryContractDAO.selectAllCompulsoryContract().get(1);
//        customer.compulsoryContract=contract2;
//        int result=CustomerDAO.updateCompulsoryCustomer(customer);
//        assertEquals(1, result);
//        Customer customerDB=CustomerDAO.selectAllCustomer().get(0);
//        assertEquals(customer.dob, customerDB.dob);
//        assertEquals(customer.email, customerDB.email);
//        assertEquals(customer.idNumber, customerDB.idNumber);
//        assertEquals(customer.name, customerDB.name);
//        assertEquals(customer.paymentDuration, customerDB.paymentDuration);
//        assertEquals(customer.phoneNo, customerDB.phoneNo);
//        assertEquals(String.valueOf(customer.salary), String.valueOf(customer.salary));
//        assertEquals(customer.sex, customerDB.sex);
//        assertEquals(customer.socialInsuranceNo, customerDB.socialInsuranceNo);
//        assertEquals(customer.taxCode, customerDB.taxCode);
//    }
//
//    @Test
//    public void testUpdateCompulsoryCustomer_WrongID() {
//        Customer customer=createCustomer();
//        CustomerDAO.inserCompulsoryCustomer(customer);
//        customer=CustomerDAO.selectAllCustomer().get(0);
//        customer.dob="12/23/2018";
//        customer.email="emagil@gmail.com";
//        customer.idNumber="12323";
//        customer.name="Test";
//        customer.paymentDuration=2;
//        customer.phoneNo="12323";
//        customer.salary=1232;
//        customer.sex=false;
//        customer.socialInsuranceNo="1111111";
//        customer.taxCode="123232";
//        customer.id=-1;
//        CompulsoryContract contract2=new CompulsoryContract("111", 0, "11", "23/4/2013");
//        CompulsoryContractDAO.insertCompulsoryContract(contract2);
//        contract2=CompulsoryContractDAO.selectAllCompulsoryContract().get(1);
//        customer.compulsoryContract=contract2;
//        int result=CustomerDAO.updateCompulsoryCustomer(customer);
//        assertEquals(0, result);
//    }
//
//    @Test
//    public void testUpdateVoluntaryCustomer() {
//        Customer customer=createCustomer();
//        CustomerDAO.inserVoluntaryCustomer(customer);
//        customer=CustomerDAO.selectAllCustomer().get(0);
//        customer.dob="12/23/2018";
//        customer.email="emagil@gmail.com";
//        customer.idNumber="12323";
//        customer.name="Test";
//        customer.paymentDuration=2;
//        customer.phoneNo="12323";
//        customer.salary=1232;
//        customer.sex=false;
//        customer.socialInsuranceNo="1111111";
//        customer.taxCode="123232";
//        VoluntaryContract contract2=new VoluntaryContract( 0, "11", "23/4/2013");
//        VoluntaryContractDAO.insertVoluntaryContract(contract2);
//        contract2=VoluntaryContractDAO.selectAllVoluntaryContract().get(1);
//        customer.voluntaryContract=contract2;
//        int result=CustomerDAO.updateVoluntaryCustomer(customer);
//        assertEquals(1, result);
//        Customer customerDB=CustomerDAO.selectAllCustomer().get(0);
//        assertEquals(customer.dob, customerDB.dob);
//        assertEquals(customer.email, customerDB.email);
//        assertEquals(customer.idNumber, customerDB.idNumber);
//        assertEquals(customer.name, customerDB.name);
//        assertEquals(customer.paymentDuration, customerDB.paymentDuration);
//        assertEquals(customer.phoneNo, customerDB.phoneNo);
//        assertEquals(String.valueOf(customer.salary), String.valueOf(customer.salary));
//        assertEquals(customer.sex, customerDB.sex);
//        assertEquals(customer.socialInsuranceNo, customerDB.socialInsuranceNo);
//        assertEquals(customer.taxCode, customerDB.taxCode);
//    }
//
//    @Test
//    public void testUpdateVoluntaryCustomer_WrongID() {
//        Customer customer=createCustomer();
//        CustomerDAO.inserVoluntaryCustomer(customer);
//        customer=CustomerDAO.selectAllCustomer().get(0);
//        customer.dob="12/23/2018";
//        customer.email="emagil@gmail.com";
//        customer.idNumber="12323";
//        customer.name="Test";
//        customer.paymentDuration=2;
//        customer.phoneNo="12323";
//        customer.salary=1232;
//        customer.sex=false;
//        customer.socialInsuranceNo="1111111";
//        customer.taxCode="123232";
//        customer.id=-1;
//        VoluntaryContract contract2=new VoluntaryContract(0, "11", "23/4/2013");
//        VoluntaryContractDAO.insertVoluntaryContract(contract2);
//        contract2=VoluntaryContractDAO.selectAllVoluntaryContract().get(1);
//        customer.voluntaryContract=contract2;
//        int result=CustomerDAO.updateVoluntaryCustomer(customer);
//        assertEquals(0, result);
//    }
//    @Test
//    public void testInsertCompulsoryCustomer() {
//        Customer customer=createCustomer();
//        int result = CustomerDAO.inserCompulsoryCustomer(customer);
//        assertEquals(1, result);
//        Customer customerDB=CustomerDAO.selectAllCustomer().get(0);
//        assertEquals(customer.dob,customerDB.dob);
//        assertEquals(customer.email,customerDB.email);
//        assertEquals(customer.idNumber,customerDB.idNumber);
//        assertEquals(customer.paymentDuration,customerDB.paymentDuration);
//        assertEquals(String.valueOf(customer.salary),String.valueOf(customerDB.salary));
//        assertEquals(customer.phoneNo,customerDB.phoneNo);
//        assertEquals(customer.taxCode,customerDB.taxCode);
//        assertEquals(customer.account.id,customerDB.account.id);
//        assertEquals(customer.account.username,customerDB.account.username);
//        assertEquals(customer.account.state,customerDB.account.state);
//        assertEquals(customer.account.password,customerDB.account.password);
//        assertEquals(customer.account.role,customerDB.account.role);
//        assertEquals(customer.hometown.ID,customerDB.hometown.ID);
//        assertEquals(customer.hometown.name,customerDB.hometown.name);
//        assertEquals(customer.hometown.section,customerDB.hometown.section);
//        assertEquals(customer.compulsoryContract.id,customerDB.compulsoryContract.id);
//        assertEquals(customer.compulsoryContract.companyCode,customerDB.compulsoryContract.companyCode);
//        assertEquals(customer.compulsoryContract.description,customerDB.compulsoryContract.description);
//        assertEquals(customer.compulsoryContract.startedDate,customerDB.compulsoryContract.startedDate);
//        assertEquals(customer.compulsoryContract.state,customerDB.compulsoryContract.state);
//    }
//
//    @Test
//    public void testInserVoluntaryCustomer() {
//        Customer customer=createCustomer();
//        int result = CustomerDAO.inserVoluntaryCustomer(customer);
//        assertEquals(1, result);
//        Customer customerDB=CustomerDAO.selectAllCustomer().get(0);
//        assertEquals(customer.dob,customerDB.dob);
//        assertEquals(customer.email,customerDB.email);
//        assertEquals(customer.idNumber,customerDB.idNumber);
//        assertEquals(customer.paymentDuration,customerDB.paymentDuration);
//        assertEquals(String.valueOf(customer.salary),String.valueOf(customerDB.salary));
//        assertEquals(customer.phoneNo,customerDB.phoneNo);
//        assertEquals(customer.taxCode,customerDB.taxCode);
//        assertEquals(customer.account.id,customerDB.account.id);
//        assertEquals(customer.account.username,customerDB.account.username);
//        assertEquals(customer.account.state,customerDB.account.state);
//        assertEquals(customer.account.password,customerDB.account.password);
//        assertEquals(customer.account.role,customerDB.account.role);
//        assertEquals(customer.hometown.ID,customerDB.hometown.ID);
//        assertEquals(customer.hometown.name,customerDB.hometown.name);
//        assertEquals(customer.hometown.section,customerDB.hometown.section);
//        assertEquals(customer.voluntaryContract.id,customerDB.voluntaryContract.id);
//        assertEquals(customer.voluntaryContract.description,customerDB.voluntaryContract.description);
//        assertEquals(customer.voluntaryContract.startedDate,customerDB.voluntaryContract.startedDate);
//        assertEquals(customer.voluntaryContract.state,customerDB.voluntaryContract.state);
//    }
//
//    @Test
//    public void testDeleteCustomerByID() {
//        Customer customer=createCustomer();;
//        CustomerDAO.inserCompulsoryCustomer(customer);
//        customer=CustomerDAO.selectAllCustomer().get(0);
//        int result = CustomerDAO.deleteCustomerByID(customer.id);
//        assertEquals(1, result);
//        ArrayList<Customer> listCustomer= CustomerDAO.selectAllCustomer();
//        assertEquals(0, listCustomer.size());
//    }
//
//    @Test
//    public void testDeleteCustomerByID_NotInTheDatabase() {
//        Customer customer=createCustomer();;
//        CustomerDAO.inserCompulsoryCustomer(customer);
//        customer=CustomerDAO.selectAllCustomer().get(0);
//        int result = CustomerDAO.deleteCustomerByID(-1);
//        assertEquals(0, result);
//        ArrayList<Customer> listCustomer= CustomerDAO.selectAllCustomer();
//        assertEquals(1, listCustomer.size());
//    }
//
//}
