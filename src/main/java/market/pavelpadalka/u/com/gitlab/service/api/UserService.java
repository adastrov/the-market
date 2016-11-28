package market.pavelpadalka.u.com.gitlab.service.api;

import market.pavelpadalka.u.com.gitlab.dto.UserDTO;

public interface UserService {

    UserDTO findByLoginAndPassword(String login, String password);

    UserDTO findByLoginAndEmail(String login, String email);

    UserDTO create(UserDTO user);

    boolean delete(Integer id);

    UserDTO update(UserDTO user);

}
