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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;


/**
 *
 * @author cris
 */

@Named(value = "register_Controller")
@ManagedBean
@RequestScoped
public class Register_Controller {
    
    private String email;
    private String password;
    
    @Inject
    private SessionControl ctrl;
    
    public Register_Controller(){
        
    }

    public String register(){
        User usr = new User(email,password);
        
        ctrl.setUser(usr);
        ctrl.addUser(usr);
        return "index.xhtml";
    }
    

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
   
    
}
