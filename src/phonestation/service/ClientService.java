package phonestation.service;
import phonestation.bean.User;

public interface ClientService {
    void SignIn(String login, String Password);
    void SignOut(String login);
    void Registration(User user);
}
