/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acoes.model.dao;

import java.util.List;
import org.acoes.model.entity.RegisteredUser;

/**
 * @author Manuel
 */
public interface UsersDAO {
    public List<RegisteredUser> getUsers();
    public RegisteredUser findUser(String email);
    /**
     * Adds a new user or updates an existing one.
     * @param user 
     */
    public void saveUser(RegisteredUser user);
}
