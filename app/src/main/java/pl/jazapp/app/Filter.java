package pl.jazapp.app;

import pl.jazapp.app.users.UserSearchService;

import javax.faces.application.ResourceHandler;
import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*")
public class Filter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if(isUserLogged() || isSiteAllowed(req) || isResource(req)){
            chain.doFilter(req,res);
        } else {
            res.sendRedirect(req.getContextPath() + "/login.xhtml");
        }

    }



    private boolean isSiteAllowed(HttpServletRequest req) {
        return "/login.xhtml".equals(req.getServletPath())
                || "/register.xhtml".equals(req.getServletPath())
                || ("/index.xhtml").equals(req.getServletPath());
    }

    private boolean isResource(HttpServletRequest req){
        return req.getRequestURI().startsWith(req.getContextPath()+ ResourceHandler.RESOURCE_IDENTIFIER+"/");
    }
    
    @Inject
    UserContext userContext;

    private boolean isUserLogged() {
        return userContext.isLogged();
    }




}
