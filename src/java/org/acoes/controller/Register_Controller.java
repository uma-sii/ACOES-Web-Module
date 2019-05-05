/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acoes.controller;

import org.acoes.model.entity.RegisteredUser;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import org.acoes.model.entity.Gender;
import org.acoes.model.exceptions.UserAlreadyExistsException;


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
    private String dni;
    
    private String address;
    private String city;
    private String country;
    private int zipcode;
    
    private String phoneNumber;
    
    private Gender gender;
    
    private String firstName;
    private String lastName;
    
    @Inject
    private SessionControl ctrl;
    
    public Register_Controller(){
        
    }

    public String register(){
        RegisteredUser usr = new RegisteredUser(email,password);
        try{
            ctrl.getUsersServices().createUser(usr);
            ctrl.setUser(usr);
            return "index.xhtml";
        } catch(UserAlreadyExistsException e){
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary(e.getMessage());
            message.setDetail(e.getMessage());
            ctx.addMessage("signupForm:Email", message);
            return "registration.xhtml";
        }
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
   
    
}
