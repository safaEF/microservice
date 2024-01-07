package com.pi.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
