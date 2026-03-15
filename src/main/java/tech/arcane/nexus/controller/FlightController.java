package tech.arcane.nexus.controller;
import lombok.RequiredArgsConstructor;
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
    public List<Flight> allFlights() { return flightService.getAllFlights(); }
    @GetMapping("/search")
    public List<Flight> byNumber(@RequestParam String flightNumber) { return flightService.getByNumber(flightNumber); }
    @PostMapping
    public Flight create(@RequestBody Flight flight) { return flightService.create(flight); }
}