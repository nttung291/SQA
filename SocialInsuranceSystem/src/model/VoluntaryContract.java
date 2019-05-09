package model;

import java.io.Serializable;

public class VoluntaryContract implements Serializable{
    public int id;
    public int state;
    public String description;
    public String startedDate;
    
    public VoluntaryContract() {
    }

    public VoluntaryContract(int state, String description, String startedDate) {
        this.state = state;
        this.description = description;
        this.startedDate = startedDate;
    }

}