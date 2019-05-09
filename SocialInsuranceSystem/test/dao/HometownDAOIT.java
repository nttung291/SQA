/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.Connection.connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.Hometown;
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
public class HometownDAOIT {
    
    public HometownDAOIT() {
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
        String sql = "DELETE FROM Hometown";
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
    public void testSelectAllHometown() {
        Hometown hometown1=new Hometown(1, "Boston", 1);
        Hometown hometown2=new Hometown(2, "Yen Bai",2);
        HometownDAO.insertHometown(hometown1);
        HometownDAO.insertHometown(hometown2);
        ArrayList<Hometown> listHometown = HometownDAO.selectAllHometown();
        assertEquals(listHometown.size(), 2);
        Hometown hometownInDB=HometownDAO.selectHometownByID(1);
        assertEquals(hometownInDB.ID, hometown1.ID);
        assertEquals(hometownInDB.name, hometown1.name);
        assertEquals(hometownInDB.section, hometown1.section);
        hometownInDB=HometownDAO.selectHometownByID(2);
        assertEquals(hometownInDB.ID, hometown2.ID);
        assertEquals(hometownInDB.name, hometown2.name);
        assertEquals(hometownInDB.section, hometown2.section);
    }
    @Test
    public void testSelectAllHometown_EmptyHometown() {
        ArrayList<Hometown> listHometown = HometownDAO.selectAllHometown();
        assertEquals(listHometown.size(), 0);
    }

    @Test
    public void testSelectHometownByID() {
       Hometown hometown=new Hometown(1, "Boston", 1);
       HometownDAO.insertHometown(hometown);
       Hometown hometownDB=HometownDAO.selectHometownByID(hometown.ID);
       assertEquals(hometown.ID, hometownDB.ID);
       assertEquals(hometown.name, hometownDB.name);
       assertEquals(hometown.section, hometownDB.section);
    }
    @Test
    public void testSelectHometownByID_NotInDatabase() {
       Hometown hometownDB=HometownDAO.selectHometownByID(-1);
       assertEquals(null, hometownDB);
    }

    @Test
    public void testInsertHometown() {
       Hometown hometown=new Hometown(1, "Boston", 1);
       HometownDAO.insertHometown(hometown);
       Hometown hometownDB=HometownDAO.selectHometownByID(hometown.ID);
       assertEquals(hometown.ID, hometownDB.ID);
       assertEquals(hometown.name, hometownDB.name);
       assertEquals(hometown.section, hometownDB.section);
    }
    
}
