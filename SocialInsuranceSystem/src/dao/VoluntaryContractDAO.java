/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.Connection.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.VoluntaryContract;

/**
 *
 * @author habui
 */
public class VoluntaryContractDAO {
     public static ArrayList<VoluntaryContract> selectAllVoluntaryContract(){
        ArrayList<VoluntaryContract> result = new ArrayList<VoluntaryContract>();
        String sql = "SELECT * FROM VoluntaryContract";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                VoluntaryContract contract = new VoluntaryContract();
                contract.id=rs.getInt("id");
                contract.state=rs.getInt("state");
                contract.description=rs.getString("Description");
                contract.startedDate=rs.getString("StartedDate");
                result.add(contract);
            }
        }catch(Exception e){
            e.printStackTrace();
        }    
        return result;
    }

    public static int insertVoluntaryContract(VoluntaryContract contract){
        String sql = "INSERT INTO VoluntaryContract(state,Description,StartedDate) VALUES (?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = null;
            ps.setInt(1, contract.state);
            ps.setString(2, contract.description);
            ps.setString(3, contract.startedDate);
            int rowCount=ps.executeUpdate();
            int candidateId = 0;
            if(rowCount == 1)
            {
                // get candidate id
                rs = ps.getGeneratedKeys();
                if(rs.next())
                    candidateId = rs.getInt(1);
 
            }
            return candidateId;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    
    public static VoluntaryContract selectVoluntaryContractByID(int id){
        VoluntaryContract result;
        String sql = "SELECT * FROM VoluntaryContract WHERE id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id );
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                VoluntaryContract contract = new VoluntaryContract();
                contract.id=rs.getInt("id");
                contract.state=rs.getInt("state");
                contract.description=rs.getString("description");
                contract.startedDate=rs.getString("StartedDate");
                result=contract;
                return result;
            }
        }catch(Exception e){
            e.printStackTrace();
        }    
        return null;
    }
    
    public static int updateVoluntaryContract(VoluntaryContract voluntaryContract){
        String sql = "UPDATE VoluntaryContract SET State=?,Description=?,StartedDate=? WHERE id=?";
        try{  
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(4, voluntaryContract.id);
            ps.setInt(1, voluntaryContract.state);
            ps.setString(2, voluntaryContract.description);
            ps.setString(3, voluntaryContract.startedDate);
            int rowCount=ps.executeUpdate();
            return rowCount;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    
      public static int deleteVoluntaryContractByID(int id) {
        String sql = "DELETE FROM VoluntaryContract WHERE id = ?";
        try{  
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            int result=ps.executeUpdate();
            return result;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
