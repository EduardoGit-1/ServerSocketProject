/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.repository;

import java.util.ArrayList;
import project.model.User;

/**
 *
 * @author Eduardo
 */
public class UserRepository {

    private final ArrayList<User> userRepository;

    public UserRepository() {

        this.userRepository = new ArrayList<User>();
    }

    public boolean userExists(User user) {

        return this.userRepository.contains(user);
    }

    public boolean userExistsByUsername(String username) {

        boolean exists = false;
        for (User user : userRepository) {
            if (user.getUsername().equals(username)) {

                exists = true;
                break;
            }
        }
        return exists;
    }

    public void addUser(User user) {

        this.userRepository.add(user);
    }

    public ArrayList<User> getUserRepository() {
        return userRepository;
    }
    
    public User getUserById(int id){
        for(User user : userRepository){
            if(user.getId() == id) return user;
        }
        return null;
    }
}
