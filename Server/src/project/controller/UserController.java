/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import project.model.User;
import project.payload.ErrorCreatingUserResponse;
import project.payload.NewUserResponse;
import project.repository.MessageRepository;
import project.repository.UserRepository;
import project.service.UserService;

/**
 *
 * @author Eduardo
 */
public class UserController {
    
    private final UserService userService;
    private final ObjectMapper objectMapper;

    public UserController() {
        this.userService = new UserService();
        this.objectMapper = new ObjectMapper();
    }
   

    public synchronized void createUser(BufferedReader in, UserRepository userRepository, MessageRepository messageRepository, Controller controller) throws IOException{
       String userJson = userService.handleNewUserRequest(in);
       System.out.println(userJson);
       User user = objectMapper.readValue(userJson, User.class);
       
       String response = null;
       if(this.userService.verifyUserExist(userRepository, user.getUsername())){
           ErrorCreatingUserResponse errorCreatingUserResponse = new ErrorCreatingUserResponse("Username já existe");
           response = objectMapper.writeValueAsString(errorCreatingUserResponse);
           System.out.println(response);
           controller.universalController(response);
       }else{
           user.setId(userRepository.getUserRepository().size() + 1);
           userRepository.addUser(user);
           NewUserResponse newUserResponse = new NewUserResponse(user.getId(), user.getUsername(), this.userService.getUserNicknames(userRepository), messageRepository.getMessageRepository());
           response = objectMapper.writeValueAsString(newUserResponse);
           System.out.println(response);
           controller.universalController(response);
       }
    }
}
