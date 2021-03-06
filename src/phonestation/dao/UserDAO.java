package phonestation.dao;
import phonestation.bean.User;
import phonestation.dao.exception.DAOException;

import java.util.ArrayList;


public interface UserDAO {
    User SignIN(String login, String password) throws DAOException;
    String Registration(User user) throws DAOException;
    User ChangeSubscribes(User user) throws DAOException;
    ArrayList<User> GetUsersDatabase() throws Exception;
}
