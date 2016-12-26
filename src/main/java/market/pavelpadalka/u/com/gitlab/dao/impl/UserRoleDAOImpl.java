package market.pavelpadalka.u.com.gitlab.dao.impl;

import market.pavelpadalka.u.com.gitlab.dao.api.UserRoleDAO;
import market.pavelpadalka.u.com.gitlab.datasource.DataSource;
import market.pavelpadalka.u.com.gitlab.dto.UserRoleDTO;
import market.pavelpadalka.u.com.gitlab.entity.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
                userRole.setDescription(resultSet.getString("role_description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            userRole = null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return userRole;

    }

    public List<UserRole> findAll() {

        Connection connection = dataSource.createConnection();

        List<UserRole> userRoleList = new LinkedList<UserRole>();

        String findAllQuery = "SELECT * FROM tbl_roles";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findAllQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                UserRole userRole = new UserRole();

                userRole.setId(resultSet.getInt("role_id"));
                userRole.setName(resultSet.getString("role_name"));
                userRole.setDescription(resultSet.getString("role_description"));

                userRoleList.add(userRole);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return userRoleList;

    }

    public UserRole create(UserRole userRole) {

        Connection connection = dataSource.createConnection();

        String createUserRoleQuery = "INSERT INTO tbl_roles (role_name, role_description) VALUES (?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createUserRoleQuery);
            preparedStatement.setString(1, userRole.getName());
            preparedStatement.setString(2, userRole.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            userRole = null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultCount > 0;

    }

    public UserRole update(UserRole userRole) {

        Connection connection = dataSource.createConnection();

        String createUserRoleQuery = "UPDATE tbl_roles SET role_name = ?, role_description = ?  WHERE role_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createUserRoleQuery);
            preparedStatement.setString(1, userRole.getName());
            preparedStatement.setString(2, userRole.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            userRole = null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return userRole;

    }

}
