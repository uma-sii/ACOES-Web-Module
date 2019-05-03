package org.acoes.model.exceptions;

/**
 * @author Manuel
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(){
        super("Error: User not found");
    }
    
    public UserNotFoundException(String username){
        super("Error: User '" + username + "' not found");
    }
}
