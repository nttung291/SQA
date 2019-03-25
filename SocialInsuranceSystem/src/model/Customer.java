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
    
    

}