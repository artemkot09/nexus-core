package tech.arcane.nexus.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.arcane.nexus.entity.Ticket;
import tech.arcane.nexus.repository.TicketRepository;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    public List<Ticket> getAllTickets() { return ticketRepository.findAll(); }
    public List<Ticket> getByUserId(String userId) { return ticketRepository.findByUserProfileUserProfileId(userId); }
    public Ticket create(Ticket ticket) {
        if (ticket.getTicketId() == null) ticket.setTicketId(UUID.randomUUID().toString());
        return ticketRepository.save(ticket);
    }
}