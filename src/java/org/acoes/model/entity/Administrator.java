package org.acoes.model.entity;

import javax.persistence.Entity;

/**
 * @author Manuel
 */
@Entity
public class Administrator extends RegisteredUser {
    private String workplace;
    private String adminGroup;

    public Administrator(){super();}
    
    public Administrator(String username, String password) {
        super(username, password);
    }
    
    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getAdminGroup() {
        return adminGroup;
    }

    public void setAdminGroup(String group) {
        this.adminGroup = group;
    }

    @Override
    public String toString() {
        return "Admin(" + email + ")";
    }
    
}
