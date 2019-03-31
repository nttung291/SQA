/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.Connection.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, contract.companyCode);
            ps.setInt(2, contract.state);
            ps.setString(3, contract.description);
            int rowCount=ps.executeUpdate();
            return rowCount;
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
}
