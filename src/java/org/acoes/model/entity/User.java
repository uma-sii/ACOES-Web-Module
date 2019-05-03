/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acoes.model.entity;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Manuel
 */
@MappedSuperclass
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    
    @Id
    protected String email;
    protected String password; // todo: <- hash of salt + password
    //protected String salt;
    
    public User(){}
    
    public User(String username, String password){
        this.email = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    /*private byte[] digest(String txt){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] salt = generateSalt();
            md.update(salt);
            return md.digest(txt.getBytes(StandardCharsets.UTF_8));
        } catch(Exception _) {
            return null;
        }
    }
    
    private byte[] generateSalt(){
        SecureRandom rnd = new SecureRandom();
        byte[] salt = new byte[16];
        rnd.nextBytes(salt);
        return salt;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return email;
    }
    
}
