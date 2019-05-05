package org.acoes.beans;

import org.acoes.model.entity.RegisteredUser;
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
        RegisteredUser temp = ctrl.getUsersServices().match(email, password);
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
