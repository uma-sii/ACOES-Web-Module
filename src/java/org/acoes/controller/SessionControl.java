/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acoes.controller;

import org.acoes.model.entity.RegisteredUser;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.acoes.business.PaymentsFacade;
import org.acoes.business.SponsorshipsFacade;
import org.acoes.business.UsersFacade;
import org.acoes.business.impl.PaymentsFacadeImpl;
import org.acoes.business.impl.SponsorshipsFacadeImpl;
import org.acoes.business.impl.UsersFacadeImpl;
import org.acoes.model.dao.dummy.PaymentsDAOInMemoryImpl;
import org.acoes.model.dao.dummy.UsersDAOImpl;
import org.acoes.model.dao.dummy.UsersDAOInMemoryImpl;
import org.acoes.model.entity.Administrator;
import org.acoes.model.entity.Gender;
import org.acoes.model.entity.Sponsor;
import org.acoes.model.entity.SponsoredChild;

/**
 *
 * @author cris
 */
@Named(value = "sessionControl")
@SessionScoped
public class SessionControl implements Serializable {
    
    private RegisteredUser user;

    private UsersFacadeImpl usersServices;
    private SponsorshipsFacadeImpl sponsorshipsServices;
    private PaymentsFacadeImpl paymentsServices;
    
    public SessionControl(){
        usersServices = UsersFacadeImpl.getInstance();
        sponsorshipsServices = SponsorshipsFacadeImpl.getInstance();
        paymentsServices = PaymentsFacadeImpl.getInstance();
        
        usersServices.setUsersDAO(UsersDAOInMemoryImpl.getInstance());
        sponsorshipsServices.setUsersDAO(UsersDAOInMemoryImpl.getInstance());
        paymentsServices.setPaymentsDAO(PaymentsDAOInMemoryImpl.getInstance());
    }
    
    public void setUser(RegisteredUser user){
        this.user = user;
    }
    
    public RegisteredUser getUser(){
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
    
    public PaymentsFacade getPaymentsServices(){
        return paymentsServices;
    }
    
    public void refreshUser(){
        usersServices.refreshUser(user);
    }
    
    public boolean loggedIn(){
        return user != null;
    }
    
    public String redirectIfNeeded(){
        System.out.println("Redirect if needed");
        if(!loggedIn())
            return "login.xhtml";
        return null;
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
        return "index.xhtml";
    }
}
