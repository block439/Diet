package pl.jazapp.app.webapp.register;

import pl.jazapp.app.UserMap;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@RequestScoped
@Named
public class RegisterController {
    @Inject
    UserMap userMap;
    public String register(RegisterRequest registerRequest){
        System.out.println(String.format("Tried to register with username: %s and password: %s", registerRequest.getUsername(), registerRequest.getPassword()));

        if(userMap.isRegistered(registerRequest.getUsername())){
            return "/register.xhtml?faces-redirect=true";
        }else{
            userMap.register(registerRequest.getUsername(),registerRequest.getPassword());
            return "/login.xhtml?faces-redirect=true";
        }


    }

}
