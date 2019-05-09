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
import model.Hometown;

/**
 *
 * @author habui
 */
public class HometownDAO {
    public static ArrayList<Hometown> selectAllHometown(){
        ArrayList<Hometown> result = new ArrayList<Hometown>();
        String sql = "SELECT * FROM Hometown";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Hometown hometown = new Hometown();
                hometown.ID=rs.getInt("ID");
                hometown.name=rs.getString("Name");
                hometown.section=rs.getInt("Section");
                result.add(hometown);
            }
        }catch(Exception e){
            e.printStackTrace();
        }    
        return result;
    }
    public static Hometown selectHometownByID(int id){
        Hometown result;
        String sql = "SELECT * FROM Hometown WHERE id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id );
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Hometown hometown = new Hometown();
                hometown.ID=rs.getInt("id");
                hometown.name=rs.getString("name");
                hometown.section=rs.getInt("section");
                result=hometown;
                return result;
            }
        }catch(Exception e){
            e.printStackTrace();
        }    
        return null;
    }
    
     public static int insertHometown(Hometown hometown){
        String sql = "INSERT INTO Hometown(Id,Name,Section) VALUES (?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, hometown.ID);
            ps.setString(2, hometown.name);
            ps.setInt(3, hometown.section);
            int rowCount=ps.executeUpdate();
            return rowCount;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }

}
