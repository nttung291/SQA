
import dao.AccountDAO;
import dao.CompulsoryContractDAO;
import dao.Connection;
import dao.CustomerDAO;
import dao.HometownDAO;
import dao.VoluntaryContractDAO;
import model.Account;
import model.CompulsoryContract;
import model.Customer;
import model.Hometown;
import model.VoluntaryContract;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author habui
 */
public class Main {
    public static void main(String[] args) {
        Float salary;
        try {
            salary = Float.parseFloat("5,000,000".replaceAll(",", ""));
        } catch (Exception e) {
            System.out.println("Salary is wrong format");
        }
    }
}
