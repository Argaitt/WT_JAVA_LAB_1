package phonestation.view;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;

import phonestation.controller.Controller;
import phonestation.controller.factory.ControllerFactory;


import static phonestation.GlobalVariables.delimeter;

public class AutorizationController extends HttpServlet {
    private static final long serialVersionUID = 1l;
    public AutorizationController(){super();};

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String command = "SIGN_IN" + delimeter + login + delimeter + password;
        ControllerFactory controllerFactory = ControllerFactory.GetInstance();
        Controller controller = controllerFactory.GetController();
        String controllerResponce = controller.ExexuteTesk(command);
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        if (controllerResponce == null){
            out.println("access denied");
            return;
        }
        String[] subStr = controllerResponce.split(delimeter);
        if (subStr[6].equals("false")){
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
                            "<input type=\"text\" name=\"login\" value=\"\"><br>" +
                            "enter password: <br>" +
                            "<input type=\"password\" name=\"password\" value=\"\"><br>" +
                            "        <input type=\"checkbox\" name=\"Base_functions\" value=\"\"><br>\n" +
                            "           <label for=\"Base_functions\">Base functions</label>\n" + "<br>" +
                            "        <input type=\"checkbox\" name=\"IPPhone\" value=\"\"><br>\n" +
                            "           <label for=\"IPPhone\">IPPhone</label>\n" + "<br>" +
                            "        <input type=\"checkbox\" name=\"Custom_alarm\" value=\"\"><br>\n" +
                            "           <label for=\"Custom_alarm\">Custom alarm</label>\n" + "<br>" +
                            "        <input type=\"checkbox\" name=\"Hide_number\" value=\"\"><br>\n" +
                            "           <label for=\"Hide_number\">Hide number</label>\n" + "<br>" +
                            "        <input type=\"submit\" value=\"Complete\">\n" + "<br>" +
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
        } else{
            command = "GET_USER_DATABASE ";
            String userDatabase = controller.ExexuteTesk(command);
            out.println("Hellow administrator! Just BAN SOMEBODY MYHAHAHHAHAHHAHAHAH!!!!!!");
            out.print(
                    "<html>\n" +
                    "  <head>\n" +
                    "    <title>UrAccount</title>\n" +
                    "  </head>\n"
            );
            String[] users = userDatabase.split("\n");
            for (int i =0; i< users.length; i++){
                String[] userData = users[i].split(delimeter);
                out.println("<form action=\"AccountController\" method=\"get\">\n");
                out.println("<Label"+ i +">" + userData[0] + delimeter + userData[1] + delimeter +userData[2] + delimeter +userData[3] + delimeter +userData[4] + delimeter + userData[5] + "</Label>");
                out.println("<input type=\"submit\" name=\"Ban\" value=\"BAN\">");
                out.println("</form>\n");
            }
            out.print("</html>"
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
