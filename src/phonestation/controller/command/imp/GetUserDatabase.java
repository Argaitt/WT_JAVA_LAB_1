package phonestation.controller.command.imp;

import phonestation.controller.command.Command;
import phonestation.service.ClientService;
import phonestation.service.exception.ServiceException;
import phonestation.service.factory.ServiceFactory;

public class GetUserDatabase implements Command {
    @Override
    public String execute(String request) {
        String responce = "";
        try {
            ServiceFactory serviceFactory = ServiceFactory.GetInstance();
            ClientService clientService = serviceFactory.GetClientService();
            responce = clientService.GetUsersDatabase();
        }catch (ServiceException e){
            return null;
        }
        return responce;
    }
}
