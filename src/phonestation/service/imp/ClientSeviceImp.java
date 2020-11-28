package phonestation.service.imp;

import phonestation.bean.User;
import phonestation.dao.UserDAO;
import phonestation.dao.factory.DAOFactory;
import phonestation.service.ClientService;

public class ClientSeviceImp implements ClientService {
    @Override
    public void SignIn(String login, String password) {
        DAOFactory daoObjectFactory = DAOFactory.GetInstance();
        UserDAO userDAO = daoObjectFactory.GetUserDAO();
        userDAO.SignIN(login, password);
    }

    @Override
    public void SignOut(String login) {


    }

    @Override
    public void Registration(User user) {

    }
}
