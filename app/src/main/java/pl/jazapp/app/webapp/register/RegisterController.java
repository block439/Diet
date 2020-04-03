package pl.jazapp.app.webapp.register;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@RequestScoped
@Named
public class RegisterController {
    public String register(RegisterRequest registerRequest){
        System.out.println(String.format("Tried to register with username: %s and password: %s", registerRequest.getUsername(), registerRequest.getPassword()));

        return "/login.xhtml?faces-redirection=true";
    }

}
