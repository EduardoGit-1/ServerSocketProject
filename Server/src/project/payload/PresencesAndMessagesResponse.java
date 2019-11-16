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
public class PresencesAndMessagesResponse {
    
    private String[] presences;
    private ArrayList<Message> messages;

    public PresencesAndMessagesResponse() {
    }

    public PresencesAndMessagesResponse(String[] presences, ArrayList<Message> messages) {
        this.presences = presences;
        this.messages = messages;
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
    
    
    
    


    
    
}
