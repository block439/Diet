package pl.jazapp.app.webapp.register;

import pl.jazapp.app.users.UserCreatorService;
import pl.jazapp.app.users.UserSearchService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@RequestScoped
@Named
public class RegisterController {

    @Inject
    UserCreatorService userCreator;

    @Inject
    UserSearchService searchService;

    public String register(RegisterRequest registerRequest){
        System.out.println(String.format("Tried to register with username: %s and password: %s", registerRequest.getUsername(), registerRequest.getPassword()));


        if(searchService.findUser(registerRequest.getUsername()).isPresent()){
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("username_taken", "Username is already taken");
            return "/register.xhtml?faces-redirect=true";
        }
        else if (!registerRequest.getPassword().equals(registerRequest.getCheckPassword())){
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("password_error", "Passwords did not match!");
            return "/register.xhtml?faces-redirect=false";
        }else{
            userCreator.createUser(registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getFirstName(), registerRequest.getLastName(), registerRequest.getMail(), registerRequest.getBirthdate());
            return "/login.xhtml?faces-redirect=true";
        }

    }





}
