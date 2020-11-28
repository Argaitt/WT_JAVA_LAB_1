package phonestation.dao;
import phonestation.bean.User;


public interface UserDAO {
    void SignIN(String login, String password);
    void Registration(User user);
}
