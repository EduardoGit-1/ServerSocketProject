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
import project.repository.MessageRepository;
import project.repository.UserRepository;

public class Server {
    
	static int DEFAULT_PORT=8081;
	
        
	public static void main(String[] args) {
		int port = DEFAULT_PORT;
		MessageRepository messageRepository = new MessageRepository();
        UserRepository userRepository = new UserRepository();
		ServerSocket servidor = null; 
	
		try	{ 
			servidor = new ServerSocket(port);
		} catch (Exception e) { 
			System.err.println("erro ao criar socket servidor...");
			e.printStackTrace();
			System.exit(-1);
		}
			
		System.out.println("Servidor à espera de ligacoes no porto " + port);
		
		while(true) {
			try {
				Socket ligacao = servidor.accept();
				RequestHandler t = new RequestHandler(ligacao, messageRepository, userRepository);
				t.start();
				
			} catch (IOException e) {
				System.out.println("Erro na execucao do servidor: "+e);
				System.exit(1);
			}
		}
	}
}