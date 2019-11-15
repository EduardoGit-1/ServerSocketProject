/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.repository;

import java.util.ArrayList;
import project.model.Message;

/**
 *
 * @author Eduardo
 */
public class MessageRepository {
    
    private final ArrayList<Message> messageRepository;
    
    public MessageRepository(){
        
        this.messageRepository = new ArrayList<Message>();
    }
    
    public boolean messageExists(Message message){
        
        return this.messageRepository.contains(message);
    }
    
    public void addMessage(Message message){
        
        this.messageRepository.add(message);
    }

    public ArrayList<Message> getMessageRepository() {
        return messageRepository;
    }
    
    
}
