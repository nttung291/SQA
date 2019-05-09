/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.Connection.connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.Account;
import model.CompulsoryContract;
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
public class CompulsoryContractDAOIT {

    public CompulsoryContractDAOIT() {
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
        String sql = "DELETE FROM CompulsoryContract";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            int rowCount=ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private CompulsoryContract createCompulsoryContract(){
        String companyCode="123";
        int state=2;
        String description="description";
        String startedDate="23/4/2019";
        CompulsoryContract compulsoryContract=new CompulsoryContract(companyCode,state,description,startedDate);
        return compulsoryContract;
    }

    @After
    public void tearDown() {
        Connection.rollback();
    }

    @Test
    public void testSelectAllCompulsoryContract() {
        CompulsoryContract contract1=createCompulsoryContract();
        CompulsoryContract contract2=createCompulsoryContract();
        CompulsoryContractDAO.insertCompulsoryContract(contract1);
        CompulsoryContractDAO.insertCompulsoryContract(contract2);
        ArrayList<CompulsoryContract> listContract=CompulsoryContractDAO.selectAllCompulsoryContract();
        assertEquals(listContract.size(), 2);
        CompulsoryContract contractDB=CompulsoryContractDAO.selectAllCompulsoryContract().get(0);
        assertEquals(contract1.companyCode,contractDB.companyCode);
        assertEquals(contract1.description,contractDB.description);
        assertEquals(contract1.startedDate,contractDB.startedDate);
        assertEquals(contract1.state,contractDB.state);
        contractDB=CompulsoryContractDAO.selectAllCompulsoryContract().get(1);
        assertEquals(contract2.companyCode,contractDB.companyCode);
        assertEquals(contract2.description,contractDB.description);
        assertEquals(contract2.startedDate,contractDB.startedDate);
        assertEquals(contract2.state,contractDB.state);
    }
    @Test
    public void testSelectAllCompulsoryContract_EmptyData() {
        ArrayList<CompulsoryContract> listContract=CompulsoryContractDAO.selectAllCompulsoryContract();
        assertEquals(listContract.size(), 0);
    }

    @Test
    public void testInsertCompulsoryContract() {
        CompulsoryContract contract=createCompulsoryContract();
        CompulsoryContractDAO.insertCompulsoryContract(contract);
        CompulsoryContract contractDB=CompulsoryContractDAO.selectAllCompulsoryContract().get(0);
        assertEquals(contract.companyCode,contractDB.companyCode);
        assertEquals(contract.description,contractDB.description);
        assertEquals(contract.startedDate,contractDB.startedDate);
        assertEquals(contract.state,contractDB.state);
    }

    @Test
    public void testSelectCompulsoryContractByID() {
        CompulsoryContract contract=createCompulsoryContract();
        CompulsoryContractDAO.insertCompulsoryContract(contract);
        contract=CompulsoryContractDAO.selectAllCompulsoryContract().get(0);
        CompulsoryContract contractDB=CompulsoryContractDAO.selectCompulsoryContractByID(contract.id);
        assertEquals(contract.companyCode,contractDB.companyCode);
        assertEquals(contract.description,contractDB.description);
        assertEquals(contract.startedDate,contractDB.startedDate);
        assertEquals(contract.state,contractDB.state);
    }

    @Test
    public void testSelectCompulsoryContractByID_NotInTheDatabase() {
        CompulsoryContract contract=createCompulsoryContract();
        CompulsoryContractDAO.insertCompulsoryContract(contract);
        contract=CompulsoryContractDAO.selectAllCompulsoryContract().get(0);
        CompulsoryContract contractDB=CompulsoryContractDAO.selectCompulsoryContractByID(-1);
        assertEquals(null,contractDB);
    }

    @Test
    public void testUpdateCompulsoryContract() {
        CompulsoryContract contract=createCompulsoryContract();
        CompulsoryContractDAO.insertCompulsoryContract(contract);
        contract=CompulsoryContractDAO.selectAllCompulsoryContract().get(0);
        contract.companyCode="234";
        contract.description="description";;
        contract.startedDate="23/4/2019";
        contract.state=1;
        int result=CompulsoryContractDAO.updateCompulsoryContract(contract);
        assertEquals(1,result);
        CompulsoryContract contractUpdated=CompulsoryContractDAO.selectCompulsoryContractByID(contract.id);
        assertEquals(contract.companyCode,contractUpdated.companyCode);
        assertEquals(contract.description,contractUpdated.description);
        assertEquals(contract.startedDate,contractUpdated.startedDate);
        assertEquals(contract.state,contractUpdated.state);
        assertEquals(contract.id,contractUpdated.id);
    }

    @Test
    public void testUpdateCompulsoryContract_WrongID() {
        CompulsoryContract contract=createCompulsoryContract();
        CompulsoryContractDAO.insertCompulsoryContract(contract);
        contract=CompulsoryContractDAO.selectAllCompulsoryContract().get(0);
        contract.companyCode="234";
        contract.description="description";;
        contract.startedDate="23/4/2019";
        contract.state=1;
        contract.id=-1;
        int result=CompulsoryContractDAO.updateCompulsoryContract(contract);
        assertEquals(0,result);
    }
    @Test
    public void testDeleteCompulsoryContractByID() {
        CompulsoryContract contract=createCompulsoryContract();
        CompulsoryContractDAO.insertCompulsoryContract(contract);
        contract=CompulsoryContractDAO.selectAllCompulsoryContract().get(0);
        int result =CompulsoryContractDAO.deleteCompulsoryContractByID(contract.id);
        assertEquals(1,result);
        contract=CompulsoryContractDAO.selectCompulsoryContractByID(contract.id);
        assertEquals(null,contract);
    }
    @Test
    public void testDeleteCompulsoryContractByID_NotInDatabase() {
        int result = CompulsoryContractDAO.deleteCompulsoryContractByID(-1);
        assertEquals(0, result);
    }

}
