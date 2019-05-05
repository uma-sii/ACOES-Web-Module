package org.acoes.business.impl;

import org.acoes.business.UsersFacade;
import org.acoes.model.dao.UsersDAO;
import org.acoes.model.entity.Administrator;
import org.acoes.model.entity.Sponsor;
import org.acoes.model.entity.RegisteredUser;
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
    public void createUser(RegisteredUser user) {
        if(doesUserExist(user))
            throw new UserAlreadyExistsException(user.getEmail());
        usersDAO.saveUser(user);
    }

    @Override
    public boolean doesUserExist(RegisteredUser user) {
        return doesUserExist(user.getEmail());
    }
    
    @Override
    public boolean doesUserExist(String email) {
        return usersDAO.findUser(email) != null;
    }

    @Override
    public RegisteredUser findUser(String email) {
        return usersDAO.findUser(email);
    }

    @Override
    public boolean isAdmin(RegisteredUser user) {
        return usersDAO.findUser(user.getEmail()) instanceof Administrator;
    }

    @Override
    public RegisteredUser match(String email, String password) {
        RegisteredUser result = findUser(email);
        if(result != null && result.getPassword().equals(password))
            return result;
        return null;
    }

    @Override
    public void refreshUser(RegisteredUser user) {
        usersDAO.saveUser(user);
    }

    @Override
    public boolean isSponsor(RegisteredUser user) {
        return usersDAO.findUser(user.getEmail()) instanceof Sponsor;
    }
    
}
