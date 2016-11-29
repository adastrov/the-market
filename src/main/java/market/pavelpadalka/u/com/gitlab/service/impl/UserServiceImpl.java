package market.pavelpadalka.u.com.gitlab.service.impl;

import market.pavelpadalka.u.com.gitlab.dao.api.UserDAO;
import market.pavelpadalka.u.com.gitlab.dao.impl.UserDAOImpl;
import market.pavelpadalka.u.com.gitlab.dto.UserDTO;
import market.pavelpadalka.u.com.gitlab.entity.User;
import market.pavelpadalka.u.com.gitlab.helper.Transformer;
import market.pavelpadalka.u.com.gitlab.service.api.UserService;

public class UserServiceImpl implements UserService {

    private static volatile UserService instance;
    private UserDAO userDAO = UserDAOImpl.getInstance();

    private UserServiceImpl() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            synchronized (UserServiceImpl.class) {
                if (instance == null)
                    instance = new UserServiceImpl();
            }
        }
        return instance;
    }

    public UserDTO findByLoginAndPassword(String login, String password) {

        UserDTO userResDTO = null;

        User user = userDAO.findByLoginAndPassword(login, password);
        if (user != null) {
            userResDTO = Transformer.transformUserToUserDTO(user);
        }

        return userResDTO;
    }

    public UserDTO findByLoginAndEmail(String login, String email) {

        UserDTO userResDTO = null;

        User user = userDAO.findByLoginAndEmail(login, email);
        if (user != null) {
            userResDTO = Transformer.transformUserToUserDTO(user);
        }

        return userResDTO;

    }

    public UserDTO create(UserDTO userDTO) {

        UserDTO resUserDto = null;
        User user = Transformer.transformUserDTOToUser(userDTO);
        User createdUser = userDAO.create(user);

        if (createdUser != null) {
            resUserDto = Transformer.transformUserToUserDTO(createdUser);
        }

        return resUserDto;
    }

    public boolean delete(Integer id) {

        return userDAO.delete(id);

    }

    public UserDTO update(UserDTO userDTO) {

        UserDTO resUserDto = null;
        User updatedUser = userDAO.update(Transformer.transformUserDTOToUser(userDTO));

        if (updatedUser != null) {
            resUserDto = Transformer.transformUserToUserDTO(updatedUser);
        }

        return resUserDto;

    }
}
