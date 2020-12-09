package phonestation.dao;
import phonestation.bean.User;
import phonestation.dao.exception.DAOException;


public interface UserDAO {
    User SignIN(String login, String password) throws DAOException;
    String Registration(User user) throws DAOException;
}
