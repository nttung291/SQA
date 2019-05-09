
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
        Connection.createConnection();
        Account account=new Account("habui","Test@1234",1,1,"");
        AccountDAO.insertAccount(account);
        account=AccountDAO.selectAllAccount().get(0);
        CompulsoryContract compulsoryContract=new CompulsoryContract("10", 0, "", "23/5/2019");
        CompulsoryContractDAO.insertCompulsoryContract(compulsoryContract);
        compulsoryContract=CompulsoryContractDAO.selectAllCompulsoryContract().get(0);
        VoluntaryContract voluntaryContract=new VoluntaryContract(0, "", "23/5/2019");
        VoluntaryContractDAO.insertVoluntaryContract(voluntaryContract);
        voluntaryContract=VoluntaryContractDAO.selectAllVoluntaryContract().get(0);
        Hometown hometown=new Hometown(1, "Yen Bai", 0);
        HometownDAO.insertHometown(hometown);
        hometown=HometownDAO.selectAllHometown().get(0);
        Customer customer=new Customer(account, 
                compulsoryContract, 
                voluntaryContract, hometown, 
                "Bui Manh Ha", true, "17/12/1997", "061092688", "20233421", "hb.buimanhha@gmail",
                "0858171297", 0, "111", 5000);
    }
}
