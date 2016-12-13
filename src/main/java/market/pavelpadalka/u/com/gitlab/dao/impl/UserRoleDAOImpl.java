package market.pavelpadalka.u.com.gitlab.dao.impl;

import market.pavelpadalka.u.com.gitlab.dao.api.UserRoleDAO;
import market.pavelpadalka.u.com.gitlab.datasource.DataSource;
import market.pavelpadalka.u.com.gitlab.dto.UserRoleDTO;
import market.pavelpadalka.u.com.gitlab.entity.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRoleDAOImpl implements UserRoleDAO {

    private static volatile UserRoleDAO instance;
    private static volatile DataSource dataSource;

    private UserRoleDAOImpl() {
    }

    public static UserRoleDAO getInstance() {
        if (instance == null) {
            synchronized (UserRoleDAOImpl.class) {
                if (instance == null)
                    instance = new UserRoleDAOImpl();
                dataSource = DataSource.getInstance();
            }
        }
        return instance;
    }

    public UserRole findByName(String name) {

        UserRole userRole = null;
        Connection connection = dataSource.createConnection();

        String findByNameQuery = "SELECT * FROM tbl_roles WHERE role_name=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findByNameQuery);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userRole = new UserRole();

                userRole.setId(resultSet.getInt("role_id"));
                userRole.setName(resultSet.getString("role_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            userRole = null;
        }

        return userRole;

    }

    public UserRole findByRoleId(Integer id) {

        UserRole userRole = null;
        Connection connection = dataSource.createConnection();

        String findByNameQuery = "SELECT * FROM tbl_roles WHERE role_id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findByNameQuery);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userRole = new UserRole();

                userRole.setId(resultSet.getInt("role_id"));
                userRole.setName(resultSet.getString("role_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            userRole = null;
        }

        return userRole;

    }

    public UserRole create(UserRole userRole) {

        Connection connection = dataSource.createConnection();

        String createUserRoleQuery = "INSERT INTO tbl_roles (role_name) VALUES (?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createUserRoleQuery);
            preparedStatement.setString(1, userRole.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            userRole = null;
        }

        return userRole;

    }

    public boolean delete(Integer id) {

        int resultCount = 0;

        Connection connection = dataSource.createConnection();

        String deleteUserQuery = "DELETE FROM tbl_roles WHERE role_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteUserQuery);
            preparedStatement.setInt(1, id);
            resultCount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultCount > 0;

    }

    public UserRole update(UserRole userRole) {

        Connection connection = dataSource.createConnection();

        String createUserRoleQuery = "UPDATE tbl_roles SET role_namw = ? WHERE role_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createUserRoleQuery);
            preparedStatement.setString(1, userRole.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            userRole = null;
        }

        return userRole;

    }

}
