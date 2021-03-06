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


    public boolean contains(String name) {
            return req.getParameter(name) != null;
    }

    public Long getParameterAsLong(String name){
        var value = req.getParameter(name);
        return Long.parseLong(value);
    }
}
