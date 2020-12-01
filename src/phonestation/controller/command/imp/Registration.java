package phonestation.controller.command.imp;

import phonestation.controller.command.Command;
import phonestation.service.ClientService;
import phonestation.service.exception.ServiceException;
import phonestation.service.factory.ServiceFactory;
import phonestation.bean.User;

public class Registration implements Command {
    @Override
    public String execute(String request) {
        String login = null;
        String password = null;
        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.GetInstance();
        ClientService clientService = serviceFactory.GetClientService();
        try {
            User user = new User();
            user.SetLogin(login);
            user.SetPassword(password);
            clientService.Registration(user);
        }catch (ServiceException e){
            response = "error during registration procedure";
        }
        return response;
    }
}
