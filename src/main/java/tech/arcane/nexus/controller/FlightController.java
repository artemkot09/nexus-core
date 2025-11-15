package tech.arcane.nexus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.arcane.nexus.model.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private static final List<Flight> flights = new ArrayList<>(List.of(
            new Flight(1L, "Kyiv", "London", LocalDateTime.of(2025, 12, 1, 10, 30), LocalDateTime.of(2025, 12, 1, 12, 30), 250.00, "PS101"),
            new Flight(2L, "Lviv", "Paris", LocalDateTime.of(2025, 12, 3, 14, 0), LocalDateTime.of(2025, 12, 3, 16, 15), 180.50, "AF220"),
            new Flight(3L, "Odesa", "Istanbul", LocalDateTime.of(2025, 12, 5, 8, 45), LocalDateTime.of(2025, 12, 5, 10, 0), 120.00, "TK456")
    ));

    private static final AtomicLong idCounter = new AtomicLong(flights.size());

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        return flights.stream()
                .filter(flight -> flight.getId().equals(id))
                .findFirst()
                .map(flight -> new ResponseEntity<>(flight, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight newFlight) {
        Long newId = idCounter.incrementAndGet();
        newFlight.setId(newId);
        newFlight.setCreation_date(LocalDateTime.now());

        flights.add(newFlight);

        return new ResponseEntity<>(newFlight, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        boolean removed = flights.removeIf(flight -> flight.getId().equals(id));

        if (removed) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}