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
    public void SignIN(String login, String password) throws DAOException {
        try {
            String url = "jdbc:mysql://localhost:3306/users?serverTimezone=Europe/Moscow&useSSL=false";
            String loginDB = "root";
            String passwordDB = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,loginDB,passwordDB);
            Statement statement = connection.createStatement();
            // тут должно быть продолжение авторизации
        } catch (ClassNotFoundException e) {
            System.out.println("error register class");
        }catch (SQLException e){
            System.out.println("DB connect error");
        }
    }

    @Override
    public void Registration(User user) throws DAOException {

    }
}
