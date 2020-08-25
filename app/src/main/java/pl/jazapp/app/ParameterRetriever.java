package pl.jazapp.app;

import pl.jazapp.app.users.UserSearchService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ApplicationScoped
public class ParameterRetriever {

    @Inject
    HttpServletRequest req;
    @Inject
    UserContext userContext;
    @Inject
    UserSearchService userSearchService;

    private boolean isAdmin(){
        var username = userContext.getUsername();
        var role = userSearchService.findUser(username).get().getRole();
        if(role.equals("ADMIN"))
        {
            return true;
        } else return false;
    }

    public boolean contains(String name) {
        if(isAdmin()) {
            return req.getParameter(name) != null;
        }else return false;
    }

    public Long getParameterAsLong(String name){
        var value = req.getParameter(name);
        return Long.parseLong(value);
    }
}
