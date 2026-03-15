package tech.arcane.nexus.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.OffsetDateTime;

@Entity
@Table(name = "city")
@Data
public class City {
    @Id
    @Column(name = "city_id")
    private String cityId;
    private String displayName;
    private OffsetDateTime createdAt = OffsetDateTime.now();
}