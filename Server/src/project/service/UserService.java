/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.service;

import java.io.BufferedReader;
import java.io.IOException;
import project.model.User;
import project.repository.UserRepository;

/**
 *
 * @author Eduardo
 */
public class UserService {

	public UserService() {}
    public String[] getUserNicknames(UserRepository userRepository) {
        int i = 0;
        String[] usernames = new String[userRepository.getUserRepository().size()];
        for (User user : userRepository.getUserRepository()) {
            usernames[i] = user.getUsername();
            i += 1;
        }
        return usernames;
    }

    public String handleNewUserRequest(BufferedReader in) throws IOException {
        String line;
        String response = "";
        for (int i = 0; i < 3; i++) {
            if (in.ready() && ((line = in.readLine()) != null)) {
                response += line.trim();
              
            }
        }
        
        response += "}";
        System.out.println(response);
        return response;
    }
    
    public Boolean verifyUserExist(UserRepository userRepository, String username){
        userRepository.userExistsByUsername(null);
        for(User user : userRepository.getUserRepository()){
            if(username.equals(user.getUsername())){
                return true;
            }
        }
        
        return false;
    }
    
  
}
