package tech.arcane.nexus.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tech.arcane.nexus.entity.Ticket;
import tech.arcane.nexus.service.TicketService;
import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Ticket> allTickets() {
        return ticketService.getAllTickets();
    }
    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<Ticket> byUser(@PathVariable Long userId) {
        return ticketService.getByUserId(userId);
    }
    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public Ticket create(@RequestBody Ticket ticket) {
        return ticketService.create(ticket);
    }
}