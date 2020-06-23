package pl.jazapp.app;


import jdk.swing.interop.SwingInterOpUtils;
import pl.jazapp.app.webapp.login.LoginRequest;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.Session;
import javax.servlet.SessionCookieConfig;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthOptionPaneUI;
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


    public String getFullName() {
        return fullName;
    }
}
