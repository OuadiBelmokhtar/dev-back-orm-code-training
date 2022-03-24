package me.obelmokhtar.usecaseormpatientrdv.services;

import me.obelmokhtar.usecaseormpatientrdv.entities.Role;
import me.obelmokhtar.usecaseormpatientrdv.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String rolName);
    void addRoleToUser(String username, String roleName);
    User authenticate(String username, String password);

}
