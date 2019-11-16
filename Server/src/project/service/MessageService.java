/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.service;

import java.io.BufferedReader;
import java.io.IOException;


/**
 *
 * @author Eduardo
 */
public class MessageService {
    
   public MessageService() {} 
   public String handleMessageRequest(BufferedReader in) throws IOException {
        String line;
        String response = "";

        for (int i = 0; i < 3; i++) {
            if (in.ready() && ((line = in.readLine()) != null)) {
                response += line.trim();
            }
        }
        response += "}";
        return response;
    }
}
