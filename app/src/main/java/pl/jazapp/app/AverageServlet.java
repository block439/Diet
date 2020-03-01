package pl.jazapp.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("average")
public class AverageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        resp.setContentType("text.plain");

        var numbers = req.getParameter("numbers");
        String[] numberSplit = numbers.split(",");
        float sum = 0;
        for (int i=0; i<numberSplit.length;i++){
            sum += Integer.parseInt(numberSplit[i]);
        }
        float avg = sum/numberSplit.length;
//liczby przeliczaja sie na floata trzeba to jeszcze wysplitowac w przypadku 0 na koncu liczby.

        var writer = resp.getWriter();

        writer.println("I got numbers '"+numbers+"'"+sum+" "+avg);
    }
}
