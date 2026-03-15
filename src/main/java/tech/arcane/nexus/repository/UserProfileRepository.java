package tech.arcane.nexus.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.arcane.nexus.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, String> { }