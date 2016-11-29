package market.pavelpadalka.u.com.gitlab.dao.impl;

import market.pavelpadalka.u.com.gitlab.dao.api.UserDAO;
import market.pavelpadalka.u.com.gitlab.datasource.DataSource;
import market.pavelpadalka.u.com.gitlab.entity.User;

import java.sql.*;

public class UserDAOImpl implements UserDAO {

    private static volatile UserDAO instance;
    private static volatile DataSource dataSource;

    private UserDAOImpl() {
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            synchronized (UserDAOImpl.class) {
                if (instance == null)
                    instance = new UserDAOImpl();
                    dataSource = DataSource.getInstance();
            }
        }
        return instance;
    }

    public User findByLoginAndPassword(String login, String password) {

        User user = null;
        Connection connection = dataSource.createConnection();

        String findByLoginAndPasswordQuery = "SELECT * FROM tbl_users WHERE user_login=? and user_password=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findByLoginAndPasswordQuery);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();

                user.setId(resultSet.getInt("user_id"));
                user.setLogin(resultSet.getString("user_login"));
                user.setPassword(resultSet.getString("user_password"));
                user.setEmail(resultSet.getString("user_email"));

                user.setFirstName(resultSet.getString("user_first_name"));
                user.setLastName(resultSet.getString("user_last_name"));
                user.setBirthday(resultSet.getDate("user_birthday"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

    public User findByLoginAndEmail(String login, String email) {

        User user = null;
        Connection connection = dataSource.createConnection();

        String findByLoginAndEmailQuery = "SELECT * FROM tbl_users WHERE user_login=? and user_email=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findByLoginAndEmailQuery);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                user = new User();
                user.setId(resultSet.getInt("user_id"));

                user.setLogin(resultSet.getString("user_login"));
                user.setPassword(resultSet.getString("user_password"));
                user.setEmail(resultSet.getString("user_email"));

                user.setFirstName(resultSet.getString("user_first_name"));
                user.setLastName(resultSet.getString("user_last_name"));
                user.setBirthday(resultSet.getDate("user_birthday"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

    public User create(User user) {

        Connection connection = dataSource.createConnection();

        String createUserQuery = "INSERT INTO tbl_users (user_login, user_password, user_email, user_firstName, user_lastName, user_birthday) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createUserQuery);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setDate(6,   user.getBirthday());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

    public User update(User user) {

        Connection connection = dataSource.createConnection();

        String updateUserQuery = "UPDATE tbl_users SET user_login = ?, user_password = ?, user_email = ?, user_first_name = ?, user_last_name = ?, user_birthday = ? WHERE user_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateUserQuery);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setDate(6,   user.getBirthday());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

    public boolean delete(Integer id) {

        int resultCount = 0;

        Connection connection = dataSource.createConnection();

        String deleteUserQuery = "DELETE FROM tbl_users WHERE user_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteUserQuery);
            preparedStatement.setInt(1, id);
            resultCount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultCount > 0;

    }

}
