/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acoes.model.dao.dummy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.acoes.model.entity.Administrator;
import org.acoes.model.entity.User;
import org.acoes.model.dao.UsersDAO;

/**
 * This singleton class contains dummy data about users.
 * @author Manuel
 */
public class UsersDAOImpl implements UsersDAO {
    //Singleton
    private static UsersDAOImpl instance = null;
    
    // In-memory copy of data
    private List<User> users;
    
    private UsersDAOImpl(){
        init();
    }
    
    public static UsersDAOImpl getInstance(){
        if(instance == null){
            instance = new UsersDAOImpl();
        }
        return instance;
    }
    
    private void init(){
        users = new LinkedList<>();
        
        Administrator admin1 = new Administrator("johndoe@acoes.org", "12345");
        admin1.setWorkplace("ACOES España");
        
        Administrator admin2 = new Administrator("janedoe@acoes.org", "12345");
        admin1.setWorkplace("ACOES Honduras");
        
        users.add(admin1);
        users.add(admin2);
        
        users.add(new User("cris@gmail.com", "12345"));
        users.add(new User("malorev@gmail.com", "12345"));
        users.add(new User("miguel@gmail.com", "12345"));
        users.add(new User("alex@gmail.com", "12345"));
        users.add(new User("diego@gmail.com", "12345"));
        users.add(new User("luis@gmail.com", "12345"));
    }
    
    @Override
    public User findUser(String email) {
        User result = null;
        for(User u : users){
            if(u.getEmail().equals(email)){
                result = u;
                break;
            }
        }
        return result;
    }

    @Override
    public void saveUser(User user) {
        String email = user.getEmail();
        int idx = 0;
        boolean found = false;
        User temp = null;
        while(!found && idx < users.size()){
            temp = users.get(idx);
            if(temp.getEmail().equals(email)){
                users.set(idx, user);
                found = true;
            }
        }
        if(!found)
            users.add(user);
    }
    
}
