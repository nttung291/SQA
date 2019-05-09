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
import model.Account;
import model.Customer;

/**
 *
 * @author habui
 */
public class CustomerDAO {
     public static ArrayList<Customer> selectAllCustomer(){
        ArrayList<Customer> result = new ArrayList<Customer>();
        String sql = "SELECT * FROM Customer";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Customer customer = new Customer();
                customer.id=rs.getInt("id");
                customer.account=AccountDAO.selectAccountByID(rs.getInt("AccountId"));
                customer.name=rs.getString("name");
                customer.hometown=HometownDAO.selectHometownByID(rs.getInt("HometownId"));
                customer.sex=rs.getBoolean("sex");
                customer.dob=rs.getString("Dob");
                customer.idNumber=rs.getString("IdNumber");
                customer.socialInsuranceNo=rs.getString("SocialInsuranceNo");
                customer.email=rs.getString("Email");
                customer.phoneNo=rs.getString("PhoneNo");
                customer.paymentDuration=rs.getInt("PaymentDuration");
                customer.taxCode=rs.getString("TaxCode");
                customer.salary=rs.getFloat("Salary");
                customer.compulsoryContract=CompulsoryContractDAO.selectCompulsoryContractByID(rs.getInt("CompulsoryContractId"));
                customer.voluntaryContract=VoluntaryContractDAO.selectVoluntaryContractByID(rs.getInt("VoluntaryContractId"));
                result.add(customer);
            }
        }catch(Exception e){
            e.printStackTrace();
        }    
        return result;
    }
     
    public static int updateCompulsoryCustomer(Customer customer){
        String sql = "UPDATE Customer SET HometownId=?,AccountId=?,Name=?,Sex=?,Dob=?,"
                + "IdNumber=?,SocialInsuranceNo=?,Email=?,PhoneNo=?,PaymentDuration=?,"
                + "TaxCode=?,Salary=?,CompulsoryContractId=? WHERE id=?" ;
        try{  
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customer.hometown.ID);
            ps.setInt(2, customer.account.id);
            ps.setString(3, customer.name);
            ps.setBoolean(4, customer.sex);
            ps.setString(5, customer.dob);
            ps.setString(6,customer.idNumber);
            ps.setString(7,customer.socialInsuranceNo);
            ps.setString(8,customer.email);
            ps.setString(9,customer.phoneNo);
            ps.setInt(10,customer.paymentDuration);
            ps.setString(11, customer.taxCode);
            ps.setFloat(12, customer.salary);
            ps.setInt(13, customer.compulsoryContract.id);
            ps.setInt(14, customer.id);
            ps.executeUpdate();
            return 1;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    
     public static int updateVoluntaryCustomer(Customer customer){
        String sql = "UPDATE Customer SET HometownId=?,AccountId=?,Name=?,Sex=?,Dob=?,"
                + "IdNumber=?,SocialInsuranceNo=?,Email=?,PhoneNo=?,PaymentDuration=?,"
                + "TaxCode=?,Salary=?,VoluntaryContractId=? WHERE id=?" ;
        try{  
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customer.hometown.ID);
            ps.setInt(2, customer.account.id);
            ps.setString(3, customer.name);
            ps.setBoolean(4, customer.sex);
            ps.setString(5, customer.dob);
            ps.setString(6,customer.idNumber);
            ps.setString(7,customer.socialInsuranceNo);
            ps.setString(8,customer.email);
            ps.setString(9,customer.phoneNo);
            ps.setInt(10,customer.paymentDuration);
            ps.setString(11, customer.taxCode);
            ps.setFloat(12, customer.salary);
            ps.setInt(13, customer.voluntaryContract.id);
            ps.setInt(14, customer.id);
            ps.executeUpdate();
            return 1;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    

    public static int insertCustomer(Customer customer){
        String sql = "INSERT INTO Customer(HometownId,VoluntaryContractId, CompulsoryContractId, AccountId,Name, Sex, Dob,IdNumber,SocialInsuranceNo"
                + ",Email,PhoneNo,PaymentDuration,TaxCode,Salary) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customer.hometown.ID);
            ps.setInt(13, customer.voluntaryContract.id);
            ps.setInt(14, customer.compulsoryContract.id);
            ps.setInt(2, customer.account.id);
            ps.setString(3, customer.name);
            ps.setBoolean(4, customer.sex);
            ps.setString(5, customer.dob);
            ps.setString(6, customer.idNumber);
            ps.setString(7, customer.socialInsuranceNo);
            ps.setString(8, customer.email);
            ps.setString(9, customer.phoneNo);
            ps.setInt(10, customer.paymentDuration);
            ps.setString(11, customer.taxCode);
            ps.setFloat(12, customer.salary);
            int rowCount=ps.executeUpdate();
            return rowCount;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    
    public static int inserCompulsoryCustomer(Customer customer){
        String sql = "INSERT INTO Customer(HometownId,AccountId,Name, Sex, Dob,IdNumber,SocialInsuranceNo ,Email,PhoneNo,PaymentDuration,TaxCode,Salary,CompulsoryContractId) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customer.hometown.ID);
            ps.setInt(2, customer.account.id);
            ps.setString(3, customer.name);
            ps.setBoolean(4, customer.sex);
            ps.setString(5, customer.dob);
            ps.setString(6, customer.idNumber);
            ps.setString(7, customer.socialInsuranceNo);
            ps.setString(8, customer.email);
            ps.setString(9, customer.phoneNo);
            ps.setInt(10, customer.paymentDuration);
            ps.setString(11, customer.taxCode);
            ps.setFloat(12, customer.salary);
            ps.setInt(13, customer.compulsoryContract.id);
            int rowCount=ps.executeUpdate();
            return rowCount;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    
    public static int inserVoluntaryCustomer(Customer customer){
        String sql = "INSERT INTO Customer(HometownId,AccountId,Name, Sex, Dob,IdNumber,SocialInsuranceNo ,Email,PhoneNo,PaymentDuration,TaxCode,Salary,VoluntaryContractId) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customer.hometown.ID);
            ps.setInt(2, customer.account.id);
            ps.setString(3, customer.name);
            ps.setBoolean(4, customer.sex);
            ps.setString(5, customer.dob);
            ps.setString(6, customer.idNumber);
            ps.setString(7, customer.socialInsuranceNo);
            ps.setString(8, customer.email);
            ps.setString(9, customer.phoneNo);
            ps.setInt(10, customer.paymentDuration);
            ps.setString(11, customer.taxCode);
            ps.setFloat(12, customer.salary);
            ps.setInt(13, customer.voluntaryContract.id);
            int rowCount=ps.executeUpdate();
            return rowCount;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    
      public static int deleteCustomerByID(Customer customer) {
        String sql = "DELETE FROM Customer Where Id = ?";
        try{  
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customer.id);
            ps.execute();
            return 1;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
