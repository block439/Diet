package pl.jazapp.app.webapp.login;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.jazapp.app.UserContext;
import pl.jazapp.app.users.UserSearchService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@RequestScoped
@Named
public class LoginController  {

    @Inject
    UserSearchService searchService;

    @Inject
    UserContext userContext;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public boolean isPasswordCorrect(String password, String username) {
        return passwordEncoder.matches(password, searchService.findUser(username).get().getPassword());
    }
    public String login(LoginRequest loginRequest) {
        System.out.println(String.format("Tried to login with username: %s an password: %s", loginRequest.getUsername(), loginRequest.getPassword()));
        if (searchService.findUser(loginRequest.getUsername()).isPresent()) {
            if (searchService.findUser(loginRequest.getUsername()).get().getUsername().equals(loginRequest.getUsername()) &&
                    isPasswordCorrect(loginRequest.getPassword(), loginRequest.getUsername())) {
                userContext.login();
                userContext.setFullName(searchService.findUser(loginRequest.getUsername()).get().getFirst_name(), searchService.findUser(loginRequest.getUsername()).get().getLast_name());
                return "/index.xhtml?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().getExternalContext().getFlash().put("error-message", "Wrong username or password! ");
                return "/login.xhtml?faces-redirect=true";
            }
        }else {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("error-message", "Wrong username or password! ");
            return "/login.xhtml?faces-redirect=true";
        }
    }
}
