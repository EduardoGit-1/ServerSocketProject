/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.payload;

/**
 *
 * @author Eduardo
 */
public class ErrorCreatingUserResponse {
    
    private String error;

    public ErrorCreatingUserResponse() {
    }

    public ErrorCreatingUserResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    
}
