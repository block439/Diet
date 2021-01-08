package pl.jazapp.app;


import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;


@Named
 @SessionScoped
public class UserContext implements Serializable {
    private static final long serialVersionUID =1L;
    private String fullName;
    private String username;



    private boolean isLogged;

    public UserContext(){
    }

    public boolean isLogged(){
        return isLogged;
    }

    public void logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public void login(){
        isLogged = true;
    }

    public void setFullName(String firstName, String lastName) {
        this.fullName = firstName + " " + lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }
}
