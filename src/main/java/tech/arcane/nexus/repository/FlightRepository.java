package tech.arcane.nexus.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.arcane.nexus.entity.Flight;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, String> {
    List<Flight> findByFlightNumber(String flightNumber);
}