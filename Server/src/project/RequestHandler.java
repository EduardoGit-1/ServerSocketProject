/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Eduardo
 */

import java.net.*;
import java.io.*;
import java.util.*;
import project.controller.Controller;
import project.controller.MessageController;
import project.controller.PresencesAndMessagesController;
import project.controller.UserController;
import project.repository.MessageRepository;
import project.repository.UserRepository;

public class RequestHandler extends Thread {

    Socket socket;
    BufferedReader in;
    PrintWriter out;
    MessageRepository messageRepository;
    UserRepository userRepository;
    Controller controller;
    MessageController messageController;
    PresencesAndMessagesController presencesAndMessagesController;
    UserController userController;

    public RequestHandler(Socket socket, MessageRepository messageRepository, UserRepository userRepository) {
        this.socket = socket;
        try {
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream());
            this.messageRepository = messageRepository;
            this.userRepository = userRepository;
            this.controller = new Controller(this.out, this.socket);
            this.messageController = new MessageController();
            this.presencesAndMessagesController = new PresencesAndMessagesController();
            this.userController = new UserController();
  
        } catch (IOException e) {
            System.out.println("Erro na execucao do servidor: " + e);
            System.exit(1);
        }
    }

    @Override
    public void run() {
        try {

            String msg;
            int len;
            String methodPath = null;
            String method = null;
            String path = null;
           
            // lê a primeira linha: request-line
            msg = in.readLine();
            len = msg == null ? 0 : msg.trim().length();

            //Trata a request line
            if (len != 0) {
                StringTokenizer tokens = new StringTokenizer(msg);
                String token = tokens.nextToken();
                if (token.equals("GET"))method = "GET";
                if (token.equals("POST"))method = "POST";

                token = tokens.nextToken();

                if (token.equals("/newUser"))path = "/newUser";
                if (token.equals("/sendMessage"))path = "/sendMessage";
                if (token.equals("/getMessages"))path = "/getMessages";
                if (token.equals("/getAll")) path = "/getAll";
                   
                methodPath = method + " " + path;
            }

            //lê todas as linhas (terminadas por new line) até ler uma linha em branco; corresponde a ler todo o cabeçalho
            while (len != 0) {
                System.out.println(msg);

                //lê a linha seguinte
                msg = in.readLine();
                len = msg == null ? 0 : msg.trim().length();
            }

            switch (methodPath) {
                case "GET /getAll":
                    this.presencesAndMessagesController.getPresencesAndMessages(controller, messageRepository, userRepository);
                    break;
                case "POST /newUser":
                    this.userController.createUser(in, userRepository, messageRepository, controller);
                    break;
                case "POST /sendMessage":
                    this.messageController.sendMessage(messageRepository, userRepository, in, controller);
                    break;
                default:
                    out.println("HTTP/1.1 404 Not Found");
                    break;
            }
            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
