package phonestation.dao.factory;
import phonestation.dao.UserDAO;
import phonestation.dao.imp.SQLUserDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final UserDAO sqlUserImp = new SQLUserDAO();
    private DAOFactory(){};
    public static DAOFactory GetInstance(){
        return instance;
    }
    public UserDAO GetUserDAO(){
        return sqlUserImp;
    }
}
