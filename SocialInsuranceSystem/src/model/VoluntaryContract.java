package model;

import java.io.Serializable;

public class VoluntaryContract implements Serializable{
    public int id;
    public int state;
    public String description;
    
    public VoluntaryContract() {
    }

    public VoluntaryContract(int id, int state, String description) {
        this.id = id;
        this.state = state;
        this.description = description;
    }

}