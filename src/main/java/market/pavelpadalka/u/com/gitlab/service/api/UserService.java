package market.pavelpadalka.u.com.gitlab.service.api;

import market.pavelpadalka.u.com.gitlab.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO findByLoginAndPassword(String login, String password);

    UserDTO findByLoginAndEmail(String login, String email);

    UserDTO findById(Integer id);

    List<UserDTO> findAll();

    UserDTO create(UserDTO user);

    boolean delete(Integer id);

    UserDTO update(UserDTO user);

}
