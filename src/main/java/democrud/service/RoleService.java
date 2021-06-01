package democrud.service;

import democrud.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role getRoleById(Integer id);

    Role addRole(Role role);

    void deleteRole(Integer id);

    boolean updateRole(Role role);
}
