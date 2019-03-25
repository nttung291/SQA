package model;

import java.io.Serializable;

public class Account implements Serializable{
    public int id;
    public String username;
    public String password;
    public int role;
    public int state;
    public String description;

    public Account() {
    }

    public Account( String username, String password, int role, int state, String description) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.state = state;
        this.description = description;
    }
    
    
    
}