package tech.arcane.nexus.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.arcane.nexus.entity.User;
import tech.arcane.nexus.repository.UserRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> getAllUsers() { return userRepository.findAll(); }
    public User getUserById(Long id) { // Було String, стало Long
        return userRepository.findById(id).orElse(null);
    }
}