package com.pi.kitchen;
 
import com.pi.kitchen.Ticket;
//import com.pi.kitchen.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/api/tickets")
public class TicketController {
 
    private final TicketService ticketService;
 
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
 
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }
 
    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id).orElse(null);
    }
 
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }
 
    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket updatedTicket) {
        return ticketService.updateTicket(id, updatedTicket);
    }
 
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }
}