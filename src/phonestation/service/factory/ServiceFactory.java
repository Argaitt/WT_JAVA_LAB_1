package phonestation.service.factory;

import phonestation.service.ClientService;
import phonestation.service.imp.ClientSeviceImp;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ClientService clientService = new ClientSeviceImp();
    private ServiceFactory(){};
    public static ServiceFactory GetInstance(){
        return instance;
    }
    public ClientService GetClientService(){
        return clientService;
    }
}
