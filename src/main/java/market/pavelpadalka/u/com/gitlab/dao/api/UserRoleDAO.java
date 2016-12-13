package market.pavelpadalka.u.com.gitlab.dao.api;

import market.pavelpadalka.u.com.gitlab.entity.UserRole;

public interface UserRoleDAO {

    UserRole findByName(String name);
    UserRole findByRoleId(Integer id);

    UserRole create(UserRole userRole);
    boolean  delete(Integer id);
    UserRole update(UserRole userRole);

}
