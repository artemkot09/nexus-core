package tech.arcane.nexus.controller;
import lombok.RequiredArgsConstructor;
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
    public List<Ticket> allTickets() { return ticketService.getAllTickets(); }
    @GetMapping("/user/{userId}")
    public List<Ticket> byUser(@PathVariable String userId) { return ticketService.getByUserId(userId); }
    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) { return ticketService.create(ticket); }
}