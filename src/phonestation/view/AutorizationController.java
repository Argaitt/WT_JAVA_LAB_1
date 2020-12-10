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
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        if (controllerResponce == null){
            out.println("access denied");
        }else {
            String[] subStr = controllerResponce.split(delimeter);
            out.print(
                    "<html>\n" +
                    "  <head>\n" +
                    "    <title>UrAccount</title>\n" +
                    "  </head>\n" +

                    "  <br>\n" +
                    "  <fieldset>\n" +
                    "  </fieldset>\n" +
                    "  <fieldset>\n" +
                    "  <form action=\"AccountController\" method=\"get\">\n" +
                    "        <input type=\"submit\" value=\"Complete\">\n" + "<br>" +
                            "        <input type=\"checkbox\" name=\"Base_functions\" value=\"\"><br>\n" +
                            "           <label for=\"Base_functions\">Base functions</label>\n" + "<br>" +
                            "        <input type=\"checkbox\" name=\"IPPhone\" value=\"\"><br>\n" +
                            "           <label for=\"IPPhone\">IPPhone</label>\n" + "<br>" +
                            "        <input type=\"checkbox\" name=\"Custom_alarm\" value=\"\"><br>\n" +
                            "           <label for=\"Custom_alarm\">Custom alarm</label>\n" + "<br>" +
                            "        <input type=\"checkbox\" name=\"Hide_number\" value=\"\"><br>\n" +
                            "           <label for=\"Hide_number\">Hide number</label>\n" + "<br>" +
                    "  </form>\n" +
                    "  <fieldset>\n" +
                            "Hi" + delimeter + subStr[0]+
                            "<br>" +
                            "Base functions" + delimeter + subStr[2] +
                            "<br>" +
                            "IPPhone" + delimeter +  subStr[3] +
                            "<br>" +
                            "Custom alarm" + delimeter +  subStr[4] +
                            "<br>" +
                            "Hide number" + delimeter + subStr[5] +
                            "<br>" +
                    "  </fieldset>\n" +
                    "</html>"
            );
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
