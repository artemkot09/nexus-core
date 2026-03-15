package tech.arcane.nexus.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.OffsetDateTime;

@Entity
@Table(name = "flight")
@Data
public class Flight {
    @Id
    @Column(name = "flight_id")
    private String flightId;
    private String flightNumber;
    @ManyToOne
    @JoinColumn(name = "departure_city_id")
    private City departureCity;
    @ManyToOne
    @JoinColumn(name = "arrival_city_id")
    private City arrivalCity;
    private OffsetDateTime departureTime;
    private OffsetDateTime arrivalTime;
    private String price;
    private OffsetDateTime createdAt = OffsetDateTime.now();
}