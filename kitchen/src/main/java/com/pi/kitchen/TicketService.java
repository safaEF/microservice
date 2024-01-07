package com.pi.kitchen;
 
// import com.TicketRepository;
import com.pi.kitchen.Ticket;
// import com.pi.kitchen.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.Optional;
 
@Service
public class TicketService {
 
    private final TicketRepository ticketRepository;
 
    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
 
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
 
    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }
 
    public Ticket createTicket(Ticket ticket) {
        // Ajoutez ici une logique de validation ou de traitement si nécessaire
        return ticketRepository.save(ticket);
    }
 
    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        // Ajoutez ici une logique de validation ou de traitement si nécessaire
        if (ticketRepository.existsById(id)) {
            updatedTicket.setId(id);
            return ticketRepository.save(updatedTicket);
        } else {
            // Gérer le cas où le ticket avec l'ID spécifié n'existe pas
            return null;
        }
    }
 
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}