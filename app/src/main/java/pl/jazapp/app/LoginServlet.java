package pl.jazapp.app;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.IOException;
import java.util.Map;


@WebServlet("login")
public class LoginServlet extends HttpServlet {

    @Inject
    UserContext userContext;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var writer = resp.getWriter();
        resp.setStatus(200);
        resp.setContentType("text.plain");
        writer.println(String.format("I am logged: %s", userContext.isLogged()));
        userContext.login();

    }
}
