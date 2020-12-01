package phonestation.service.imp;

import phonestation.bean.User;
import phonestation.dao.UserDAO;
import phonestation.dao.factory.DAOFactory;
import phonestation.service.ClientService;

import phonestation.service.exception.ServiceException;

public class ClientSeviceImp implements ClientService {
    @Override
    public void SignIn(String login, String password) throws ServiceException{
        if (login == null || login.isEmpty()){
            throw new ServiceException("incorrect login");
        }
        try {
            DAOFactory daoObjectFactory = DAOFactory.GetInstance();
            UserDAO userDAO = daoObjectFactory.GetUserDAO();
            userDAO.SignIN(login, password);
        }catch (Exception e){
            throw new ServiceException(e);
        }

    }

    @Override
    public void SignOut(String login) throws ServiceException {


    }

    @Override
    public void Registration(User user) throws ServiceException {

    }
}
