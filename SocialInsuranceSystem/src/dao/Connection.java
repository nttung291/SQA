/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author habui
 */
public class Connection {
    protected static java.sql.Connection connection;

    public static void createConnection(){
//        if(connection == null){
//            
//            String dbUrl = "jdbc:mysql://localhost:8889/SQA";
//            String dbClass = "com.mysql.jdbc.Driver";
//
//            try {
//                Class.forName(dbClass);
//                connection = DriverManager.getConnection (dbUrl, "root", "root");
//            }catch(Exception e) {
//                e.printStackTrace();
//            }
//        }
        if(connection == null){
//            String dbUrl = "jdbc:mysql://localhost:8889/SocialInsuranceDB";
            String dbUrl = "jdbc:mysql://localhost:3306/SocialInsuranceDB";
            String dbClass = "com.mysql.jdbc.Driver";

            try {
                Class.forName(dbClass);
                connection = DriverManager.getConnection (dbUrl, "root", "");
//                connection = DriverManager.getConnection (dbUrl, "root", "root");
            }catch(Exception e) {
                e.printStackTrace();
                int result = JOptionPane.showConfirmDialog(null, "No Internet", "Message", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
