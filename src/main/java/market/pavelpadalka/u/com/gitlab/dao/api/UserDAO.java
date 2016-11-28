package market.pavelpadalka.u.com.gitlab.dao.api;

import market.pavelpadalka.u.com.gitlab.entity.User;

public interface UserDAO {

    User findByLoginAndPassword(String login, String password);
    User findByLoginAndEmail(String login, String email);

    User    create(User user);
    boolean delete(Integer id);
    User    update(User user);

}
