package phonestation.service;
import phonestation.bean.User;
import phonestation.service.exception.ServiceException;

import javax.servlet.ServletException;

public interface ClientService {
    User SignIn(String login, String Password) throws ServiceException;
    void SignOut(String login) throws ServiceException;
    void Registration(User user) throws ServiceException;
    User ChangeSubscribe(String reques) throws ServiceException;
    String GetUsersDatabase() throws  ServiceException;
}
