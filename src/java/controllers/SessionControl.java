/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.*;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author cris
 */
@Named(value = "sessionControl")
@SessionScoped
public class SessionControl implements Serializable {
    
    private User user;
    
    public SessionControl(){
        
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
    public User getUser(){
        return user;
    }
    
    public String log(){
        
        FacesContext ctx = FacesContext.getCurrentInstance();
        
        
        if(user == null){
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, incorrect user or password", "Error, incorrect user or password"));
            return "login.xhtml";
        } 
        return "sponsored_child.xhtml";
    }
    
    public String logout(){

        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        user = null;
        return "login.xhtml";
    }
}
