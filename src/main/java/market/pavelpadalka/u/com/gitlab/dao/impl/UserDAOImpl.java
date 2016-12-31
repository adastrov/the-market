package market.pavelpadalka.u.com.gitlab.dao.impl;

import market.pavelpadalka.u.com.gitlab.dao.api.UserDAO;
import market.pavelpadalka.u.com.gitlab.datasource.DataSource;
import market.pavelpadalka.u.com.gitlab.dto.UserRoleDTO;
import market.pavelpadalka.u.com.gitlab.entity.User;
import market.pavelpadalka.u.com.gitlab.entity.UserSex;
import market.pavelpadalka.u.com.gitlab.service.api.UserRoleService;
import market.pavelpadalka.u.com.gitlab.service.impl.UserRoleServiceImpl;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static volatile UserDAO instance;
    private static volatile DataSource dataSource;
    private static volatile UserRoleService userRoleService;

    private UserDAOImpl() {
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            synchronized (UserDAOImpl.class) {
                if (instance == null)
                    instance = new UserDAOImpl();
                dataSource = DataSource.getInstance();
                userRoleService = UserRoleServiceImpl.getInstance();
            }
        }
        return instance;
    }

    public User findByLoginAndPassword(String login, String password) {

        User user = null;
        Connection connection = dataSource.createConnection();

        String findByLoginAndPasswordQuery = "SELECT * FROM tbl_users LEFT JOIN tbl_roles on tbl_roles.role_id = tbl_users.user_role_id WHERE user_login=? and user_password=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findByLoginAndPasswordQuery);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                setDefaultUserFields(user, resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            user = null;
        } finally {
            closeConnection(connection);
        }

        return user;

    }

    public User findByLoginAndEmail(String login, String email) {

        User user = null;
        Connection connection = dataSource.createConnection();

        String findByLoginAndEmailQuery = "SELECT * FROM tbl_users LEFT JOIN tbl_roles on tbl_roles.role_id = tbl_users.user_role_id WHERE user_login=? and user_email=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findByLoginAndEmailQuery);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                setDefaultUserFields(user, resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            user = null;
        } finally {
            closeConnection(connection);
        }

        return user;

    }

    public User findById(Integer id) {

        User user = null;
        Connection connection = dataSource.createConnection();

        String findByLoginAndPasswordQuery = "SELECT * FROM tbl_users LEFT JOIN tbl_roles on tbl_roles.role_id = tbl_users.user_role_id WHERE user_id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findByLoginAndPasswordQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                setDefaultUserFields(user, resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            user = null;
        } finally {
            closeConnection(connection);
        }

        return user;

    }

    public List<User> findAll() {

        Connection connection = dataSource.createConnection();

        List<User> userList = new LinkedList<User>();

        String findAllQuery = "SELECT * FROM tbl_users LEFT JOIN tbl_roles on tbl_roles.role_id = tbl_users.user_role_id ORDER BY tbl_users.user_id";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findAllQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                User user = new User();

                setDefaultUserFields(user, resultSet);

                userList.add(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }

        return userList;

    }

    public User create(User user) {

        Connection connection = dataSource.createConnection();

        String createUserQuery = "INSERT INTO tbl_users (user_login, user_password, user_email, user_first_name, user_last_name, user_birthday, user_sex, user_role_id) VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createUserQuery);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setDate(6, user.getBirthday());
            preparedStatement.setString(7, user.getSex().toString());
            preparedStatement.setInt(8, user.getRole().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            user = null;
        } finally {
            closeConnection(connection);
        }

        return user;

    }

    public User update(User user) {

        Connection connection = dataSource.createConnection();

        String updateUserQuery = "UPDATE tbl_users SET user_login = ?, user_password = ?, user_email = ?, user_first_name = ?, user_last_name = ?, user_birthday = ?, user_sex = ?, user_role_id = ? WHERE user_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateUserQuery);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setDate(6, user.getBirthday());
            preparedStatement.setString(7, user.getSex().toString());
            preparedStatement.setInt(8, user.getRole().getId());
            preparedStatement.setInt(9, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            user = null;
        } finally {
            closeConnection(connection);
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
        } finally {
            closeConnection(connection);
        }

        return resultCount > 0;

    }

    private void setDefaultUserFields(User user, ResultSet resultSet) throws SQLException {

        user.setId(resultSet.getInt("user_id"));

        user.setLogin(resultSet.getString("user_login"));
        user.setPassword(resultSet.getString("user_password"));
        user.setEmail(resultSet.getString("user_email"));

        user.setFirstName(resultSet.getString("user_first_name"));
        user.setLastName(resultSet.getString("user_last_name"));
        user.setBirthday(resultSet.getDate("user_birthday"));

        user.setSex(resultSet.getString("user_sex").toLowerCase().equals("male") ? UserSex.MALE : UserSex.FEMALE);

        UserRoleDTO userRoleDTO = new UserRoleDTO();
        userRoleDTO.setId(resultSet.getInt("role_id"));
        userRoleDTO.setName(resultSet.getString("role_name"));
        userRoleDTO.setDescription(resultSet.getString("role_description"));

        user.setRole(userRoleDTO);

    }

    private void closeConnection(Connection connection) {

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
