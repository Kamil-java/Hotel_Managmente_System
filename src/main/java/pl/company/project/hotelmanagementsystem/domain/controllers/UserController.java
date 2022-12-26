package pl.company.project.hotelmanagementsystem.domain.controllers;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.company.project.hotelmanagementsystem.domain.services.UserService;
import pl.company.project.hotelmanagementsystem.model.User;

@RestController("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        return userService.getUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
    }
}
