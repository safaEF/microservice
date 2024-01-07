package com.pi.kitchen;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.kitchen.Ticket;
 
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}