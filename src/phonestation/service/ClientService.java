package phonestation.service;
import phonestation.bean.User;
import phonestation.service.exception.ServiceException;

public interface ClientService {
    void SignIn(String login, String Password) throws ServiceException;
    void SignOut(String login) throws ServiceException;
    void Registration(User user) throws ServiceException;
}
