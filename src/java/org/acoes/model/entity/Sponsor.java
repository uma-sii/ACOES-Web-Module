package org.acoes.model.entity;

import javax.persistence.Entity;

import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

/**
 * @author Manuel
 */
@Entity
public class Sponsor extends RegisteredUser {
    private String dni;
    
    private String address;
    private String city;
    private String country;
    private int zipcode;
    
    private String phoneNumber;
    
    private Gender gender;
    
    private String firstName;
    private String lastName;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<SponsoredChild> sponsoredChildren;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Payment> payments;

    public Sponsor(){super();}
    
    public Sponsor(String username, String password) {
        super(username, password);
    }
    
    public String getDNI() {
        return dni;
    }
    
    public void setDNI(String id) {
        this.dni = id;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender g) {
        this.gender = g;
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
    
    public void setPhoneNumber(String number) {
        this.phoneNumber = number;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
    
    public List<SponsoredChild> getSponsoredChildren() {
        return sponsoredChildren;
    }

    public void setSponsoredChildren(List<SponsoredChild> sponsoredChildren) {
        this.sponsoredChildren = sponsoredChildren;
    }
    
    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Sponsor(" + email + ")";
    }
    
}
