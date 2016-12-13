package market.pavelpadalka.u.com.gitlab.service.api;

import market.pavelpadalka.u.com.gitlab.dto.UserRoleDTO;

public interface UserRoleService {

    UserRoleDTO findByName(String name);

    UserRoleDTO findByRoleId(Integer id);

    UserRoleDTO create(UserRoleDTO userRoleDTO);

    boolean delete(Integer id);

    UserRoleDTO update(UserRoleDTO userRoleDTO);

}
