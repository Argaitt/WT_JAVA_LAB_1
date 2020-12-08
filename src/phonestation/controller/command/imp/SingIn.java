package phonestation.controller.command.imp;
import phonestation.GlobalVariables;
import phonestation.controller.command.Command;
import phonestation.service.ClientService;
import phonestation.service.exception.ServiceException;
import phonestation.service.factory.ServiceFactory;

public class SingIn implements Command {
    private String delimiter = GlobalVariables.delimeter;
    @Override
    public String execute(String request) {
        String login = null;
        String password = null;
        String response = null;
        String[] subStrings = request.split(delimiter);
        ServiceFactory serviceFactory = ServiceFactory.GetInstance();
        ClientService clientService = serviceFactory.GetClientService();
        try {
            login = subStrings[1];
            password = subStrings[2];
            clientService.SignIn(login,password);
        }catch (ServiceException e){
            response = "error during login procedure";
        }
        return response;
    }
}
