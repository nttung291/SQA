/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dao.Connection;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author nttungg
 */
public class AccountCtr {
    
    public static boolean checkUserByName(String username) {
       ArrayList<Account> allAccount = AccountDAO.selectAllAccount();
       if (allAccount.size() > 0) {
           for (int i=0;i<allAccount.size();i++){
               if (allAccount.get(i).username.equals(username)){
                   return true;
               }
           }
           return false;
       }
       return false;
    }
    
    public static ArrayList<Account> getAllAccountUnstate() {
        ArrayList<Account> allAccount = AccountDAO.selectAllAccount();
        ArrayList<Account> unStateAccount = new ArrayList<>();
        for (int i=0; i< allAccount.size(); i++) {
            if (allAccount.get(i).state == 0) {
                unStateAccount.add(allAccount.get(i));
            }
        }
        return unStateAccount;
    }
    
    public static int loginAccount(String username, String password) {
       ArrayList<Account> allAccount = AccountDAO.selectAllAccount();
       if (allAccount.size() > 0) {
           for (int i=0;i<allAccount.size();i++){
               if (allAccount.get(i).username.equals(username) && allAccount.get(i).password.equals(password)){
                   return allAccount.get(i).role;
               } else if (allAccount.get(i).username.equals(username) && !allAccount.get(i).password.equals(password)){
                   return -2;
               }
           }
           return -1;
       } else {
           return -1;
       }
       
    }
    
    public static int registerAccount(String username, String password, int role, int state, String description) {
        if (!checkUserByName(username)) {
            return AccountDAO.insertAccount(new Account(username, password, role, 0, description));
        } else {
            return -2;
        }
    }
    
    public static int updateAccount(Account account) {
        return AccountDAO.updateAccount(account);
    }
}
