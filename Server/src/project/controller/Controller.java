/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;



import java.io.PrintWriter;
import java.net.Socket;


/**
 *
 * @author Eduardo
 */
public class Controller {
    
    private final PrintWriter out;
    public Controller(PrintWriter out, Socket ligacao) {
        this.out = out;
       
    }

    public void universalController(String response){
        
        this.out.println("HTTP/1.1 200 OK");
        int length = response.length();
        this.out.println("Content-type: application/json");
        this.out.println("Content-Length: " + length);
        this.out.write("\r\n");
        this.out.println(response);
        this.out.flush();

    }

}
