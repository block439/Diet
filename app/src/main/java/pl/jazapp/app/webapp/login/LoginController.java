package pl.jazapp.app.webapp.login;

import pl.jazapp.app.UserMap;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@RequestScoped
@Named
public class LoginController {

    @Inject
    UserMap userMap;

    public String login(LoginRequest loginRequest){
        System.out.println(String.format("Tried to login with username: %s an password: %s", loginRequest.getUsername(), loginRequest.getPassword()));
        //TODO kod do logowania
        userMap.start();
        if (userMap.login(loginRequest.getUsername(),loginRequest.getPassword())) {
            return "/index.xhtml?faces-redirect=true";
        }else {
            return "/login.xhtml?faces-redirect=true";
        }
    }
}
