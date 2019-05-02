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
import org.acoes.business.SponsorshipsFacade;
import org.acoes.business.UsersFacade;
import org.acoes.business.impl.SponsorshipsFacadeImpl;
import org.acoes.business.impl.UsersFacadeImpl;
import org.acoes.model.dao.dummy.UsersDAOImpl;
import org.acoes.model.entity.Administrator;
import org.acoes.model.entity.Sponsor;

/**
 *
 * @author cris
 */
@Named(value = "sessionControl")
@SessionScoped
public class SessionControl implements Serializable {
    
    private User user;

    private UsersFacadeImpl usersServices;
    private SponsorshipsFacadeImpl sponsorshipsServices;
    
    public SessionControl(){
        usersServices = UsersFacadeImpl.getInstance();
        sponsorshipsServices = SponsorshipsFacadeImpl.getInstance();
        // We are going to work with dummy data in-memory
        usersServices.setUsersDAO(UsersDAOImpl.getInstance());
        sponsorshipsServices.setUsersDAO(UsersDAOImpl.getInstance());
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
    public User getUser(){
        return user;
    }
    
    public Administrator getAdmin(){
        return (Administrator)user;
    }
    
    public Sponsor getSponsor(){
        return (Sponsor)user;
    }
    
    public UsersFacade getUsersServices(){
        return usersServices;
    }
    
    public SponsorshipsFacade getSponsorshipsServices(){
        return sponsorshipsServices;
    }
    
    public String refreshUser(){
        usersServices.refreshUser(user);
        return "index.xhtml";
    }
    
    public String log(){ 
        FacesContext ctx = FacesContext.getCurrentInstance();
        
        if(user == null){
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, incorrect user or password", "Error, incorrect user or password"));
            return "login.xhtml";
        }
        
        if(user instanceof Administrator)
            return "sponsors_info.xhtml";
        return "index.xhtml";
    }
    
    public String logout(){
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        user = null;
        return "login.xhtml";
    }
}
