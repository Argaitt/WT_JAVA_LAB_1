package phonestation.view;

import phonestation.GlobalVariables;
import phonestation.controller.Controller;
import phonestation.controller.factory.ControllerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static phonestation.GlobalVariables.delimeter;

public class AccountController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        var parameterNames = req.getParameterNames();
        String resultStr = "";
        resultStr += req.getParameter("login") + GlobalVariables.delimeter;
        resultStr += req.getParameter("password") + GlobalVariables.delimeter;
        if (req.getParameter("Base_functions") != null){
            resultStr += "true" + GlobalVariables.delimeter;
        }else {
            resultStr += "false" + GlobalVariables.delimeter;
        }
        if (req.getParameter("IPPhone") != null){
            resultStr += "true" + GlobalVariables.delimeter;
        }else {
            resultStr += "false" +
                    "" + GlobalVariables.delimeter;
        }
        if (req.getParameter("Custom_alarm") != null){
            resultStr += "true" + GlobalVariables.delimeter;
        }else {
            resultStr += "false" +
                    "" + GlobalVariables.delimeter;
        }
        if (req.getParameter("Hide_number") != null){
            resultStr += "true" + GlobalVariables.delimeter;
        }else {
            resultStr += "false" +
                    "" + GlobalVariables.delimeter;
        }
        String controllerReq = "CHANGE_SUBSCRIBE" + GlobalVariables.delimeter + resultStr;
        ControllerFactory controllerFactory = ControllerFactory.GetInstance();
        Controller controller = controllerFactory.GetController();
        String controllerResponce = controller.ExexuteTesk(controllerReq);
        resp.setContentType("text/html");
        java.io.PrintWriter out = resp.getWriter();
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
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
