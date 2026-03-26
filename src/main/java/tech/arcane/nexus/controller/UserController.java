package tech.arcane.nexus.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tech.arcane.nexus.entity.User;
import tech.arcane.nexus.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> allUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public User userInfo(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}