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
import model.CompulsoryContract;

/**
 *
 * @author habui
 */
public class CompulsoryContractDAO {
    
    public static ArrayList<CompulsoryContract> selectAllCompulsoryContract(){
        ArrayList<CompulsoryContract> result = new ArrayList<CompulsoryContract>();
        String sql = "SELECT * FROM CompulsoryContract";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                CompulsoryContract contract = new CompulsoryContract();
                contract.id=rs.getInt("id");
                contract.companyCode=rs.getString("companyCode");
                contract.state=rs.getInt("state");
                contract.description=rs.getString("Description");
                result.add(contract);
            }
        }catch(Exception e){
            e.printStackTrace();
        }    
        return result;
    }

    public static int insertCompulsoryContract(CompulsoryContract contract){
        String sql = "INSERT INTO CompulsoryContract(CompanyCode,State,Description) VALUES (?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = null;
            
            ps.setString(1, contract.companyCode);
            ps.setInt(2, contract.state);
            ps.setString(3, contract.description);
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
    
    public static CompulsoryContract selectCompulsoryContractByID(int id){
        CompulsoryContract result;
        String sql = "SELECT * FROM CompulsoryContract WHERE id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id );
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                CompulsoryContract contract = new CompulsoryContract();
                contract.id=rs.getInt("id");
                contract.companyCode=rs.getString("CompanyCode");
                contract.state=rs.getInt("state");
                contract.description=rs.getString("description");
                result=contract;
                return result;
            }
        }catch(Exception e){
            e.printStackTrace();
        }    
        return null;
    }
    
      public static int updateCompulsoryContract(CompulsoryContract compulsoryContract){
        String sql = "UPDATE CompulsoryContract SET CompanyCode=?,State=?,Description=? WHERE id=?";
        try{  
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(4, compulsoryContract.id);
            ps.setString(1, compulsoryContract.companyCode);
            ps.setInt(2, compulsoryContract.state);
            ps.setString(3, compulsoryContract.description);
            int rowCount=ps.executeUpdate();
            return rowCount;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
      
     public static int deleteCompulsoryContractByID(CompulsoryContract compulsoryContract) {
        String sql = "DELETE FROM CompulsoryContract Where Id = ?";
        try{  
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, compulsoryContract.id);
            ps.execute();
            return 1;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
