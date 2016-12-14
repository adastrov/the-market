package market.pavelpadalka.u.com.gitlab.dao.api;

import market.pavelpadalka.u.com.gitlab.entity.UserRole;

import java.util.List;

public interface UserRoleDAO {

    UserRole findByName(String name);
    UserRole findByRoleId(Integer id);
    List<UserRole> findAll();

    UserRole create(UserRole userRole);
    boolean  delete(Integer id);
    UserRole update(UserRole userRole);

}
