package org.acoes.business;

import org.acoes.model.entity.User;

/**
  Business tier operations related to users.
  @author Manuel
 */
public interface UsersFacade {
    public void    createUser(User user);
    public boolean doesUserExist(User user);
    public boolean doesUserExist(String email);
    public User    findUser(String email);
    public boolean isAdmin(User user);
    public boolean isSponsor(User user);
    /**
     * Finds an user with the email and password given.
     * @param email
     * @param password
     * @return if it exists, returns that user. Otherwise, returns null.
     */
    public User    match(String email, String password);
    public void    refreshUser(User user);
}
