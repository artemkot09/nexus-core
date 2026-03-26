package tech.arcane.nexus.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.arcane.nexus.entity.Ticket;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, String> {
    List<Ticket> findByUserId(Long userId);
}