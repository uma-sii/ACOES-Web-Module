/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acoes.model.entity;

import javax.persistence.Entity;

/**
 * @author Manuel
 */
@Entity
public class Administrator extends User {

    private static final long serialVersionUID = 1L;

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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrator)) {
            return false;
        }
        Administrator other = (Administrator) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoes.models.Admin[ id=" + id + " ]";
    }
    
}
