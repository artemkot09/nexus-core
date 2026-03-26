package tech.arcane.nexus.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tech.arcane.nexus.entity.Flight;
import tech.arcane.nexus.service.FlightService;
import java.util.List;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<Flight> allFlights() {
        return flightService.getAllFlights();
    }
    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<Flight> byNumber(@RequestParam String flightNumber) {
        return flightService.getByNumber(flightNumber);
    }
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Flight create(@RequestBody Flight flight) {
        return flightService.create(flight);
    }
}