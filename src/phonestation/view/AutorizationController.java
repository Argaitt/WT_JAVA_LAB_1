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
import phonestation.GlobalVariables;

import static phonestation.GlobalVariables.delimeter;

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
        if (controllerResponce == null){
            out.println("access denied");
        }else {
            String[] subStr = controllerResponce.split(delimeter);
            out.println("Hi" + delimeter + subStr[0]);
            out.println("Base functions" + delimeter + subStr[2]);
            out.println("IPPhone" + delimeter +  subStr[3]);
            out.println("Custom alarm" + delimeter +  subStr[4]);
            out.println("Hide number" + delimeter + subStr[5]);
        }

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
