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
        String[] splitedNumbers = numbers.split(",");
        double sum = 0;
        for (int i=0; i<splitedNumbers.length;i++){
            sum += Integer.parseInt(splitedNumbers[i]);
        }
        double avg = sum/splitedNumbers.length;

        var writer = resp.getWriter();

        //do rozwiązania opcja z nullem i skrócenie formatowania dla 1.3333 np
        String roundedAverage = String.valueOf(avg);
        if(".0".equals(roundedAverage.substring(roundedAverage.length()-2)))
           writer.println("sub " + roundedAverage.substring(0,roundedAverage.length()-2));
        else if(numbers == null)
            writer.println("pusto");
        else
            writer.println("zwykla "+ roundedAverage);

    }
}
