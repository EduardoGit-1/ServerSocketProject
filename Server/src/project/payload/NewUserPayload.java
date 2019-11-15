/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.payload;


import java.util.ArrayList;
import project.model.Message;

/**
 *
 * @author Eduardo
 */
public class NewUserPayload {
    private int userID;
    private String username;
    private String[] presences;
    private ArrayList<Message> messages;

    public NewUserPayload() {
    }

    public NewUserPayload(int userID, String username,String[] presences, ArrayList<Message> messages) {
        this.userID = userID;
        this.presences = presences;
        this.messages = messages;
        this.username = username;
        
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String[] getPresences() {
        return presences;
    }

    public void setPresences(String[] presences) {
        this.presences = presences;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
    
}
