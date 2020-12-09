package phonestation.dao.imp;

import phonestation.bean.User;
import phonestation.dao.UserDAO;
import phonestation.dao.exception.DAOException;

import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

public class SQLUserDAO implements UserDAO {
    @Override
    public User SignIN(String login, String password) throws DAOException {
        try {
            String url = "jdbc:mysql://localhost:3306/lab1_wt?serverTimezone=Europe/Moscow&useSSL=false";
            String loginDB = "root";
            String passwordDB = "root";
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection connection = DriverManager.getConnection(url,loginDB,passwordDB);
            Statement statement = connection.createStatement();
            String sqlCommand = "SELECT * FROM users";
            User user = new User();
            ResultSet resultSet = statement.executeQuery(sqlCommand);
            while (resultSet.next()){
                String etalonLogin = resultSet.getString("login");
                if (!etalonLogin.equals(login)){
                    continue;
                }
                user.SetLogin(etalonLogin);
                user.SetPassword(resultSet.getString("password"));
                user.SetBaseFunctions(resultSet.getBoolean("baseFunctions"));
                user.SetCustomAlarm(resultSet.getBoolean("customAlarm"));
                user.SetHideNumber(resultSet.getBoolean("hideNumber"));
                user.SetipPhone(resultSet.getBoolean("ipPhone"));
                statement.close();
                return user;
            }
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("error register class");
            return null;
        }catch (SQLException e){
            System.out.println("DB connect error");
            return null;
        }
    }

    @Override
    public void Registration(User user) throws DAOException {
        try {
            String url = "jdbc:mysql://localhost:3306/lab1_wt?serverTimezone=Europe/Moscow&useSSL=false";
            String loginDB = "root";
            String passwordDB = "root";
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection connection = DriverManager.getConnection(url,loginDB,passwordDB);
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT users(login, password) VALUES ('testlogin', 'testpassword')");

        }catch (SQLException e){
            System.out.println("DB connection error");
        }catch (ClassNotFoundException e){
            System.out.println("Class register error");
        }
    }
}
