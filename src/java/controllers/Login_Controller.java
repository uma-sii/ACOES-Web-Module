/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.*;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author cris
 */

@Named(value = "login_Controller")
@RequestScoped
public class Login_Controller {
    
    private String email;
    private String password;
    private List<User> users;
    
    @Inject
    private SessionControl ctrl;
    
    public Login_Controller(){
        users = new ArrayList<User>();
        users.add(new User("cris@gmail.com", "jeje"));
    }
    
    public String authenticate(){
        
        User temp = null;
        
        for(User u: users){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                temp = u;
            }
        }
        
        ctrl.setUser(temp);
        
        return ctrl.log();
    }
    
    public String register(){
        User usr = new User(email,password);
        users.add(usr);
                
        ctrl.setUser(usr);
        
        return ctrl.log();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<User> getUsers() {
        return users;
    }
}
