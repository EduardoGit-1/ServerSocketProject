/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import project.payload.PresencesAndMessagesResponse;
import project.repository.MessageRepository;
import project.repository.UserRepository;
import project.service.UserService;

/**
 *
 * @author Eduardo
 */
public class PresencesAndMessagesController {
    
    private final ObjectMapper objectMapper;
    private final UserService userService;

    public PresencesAndMessagesController() {
        
        this.objectMapper = new ObjectMapper();
        this.userService = new UserService();
    }
    
    public void getPresencesAndMessages(String path, Controller controller, MessageRepository messageRepository, UserRepository userRepository) throws JsonProcessingException{
        PresencesAndMessagesResponse presencesAndMessagesResponse = new PresencesAndMessagesResponse(this.userService.getUserNicknames(userRepository), messageRepository.getMessageRepository());
        String response = objectMapper.writeValueAsString(presencesAndMessagesResponse);
        controller.universalController(response);
    }
}
