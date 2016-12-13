package market.pavelpadalka.u.com.gitlab.service.impl;

import market.pavelpadalka.u.com.gitlab.dao.api.UserRoleDAO;
import market.pavelpadalka.u.com.gitlab.dao.impl.UserRoleDAOImpl;
import market.pavelpadalka.u.com.gitlab.dto.UserRoleDTO;
import market.pavelpadalka.u.com.gitlab.entity.UserRole;
import market.pavelpadalka.u.com.gitlab.helper.Transformer;
import market.pavelpadalka.u.com.gitlab.service.api.UserRoleService;

public class UserRoleServiceImpl implements UserRoleService{

    private static volatile UserRoleService instance;
    private UserRoleDAO userRoleDAO = UserRoleDAOImpl.getInstance();

    private UserRoleServiceImpl() {
    }

    public static UserRoleService getInstance() {
        if (instance == null) {
            synchronized (UserRoleServiceImpl.class) {
                if (instance == null)
                    instance = new UserRoleServiceImpl();
            }
        }
        return instance;
    }

    public UserRoleDTO findByName(String name) {

        UserRoleDTO userRoleResDTO = null;

        UserRole userRole = userRoleDAO.findByName(name);
        if (userRole != null) {
            userRoleResDTO = Transformer.transformUserRoleToUserRoleDTO(userRole);
        }

        return userRoleResDTO;

    }

    public UserRoleDTO findByRoleId(Integer id) {

        UserRoleDTO userRoleResDTO = null;

        UserRole userRole = userRoleDAO.findByRoleId(id);
        if (userRole != null) {
            userRoleResDTO = Transformer.transformUserRoleToUserRoleDTO(userRole);
        }

        return userRoleResDTO;

    }

    public UserRoleDTO create(UserRoleDTO userRoleDTO) {

        UserRoleDTO resUserRoleDto = null;
        UserRole userRole = Transformer.transformUserRoleDTOToUserRole(userRoleDTO);
        UserRole createdUserRole = userRoleDAO.create(userRole);

        if (createdUserRole != null) {
            resUserRoleDto = Transformer.transformUserRoleToUserRoleDTO(createdUserRole);
        }

        return resUserRoleDto;

    }

    public boolean delete(Integer id) {

        return userRoleDAO.delete(id);

    }

    public UserRoleDTO update(UserRoleDTO userRoleDTO) {

        UserRoleDTO resUserRoleDto = null;
        UserRole updatedUserRole = userRoleDAO.update(Transformer.transformUserRoleDTOToUserRole(userRoleDTO));

        if (updatedUserRole != null) {
            resUserRoleDto = Transformer.transformUserRoleToUserRoleDTO(updatedUserRole);
        }

        return resUserRoleDto;

    }
}
