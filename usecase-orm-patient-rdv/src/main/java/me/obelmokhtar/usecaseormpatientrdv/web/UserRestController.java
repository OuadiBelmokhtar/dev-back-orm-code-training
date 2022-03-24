package me.obelmokhtar.usecaseormpatientrdv.web;

import lombok.AllArgsConstructor;
import me.obelmokhtar.usecaseormpatientrdv.entities.User;
import me.obelmokhtar.usecaseormpatientrdv.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserRestController {
    private UserRepository userRepository;

    @GetMapping("users/{username}")
    User getUserByUserName(@PathVariable(name = "username") String userName){
        return userRepository.findByUsername(userName);
    }
}
