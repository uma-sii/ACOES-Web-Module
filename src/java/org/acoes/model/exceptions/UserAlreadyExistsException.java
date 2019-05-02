package org.acoes.model.exceptions;

/**
 *
 * @author Manuel
 */
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(){
        super("Error: User already exists");
    }
    
    public UserAlreadyExistsException(String username){
        super("Error: User '" + username + "' already exists");
    }
}
