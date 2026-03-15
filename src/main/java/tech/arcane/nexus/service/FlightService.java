package tech.arcane.nexus.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.arcane.nexus.entity.Flight;
import tech.arcane.nexus.repository.FlightRepository;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    public List<Flight> getAllFlights() { return flightRepository.findAll(); }
    public List<Flight> getByNumber(String num) { return flightRepository.findByFlightNumber(num); }
    public Flight create(Flight flight) {
        if (flight.getFlightId() == null) flight.setFlightId(UUID.randomUUID().toString());
        return flightRepository.save(flight);
    }
}