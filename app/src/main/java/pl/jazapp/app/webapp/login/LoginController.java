package pl.jazapp.app.webapp.login;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.swing.*;

@RequestScoped
@Named
public class LoginController {

    public String login(LoginRequest loginRequest){
        System.out.println(String.format("Tried to login with username: %s an password: %s", loginRequest.getUsername(), loginRequest.getPassword()));
        //TODO kod do logowania
        return "/index.xhtml?faces-redirection=true";
    }
}
