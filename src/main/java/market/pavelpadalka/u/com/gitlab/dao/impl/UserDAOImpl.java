package market.pavelpadalka.u.com.gitlab.dao.impl;

import market.pavelpadalka.u.com.gitlab.dao.api.UserDAO;
import market.pavelpadalka.u.com.gitlab.datasource.InMemoryDB;
import market.pavelpadalka.u.com.gitlab.entity.User;

public class UserDAOImpl implements UserDAO {

    private static volatile UserDAO instance;
    private InMemoryDB inMemoryDB = InMemoryDB.getInstance();

    private UserDAOImpl() {
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            synchronized (UserDAOImpl.class) {
                if (instance == null)
                    instance = new UserDAOImpl();
            }
        }
        return instance;
    }

    public User findByLoginAndPassword(String login, String password) {
        return inMemoryDB.findUserByLoginAndPassword(login, password);
    }

    public User findByLoginAndEmail(String login, String email) {
        return new User();
    }

    public User create(User user) {
        return inMemoryDB.addUser(user);
    }

    public boolean delete(Integer id) {
        return true;
    }

    public User update(User user) {
        return user;
    }
}
