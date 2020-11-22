package pl.jazapp.app.webapp.logout;


import pl.jazapp.app.UserContext;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;



@Named
@RequestScoped
public class LogoutController{
    @Inject UserContext userContext;

    public String logout(){
        userContext.logout();
        return "/login.xhtml?faces-redirect=true";
    }

}
