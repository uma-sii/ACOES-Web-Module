/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acoes.controller;

import org.acoes.model.entity.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.acoes.business.UsersFacade;
import org.acoes.business.impl.UsersFacadeImpl;
import org.acoes.model.dao.dummy.UsersDAOImpl;

/**
 *
 * @author cris
 */
@Named(value = "sessionControl")
@SessionScoped
public class SessionControl implements Serializable {
    
    private User user;

    private UsersFacadeImpl usersServices;
    
    public SessionControl(){
        usersServices = UsersFacadeImpl.getInstance();
        // We are going to work with dummy data in-memory
        usersServices.setUsersDAO(UsersDAOImpl.getInstance());
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
    public User getUser(){
        return user;
    }
    
    public UsersFacade getUsersServices(){
        return usersServices;
    }
    
    public String refreshUser(){
        usersServices.refreshUser(user);
        return "";
    }
    
    public String log(){ 
        FacesContext ctx = FacesContext.getCurrentInstance();
        
        if(user == null){
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, incorrect user or password", "Error, incorrect user or password"));
            return "login.xhtml";
        } 
        return "index.xhtml";
    }
    
    public String logout(){
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        user = null;
        return "login.xhtml";
    }
}
