/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author habui
 */
public class AccountDAO extends Connection{
    
    public static ArrayList<Account> selectAllAccount(){
        ArrayList<Account> result = new ArrayList<Account>();
        String sql = "SELECT * FROM Account";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Account account = new Account();
                account.id=rs.getInt("id");
                account.username=rs.getString("username");
                account.password=rs.getString("password");
                account.role=rs.getInt("role");
                account.state=rs.getInt("state");
                account.description=rs.getString("description");
                result.add(account);
            }
        }catch(Exception e){
            e.printStackTrace();
        }    
        return result;
    }

    public static int insertAccount(Account account){
        String sql = "INSERT INTO Account(Username,Password,Role, State, Description) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account.username);
            ps.setString(2, account.password);
            ps.setInt(3, account.role);
            ps.setInt(4, account.state);
            ps.setString(5, account.description);
            int rowCount=ps.executeUpdate();
            return rowCount;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    
    public static int updateAccount(Account account){
        String sql = "UPDATE Account SET Username=?,Password=?,Role=?,State=?,Description=? WHERE id=?";
        try{  
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(6, account.id);
            ps.setString(1, account.username);
            ps.setString(2, account.password);
            ps.setInt(3, account.role);
            ps.setInt(4, account.state);
            ps.setString(5,account.description);
            int rowCount=ps.executeUpdate();
            return rowCount;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    
    public static int deleteAccountByID(int id) {
        String sql = "DELETE FROM Account Where Id = ?";
        try{  
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int rowCount=ps.executeUpdate();
            return rowCount;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    
    public static Account selectAccountByID(int id){
        Account result;
        String sql = "SELECT * FROM Account WHERE id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id );
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Account account = new Account();
                account.id=rs.getInt("id");
                account.username=rs.getString("username");
                account.password=rs.getString("password");
                account.role=rs.getInt("role");
                account.state=rs.getInt("state");
                account.description=rs.getString("description");
                result=account;
                return result;
            }
        }catch(Exception e){
            e.printStackTrace();
        }    
        return null;
    }
    
}
