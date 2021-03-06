package me.obelmokhtar.usecaseormpatientrdv.services;

import lombok.AllArgsConstructor;
import me.obelmokhtar.usecaseormpatientrdv.entities.Role;
import me.obelmokhtar.usecaseormpatientrdv.entities.User;
import me.obelmokhtar.usecaseormpatientrdv.repositories.RoleRepository;
import me.obelmokhtar.usecaseormpatientrdv.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor // pr faire l'injection par constructeur
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUserName(username);
        Role role = findRoleByRoleName(roleName);
        if (user.getRoles() != null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
        // userRepository.save(user); facultative, car deja fait lors du COMMIT de la transaction
        // roleRepository.save(role); facultative, car deja fait lors du COMMIT de la transaction
    }

    @Override
    public User authenticate(String username, String password) {
        User user = findUserByUserName(username);
        if (user == null) {
            throw new IllegalArgumentException("Bad credentials");
        }
        if (user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Bad credentials");
    }
}
