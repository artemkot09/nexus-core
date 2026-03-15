package tech.arcane.nexus.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.arcane.nexus.entity.UserProfile;
import tech.arcane.nexus.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public List<UserProfile> allUsers() { return userService.getAllUsers(); }
    @GetMapping("/{id}")
    public UserProfile userInfo(@PathVariable String id) { return userService.getUserById(id); }
}