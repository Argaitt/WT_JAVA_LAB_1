package phonestation.view;

import phonestation.controller.Controller;
import phonestation.controller.factory.ControllerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;

public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1l;
    public RegistrationController(){super();};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String command = "REGISTRATION " + login + " " + password;
        ControllerFactory controllerFactory = ControllerFactory.GetInstance();
        Controller controller = controllerFactory.GetController();
        String controllerResponce = controller.ExexuteTesk(command);
        resp.setContentType("text/html");
        java.io.PrintWriter out = resp.getWriter();
        if (controllerResponce == null){
            out.println("this login is already exists");
        }else{
            out.println("registrations sucessfull");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
