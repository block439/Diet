package pl.jazapp.app;


import pl.jazapp.app.webapp.login.LoginRequest;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.xml.registry.infomodel.User;
import java.io.Serializable;

@SessionScoped
public class UserContext implements Serializable {
    private static final long serialVersionUID =1L;

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

    public String fullName(LoginRequest loginRequest, UserMap userMap){
        return userMap.getFullName(loginRequest).getFirstName() + userMap.getFullName(loginRequest).getLastName();
    }




}
