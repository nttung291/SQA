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
//public class VoluntaryContractDAOIT {
//
//    public VoluntaryContractDAOIT() {
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
//        String sql = "DELETE FROM VoluntaryContract";
//        try{
//            PreparedStatement ps = connection.prepareStatement(sql);
//            int rowCount=ps.executeUpdate();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    private VoluntaryContract createVoluntaryContract(){
//        int state=2;
//        String description="description";
//        String startedDate="23/4/2019";
//        VoluntaryContract voluntaryContract=new VoluntaryContract(state,description,startedDate);
//        return voluntaryContract;
//    }
//
//    @After
//    public void tearDown() {
//        Connection.rollback();
//    }
//
//    @Test
//    public void testSelectAllVoluntaryContract() {
//        VoluntaryContract contract1=createVoluntaryContract();
//        VoluntaryContract contract2=createVoluntaryContract();
//        VoluntaryContractDAO.insertVoluntaryContract(contract1);
//        VoluntaryContractDAO.insertVoluntaryContract(contract2);
//        ArrayList<VoluntaryContract> listContract=VoluntaryContractDAO.selectAllVoluntaryContract();
//        assertEquals(listContract.size(), 2);
//        VoluntaryContract contractDB=VoluntaryContractDAO.selectAllVoluntaryContract().get(0);
//        assertEquals(contract1.description,contractDB.description);
//        assertEquals(contract1.startedDate,contractDB.startedDate);
//        assertEquals(contract1.state,contractDB.state);
//        contractDB=VoluntaryContractDAO.selectAllVoluntaryContract().get(1);
//        assertEquals(contract2.description,contractDB.description);
//        assertEquals(contract2.startedDate,contractDB.startedDate);
//        assertEquals(contract2.state,contractDB.state);
//    }
//
//    @Test
//    public void testSelectAllVoluntaryContract_EmptyData() {
//        ArrayList<VoluntaryContract> listContract=VoluntaryContractDAO.selectAllVoluntaryContract();
//        assertEquals(listContract.size(), 0);
//    }
//
//    @Test
//    public void testInsertVoluntaryContract() {
//        VoluntaryContract contract=createVoluntaryContract();
//        VoluntaryContractDAO.insertVoluntaryContract(contract);
//        VoluntaryContract contractDB=VoluntaryContractDAO.selectAllVoluntaryContract().get(0);
//        assertEquals(contract.description,contractDB.description);
//        assertEquals(contract.startedDate,contractDB.startedDate);
//        assertEquals(contract.state,contractDB.state);
//    }
//
//    @Test
//    public void testSelectVoluntaryContractByID() {
//        VoluntaryContract contract=createVoluntaryContract();
//        VoluntaryContractDAO.insertVoluntaryContract(contract);
//        contract=VoluntaryContractDAO.selectAllVoluntaryContract().get(0);
//        VoluntaryContract contractDB=VoluntaryContractDAO.selectVoluntaryContractByID(contract.id);
//        assertEquals(contract.description,contractDB.description);
//        assertEquals(contract.startedDate,contractDB.startedDate);
//        assertEquals(contract.state,contractDB.state);
//    }
//
//    @Test
//    public void testSelectVoluntaryContractByID_NotInTheDatabase() {
//        VoluntaryContract contract=createVoluntaryContract();
//        VoluntaryContractDAO.insertVoluntaryContract(contract);
//        contract=VoluntaryContractDAO.selectAllVoluntaryContract().get(0);
//        VoluntaryContract contractDB=VoluntaryContractDAO.selectVoluntaryContractByID(-1);
//        assertEquals(null,contractDB);
//    }
//
//    @Test
//    public void testUpdateVoluntaryContract() {
//        VoluntaryContract contract=createVoluntaryContract();
//        VoluntaryContractDAO.insertVoluntaryContract(contract);
//        contract=VoluntaryContractDAO.selectAllVoluntaryContract().get(0);
//        contract.description="description";;
//        contract.startedDate="23/4/2019";
//        contract.state=1;
//        int result=VoluntaryContractDAO.updateVoluntaryContract(contract);
//        assertEquals(1,result);
//        VoluntaryContract contractUpdated=VoluntaryContractDAO.selectVoluntaryContractByID(contract.id);
//        assertEquals(contract.description,contractUpdated.description);
//        assertEquals(contract.startedDate,contractUpdated.startedDate);
//        assertEquals(contract.state,contractUpdated.state);
//        assertEquals(contract.id,contractUpdated.id);
//    }
//    @Test
//    public void testUpdateVoluntaryContract_WrongID() {
//        VoluntaryContract contract=createVoluntaryContract();
//        VoluntaryContractDAO.insertVoluntaryContract(contract);
//        contract=VoluntaryContractDAO.selectAllVoluntaryContract().get(0);
//        contract.description="description";;
//        contract.startedDate="23/4/2019";
//        contract.state=1;
//        contract.id=-1;
//        int result=VoluntaryContractDAO.updateVoluntaryContract(contract);
//        assertEquals(0,result);
//    }
//    @Test
//    public void testDeleteVoluntaryContractByID() {
//        VoluntaryContract contract=createVoluntaryContract();
//        VoluntaryContractDAO.insertVoluntaryContract(contract);
//        contract=VoluntaryContractDAO.selectAllVoluntaryContract().get(0);
//        int result =VoluntaryContractDAO.deleteVoluntaryContractByID(contract.id);
//        assertEquals(1,result);
//        contract=VoluntaryContractDAO.selectVoluntaryContractByID(contract.id);
//        assertEquals(null,contract);
//    }
//    @Test
//    public void testDeleteCompulsoryContractByID_NotInDatabase() {
//        int result = VoluntaryContractDAO.deleteVoluntaryContractByID(-1);
//        assertEquals(0, result);
//    }
//
//}
