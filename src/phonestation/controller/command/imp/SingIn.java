package phonestation.controller.command.imp;
import phonestation.controller.command.Command;
import phonestation.service.ClientService;
import phonestation.service.exception.ServiceException;
import phonestation.service.factory.ServiceFactory;

public class SingIn implements Command {
    @Override
    public String execute(String request) {
        String login = null;
        String password = null;
        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.GetInstance();
        ClientService clientService = serviceFactory.GetClientService();
        try {
            clientService.SignIn(login,password);
        }catch (ServiceException e){
            response = "error during login procedure";
        }
        return response;
    }
}
