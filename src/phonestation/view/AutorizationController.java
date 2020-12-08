package phonestation.view;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;

import phonestation.controller.Controller;
import phonestation.controller.factory.ControllerFactory;
import phonestation.dao.factory.DAOFactory;

public class AutorizationController extends HttpServlet {
    private static final long serialVersionUID = 1l;
    public AutorizationController(){super();};

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String command = "SIGN_IN " + login + " " + password;
        ControllerFactory controllerFactory = ControllerFactory.GetInstance();
        Controller controller = controllerFactory.GetController();
        String controllerResponce = controller.ExexuteTesk(command);
        java.io.PrintWriter out = response.getWriter();
        out.println(controllerResponce);
    }

    protected void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

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
