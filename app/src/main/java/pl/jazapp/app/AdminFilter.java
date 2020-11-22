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

@WebFilter(urlPatterns = {"/departments/edit.xhtml", "/categories/edit.xhtml"})
public class AdminFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if(isAdmin() ){
            chain.doFilter(req,res);
        } else {
            res.sendRedirect(req.getContextPath() + "/index.xhtml");
        }

    }

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





}
