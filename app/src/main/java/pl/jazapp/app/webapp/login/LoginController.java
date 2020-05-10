package pl.jazapp.app.webapp.login;

import pl.jazapp.app.UserContext;
import pl.jazapp.app.UserMap;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@RequestScoped
@Named
public class LoginController  {

    @Inject
    UserMap userMap;
    @Inject
    UserContext userContext;

    public String login(LoginRequest loginRequest){
        System.out.println(String.format("Tried to login with username: %s an password: %s", loginRequest.getUsername(), loginRequest.getPassword()));

        if (userMap.isRegistered(loginRequest.getUsername()) && userMap.getUser(loginRequest.getUsername()).getPassword().equals(loginRequest.getPassword())){
            userContext.login();
            userContext.setFullName(userMap.getUser(loginRequest.getUsername()).getFirstName(), userMap.getUser(loginRequest.getUsername()).getLastName());
            return "/index.xhtml?faces-redirect=true";
        }else {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("error-message", "Wrong username or password! ");
            return "/login.xhtml?faces-redirect=true";
        }
    }
}
