package pl.tul;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Winiu on 13-04-2016.
 */
@WebServlet(name = "HelloWorld")
public class HelloServet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "index.jsp";
        try{
            RequestDispatcher rd=request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
