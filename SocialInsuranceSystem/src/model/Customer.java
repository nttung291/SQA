package model;

import java.io.Serializable;

public class Customer implements Serializable{

    public Account account;
    public CompulsoryContract compulsoryContract;
    public VoluntaryContract voluntaryContract;
    public Hometown hometown;
    public int id;
    public String name;
    public boolean sex;
    public String dob;
    public String idNumber;
    public String socialInsuranceNo;
    public String email;
    public String phoneNo;
    public int paymentDuration;
    public String taxCode;
    public float salary;

    public Customer() {
    }
    
     public Customer(Account account, CompulsoryContract compulsoryContract, VoluntaryContract voluntaryContract, Hometown hometown, String name, boolean sex, String dob, String idNumber, String socialInsuranceNo, String email, String phoneNo, int paymentDuration, String taxCode, float salary) {
        this.account = account;
        this.compulsoryContract = compulsoryContract;
        this.voluntaryContract = voluntaryContract;
        this.hometown = hometown;
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.dob = dob;
        this.idNumber = idNumber;
        this.socialInsuranceNo = socialInsuranceNo;
        this.email = email;
        this.phoneNo = phoneNo;
        this.paymentDuration = paymentDuration;
        this.taxCode = taxCode;
        this.salary = salary;
    }

}