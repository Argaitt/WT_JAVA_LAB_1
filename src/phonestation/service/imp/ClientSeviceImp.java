package phonestation.service.imp;

import phonestation.bean.User;
import phonestation.dao.UserDAO;
import phonestation.dao.factory.DAOFactory;
import phonestation.service.ClientService;

import phonestation.service.exception.ServiceException;

import java.util.regex.Pattern;

public class ClientSeviceImp implements ClientService {
    @Override
    public User SignIn(String login, String password) throws ServiceException{
        if (login == null || login.isEmpty()){
            throw new ServiceException("incorrect login");
        }
        try {
            DAOFactory daoObjectFactory = DAOFactory.GetInstance();
            UserDAO userDAO = daoObjectFactory.GetUserDAO();
            User user = userDAO.SignIN(login, password);
            if (user == null){
                return null;
            }else {
                if (user.GetPassword().equals(password)){
                    return user;
                }else {
                    return null;
                }
            }
        }catch (Exception e){
            throw new ServiceException(e);
        }

    }

    @Override
    public void SignOut(String login) throws ServiceException {


    }

    @Override
    public void Registration(User user) throws ServiceException {
        if (user.GetLogin() == null || user.GetLogin().isEmpty() || user.GetPassword() == null || user.GetPassword().isEmpty()){
            throw new ServiceException("login or password is empty");
        }
        String pattern = "^[A-Za-z]([.A-Za-z0-9-]{1,18})([A-Za-z0-9])$";
        if (!Pattern.matches(pattern, user.GetLogin())){
            throw new ServiceException("invalid login");
        }
        if (!Pattern.matches(pattern, user.GetPassword())){
            throw new ServiceException("invalid password");
        }
        try {
            DAOFactory daoObjectFactory = DAOFactory.GetInstance();
            UserDAO userDAO = daoObjectFactory.GetUserDAO();
            userDAO.Registration(user);
        }catch (Exception e){
            throw new ServiceException(e);
        }
    }
}
