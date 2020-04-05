package pl.jazapp.app;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*")
public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if(isUserLogged() || isSiteAllowed(req)){
            chain.doFilter(req,res);
        } else {
            res.sendRedirect(req.getContextPath()+"/login.xhtml");
        }

    }

    private boolean isSiteAllowed(HttpServletRequest req) {
        return "/login.xhtml".equals(req.getServletPath())
                || "/register.xhtml".equals(req.getServletPath());
    }

    @Inject
    UserContext userContext;

    private boolean isUserLogged() {
        if(userContext.isLogged()){
            return true;}
        else{
            return false;
        }
    }


}
