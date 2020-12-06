package phonestation.view;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;


public class AutorizationController extends HttpServlet {
    private static final long serialVersionUID = 1l;
    public AutorizationController(){super();};

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("jsp/registration").forward(request,response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        out.println("Your login: " + login);
        out.println("Your password: " + password);
    }
}
