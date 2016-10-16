package Shop.pavelpadalka.u.com.gitlab.dao.impl;

import Shop.pavelpadalka.u.com.gitlab.dao.api.UserDAO;
import Shop.pavelpadalka.u.com.gitlab.entity.User;

public class UserDAOImpl implements UserDAO {

    public User findByLoginAndPassword(String login, String password) {
        return new User();
    }

    public User findByLoginAndEmail(String login, String email) {
        return new User();
    }

    public User create(User user) {
        return user;
    }

    public boolean delete(Integer id) {
        return true;
    }

    public User update(User user) {
        return user;
    }
}
