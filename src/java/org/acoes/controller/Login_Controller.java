/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acoes.controller;

import org.acoes.model.entity.User;
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
    
    @Inject
    private SessionControl ctrl;
    
    public Login_Controller(){
        ctrl = new SessionControl();
    }
    
    public String authenticate(){
        User temp = ctrl.getUsersServices().match(email, password);
        ctrl.setUser(temp);
        return ctrl.log();
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
