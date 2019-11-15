/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.model;

/**
 *
 * @author Eduardo
 */
public class Message {

     private User user;
     private String content;
     
     public Message(){}
     public Message(User user, String content) {
     this.user = user;
     this.content = content;
     }

     public User getUser() {
     return user;
     }

     public void setUser(User user) {
     this.user = user;
     }

     public String getContent() {
     return content;
     }

     public void setContent(String content) {
     this.content = content;
     }
    /*private int id;
    private String content;
    
    public Message(){}
    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }*/

}
