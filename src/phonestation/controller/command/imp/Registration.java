package phonestation.controller.command.imp;

import phonestation.GlobalVariables;
import phonestation.controller.command.Command;
import phonestation.service.ClientService;
import phonestation.service.exception.ServiceException;
import phonestation.service.factory.ServiceFactory;
import phonestation.bean.User;

public class Registration implements Command {
    @Override
    public String execute(String request) {
        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.GetInstance();
        ClientService clientService = serviceFactory.GetClientService();
        try {
            String[] subStrings = request.split(GlobalVariables.delimeter);
            User user = new User();
            user.SetLogin(subStrings[1]);
            user.SetPassword(subStrings[2]);
            clientService.Registration(user);
        }catch (ServiceException e){
            response = "error during registration procedure";
        }
        return response;
    }
}
