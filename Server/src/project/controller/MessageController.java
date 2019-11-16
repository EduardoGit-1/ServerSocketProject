/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import project.model.Message;
import project.model.User;
import project.payload.MessagePayload;
import project.payload.PresencesAndMessagesResponse;
import project.repository.MessageRepository;
import project.repository.UserRepository;
import project.service.MessageService;
import project.service.UserService;

/**
 *
 * @author Eduardo
 */
public class MessageController {
    
    private final ObjectMapper objectMapper;
    private final MessageService messageService;
    private final UserService userService;
    public MessageController() {
        this.objectMapper = new ObjectMapper();
        this.messageService = new MessageService();
        this.userService = new UserService();
        
}
    
    
    public void sendMessage(MessageRepository messageRepository, UserRepository userRepository, BufferedReader in, Controller controller) throws IOException{
        String messageJson = this.messageService.handleMessageRequest(in);
        MessagePayload messagePayload = objectMapper.readValue(messageJson, MessagePayload.class);
        User user = userRepository.getUserById(messagePayload.getId());
        Message message = new Message(user, messagePayload.getContent());
        messageRepository.addMessage(message);
        PresencesAndMessagesResponse presencesAndMessagesResponse = new PresencesAndMessagesResponse(this.userService.getUserNicknames(userRepository), messageRepository.getMessageRepository());
        String response = objectMapper.writeValueAsString(presencesAndMessagesResponse);
        System.out.println("Resposta: " + response);
        controller.universalController(response);
    }
}
