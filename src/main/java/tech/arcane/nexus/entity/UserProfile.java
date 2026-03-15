package tech.arcane.nexus.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.OffsetDateTime;

@Entity
@Table(name = "user_profile")
@Data
public class UserProfile {
    @Id
    @Column(name = "user_profile_id")
    private String userProfileId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private OffsetDateTime createdAt = OffsetDateTime.now();
}