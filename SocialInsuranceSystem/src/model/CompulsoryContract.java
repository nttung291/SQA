package model;

import java.io.Serializable;

public class CompulsoryContract implements Serializable{
    public String companyCode;
    public int id;
    public int state;
    public String description;
 
    public CompulsoryContract() {
    }

    public CompulsoryContract(String companyCode, int state, String description) {
        this.companyCode = companyCode;
        this.state = state;
        this.description = description;
    }
}