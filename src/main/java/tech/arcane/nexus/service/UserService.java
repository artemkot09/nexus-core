package tech.arcane.nexus.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.arcane.nexus.entity.UserProfile;
import tech.arcane.nexus.repository.UserProfileRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserProfileRepository userRepository;
    public List<UserProfile> getAllUsers() { return userRepository.findAll(); }
    public UserProfile getUserById(String id) { return userRepository.findById(id).orElse(null); }
}