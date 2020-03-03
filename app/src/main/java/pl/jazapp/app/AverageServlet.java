package pl.jazapp.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;

@WebServlet("average")
public class AverageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        resp.setContentType("text.plain");

        var numbers = req.getParameter("numbers");
        var writer = resp.getWriter();


        if (numbers != null) {
            String[] splitedNumbers = numbers.split(",");

            double sum = 0;

            for (int i = 0; i < splitedNumbers.length; i++) {
                sum += Integer.parseInt(splitedNumbers[i]);
            }

            sum = (double) Math.round(sum / splitedNumbers.length * 100d) / 100d;

            String roundedAverage = String.valueOf(sum);
            if (roundedAverage.substring(roundedAverage.length() - 2).endsWith(".0"))
                writer.println("Average equals: " + roundedAverage.substring(0, roundedAverage.length() - 2));
            else
                writer.println("Average equals: " + roundedAverage);
        }
        else
            writer.println("Please put parameters.");

    }
}
