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
    public String Registration(User user) throws DAOException {
        try {
            String url = "jdbc:mysql://localhost:3306/lab1_wt?serverTimezone=Europe/Moscow&useSSL=false";
            String loginDB = "root";
            String passwordDB = "root";
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection connection = DriverManager.getConnection(url,loginDB,passwordDB);
            String sqlCommandSELECT = "SELECT * FROM users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCommandSELECT);
            while (resultSet.next()){
                String etalonLogin = resultSet.getString("login");
                if (!etalonLogin.equals(user.GetLogin())){
                    continue;
                }
                statement.close();
                return "this login already exixts";
            }
            statement.executeUpdate("UPDATE users SET ");
            statement.close();
            return "sucessfull registration";
        }catch (SQLException e){
            System.out.println("DB connection error");
            return null;
        }catch (ClassNotFoundException e){
            System.out.println("Class register error");
            return null;
        }
    }

    @Override
    public User ChangeSubscribes(User user) throws DAOException {
        try {
            String url = "jdbc:mysql://localhost:3306/lab1_wt?serverTimezone=Europe/Moscow&useSSL=false";
            String loginDB = "root";
            String passwordDB = "root";
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection connection = DriverManager.getConnection(url,loginDB,passwordDB);
            Statement statement = connection.createStatement();
            String sqlCommand = "UPDATE users SET baseFunctions = " + user.GetBaseFunctions() +", ipPhone = " + user.GetipPhone() + ", customAlarm = " + user.GetCustomAlarm() + ", hideNumber = " + user.GetHideNumber() + " WHERE login = '"+ user.GetLogin() +"';";
            var check = statement.executeUpdate(sqlCommand);
            if (check != 0){
                return user;
            }else{
                return null;
            }

        }catch (SQLException e){
            System.out.println("DB connection error");
            return null;
        }catch (ClassNotFoundException e){
            System.out.println("Class register error");
            return null;
        }
    }


}
