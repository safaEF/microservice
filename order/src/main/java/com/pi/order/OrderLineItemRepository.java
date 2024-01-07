package com.pi.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Integer> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
