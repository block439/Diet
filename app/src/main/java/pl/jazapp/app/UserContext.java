package pl.jazapp.app;


import pl.jazapp.app.webapp.login.LoginRequest;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.registry.infomodel.User;
import java.io.Serializable;
@Named
@SessionScoped
public class UserContext implements Serializable {
    private static final long serialVersionUID =1L;
    private String fullName;

    private boolean isLogged;

    public UserContext(){
    }

    public UserContext(boolean isLogged) {
        this.isLogged = isLogged;
    }

    public boolean isLogged(){
        return isLogged;
    }

    public void login(){
        isLogged =true;
    }

    public void setFullName(String firstName, String lastName) {
        this.fullName = firstName + " " + lastName;
    }


    public String getFullName() {
        return fullName;
    }
}
