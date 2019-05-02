/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acoes.business.impl;

import org.acoes.business.UsersFacade;
import org.acoes.model.dao.UsersDAO;
import org.acoes.model.entity.Administrator;
import org.acoes.model.entity.Sponsor;
import org.acoes.model.entity.User;
import org.acoes.model.exceptions.UserAlreadyExistsException;

/**
 * Implementation of the service UserFacade
 * @author Manuel
 */
public class UsersFacadeImpl implements UsersFacade {
     //Singleton
    private static UsersFacadeImpl instance = null;
    
    private UsersDAO usersDAO;
    
    private UsersFacadeImpl(){}
    
    public static UsersFacadeImpl getInstance(){
        if(instance == null){
            instance = new UsersFacadeImpl();
        }
        return instance;
    }
    
    public void setUsersDAO(UsersDAO dao){
        usersDAO = dao;
    }
    
    public UsersDAO getUsersDAO(){
        return usersDAO;
    }
    
    @Override
    public void createUser(User user) {
        if(doesUserExist(user))
            throw new UserAlreadyExistsException(user.getEmail());
        usersDAO.saveUser(user);
    }

    @Override
    public boolean doesUserExist(User user) {
        return usersDAO.findUser(user.getEmail()) != null;
    }

    @Override
    public User findUser(String email) {
        return usersDAO.findUser(email);
    }

    @Override
    public boolean isAdmin(User user) {
        return usersDAO.findUser(user.getEmail()) instanceof Administrator;
    }

    @Override
    public User match(String email, String password) {
        User result = findUser(email);
        if(result != null && result.getPassword().equals(password))
            return result;
        return null;
    }

    @Override
    public void refreshUser(User user) {
        usersDAO.saveUser(user);
    }

    @Override
    public boolean isSponsor(User user) {
        return usersDAO.findUser(user.getEmail()) instanceof Sponsor;
    }
    
}
