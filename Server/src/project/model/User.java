/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Eduardo
 */
public class User {
    @JsonIgnore
    private int id;
    private String username;
    
    public User(){}
    public User(int id, String username) {
        
        this.id = id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}   
