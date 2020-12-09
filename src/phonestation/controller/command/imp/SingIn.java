package phonestation.controller.command.imp;
import phonestation.GlobalVariables;
import phonestation.bean.User;
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
            User user = clientService.SignIn(login,password);
            if (user == null){
                response = null;
            }else {
                response = user.GetLogin() + delimiter + user.GetPassword() + delimiter + user.GetBaseFunctions() + delimiter +
                        user.GetipPhone() + delimiter + user.GetCustomAlarm() + delimiter + user.GetHideNumber();
            }
        }catch (ServiceException e){
            response = "error during login procedure";
        }
        return response;
    }
}
