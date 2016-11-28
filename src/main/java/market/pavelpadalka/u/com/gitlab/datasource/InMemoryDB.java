package market.pavelpadalka.u.com.gitlab.datasource;

import market.pavelpadalka.u.com.gitlab.entity.User;

import java.util.LinkedList;
import java.util.List;

public class InMemoryDB {

    private static Integer userCount = 0;

    private List<User> users = new LinkedList();
    private static volatile InMemoryDB instance;

    private InMemoryDB() {
    }

    public static InMemoryDB getInstance() {
        if (instance == null) {
            synchronized (InMemoryDB.class) {
                if (instance == null)
                    instance = new InMemoryDB();
            }
        }
        return instance;
    }

    public User findUserByLoginAndPassword(String login, String password) {
        User userRes = null;

        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                userRes = user;
            }
        }
        return userRes;
    }

    public synchronized User addUser(User user) {

        User userRes = null;

        if (!users.contains(user)) {

            user.setId(userCount);
            users.add(user);
            userRes = user;

            ++userCount;
        }

        return userRes;
    }
}
