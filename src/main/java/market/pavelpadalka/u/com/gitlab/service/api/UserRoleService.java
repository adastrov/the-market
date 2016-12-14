package market.pavelpadalka.u.com.gitlab.service.api;

import market.pavelpadalka.u.com.gitlab.dto.UserRoleDTO;

import java.util.List;

public interface UserRoleService {

    UserRoleDTO findByName(String name);

    UserRoleDTO findByRoleId(Integer id);

    List<UserRoleDTO> findAll();

    UserRoleDTO create(UserRoleDTO userRoleDTO);

    boolean delete(Integer id);

    UserRoleDTO update(UserRoleDTO userRoleDTO);

}
