package phonestation.controller.command.imp;

import phonestation.GlobalVariables;
import phonestation.bean.User;
import phonestation.controller.command.Command;
import phonestation.service.ClientService;
import phonestation.service.factory.ServiceFactory;
import phonestation.service.exception.ServiceException;

import javax.servlet.ServletException;

public class ChangeSubscribe implements Command {
    private String delimiter = GlobalVariables.delimeter;
    @Override
    public String execute(String request) {
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.GetInstance();
        ClientService clientService = serviceFactory.GetClientService();
        String resp = "";
        User user = new User();
        try {
            request = request.substring(request.indexOf(GlobalVariables.delimeter)+1);
            user = clientService.ChangeSubscribe(request);
            if (user == null){
                response = null;
            }else {
                response = user.GetLogin() + delimiter + user.GetPassword() + delimiter + user.GetBaseFunctions() + delimiter +
                        user.GetipPhone() + delimiter + user.GetCustomAlarm() + delimiter + user.GetHideNumber();
            }
            return response;
        }catch (ServiceException e){
            return null;
        }
    }
}
